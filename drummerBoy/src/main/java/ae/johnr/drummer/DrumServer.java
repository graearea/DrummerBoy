package ae.johnr.drummer;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import static org.eclipse.jetty.util.resource.Resource.newClassPathResource;

public class DrumServer extends HttpServlet {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletHandler servletHandler = new ServletHandler();
        servletHandler.addServletWithMapping(DrumServer.class, "/drum/*");
        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setBaseResource(newClassPathResource("ae/johnr.ae.johnr"));

        DefaultHandler defaultHandler = new DefaultHandler();

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{servletHandler, resourceHandler, defaultHandler});
        server.setHandler(handlers);

        server.start();
        server.join();
    }

    private WebSocketFactory webSocketFactory;
    private static Set<DrumWebSocket> members = new CopyOnWriteArraySet<DrumWebSocket>();


    @Override
    public void init() throws ServletException {
        webSocketFactory = new WebSocketFactory(new WebSocketFactory.Acceptor() {
            public WebSocket doWebSocketConnect(HttpServletRequest httpServletRequest, String protocol) {
                if ("drum".equals(protocol))
                    return new DrumWebSocket();
                throw new RuntimeException("unknown protocol");
            }

            public boolean checkOrigin(HttpServletRequest httpServletRequest, String s) {return true;}
        });
        webSocketFactory.setBufferSize(4096);
        webSocketFactory.setMaxIdleTime(600000);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (webSocketFactory.acceptWebSocket(req, resp)) {
            return;
        }
        resp.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE, "Websocket only");
    }


    private class DrumWebSocket implements WebSocket.OnTextMessage {
        private Connection connection;

        public void onMessage(String message) {
            System.out.println("recv:"+message);
        }

        public void sendMessage(String message) {
            try {
                connection.sendMessage(message);
            } catch (IOException e) {
                throw new RuntimeException("error sending message", e);
            }

        }

        public void onOpen(Connection connection) {
            this.connection = connection;
            members.add(this);
        }

        public void onClose(int i, String s) {
            members.remove(this);
        }
    }
}

