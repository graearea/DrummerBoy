
if (!window.WebSocket) {
	window.WebSocket=window.MozWebSocket;
	if (!window.WebSocket)
		alert("WebSocket not supported by this browser");
}

function $() {
	return document.getElementById(arguments[0]);
}
function $F() {
	return document.getElementById(arguments[0]).value;
}

var drumServer ={
    connect : function()
    {
        var location = document.location.toString()
                .replace('http://', 'ws://')
                .replace('https://', 'wss://')
                + "drum";
		    this._ws = new WebSocket(location, "chat");
    		this._ws.onOpen = this.onOpen;
    		this._ws.onMessage = this.onMessage;
    		this._ws.onClose = this.onClose;
    },
    onOpen :function()
    {
          drumServer.send('I has joined!');
    },

    send : function(message) {
        if (this._ws)
            this._ws.send(message);
    },
	onmessage : function(m) {
		if (m.data) {
			var c = m.data.indexOf(':');
			var drum = m.data.substring(0, c)
			  .replace('<','&lt;')
			  .replace('>','&gt;');
			var info = m.data.substring(c + 1)
			  .replace('<', '&lt;')
			  .replace('>', '&gt;');

			var chat = $('beat');
			var drum = document.createElement('span');
			drum.className = 'drum';
			drum.innerHTML = from + ':&nbsp;';
			var info = document.createElement('span');
			info.className = 'text';
			info.innerHTML = text;
			var lineBreak = document.createElement('br');
			chat.appendChild(drum);
			chat.appendChild(info);
			chat.appendChild(lineBreak);
			chat.scrollTop = chat.scrollHeight - chat.clientHeight;
		}
	}


}

function init()
{
$(connect).onclick = function(event){drumServer.connect()}
}