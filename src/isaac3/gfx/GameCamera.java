/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isaac3.gfx;

import isaac3.Game;
import isaac3.entities.Entity;

/**
 *
 * @author jordy
 */
public class GameCamera {
    
    private float xOffset, yOffset;
    private Game game;
    
    public GameCamera(Game game,float xOffset, float yOffset){
        this.game = game;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }
    
    public void centerOnEntity(Entity e){
        
        if (e.getX()> this.xOffset + game.getWidth()){
            xOffset += game.getWidth();
            
        }
        if (e.getX()< this.xOffset){
            xOffset -= game.getWidth();
        }
        if (e.getY()> this.yOffset + game.getHeight()){ 
            yOffset += game.getHeight();
        }
        if (e.getY()< this.yOffset ){
            yOffset -= game.getHeight();
        }

    }
    
    
    public void move(float xAmt, float yAmt){
        xOffset += xAmt;
        yOffset += yAmt;
    }

    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }
    
    
    
    
    
}
