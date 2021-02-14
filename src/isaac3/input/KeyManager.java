/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isaac3.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author jordy
 */
public class KeyManager implements KeyListener {
    
    private boolean[] keys;
    public boolean up,down, left, right;
    public boolean aUp,aDown, aLeft, aRight;;
    
    public KeyManager(){
        keys = new boolean[256];
    }
    
    public void update(){
        up = keys[KeyEvent.VK_Z];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_Q];
        right = keys[KeyEvent.VK_D];
        
        aUp = keys[KeyEvent.VK_UP];
        aDown = keys[KeyEvent.VK_DOWN];
        aLeft = keys[KeyEvent.VK_LEFT];
        aRight = keys[KeyEvent.VK_RIGHT];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
}
