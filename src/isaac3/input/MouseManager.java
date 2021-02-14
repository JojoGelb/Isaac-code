/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isaac3.input;

import isaac3.ui.UIManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author jordy
 */
public class MouseManager implements MouseListener, MouseMotionListener {
    
    private boolean leftPressed, rightPressed;
    private int mouseX, mouseY;
    private UIManager uIManager;
    
    public MouseManager(){
        
    }
    
    public void setUIManager(UIManager uiManager){
        this.uIManager = uiManager;
    }

    //Getters

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }
    
    
    
    //Implementeds methods

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) leftPressed = true;
        else if (e.getButton() == MouseEvent.BUTTON3) rightPressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) leftPressed = false;
        else if (e.getButton() == MouseEvent.BUTTON3) rightPressed = false;
        
        if(uIManager != null){
            uIManager.onMouseRelease(e);
        }
    }
    
        @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        
        if(uIManager != null){
            uIManager.onMouseMove(e);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    
        @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    
}
