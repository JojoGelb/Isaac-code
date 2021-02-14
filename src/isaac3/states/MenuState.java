/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isaac3.states;

import isaac3.gfx.Assets;
import isaac3.Handler;
import isaac3.ui.ClickListener;
import isaac3.ui.UIImageButton;
import isaac3.ui.UIManager;
import java.awt.Graphics;

/**
 *
 * @author jordy
 */
public class MenuState extends State{
    
    private UIManager uiManager;
    
    public MenuState(Handler handler){
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUIManager(uiManager);
        
        
        
        uiManager.addObject(new UIImageButton(350,320,250,230,Assets.menuStart, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUIManager(null);
                State.setState(handler.getGame().gameState);
            }
        }));
        
    }

    @Override
    public void update() {
        uiManager.update();
        
        //A retirer pour afficher le menu
        
        handler.getMouseManager().setUIManager(null);
        State.setState(handler.getGame().gameState);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.menuBg, 0, 0,handler.getWidth(),handler.getHeight(), null);
        g.drawImage(Assets.menuTitle, 240, 150,540,100, null);
        uiManager.render(g);
       
    }
    
}
