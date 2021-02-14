/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isaac3.entities;


import java.awt.Graphics;

import isaac3.Handler;
import isaac3.gfx.Animation;
import isaac3.gfx.Assets;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author jordy
 */
public class Player extends Creature {
    
    //Animations
    
    private Animation animDown,animUp, animLeft, animRight;
    
    //hitboxDegat
    
    //protected Rectangle hitBoxDegat;
    
    private ArrayList<Projectile> projectiles;
    private float shootSize;
    
    
    public static final int DEFAULT_PLAYER_WIDTH = 56,
                            DEFAULT_PLAYER_HEIGHT = 68;
    
    private int FacteurTailleX, FacteurTailleY;

    public Player(Handler handler, float x, float y) {
        super(handler,x,y, DEFAULT_PLAYER_WIDTH,DEFAULT_PLAYER_HEIGHT);
        this.speed = speed*2;
        this.health =6;
        this.FacteurTailleX = ((this.getWidth()*64)/DEFAULT_PLAYER_WIDTH);
        this.FacteurTailleY = ((this.getHeight()*64)/DEFAULT_PLAYER_HEIGHT);
        
        //Hitbox environnement
        bounds.x = (FacteurTailleX-this.width)/2+10; 
        bounds.y = (FacteurTailleY-this.height)/2 +(8*width)/68 +30;
        bounds.width =  width - 20;
        bounds.height= height -30;
        //Hitbox Degat
        
        /*hitBoxDegat = new Rectangle();
        hitBoxDegat.x =(int)(x+ handler.getGameCamera().getxOffset() +(FacteurTailleX-this.width)/2);
        hitBoxDegat.y =(int) (y +handler.getGameCamera().getyOffset() + (FacteurTailleY-this.height)/2 +(8*width)/68+10);
        hitBoxDegat.width = width-20;
        hitBoxDegat.height = height-10;*/
        //Animations
        animDown = new Animation(80, Assets.player_down);
        animUp = new Animation(80, Assets.player_up);
        animLeft = new Animation(80, Assets.player_left);
        animRight = new Animation(80, Assets.player_right);       
         //Tear
        projectiles = new ArrayList<>();
        shootSize = 2;
        shootSpeed = shootSpeed*2;
        range = range*2;
        attackCooldown = 300;
        attackTimer = attackCooldown;
         
    }

    
    @Override
    public void update() {
        //Animations
        animDown.update();
        animLeft.update();
        animRight.update();
        animUp.update();
        //Movement
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
        //Attack
        checkAttacks();
  
    }
    
    private void checkAttacks(){
        
        Rectangle Bt,Be;
        
        for(int i =0; i < projectiles.size();i++){
            projectiles.get(i).update();
            if(!projectiles.get(i).isActive()) projectiles.remove(projectiles.get(i));
        }
        
        for(Entity e: handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this))
                continue;
            for(Projectile p: this.projectiles){

                        Bt = new Rectangle();
                        Bt.x = (int)p.x+p.bounds.x+(int)handler.getGameCamera().getxOffset();
                        Bt.y = (int)p.y+p.bounds.y+ (int)handler.getGameCamera().getyOffset();
                        Bt.width = p.bounds.width;
                        Bt.height = p.bounds.height;
                        Be = new Rectangle();
                        Be.x = (int)e.x+e.bounds.x+4;
                        Be.y = (int)e.y+e.bounds.y+4;
                        Be.width = e.bounds.width-8;
                        Be.height = e.bounds.height-8;
                    
                        if(Be.intersects(Bt)){
                            if(p.isFly() && e instanceof Creature){
                                e.hurt(damage);
                            }
                            p.setFly(false);                        
                        
                    }
            }
        }
        
        attackTimer += System.currentTimeMillis() -lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if(attackTimer < attackCooldown)
            return;
        else{
            if(handler.getKeyManager().aUp){
                Projectile p = new Projectile(handler, x-this.width/2-handler.getGameCamera().getxOffset(), y-this.height/2 -handler.getGameCamera().getyOffset(), (int)shootSize*15, (int)shootSize*15, 'u');
                projectiles.add(p);
            }else if(handler.getKeyManager().aDown){
                Projectile p = new Projectile(handler, x-this.width/2-handler.getGameCamera().getxOffset(), y -handler.getGameCamera().getyOffset(), (int)shootSize*15, (int)shootSize*15, 'd');
                projectiles.add(p);   
            }else if(handler.getKeyManager().aLeft){
                Projectile p = new Projectile(handler, x-this.width-handler.getGameCamera().getxOffset(), y -this.height/2- handler.getGameCamera().getyOffset(), (int)shootSize*15, (int)shootSize*15, 'l');
                projectiles.add(p);
            }else if(handler.getKeyManager().aRight){
                Projectile p = new Projectile(handler, x-handler.getGameCamera().getxOffset(), y -this.height/2 -handler.getGameCamera().getyOffset(), (int)shootSize*15, (int)shootSize*15, 'r');
                projectiles.add(p);
            }
        attackTimer = 0;
        }
        
        
        
    }
    
        
    @Override
    public void die() {
        System.out.println("You lose");
    }
        
    private void getInput(){
        xMove = 0;
        yMove = 0;
        
        if(handler.getKeyManager().up) yMove = -speed;
        if(handler.getKeyManager().down) yMove= speed;
        if(handler.getKeyManager().right) xMove= speed;
        if(handler.getKeyManager().left) xMove = -speed;
    }
    @Override
    public void render(Graphics g) {
        
       // g.fillRect((int) (x +bounds.x - handler.getGameCamera().getxOffset()), (int) (bounds.y +y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
        
        
        g.drawImage(getCurrentAnimationFrame(), (int) (x-handler.getGameCamera().getxOffset()), (int) (((y+(height*20)/68)) -handler.getGameCamera().getyOffset()),this.FacteurTailleX,this.FacteurTailleY, null);
        g.drawImage(getCurrentHead(),(int) (x-handler.getGameCamera().getxOffset()), (int) (y -handler.getGameCamera().getyOffset()),this.FacteurTailleX, this.FacteurTailleY, null);
        for(Projectile p: projectiles){
            p.render(g);
        }
        
        if (this.health%2 ==0 ){
            for(int i =0; i<this.health/2;i++){
            g.drawImage(Assets.uiRedFullHeart, 50 +i*30, 50,30,30, null);
            }
        }else{
            int test;
            for(test =0; test<(this.health-1)/2;test++){
                g.drawImage(Assets.uiRedFullHeart, 50 +test*30, 50,30,30, null);
            }
            g.drawImage(Assets.uiRedHalfHeart, 50 +test*30, 50,30,30, null);
            
        }
        /*g.setColor(Color.red);
        g.fillRect((int) (x +hitBoxDegat.x - handler.getGameCamera().getxOffset()), (int) (hitBoxDegat.y +y - handler.getGameCamera().getyOffset()), hitBoxDegat.width, hitBoxDegat.height);
        */

    }
    
    private BufferedImage getCurrentAnimationFrame(){
        if(xMove <0){
            
            return animLeft.getCurrentFrame();
        }else if (xMove>0){
            
            return animRight.getCurrentFrame();
        }else if (yMove < 0){
            
            return animUp.getCurrentFrame();
        }else if (yMove > 0){
            return animDown.getCurrentFrame();
        }else return Assets.player_down[2];
    }
    
    private BufferedImage getCurrentHead(){
        if(xMove <0){
            
            return Assets.playerFaceLeftEO;
        }else if (xMove>0){
            
            return Assets.playerFaceRightEO;
        }else if (yMove < 0){
            
            return Assets.playerFaceBehind;
        }else if (yMove > 0){
            return Assets.playerFaceFrontEO;
        }
        return Assets.playerFaceFrontEO;
    }


    public ArrayList<Projectile> getProjectiles() {
        return projectiles;
    }
    
    
    




    
    
    
    
    

    
    
}
