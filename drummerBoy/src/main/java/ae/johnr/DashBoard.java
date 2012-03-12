package ae.johnr;

import javax.swing.*;
import java.awt.*;

public class DashBoard extends JFrame {
    public DashBoard(String title) throws HeadlessException {
        super(title);
    }

    public static void main(String[] args) {
        new DashBoard("hello");
    }
}
