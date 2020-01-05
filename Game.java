import java.awt.Canvas;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;
import java.io.*;
public class Game extends Canvas implements Runnable
{
    //The Runnable interface should be implemented by any class whose instances are intended to be executed by a thread. The class must define a method of no arguments called run.
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 *9; // simple logic to give a 16/9 ratio
    private Thread thread;
    private boolean running = false;
    private Random r;
    private Handler handler;
    private HUD hud;
    private Spawn spawn; 
    static String name;
    public Game()
    {
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
        new Window(WIDTH,HEIGHT, "Wave",this);
        hud = new HUD();
        spawn = new Spawn(handler,hud);
        r = new Random();
        handler.addObject(new Player(((WIDTH/2)-32),((HEIGHT/2)-32),ID.Player, handler));
        handler.addObject(new BasicEnemy(r.nextInt(WIDTH-50),r.nextInt(HEIGHT-50),ID.BasicEnemy, handler));
    }
    public synchronized void start() 
    { 
        thread = new Thread (this); // this refers to this instance of game class
        thread.start();
        running = true;
    }
    public synchronized void stop() 
    { 
        try
        {
            thread.join(); // just kills off the thread
            running = false;
        }
        catch (Exception e)
        {
            e.printStackTrace(); // runs the error through our console, so it tells us why an error occured
        }
        
    }
    // the game loop is a very popular one
    public void run() 
    {
        //lastTime is a start time to measure amount of time passed
        //amountOfTicks is the number of ticks per second
        //ns is the number of nanoseconds allowed between ticks
        //delta is the amount of time difference between ticks
        this.requestFocus();
        long lastTime = System.nanoTime(); // Returns the current value of the most precise available system timer, in nanoseconds. 
        double amountOfTicks = 60.0; 
        double ns = 1000000000 / amountOfTicks; //100000000 nanoseconds is one second
        double delta = 0;
        while (running)
        {
            long now = System.nanoTime();
            delta += (now -lastTime)/ ns;
            lastTime = now;
            while (delta >= 1)
            {
                tick(); //also known as the update method, deals with logic part
                delta--;
            }
            if (running)
            {
                render(); // deals with the graphics part
            }   
        }
        stop();
    }
    private void tick()
    {
        handler.tick();
        hud.tick();
        spawn.tick();
    }    
    private void render() 
    {
        BufferStrategy bs = this.getBufferStrategy(); // a bufferstrategy is created though render runs many times, but (this refers to the canvas class) this.getBufferStrategy is a method of canvas which returns null  
        if (bs == null) {
            this.createBufferStrategy(3); // this refers to canvas, creates as many buffers as you want, best is 3 buffers
            // so bufferstrategy is used as a space where the next image is kinda made ready in the buffer, then just passed to the screen, making it more effecient and smoother
             return; //by doing this we create a bufferStrategy only once
        }
        //When you want to start drawing, get a draw graphics and use it. When you are finished drawing and want to present your information to the screen, call show.
        Graphics g = bs.getDrawGraphics();
        
        g.setColor(Color.black);
        g.fillRect(0,0,WIDTH,HEIGHT);
        
        handler.render(g);
        hud.render(g);
        
        g.dispose(); //Disposes of this graphics context and releases any system resources that it is using.
        bs.show();
    }
    public static float clamp(float var,float min,float max)
    {
        if (var >= max)
        {
            return var = max;
        }
        else if (var <= min)
        {
            return var = min;
        }
        else
        {
            return var;
        }
    }
    public static void main(String[]args) throws Exception
    {
        BufferedReader br = new BufferedReader ( new InputStreamReader (System.in));
        System.out.println("Enter player name");
        name = br.readLine();
        new Game();
    }
}