/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isaac3.worlds.Salles;

import isaac3.Handler;
import isaac3.entities.EntityManager;
import isaac3.entities.Mouche;
import isaac3.entities.Rock;
import isaac3.worlds.Salle;

/**
 *
 * @author jordy
 */
public class SalleRoche extends Salle {

    public SalleRoche(int xOffset, int yOffset, Handler handler,EntityManager entityManager, int numSalle ) {
        super(xOffset, yOffset,handler,entityManager,numSalle);
        entityManager.addEntity(new Rock(handler,xOffset+110,yOffset+110));
        entityManager.addEntity(new Rock(handler,xOffset+160,yOffset+160));
        entityManager.addEntity(new Rock(handler,xOffset+110,yOffset+160));
        entityManager.addEntity(new Rock(handler,xOffset+160,yOffset+110));
        entityManager.addEntity(new Rock(handler,xOffset+210,yOffset+210));
        entityManager.addEntity(new Rock(handler,xOffset+260,yOffset+260));
        entityManager.addEntity(new Rock(handler,xOffset+210,yOffset+260));
        entityManager.addEntity(new Rock(handler,xOffset+260,yOffset+210));
        
    }
    

    
}
