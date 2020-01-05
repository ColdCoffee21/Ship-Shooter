import java.awt.Graphics;
import java.util.LinkedList; // read about LinkedList class
//we are creating a linked list because we dont know how many gameObjects we are going to have
//if we dont give proper things like public and all it gives some errors
//this class is going to update and render all of our objects of our game
public class Handler {
    LinkedList<GameObject> object = new LinkedList<GameObject>();    
    public void tick()
    {
        for (int i =0; i < object.size(); i++) 
        {
            GameObject tempObject = object.get(i);
            tempObject.tick();
        }
    }
    public void render(Graphics g) 
    {
        for (int i =0; i < object.size(); i++)
        {
            GameObject tempObject = object.get(i);
            tempObject.render(g);
        }
    }
    public void addObject(GameObject object) {
        this.object.add(object);
    }
    public void removeObject(GameObject object) {
        this.object.remove(object);
    }
    public void clearEnemies ()
    {
        for (int i = 0; i < this.object.size(); i++)
        {
            GameObject tempObject = this.object.get(i);
            if (tempObject.getId() != ID.Player) 
            {
                this.removeObject(tempObject);
                i--;
            }
        }
    }
}