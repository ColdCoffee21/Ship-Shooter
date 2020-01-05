import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
//the class for handling events
//keyevent is passed to keyadapter and keyadapter takes input
//shouldnt it be implements?
public class KeyInput extends KeyAdapter
{
    private Handler handler;
    private boolean[] keyDown = new boolean[4];
    public KeyInput(Handler handler){
        this.handler = handler;
        for (int i =0; i < keyDown.length; i++)
        {
            keyDown[i] = false;
        }
    }
    public void keyPressed(KeyEvent e)
    {
        int key =e.getKeyCode();
        for(int i =0; i <handler.object.size(); i++)
        {
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Player) 
            {
                if(key == KeyEvent.VK_UP)
                {
                    tempObject.setVelY(-5) ;
                    keyDown[0] = true;
                }
                if(key == KeyEvent.VK_DOWN)
                {
                    tempObject.setVelY(5) ;
                    keyDown[1] = true;
                }
                if(key == KeyEvent.VK_LEFT)
                {
                    tempObject.setVelX(-5) ;
                    keyDown[2] = true;
                }
                if(key == KeyEvent.VK_RIGHT)
                {
                    tempObject.setVelX(5) ;
                    keyDown[3] = true;
                }
            }
        }
    }
    public void keyReleased(KeyEvent e)
    {
        int key =e.getKeyCode();
        for(int i =0; i <handler.object.size(); i++)
        {
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Player) 
            {
                if(key == KeyEvent.VK_UP)
                {
                    //tempObject.setVelY(0) ;
                    keyDown[0] = false;
                }
                if(key == KeyEvent.VK_DOWN)
                {
                    //tempObject.setVelY(0) ;
                    keyDown[1] = false;
                }
                if(key == KeyEvent.VK_LEFT)
                {
                    //tempObject.setVelX(0) ;
                    keyDown[2] = false;
                }
                if(key == KeyEvent.VK_RIGHT)
                {
                    //tempObject.setVelX(0) ;
                    keyDown[3] = false;
                }
                //vertical movement
                if(!keyDown[0] && !keyDown[1])
                {
                    tempObject.setVelY(0);
                }
                //horizontal movement
                if(!keyDown[2] && !keyDown[3])
                {
                    tempObject.setVelX(0);
                }
            }
        }
        if (key == KeyEvent.VK_ESCAPE)
        {
            System.exit(1);
        }
    }
}
