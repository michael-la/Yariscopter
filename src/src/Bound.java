import java.awt.*;
import java.net.StandardSocketOptions;

public class Bound {
    //dimension
    private int lastHeight;
    private int tunnelDepth = 400;
    public int width = 50;
    private int boty,topy;
    private Rectangle bottom, top;
    private int screenWidth = 1000;
    private int screenHeight = 800;
    private int minHeight = 50;
    private int maxHeight = 350;
    private int botHeight, topHeight;




    //movement
    private int spawnX = screenWidth;
    private int x = spawnX;
    private double vx = -5;

    //mechanics
    private static int rowCounter;
    private int stepHeight = 20;

    public Bound(int lastHeight) {
        this.lastHeight = lastHeight;
        updateCount();
        boty = randomNumber();
        topy = boty + tunnelDepth;
        botHeight = boty;
        topHeight = screenHeight - topy;


        bottom = new Rectangle(spawnX, screenHeight - boty, width, botHeight);
        top = new Rectangle(spawnX, 0, width, topHeight);
    }

    public Bound() {
        this.lastHeight = lastHeight;
        rowCounter = 1;

        boty = randomNumber();
        topy = boty + tunnelDepth;
        botHeight = boty;
        topHeight = screenHeight - topy;


        bottom = new Rectangle(spawnX, screenHeight - boty, width, botHeight);
        top = new Rectangle(spawnX, 0, width, topHeight);

    }

    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.fill(top);
        g2.fill(bottom);
    }

    public void updateCount(){
        rowCounter++;
    }

    public int getCount(){
        return rowCounter;
    }

    public void move(){
        x += vx;
        top.setLocation(x, top.y);
        bottom.setLocation(x, bottom.y);
    }


    public Rectangle getBottom() {
        return bottom;
    }

    public void setBottom(Rectangle bottom) {
        this.bottom = bottom;
    }

    public Rectangle getTop() {
        return top;
    }

    public void setTop(Rectangle top) {
        this.top = top;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getLastHeight(){
        return boty;
    }

    public int randomNumber(){
        int num = 0;
        if(rowCounter == 1){
            num = (int) (Math.random() * ((maxHeight- minHeight) + minHeight));
            num = (num / stepHeight) * stepHeight;
        } else {

            if(lastHeight <= minHeight){
                num = lastHeight + stepHeight;
                return num;
            }else if(lastHeight >= maxHeight){
                num =lastHeight - stepHeight;

                return num;
            }else {

                int dir = (int) (Math.random() * ((3) + 0)); //direction variable

                switch (dir) {
                    case 0:                             //go down
                        num = lastHeight - stepHeight;
                        break;
                    case 1:                             //stay same
                        num = lastHeight;
                        break;
                    case 2:                             //go up
                        num = lastHeight + stepHeight;
                        break;
                }
            }
        }
        return num;
    }
}
