import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.Random;
public class BasicEnemy extends GameObject
{
    private Random R;
    private Handler handler;
    public BasicEnemy(int x,int y,ID id, Handler handler)
    {
        super(x,y,id);
        this.handler = handler;
        velX = 5;
        velY = 5;
    }
    public Rectangle getBounds()
    {
        return new Rectangle((int)x,(int)y,16,16);
    }
    public void tick()
    {
        x += velX;
        y += velY;
        if (y<=0 || y >=Game.HEIGHT -32)
        {
            velY = -velY;
        }
        if (x<=0 || x >=Game.WIDTH -32)
        {
            velX = -velX;
        }
        handler.addObject(new Trail((int)x,(int)y,ID.Trail,Color.red,16,16, 0.02f,handler));        
    }
    public void render(Graphics g)
    {
        g.setColor(Color.red);
        g.fillRect((int)x,(int)y,16,16);
    }
    
}