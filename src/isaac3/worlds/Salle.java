/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isaac3.worlds;

import isaac3.Handler;
import isaac3.entities.Door;
import isaac3.entities.Entity;
import isaac3.entities.EntityManager;
import isaac3.gfx.Assets;
import isaac3.worlds.Salles.SalleVoid;
import java.util.ArrayList;

/**
 *
 * @author jordy
 */
public abstract class Salle {
    
    private int xOffset, yOffset, numSalle;
    protected ArrayList<Entity> entities;
    protected Handler handler;
    protected EntityManager entityManager;
    
    public Salle(int xOffset, int yOffset, Handler handler, EntityManager entityManager, int numSalle){
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.numSalle = numSalle;
        this.handler = handler;
        this.entityManager = entityManager;
        
    }

    public int getNumSalle() {
        return numSalle;
    }
    
    public void DoorGenerator(ArrayList<Salle> salles){
        if (!(this instanceof SalleVoid)){
            if (this.numSalle == 0){
                entityManager.addEntity(new Door(handler, 0, 10, Assets.normalDoor));
                //System.out.println(salles.get(1).getNumSalle());
            }
        }
    }
        
    
}
