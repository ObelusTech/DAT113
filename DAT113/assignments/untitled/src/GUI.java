import com.sun.prism.Graphics;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    public Graphics g;

    public JFrame frame;

    public GUI(){

        super.paintComponents(getGraphics());


        frame = new JFrame("lol");
        frame.setSize(800,800);
        frame.setBackground(Color.BLACK);

        frame.setVisible(true);
        g.fillRect(0, 0, 100 , 100);

    }

}
