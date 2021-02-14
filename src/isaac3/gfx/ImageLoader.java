/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isaac3.gfx;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author jordy
 */
public class ImageLoader {
    
    public static BufferedImage loadImage(String path){
        try {
            return ImageIO.read(ImageLoader.class.getResource(path));
        } catch (IOException ex) {
            Logger.getLogger(ImageLoader.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
        return null;
    }
    
    public static BufferedImage rotate(BufferedImage bimg, double angle) {

        int w = bimg.getWidth();    
        int h = bimg.getHeight();

        BufferedImage rotated = new BufferedImage(w, h, bimg.getType());  
        Graphics2D graphic = rotated.createGraphics();
        graphic.rotate(Math.toRadians(angle), w/2, h/2);
        graphic.drawImage(bimg, null, 0, 0);
        graphic.dispose();
    return rotated;
}
    public static BufferedImage horizontalFlip(BufferedImage img) {
        int w = img.getWidth();
        int h = img.getHeight();
        BufferedImage flippedImage = new BufferedImage(w, h, img.getType());
        Graphics2D g = flippedImage.createGraphics();
        g.drawImage(img, 0, 0, w, h, w, 0, 0, h, null);
        g.dispose();
        return flippedImage;
    }
    
}
