/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isaac3.entities;

import isaac3.Handler;
import isaac3.gfx.Assets;
import java.awt.Graphics;

/**
 *
 * @author jordy
 */
public class Rock extends StaticEntity {
    
    private int FacteurTaille;

    public Rock(Handler handler, float x, float y){
        super(handler,x,y,48,48);
        FacteurTaille = (width*32)/24;
        
        bounds.x = (FacteurTaille-width)/2;
        bounds.y = (FacteurTaille-height)/2;
        bounds.width = width;
        bounds.height = height;
    }
    
    @Override
    public void update(){
        
    }
        
    @Override
    public void die() {
        
    }
    
    
    @Override
    public void render(Graphics g){
        g.drawImage(Assets.rock, (int)(x-handler.getGameCamera().getxOffset()),(int) (y-handler.getGameCamera().getyOffset()),FacteurTaille,FacteurTaille, null);
       
    
    }
}
