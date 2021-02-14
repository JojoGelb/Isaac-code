/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isaac3.tuiles;

import isaac3.gfx.Assets;
import isaac3.gfx.ImageLoader;
import isaac3.tuiles.Tuile;
import java.awt.image.BufferedImage;

/**
 *
 * @author jordy
 */
public class Cellar extends Tuile {
    

    public Cellar(int id, int type, int angle, boolean miror) {
        super(Assets.cellar1, id, type ,angle ,miror);
        this.texture = setTexture();
        this.texture = setAngle();
        this.texture = setMiror();
    }
    
    public BufferedImage setTexture(){
        if(this.type ==0)return Assets.menuTitle;
        if(this.type ==1)return Assets.cellar1;
        if(this.type ==2)return Assets.cellar2;
        if(this.type ==3)return Assets.cellar3;
        if(this.type ==4)return Assets.cellar4;
        if(this.type ==5)return Assets.cellar5;
        if(this.type ==6)return Assets.cellar6;
        return Assets.menuTitle;
    }
    
    public BufferedImage setAngle(){
        if(angle != 0) return ImageLoader.rotate(texture, (double)angle);
        return texture;           
    }
    
    public BufferedImage setMiror(){
        if(miror) return ImageLoader.horizontalFlip(texture);
        return texture;
    }
    
}
