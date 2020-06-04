import java.awt.*;

public class Bounds {
    BoundQueue<Bound> boundQueue = new BoundQueue<Bound>();

    //screen variables
    private int screenWidth = 1000;

    //mechanics
    private boolean isAlive = true;

    public Bounds(){
        boundQueue.add(new Bound());
    }

    public void move(){           //check for bound to be made, yeeted, and ask BoundQueue to update each bound
        if(isAlive) {
            //update each bound
            for (int i = 0; i < boundQueue.size(); i++) {
                boundQueue.get(i).move();
            }

            //check if new bound can be made
            if (boundQueue.peekLast().getX() + boundQueue.peekLast().width <= screenWidth) {
                boundQueue.add(new Bound(boundQueue.peekLast().getLastHeight()));
            }

            if (boundQueue.peek().getX() < -boundQueue.peek().width) {
                boundQueue.remove();
            }
        }
    }

    public void paint(Graphics g){          //paint the bounds
        for(int i = 0; i < boundQueue.size(); i++){
            boundQueue.get(i).paint(g);
        }
    }

    public boolean didCollide(Player player){
        for(int i = 0; i < boundQueue.size(); i++){
            if(player.getBounds().intersects(boundQueue.get(i).getTop()) || player.getBounds().intersects(boundQueue.get(i).getBottom())){
                return true;
            }
        }
        return false;
    }

    public void stop(){
        isAlive = false;
    }


}
