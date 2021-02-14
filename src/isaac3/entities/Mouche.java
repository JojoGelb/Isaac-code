/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isaac3.entities;

import isaac3.gfx.Animation;
import isaac3.gfx.Assets;
import isaac3.Handler;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author jordy
 */
public class Mouche extends Creature {
    
    private Animation anim,animDeath;
    private boolean dying;
    private int FacteurTaille;
    private long lastAttackTimer, attackCooldown = 300, attackTimer = attackCooldown;

    public Mouche(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        this.anim = new Animation(40,Assets.mouche);
        animDeath = new Animation(20, Assets.moucheDeath);
        this.FacteurTaille = (this.width*32)/8;
        this.dying = false;
        
        bounds.x = (FacteurTaille-width)/2;
        bounds.y = (FacteurTaille-height)/2;
        bounds.width = width;
        bounds.height = height;  
        
        attackCooldown = 800;
        attackTimer = attackCooldown;
    }
    
    

    @Override
    public void update() {
        xMove = 0 ;
        yMove = 0;
        if (handler.getGameCamera().getxOffset()<x && handler.getGameCamera().getxOffset()+1000 > x)
            deplacementMouche();
            
        move();
        
        contactDamage();

        if(dying){
            animDeath.update();
        }else
            anim.update();
        
        if(animDeath.getIndex()==10){
            setActive(false);
        } 
    }
    
    public void deplacementMouche(){
        if (handler.getWorld().getEntityManager().getPlayer().getX()>x) xMove = 1;
        if (handler.getWorld().getEntityManager().getPlayer().getX()<x) xMove = -1;
        if (handler.getWorld().getEntityManager().getPlayer().getY()>=y) yMove = 1;
        if (handler.getWorld().getEntityManager().getPlayer().getY()<y) yMove = -1;      
        if (handler.getWorld().getEntityManager().getPlayer().getX()==x) xMove = 0 ;
        if (handler.getWorld().getEntityManager().getPlayer().getY()==y) yMove = 0;
    }
    
    @Override
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

    @Override
    public void render(Graphics g) {
        if(!dying){
            g.drawImage(anim.getCurrentFrame(), (int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()), FacteurTaille,FacteurTaille,null);
        }else{
            g.drawImage(animDeath.getCurrentFrame(), (int)x, (int)y, FacteurTaille,FacteurTaille,null);
        }
        /*g.setColor(Color.red);
        g.fillRect((int) (x +bounds.x - handler.getGameCamera().getxOffset()), (int) (bounds.y +y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
        */
    }

    @Override
    public void die() {
        System.out.println("here");
       this.dying = true;
        
    }

    public boolean isDying() {
        return dying;
    }
    
    
    
}
