import java.awt.*;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Player {

    //instance variables
    private double x, y;		    //position in map
    private double vx, vy;			//velocity
    private double ax, ay;			//acceleration
    private double angle;			//current flight angle
    private double rv;	    		//rotation velocity
    private double appliedThrust;	//current forward thrust from yaris

    //image variables
    private int imgWidth = 1024;
    private int imgHeight = 768;

    //display variables
    private double scale = 0.25;					//size of yaris on screen
    private double displayX = 50, displayY = 400;	//display location for yaris (the center)
    private double offsetx = (int)(540*scale);		//offset of yaris image (to center yaris)
    private double offsety = (int)(390*scale);
    private int width = (int)(1024*scale);		//size of yaris image
    private int height= (int)(768*scale);
    private Image img;							//image

    //physics variables
    private int mass = 20;
    private double lift = 0;
    private double gravity = 0.15;
    private double power = 1;

    //gameplay variables
    private boolean onGround = false;			//keep track if yaris dies
    public boolean alive;						//aliveness of our manual 2007 red yaris driving friend
    public Shape bounds;						//collision boundaries for yaris (for obstacles and ground)
    public boolean onRamp;

    //affine
    private AffineTransform tx;
    private String path;

    public Player(String fileName){
        x = displayX;
        y = displayY - offsety;
        angle = 0;
        vx = 5;
        vy = 0;
        img = getImage(fileName);
        alive = true;

        //bounds = new Rectangle();
    }

    public void move(){
        updateAccelerations();
        vy -= ay;
        y += vy;

    }

    private void updateAccelerations() {
        double fy = lift - gravity;
        ay = fy / mass;
    }

    public void up(){
        lift += power;
    }
    public void down(){
        lift -= power;
    }
    public void neutral(){
        lift = 0;
    }

    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(img, (int) x, (int) y,(int) (imgWidth * scale), (int) (imgHeight * scale), null);
        g2.setColor(Color.BLACK);
    }

    private Image getImage(String path){
        this.path = path;
        Image tempImage = null;
        try {
            URL imageURL = Player.class.getResource(path);
            tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tempImage;
    }

}
