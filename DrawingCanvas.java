import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DrawingCanvas extends JPanel implements ActionListener {

    //Points to store the x and y coordinates of the cloud shape drawing
    private Point p1;
    private Point p2;
    private Point p3;
    private Point p4;
    private Point p5;
    private Point p6;
    private int dx;

    //Constructor
    public DrawingCanvas()
    {
        p1 = new Point(260,60);
        p2 = new Point(290,45);
        p3 = new Point(330,60);
        p4 = new Point(460,60);
        p5 = new Point(480,45);
        p6 = new Point(510,60);

        dx = 5;
        Timer time = new Timer(100,this);
        time.start();
    }

    //Void function where all the drawing of the shapes will be handled
    public void paintComponent( Graphics g )
    {
        super.paintComponent(g);
        //The background
        this.setBackground(new Color(173,216,230));

        //The ground is drawn
        g.setColor(Color.GREEN);
        g.fillOval(-60,400,900,600);

        //Road for the train is drawn
        g.setColor(new Color(165,42,42));
        g.fillRect(-60,670,900,25);


        //Back side of the train is drawn
        g.setColor(new Color(165,42,42));
        g.fillRoundRect(250,570,130,80,5,5);

        //The tires of the back of wheel is drawn
        g.setColor(Color.BLACK);
        g.fillOval(260,625,45,45);
        g.fillOval(325,625,45,45);


        //Inner frame of the back wheel of the train is drawn
        g.setColor(Color.RED);
        g.fillOval(270,635,25,25);
        g.fillOval(335,635,25,25);

        //The connection between the front and the back of the train is drawn
        g.setColor(Color.BLUE);
        g.fillRoundRect(355,600,90,20,5,5);

        //Front of the train is drawn
        g.setColor(Color.BLUE);
        g.fillRoundRect(420,570,170,80,5,5);

        //The tires of the front of wheel is drawn
        g.setColor(Color.BLACK);
        g.fillOval(430,590,80,80);
        g.fillOval(530,625,45,45);


        //Inner frame of the front wheel of the train is drawn
        g.setColor(Color.red);
        g.fillOval(448,608,45,45);
        g.fillOval(540,635,25,25);


        //Train front top
        g.setColor(Color.RED);
        g.fillRoundRect(430,490,80,80,5,5);

        g.setColor(Color.BLUE);
        g.fillRoundRect(430,475,80,15,5,5);

        g.setColor(Color.BLUE);
        g.fillRoundRect(545,525,25,50,5,5);


        //Train front bumper
        g.setColor(Color.BLACK);
        g.fillRoundRect(590,590,20,50,5,5);


        //The body of the house is drawn
        g.setColor(Color.BLUE);
        g.fillRoundRect(250,320,100,100,5,5);


        //The window of the house is drawn
        g.setColor(new Color(255,219,88));
        g.fillRoundRect(275,345,50,50,5,5);

        //The roof of the house is drawn
        g.setColor(new Color(252,15,192));
        int [] xpoints = {235, 300, 365};
        int [] ypoints = {320, 250, 320};
        int npoints = 3;
        g.fillPolygon(xpoints, ypoints, npoints);

        //The leaves of the tree are drawn
        g.setColor(Color.green);
        g.fillOval(35,180,150,170);

        //The branch of the tree is drawn
        g.setColor(new Color(165,42,42));
        g.fillRoundRect(100,280,20,200,5,5);

        //The fruits of the tree are drawn
        g.setColor(Color.red);
        g.fillOval(110,200,23,23);
        g.fillOval(70,220,20,20);
        g.fillOval(70,250,18,18);
        g.fillOval(70,280,15,15);
        g.fillOval(140,220,22,22);
        g.fillOval(140,260,18,18);
        g.fillOval(130,280,15,15);

        //Clouds are drawn
        g.setColor(new Color(219, 240, 254));
        g.fillOval(p1.x,p1.y,60,60);
        g.fillOval(p2.x, p2.y, 70,70);
        g.fillOval(p3.x,p3.y,60,60);

        g.fillOval(p4.x,p4.y,40,40);
        g.fillOval(p5.x,p5.y,50,50);
        g.fillOval(p6.x,p6.y,40,40);


        //Sun is drawn
        g.setColor(Color.yellow);
        g.fillOval(620,50,90,90);
    }

    //The actionPerformed of the ActionListener interface is overrided
    @Override
    public void actionPerformed(ActionEvent e) {
        p1.x +=dx;
        p2.x +=dx;
        p3.x +=dx;
        p4.x +=dx;
        p5.x +=dx;
        p6.x +=dx;

        //Checks to see if the cloud reaches the ends of the drawing canvas
        //If yes then adjusts the position of the drawing
        if(p6.x <= 0|| p1.x + 10 >= getWidth())
        {
            dx =- dx;
        }
        repaint();
    }

}


