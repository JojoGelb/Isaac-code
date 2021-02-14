/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isaac3;

import isaac3.gfx.GameCamera;
import isaac3.input.KeyManager;
import isaac3.input.MouseManager;
import isaac3.worlds.World;

/**
 *
 * @author jordy
 */
public class Handler {
    
    private Game game;
    private World world;
    
    public Handler(Game game){
        this.game = game;
    }
    
    public int getWidth(){
        return game.getWidth();
    }
    
    public int getHeight(){
        return game.getHeight();
    }
    
    public KeyManager getKeyManager(){
        return game.getKeyManager();        
    }
    
    public MouseManager getMouseManager(){
        return game.getMouseManager();
    }
    
    public GameCamera getGameCamera(){
        return game.getGameCamera();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
    
    
}
