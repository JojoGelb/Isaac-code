/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isaac3.entities;

import isaac3.Handler;
import isaac3.gfx.Animation;
import isaac3.gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author jordy
 */
public class Projectile extends Entity {
    
    protected float range, shootSpeed;
    private int FacteurTaille;
    private char direction;
    private Animation contactTear;
    private boolean fly = true;

    public Projectile(Handler handler,float x, float y, int width, int height, char direction) {
        super(handler, x, y, width, height);
        this.range = handler.getWorld().getEntityManager().getPlayer().getRange() *100;
        this.shootSpeed = handler.getWorld().getEntityManager().getPlayer().getShootSpeed();
        this.FacteurTaille = (width*64)/15;
        this.bounds.x =  (FacteurTaille-width)/2;
        this.bounds.y = (FacteurTaille-height)/2;
        
        this.bounds.width = width;
        this.bounds.height = height;
        this.direction = direction;
        this.contactTear = new Animation(5, Assets.tear);
        
    }
    
    public void volProjectile(){
        if(fly){
        switch (direction) {
            case 'r':
                x +=shootSpeed;
                range -= shootSpeed;
                break;
            case 'l':
                x-=shootSpeed;
                range -= shootSpeed;
                break;
            case 'u':
                y-=shootSpeed;
                range -= shootSpeed;
                break;
            case 'd':
                y+=shootSpeed;
                range -= shootSpeed;
                break;
            default:
                break;
        }
        }
    }
    
    public void contactProjectile() { //!!!!!!!!!!!!!!!!Penser à creer une classe salle
        if(this.range<=0|| x + bounds.x+this.handler.getGameCamera().getxOffset() -110    <= this.handler.getGameCamera().getxOffset() || 
                this.x+ bounds.x+bounds.width +110 +this.handler.getGameCamera().getxOffset() > this.handler.getGameCamera().getxOffset() + this.handler.getWidth()||
                y + bounds.y+this.handler.getGameCamera().getyOffset() -60    <= this.handler.getGameCamera().getyOffset()||
                this.y+ bounds.y+bounds.height +110 +this.handler.getGameCamera().getyOffset() > this.handler.getGameCamera().getyOffset()+ this.handler.getHeight()){
            fly = false;
        }

    }

    @Override
    public void update() {
                    
        if(fly){
            volProjectile();
            contactProjectile();
        }else{
            contactTear.update();
            if(contactTear.getIndex() == 15) die();
        }
    }

    @Override //(contactTear.getIndex()!=15)
    public void render(Graphics g) {
        
        g.drawImage(getCurrentAnimationFrame(),(int)(x),(int) (y),  FacteurTaille, FacteurTaille,null);
        // g.setColor(Color.red);
        //g.fillRect((int) (bounds.x+ x - handler.getGameCamera().getxOffset()), (int) (bounds.y +y- handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
        
    }
    
    private BufferedImage getCurrentAnimationFrame(){  
            return contactTear.getCurrentFrame();
    }

    @Override
    public void die() {
        setActive(false);
    }

    public void setFly(boolean fly) {
        this.fly = fly;
    }

    public boolean isFly() {
        return fly;
    }

    public char getDirection() {
        return direction;
    }
    
    
    
}
