/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isaac3.entities;

import java.awt.image.BufferedImage;

/**
 *
 * @author jordy
 */
public class Item {
    
    public static final int ITEMWIDTH = 32, ITEMHEIGHT = 32, PICKED_UP= -1;
    protected BufferedImage texture;
    protected String name;
    protected final int id;
    
    protected int x,y,count;
    
    
    public Item(BufferedImage texture, String name, int id){
        this.texture = texture;
        this.name = name;
        this.id = id;
        count = 1;
    }
}
