/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isaac3.states;

import isaac3.Handler;
import isaac3.worlds.World;
import isaac3.entities.Player;
import isaac3.entities.Rock;
import java.awt.Graphics;

/**
 *
 * @author jordy
 */
public class GameState extends State {
    
    //private Player player;
    public World world;
    
    
    public GameState(Handler handler){
        super(handler);
        world = new World( handler,"res/worlds/world1.txt");    
        handler.setWorld(world);
        //player = new Player(handler,300, 300);
    }


    @Override
    public void update() {
        world.update();
        //player.update();
        
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        //player.render(g);
        
    }

    
    

    
    


    
    
    
    
}
