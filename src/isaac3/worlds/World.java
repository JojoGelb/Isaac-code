/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isaac3.worlds;

import isaac3.Handler;
import isaac3.entities.EntityManager;
import isaac3.entities.Mouche;
import isaac3.entities.Player;
import isaac3.entities.Rock;
import isaac3.tuiles.Tuile;
import isaac3.utils.Utils;
import isaac3.worlds.Salles.Salle2Mouche;
import isaac3.worlds.Salles.SalleRoche;
import isaac3.worlds.Salles.SalleVoid;
import java.awt.Graphics;
import java.util.ArrayList;


/**
 *
 * @author jordy
 */
public class World {
    
    private Handler handler;
    private int width, height;
    private int spawnX, spawnY;
    private int[][] tuiles;
    private final int wallWidth;
    private ArrayList<Salle> salles;
    
    //Entities
    private EntityManager entityManager;
    
    public World(Handler handler,String path){
        
        this.wallWidth = 110;
        this.handler = handler;
        entityManager= new EntityManager(handler, new Player(handler,10,10));
        
        salles = new ArrayList<>();
        
        loadWorld(path);
        
        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);
        
    }
    
    public void update(){
        entityManager.update();
    }
    
    public void render(Graphics g){

        int xStart = (int)Math.max(0, handler.getGameCamera().getxOffset() / Tuile.TUILE_WIDTH);
        int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth())/Tuile.TUILE_WIDTH);
        int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset()/Tuile.TUILE_HEIGHT);
        int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()/Tuile.TUILE_HEIGHT));
        
        
        for (int y =yStart; y< yEnd; y++){ //ici pour changer pos du jeux
            for (int x = xStart; x < xEnd; x++){
                getTuile(x, y).render(g, (int)(x * Tuile.TUILE_WIDTH - handler.getGameCamera().getxOffset()), 
                        (int)(y * Tuile.TUILE_HEIGHT - handler.getGameCamera().getyOffset()));
            }
        }
        //Entities 
        entityManager.render(g);
        
    }
    
    public Tuile getTuile(int x, int y){
        if(x <0 || y <0 || x>= width || y >= height) return Tuile.Rien;
        Tuile t = Tuile.sol[tuiles[x][y]];
        if(t == null) return Tuile.Cellar;
        
        return t;
    }
    
    private void loadWorld(String path){
        
        System.out.println(path);
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);
        
        tuiles = new int[width][height];
        
        for( int y =0; y<height;y++){
            for (int x = 0; x< width; x++){
                tuiles[x][y] = Utils.parseInt(tokens[(x+y*width)+4]);
                if(x%2==0 && y%2 ==0){              
                    if (tuiles[x][y] != 0) salles.add(new SalleRoche(x/2 * 1000, (y/2) * 700, handler, entityManager,y/2*4 + x/2));
                    else salles.add(new SalleVoid(x/2 * 1000, (y/2) * 700, handler, entityManager,y/2*4 + x/2));
                    System.out.println(x/2 * 1000 + "...." + (y/2) * 700);
                }
            }
        }
        for (Salle s: salles){
            s.DoorGenerator(salles);
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getWallWidth() {
        return wallWidth;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public ArrayList<Salle> getSalles() {
        return salles;
    }
    
    
    
    
    
    
    
    
    
}
