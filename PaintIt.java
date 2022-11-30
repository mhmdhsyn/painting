import java.awt.*;
import javax.swing.*;

public class PaintIt {

    public static void main(String[] args){
        JFrame frame = new JFrame("Draw");

        MyCanvas oi = new MyCanvas();
        frame.add(oi);
        frame.setSize(768,768);
        frame.setVisible(true);
    }
}
