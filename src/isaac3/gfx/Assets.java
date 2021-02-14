/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isaac3.gfx;

import java.awt.image.BufferedImage;

/**
 *
 * @author jordy
 */
public class Assets {

    private static final int width = 32, height = 32;

    public static BufferedImage[] mouche,moucheDeath;
    public static BufferedImage playerFaceFrontEO, playerFaceFrontEC, playerFaceRightEO, playerFaceRightEC, playerFaceLeftEO, playerFaceLeftEC, playerFaceBehind;
    public static BufferedImage[] player_down,player_up,player_left,player_right;
    public static BufferedImage cellar1, cellar2, cellar3, cellar4, cellar5, cellar6;
    public static BufferedImage rock;
    public static BufferedImage[] menuStart;
    public static BufferedImage menuBg,menuTitle;
    public static BufferedImage[] tear;
    public static BufferedImage redFullHeart, uiRedFullHeart, uiRedHalfHeart;
    public static BufferedImage normalDoor,backDoor;
     
    public static void init() {
        
        
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/256.000_dartfly.png"));
        
        mouche = new BufferedImage[4];
        mouche[0] = sheet.crop(0, 1, width, height);
        mouche[1] = sheet.crop(1, 1, width, height);
        mouche[2] = sheet.crop(2, 1, width, height);
        mouche[3] = sheet.crop(3, 1, width, height);
        
        moucheDeath = new BufferedImage[11];
        moucheDeath[0] = sheet.crop(0,1,64,64);
        moucheDeath[1] = sheet.crop(1,1,64,64);
        moucheDeath[2] = sheet.crop(2,1,64,64);
        moucheDeath[3] = sheet.crop(3,1,64,64);
        moucheDeath[4] = sheet.crop(0,2,64,64);
        moucheDeath[5] = sheet.crop(1,2,64,64);
        moucheDeath[6] = sheet.crop(2,2,64,64);
        moucheDeath[7] = sheet.crop(3,2,64,64);
        moucheDeath[8] = sheet.crop(0,3,64,64);
        moucheDeath[9] = sheet.crop(1,3,64,64);
        moucheDeath[10]= sheet.crop(2,3,64,64);
        
        

        sheet = new SpriteSheet(ImageLoader.loadImage("/textures/character_001_isaac.png"));
        
        playerFaceFrontEO = sheet.crop(0, 0, width, height);
        playerFaceFrontEC = sheet.crop(1, 0, width, height);
        playerFaceRightEO = sheet.crop(2, 0, width, height);
        playerFaceRightEC = sheet.crop(3, 0, width, height);
        playerFaceLeftEO = ImageLoader.horizontalFlip(playerFaceRightEO);
        playerFaceLeftEC = ImageLoader.horizontalFlip(playerFaceRightEC);
        playerFaceBehind = sheet.crop(4, 0, width, height);
        

        player_down = new BufferedImage[10];
        player_down[0] = sheet.crop(6, 0, width, height);
        player_down[1] = sheet.crop(7, 0, width, height);
        player_down[2] = sheet.crop(0, 1, width, height);
        player_down[3] = sheet.crop(1, 1, width, height);
        player_down[4] = sheet.crop(2, 1, width, height);
        player_down[5] = sheet.crop(3, 1, width, height);
        player_down[6] = sheet.crop(4, 1, width, height);
        player_down[7] = sheet.crop(5, 1, width, height);
        player_down[8] = sheet.crop(6, 1, width, height);
        player_down[9] = sheet.crop(7, 1, width, height);
        
        player_up = new BufferedImage[10];
        player_up[0] = ImageLoader.horizontalFlip(sheet.crop(6, 0, width, height));
        player_up[1] = ImageLoader.horizontalFlip(sheet.crop(7, 0, width, height));
        player_up[2] = ImageLoader.horizontalFlip(sheet.crop(0, 1, width, height));
        player_up[3] = ImageLoader.horizontalFlip(sheet.crop(1, 1, width, height));
        player_up[4] = ImageLoader.horizontalFlip(sheet.crop(2, 1, width, height));
        player_up[5] = ImageLoader.horizontalFlip(sheet.crop(3, 1, width, height));
        player_up[6] = ImageLoader.horizontalFlip(sheet.crop(4, 1, width, height));
        player_up[7] = ImageLoader.horizontalFlip(sheet.crop(5, 1, width, height));
        player_up[8] = ImageLoader.horizontalFlip(sheet.crop(6, 1, width, height));
        player_up[9] = ImageLoader.horizontalFlip(sheet.crop(7, 1, width, height));
        
        player_right = new BufferedImage[10];
        player_right[0] = sheet.crop(0, 2, width, height);
        player_right[1] = sheet.crop(1, 2, width, height);
        player_right[2] = sheet.crop(2, 2, width, height);
        player_right[3] = sheet.crop(3, 2, width, height);
        player_right[4] = sheet.crop(4, 2, width, height);
        player_right[5] = sheet.crop(5, 2, width, height);
        player_right[6] = sheet.crop(6, 2, width, height);
        player_right[7] = sheet.crop(7, 2, width, height);
        player_right[8] = sheet.crop(0, 3, width, height);
        player_right[9] = sheet.crop(1, 3, width, height);
        
        player_left = new BufferedImage[10];
        player_left[0] = ImageLoader.horizontalFlip(sheet.crop(0, 2, width, height));
        player_left[1] = ImageLoader.horizontalFlip(sheet.crop(1, 2, width, height));
        player_left[2] = ImageLoader.horizontalFlip(sheet.crop(2, 2, width, height));
        player_left[3] = ImageLoader.horizontalFlip(sheet.crop(3, 2, width, height));
        player_left[4] = ImageLoader.horizontalFlip(sheet.crop(4, 2, width, height));
        player_left[5] = ImageLoader.horizontalFlip(sheet.crop(5, 2, width, height));
        player_left[6] = ImageLoader.horizontalFlip(sheet.crop(6, 2, width, height));
        player_left[7] = ImageLoader.horizontalFlip(sheet.crop(7, 2, width, height));
        player_left[8] = ImageLoader.horizontalFlip(sheet.crop(0, 3, width, height));
        player_left[9] = ImageLoader.horizontalFlip(sheet.crop(1, 3, width, height));
        

        sheet = new SpriteSheet(ImageLoader.loadImage("/textures/02_cellar.png"));

        cellar1 = sheet.crop(0, 0, 234, 156);
        cellar2 = sheet.crop(1, 0, 234, 156);
        cellar3 = sheet.crop(0, 1, 234, 156);
        cellar4 = sheet.crop(1, 1, 234, 156);
        cellar5 = sheet.crop(0, 2, 234, 156);
        cellar6 = sheet.crop(1, 2, 234, 156);
        
        sheet = new SpriteSheet(ImageLoader.loadImage("/textures/rocks_basement.png"));
        
        rock = sheet.crop(0, 0, width, height);
        
        sheet = new SpriteSheet(ImageLoader.loadImage("/textures/titlemenu.png"));
        
        menuStart = new BufferedImage[2];
        
        
        menuStart[0] = sheet.crop(0, 2, 160, 180);   //isa1
        menuStart[1] = (sheet.crop(1, 2, 160, 180)).getSubimage(0, 11, 160, 169);   //isa2
        menuBg = sheet.crop(0, 0, 480, 260);   //BG
        menuTitle = sheet.crop(0, 3, 480, 95);    //Title
        
        sheet = new SpriteSheet(ImageLoader.loadImage("/textures/effect_015_tearpoofb.png"));
        
        tear = new BufferedImage[16];
        
        tear[0] = sheet.crop(0, 0, 64, 64);
        tear[1] = sheet.crop(1, 0, 64, 64);
        tear[2] = sheet.crop(2, 0, 64, 64);
        tear[3] = sheet.crop(3, 0, 64, 64);
        tear[4] = sheet.crop(0, 1, 64, 64);
        tear[5] = sheet.crop(1, 1, 64, 64);
        tear[6] = sheet.crop(2, 1 ,64, 64);
        tear[7] = sheet.crop(3, 1, 64, 64);
        tear[8] = sheet.crop(0, 2, 64, 64);
        tear[9] = sheet.crop(1, 2, 64, 64);
        tear[10] = sheet.crop(2, 2, 64, 64);
        tear[11] = sheet.crop(3, 2, 64, 64);
        tear[12] = sheet.crop(0, 3, 64, 64);
        tear[13] = sheet.crop(1, 3, 64, 64);
        tear[14] = sheet.crop(2, 3, 64, 64);
        tear[15] = sheet.crop(3, 3, 64, 64);
        
        sheet = new SpriteSheet(ImageLoader.loadImage("/textures/pickup_001_heart.png"));
        
        redFullHeart = sheet.crop(0, 0, width, height);
        
        sheet = new SpriteSheet(ImageLoader.loadImage("/textures/ui_hearts.png"));
        
        uiRedFullHeart = sheet.crop(0, 0, 15, 15);
        uiRedHalfHeart = sheet.crop(1, 0, 15, 15);
        
        sheet = new SpriteSheet(ImageLoader.loadImage("/textures/door_01_normaldoor.png"));
        
        normalDoor = sheet.crop(0, 0, 64, 48);
        backDoor = sheet.crop(1, 0, 64, 48);
        
    }
}
