//The AlphaComposite class implements basic alpha compositing rules for 
//combining source and destination colors to achieve blending and transparency effects
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.AlphaComposite;
import java.awt.Color;
public class Trail extends GameObject
{
    private float alpha = 1;
    private Handler handler;
    private Color color;
    private int width,height;
    private float life; // the life sets the life of the trail, smaller = more life
    //tick runs many times therefore we get a proper trail
    public Trail(int x, int y, ID id, Color color, int width, int height,float life, Handler handler)
    {
        super(x,y,id);
        this.handler = handler;
        this.color = color;
        this.width =width;
        this.height = height;
        this.life =life;
    }
    public void tick()
    {
        if (alpha >life)
        {
            alpha = alpha - (life -0.0001f);
        }
        else
        {
            handler.removeObject(this);
        }
    }
    public void render(Graphics g)
    {
        //the graphics part to make the transparency the alpha particle does the transparency
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(makeTransparent(alpha));
        g.setColor(color);
        g.fillRect((int) x, (int) y, width,height);
        g2d.setComposite(makeTransparent(1)); // this is done to avoid transparency later
    }
    private AlphaComposite makeTransparent(float alpha)
    {
        int type = AlphaComposite.SRC_OVER;
        return(AlphaComposite.getInstance(type,alpha));
    }
    public Rectangle getBounds()
    {
        return null;
    }
}