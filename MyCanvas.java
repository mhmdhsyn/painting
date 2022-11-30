import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Defining the canvas class
public class MyCanvas extends JPanel implements ActionListener {
    //Defining point for the clouds
    private Point p1 = new Point(250,50);
    private Point p2 = new Point(270,40);
    private Point p3 = new Point(290,50);
    private Point p4 = new Point(440,50);
    private Point p5 = new Point(460,40);
    private Point p6 = new Point(480,50);
    private int dx; // Speed of the clouds
    //Class constructor
    public MyCanvas(){
        //setting speed to 1
        dx = 1;
        //Constructing the timer
        Timer time = new Timer(20,this);
        //Starting the timer
        time.start();
    }
    //Printing the background
    public void printBackground (Graphics g){
        //Calling the super class constructor
        super.paintComponent(g);
        //Setting the background
        this.setBackground(new Color(113, 218, 250));
    }
    //Function to draw the ground
    public void drawGround (Graphics g){
        //Calling the super class constructor
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillOval(-60,400,1000,500);
    }
    //Function to draw the train
    public void drawTrain (Graphics g){
        //Drawing the main body
        g.setColor(Color.BLUE);
        g.fillRoundRect(420,570,190,70,10,10);
        //Drawing the Cart
        g.setColor(new Color(106, 67, 45));
        g.fillRoundRect(230,570,130,70,10,10);
        //Drawing the Train rails
        g.setColor(new Color(65, 25, 2));
        g.fillRect(-60,670,800,30);
        //Drawing the Wheels
        g.setColor(Color.BLACK);
        g.fillOval(240,635,50,50);
        g.fillOval(300,635,50,50);
        g.setColor(Color.RED);
        g.fillOval(250,645,30,30);
        g.fillOval(310,645,30,30);
        //Drawing the connector
        g.setColor(Color.BLUE);
        g.fillRoundRect(355,600,90,20,10,10);
        //Drawing main wheels
        g.setColor(Color.BLACK);
        g.fillOval(435,600,70,70);
        g.fillOval(530,625,45,45);
        //Drawing inside the wheel
        g.setColor(Color.red);
        g.fillOval(453,617,35,35);
        g.fillOval(542,638,20,20);
        //Drawing top of the train
        g.setColor(Color.RED);
        g.fillRoundRect(420,470,100,100,10,10);
        //Drawing the line on top of the train
        g.setColor(Color.BLUE);
        g.fillRoundRect(420,470,100,15,10,10);
        //Drawing the pipe
        g.fillRoundRect(560,525,20,55,10,10);
        //Drawing the safety guard
        g.setColor(Color.BLACK);
        g.fillRoundRect(610,585,15,40,10,10);

    }

    //Function to draw the tree
    public void drawTree (Graphics g){
        //Drawing the tree top
        g.setColor(Color.GREEN);
        g.fillOval(65,160,150,200);

        //Drawing the tree body
        g.setColor(new Color(65, 25, 2));
        g.fillRoundRect(130,280,20,180,10,10);

        //Drawing fruits of the tree
        g.setColor(Color.red);
        g.fillOval(160,200,20,20);
        g.fillOval(120,180,25,25);
        g.fillOval(110,220,15,15);
        g.fillOval(160,200,25,25);
        g.fillOval(160,240,10,10);
        g.fillOval(100,270,25,25);
        g.fillOval(170,270,30,30);
    }
    //Function to draw the house
    public void drawHouse (Graphics g){
        //Drawing the main body
        g.setColor(Color.BLUE);
        g.fillRoundRect(300,340,120,120,10,10);


        //Drawing the window
        g.setColor(Color.YELLOW);
        g.fillRoundRect(330,355,60,60,10,10);

        //drawing the roof
        g.setColor(Color.MAGENTA);
        int [] xpoints = {280, 362, 445};
        int [] ypoints = {340, 240, 340};
        int npoints = 3;
        g.fillPolygon(xpoints, ypoints, npoints);
    }
    //Function to draw the clouds
    public void drawClouds (Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(p1.x,p1.y,50,50);
        g.fillOval(p2.x, p2.y, 60,60);
        g.fillOval(p3.x,p3.y,50,50);

        g.fillOval(p4.x,p4.y,50,50);
        g.fillOval(p5.x,p5.y,60,60);
        g.fillOval(p6.x,p6.y,50,50);
    }
    //Function to draw the sun
    public void drawSun (Graphics g){
        g.setColor(Color.yellow);
        g.fillOval(660,70,80,80);
    }
    //Overloading the paintComponent and
    //drawing the painting
    public void paintComponent(Graphics g){
        printBackground(g);
        drawGround(g);
        drawTrain(g);
        drawHouse(g);
        drawTree(g);
        drawSun(g);
        drawClouds(g);

    }
    //Overriding the actionPerformed to redraw the painting
    @Override
    public void actionPerformed(ActionEvent e) {
        //Adding the speed to the point
        p1.x +=dx;
        p2.x +=dx;
        p3.x +=dx;
        p4.x +=dx;
        p5.x +=dx;
        p6.x +=dx;

        //Reversing the direction of the cloud if reaching the end
        if(p1.x <= 0|| p6.x >= getWidth())
        {
            dx =- dx;
        }
        repaint();
    }

}
