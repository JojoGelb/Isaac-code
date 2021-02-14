/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isaac3.entities;

import isaac3.Handler;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author jordy
 */
public class EntityManager {
    
    private Handler handler;
    private Player player;
    private ArrayList<Entity> entities;
    
    public EntityManager(Handler handler, Player player){
        this.handler = handler;
        this.player = player;
        entities = new ArrayList<Entity>(); 
        addEntity(player);
    }
    
    public void update(){
        Iterator<Entity> it = entities.iterator();
        while(it.hasNext()){
            Entity e = it.next();

            if (e instanceof Player||(handler.getGameCamera().getxOffset()<e.getX() && handler.getGameCamera().getxOffset()+1000 > e.getX())) { 
                e.update();
            }
            if(!e.isActive())
                it.remove();
        }
            
    }
    
    public void render (Graphics g){
        for(int i = entities.size()-1; i >=0 ;i--){
            entities.get(i).render(g);
        }
    }
    
    public void addEntity(Entity e){
        entities.add(e);
    }
    
    //GETTERS SETTERS

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }
    
    
    
}
