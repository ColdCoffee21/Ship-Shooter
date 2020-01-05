import java.awt.Graphics;
import java.awt.Rectangle;
//player, enemy and all are GameObjects and all the methods and functions that are made in the game object 
// are going to be there in the class that inherits them, but the abstract functions must be def in the class that inherit
public abstract class GameObject 
{
    protected float x, y;
    protected ID id;
    protected float velX, velY;
    public GameObject (float x, float y, ID id)
    {
        this.x = x;
        this.y = y;
        this.id = id; 
    }
    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();
    //im creating setters and getters cuz its good programming prac. and it can be used after the const. to change values
    public void setX(int x) 
    {
        this.x = x;
    }
    public void setY(int y)
    {
        this.y = y;
    }
    public float getX()
    {
        return x;
    }
    public float getY()
    {
        return y;
    }
    public void setID(ID id)
    {
        this.id = id;
    }
    public ID getId() 
    {
        return id;
    }
    public void setVelX(int velX) 
    {
        this.velX = velX;
    }
    public void setVelY(int velY) 
    {
        this.velY =velY;
    }
    public float getVelx(int velx) 
    {
        return velx;
    }
    public float getVelY(int vely) 
    {
        return vely;
    }
}