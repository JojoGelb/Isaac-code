/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isaac3.entities;

import isaac3.Handler;
import isaac3.gfx.Assets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author jordy
 */
public class Door extends Entity {
    
    private int FacteurTailleX, FacteurTailleY;
    private BufferedImage texture;
    
    public Door(Handler handler, float x, float y, BufferedImage texture){
        super(handler,x,y,110,110);
        //FacteurTailleX = (width*32)/24;
        //FacteurTailleY = (height*32)/24;
        this.texture = texture;
    }
    
    @Override
    public void update() {
        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(texture,(int)x+500-64,(int)y+10, width, height, null);
        g.drawImage(Assets.backDoor,(int)x+500-64,(int)y+10, width, height, null);
    }

    @Override
    public void die() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
