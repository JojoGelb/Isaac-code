/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isaac3.entities;

import isaac3.Handler;
import java.awt.Rectangle;

/**
 *
 * @author jordy
 */
public abstract class Creature extends Entity {
    
    
    public static final float DEFAULT_SPEED = 3.0f,
                              DEFAULT_RANGE = 3.0f,
                              DEFAULT_SHOOTSPEED=3.0f;
                              
    
    public static final int DEFAULT_CREATURE_WIDTH = 64,
                            DEFAULT_CREATURE_HEIGHT = 64,
                            DEFAULT_DAMAGE= 1;
    
    
    protected int damage;
    protected float speed,range,shootSpeed;
    protected float xMove, yMove;
    protected long lastAttackTimer, attackCooldown = 300, attackTimer = attackCooldown;
    
    public Creature(Handler handler,float x, float y, int width, int height){
        super(handler,x,y, width, height);
        speed = DEFAULT_SPEED;
        shootSpeed = DEFAULT_SHOOTSPEED;
        xMove = 0;
        yMove = 0;
        this.damage = DEFAULT_DAMAGE;
        this.range = DEFAULT_RANGE;
    }
    
    //*******************METHODES***********************//
    
    public void move(){
        if(!checkEntityCollisions(xMove,0f))
            moveX();
        if(!checkEntityCollisions(0f,yMove))
            moveY();
    }
    
    public void moveX(){
        
        if(xMove > 0){// Moving right
            int tx = (int) (x+xMove+ bounds.x + bounds.width);
            //if (tx <= handler.getGameCamera().getxOffset()+handler.getWidth() -handler.getWorld().getWallWidth()){
                x+=xMove;
            //}
        }else if (xMove < 0){//Moving Left
            int tx = (int) (x+xMove+ bounds.x);
            //if (tx >= handler.getGameCamera().getxOffset() +handler.getWorld().getWallWidth()){
                x+=xMove;
            //}
        }
    }
    
    public void moveY(){
        if(yMove < 0){// moving up
            int ty = (int) (y+ yMove + bounds.y);
           // if (ty + this.height -50 >= handler.getGameCamera().getyOffset() +handler.getWorld().getWallWidth()){
                y+=yMove;
           // }
        }else if (yMove > 0){ //moving down
             int ty = (int) (y+ yMove + bounds.y + bounds.height);
            // if (ty <= handler.getGameCamera().getyOffset()+handler.getHeight()-handler.getWorld().getWallWidth()){
                y+=yMove;
           // }
        }
    }
    
        @Override
    public boolean checkEntityCollisions(float xOffset, float yOffset){
        for(Entity e : handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this))
                continue;
            if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))) 
                return true;
            /*if(e.getCollisionBounds(0f, 0f).intersects(handler.getWorld().getEntityManager().getPlayer().hitBoxDegat)){
                System.out.println("Hell yeah");
                return true;
                
            }*/
        }
        return false;
    }
    
    public boolean checkEntityCollisionsToPlayer(float xOffset, float yOffset){

        if(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))){ 
            return true;
        }else
            return false;
    }
    
    @Override
    public Rectangle getCollisionBounds(float xOffset, float yOffset){
        return new Rectangle((int) (x+ bounds.x + xOffset), (int) (y + bounds.y+ yOffset),bounds.width,bounds.height);
    }
    
        public void contactDamage(){
        attackTimer += System.currentTimeMillis() -lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if(attackTimer < attackCooldown)
            return;
        else{
            if( checkEntityCollisionsToPlayer(5f, 5f)){
                handler.getWorld().getEntityManager().getPlayer().hurt(1);
                attackTimer = 0;
            }else if( checkEntityCollisionsToPlayer(-5f, -5f)){
                handler.getWorld().getEntityManager().getPlayer().hurt(1);
                attackTimer = 0;
            }
        }
    }
    
    
    
    
    //******************GETTERS SETTERS*********************//

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }
    
    

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
    
    public float getRange(){
        return this.range;
    }
    
    public float getShootSpeed(){
        return this.shootSpeed;
    }
    
    
    
    
    
    
    
}
