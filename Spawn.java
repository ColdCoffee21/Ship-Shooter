import java.util.Random;
public class Spawn
{
    private Handler handler;
    private HUD hud;
    private int scoreKeep =0;
    private Random r = new Random();
    public Spawn(Handler handler, HUD hud)
    {
        this.handler = handler;
        this.hud =hud;
    }
    public void tick()
    {
        scoreKeep++;
        if(scoreKeep >= 500)
        {
            scoreKeep =0;
            hud.setLevel(hud.getLevel()+ 1);
            if(hud.getLevel() ==2)
            {
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50),ID.BasicEnemy, handler));
            }
            if(hud.getLevel() ==3)
            {
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50),ID.BasicEnemy, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50)-10,r.nextInt(Game.HEIGHT-50)-10,ID.BasicEnemy, handler));
            }
            if(hud.getLevel() ==4)
            {
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50),ID.FastEnemy, handler));
            }
            if(hud.getLevel() ==5)
            {
                handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50),ID.SmartEnemy, handler));
            }
            if(hud.getLevel() ==6)
            {
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50),ID.FastEnemy, handler));
            }
            if(hud.getLevel() ==7)
            {
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50),ID.FastEnemy, handler));
            }
            if(hud.getLevel() ==8)
            {
                handler.clearEnemies();
                handler.addObject(new BasicEnemy(0,0,ID.BasicEnemy, handler));
                handler.addObject(new BasicEnemy(600,0,ID.BasicEnemy, handler));
                handler.addObject(new BasicEnemy(0,440,ID.BasicEnemy, handler));
                handler.addObject(new BasicEnemy(600,440,ID.BasicEnemy, handler));
            }
            if(hud.getLevel() ==  9)
            {
                handler.addObject(new SmartEnemy(((Game.WIDTH/2)-16),((Game.HEIGHT/2)-16),ID.SmartEnemy,handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50),ID.FastEnemy, handler));
            }
            if(hud.getLevel() ==10)
            {
                handler.clearEnemies();
                System.out.println("MAX LVL REACHED");
                System.exit(1);
            }
        }
    }
}