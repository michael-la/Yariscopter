import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.net.URL;
import javax.swing.Timer;

public class Driver extends JPanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener {
    private int screen_height = 800;
    private int screen_width = 1000;
    private Timer t;
    private int stage = 0;

    private AffineTransform tx;

    Player player;

    public void update(){
        player.move();
    }


    public void paint(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, screen_width, screen_height);
        g.setColor(Color.BLACK);
        g.fillRect(475, 375, 50, 50); //placement, remove later

        player.paint(g);
    }

    private Image getImage(String path){
        Image tempImage = null;
        try {
            URL imageURL = null;
            tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tempImage;
    }

    public void startGame(){

    }

    /////////////////////////////////////////////// DRIVER ///////////////////////////////////////////

    public static void main(String[] args) {
        Driver d = new Driver();
    }

    public Driver() {
        JFrame f = new JFrame();
        f.setTitle("Yariscopter");
        f.setSize(screen_width, screen_height);
        f.setResizable(false);
        f.addKeyListener(this);
        f.addMouseListener(this);

        //sprite instantiation
        player = new Player("yarisright.png");

        f.add(this);
        t = new Timer(10, this);
        t.start();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public boolean isInside(int x, int y, int xBound1, int yBound1, int xBound2, int yBound2) {
        if(x >= xBound1 && x <= xBound2 && y >= yBound1 && y <= yBound2) {
            return true;
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch(key){
            case 38:
                player.up();
                break;
            case 40:
                player.down();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        switch(key){
            case 38:
            case 40:
                player.neutral();
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
