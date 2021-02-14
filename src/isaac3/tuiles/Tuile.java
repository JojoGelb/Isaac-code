/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isaac3.tuiles;

import isaac3.gfx.Assets;
import isaac3.gfx.ImageLoader;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author jordy
 */
public class Tuile {
    
    //STATIC
    
    public static Tuile[] sol = new Tuile[10];
    public static Tuile Rien = new Tuile(null,0,0,0,false);
    public static Tuile Cellar = new Cellar(1,1,0,false); 
    public static Tuile Cellar1 = new Cellar(2,1,0,true);
    public static Tuile Cellar2 = new Cellar(3,1,180,true);
    public static Tuile Cellar4 = new Cellar(4,1,180,false);
    
    
    //CLASS
    
    public static final int TUILE_WIDTH = 500, TUILE_HEIGHT = 350;
    protected final int id;
    
    protected final int type,angle;
    protected final boolean miror;
    
    
    protected BufferedImage texture;
    
    public Tuile(BufferedImage texture, int id,int type, int angle, boolean miror){
        this.texture = texture;
        this.id = id;
        sol[id] = this;
        this.type = type;
        this.angle = angle;
        this.miror = miror;
    }
    
    public void update(){
        
    }
    
    public void render(Graphics g, int x, int y){
            g.drawImage(texture, x, y,TUILE_WIDTH, TUILE_HEIGHT,null);
       /* g.drawImage(ImageLoader.horizontalFlip(texture), x+BACKGROUND_WIDTH, y,BACKGROUND_WIDTH, BACKGROUND_HEIGHT, null);
        g.drawImage(ImageLoader.rotate(texture, 180), x+BACKGROUND_WIDTH, y+BACKGROUND_HEIGHT,BACKGROUND_WIDTH, BACKGROUND_HEIGHT, null);
        g.drawImage(ImageLoader.rotate(ImageLoader.horizontalFlip(texture), 180),x, y+BACKGROUND_HEIGHT,BACKGROUND_WIDTH, BACKGROUND_HEIGHT, null);*/
    }

    

    

    
    
    
    
}
