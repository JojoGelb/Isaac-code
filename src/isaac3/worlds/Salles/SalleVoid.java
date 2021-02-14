/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isaac3.worlds.Salles;

import isaac3.Handler;
import isaac3.entities.EntityManager;
import isaac3.entities.Rock;
import isaac3.worlds.Salle;

/**
 *
 * @author jordy
 */
public class SalleVoid extends Salle {
    
    public SalleVoid(int xOffset, int yOffset, Handler handler,EntityManager entityManager, int numSalle ) {
        super(xOffset, yOffset,handler,entityManager,numSalle);    
    }
}
