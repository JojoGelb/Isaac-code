/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isaac3.worlds.Salles;

import isaac3.Handler;
import isaac3.entities.EntityManager;
import isaac3.entities.Mouche;
import isaac3.worlds.Salle;

/**
 *
 * @author jordy
 */
public class Salle2Mouche extends Salle {

    public Salle2Mouche(int xOffset, int yOffset, Handler handler, EntityManager entityManager, int numSalle) {
        super(xOffset, yOffset, handler, entityManager, numSalle);
        entityManager.addEntity(new Mouche(handler,xOffset+310,yOffset+310,16,16));
        entityManager.addEntity(new Mouche(handler,xOffset+500,yOffset+510,16,16));
    }
    
    
    
}
