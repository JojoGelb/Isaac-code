/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isaac3.display;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author jordy
 */
public class Display {

    private JFrame fenetre;
    private Canvas canvas;
    
    private int width, height;
   
    public Display(){
        this.width = 1000;
        this.height = 700;
        
        createDisplay();
    }
    
    private void createDisplay(){
        fenetre = new JFrame("Isaac2");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(1200,900);
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);
        fenetre.setResizable(false);  
        
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        canvas.setFocusable(false);
        canvas.setBackground(Color.BLACK);
        
        fenetre.add(canvas);
        fenetre.pack();
    }

    public Canvas getCanvas() {
        return canvas;
    }
    
    public JFrame getFenetre(){
        return fenetre;
    }
    
    
}
