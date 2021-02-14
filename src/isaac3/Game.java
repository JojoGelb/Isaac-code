/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isaac3;

import isaac3.states.State;
import isaac3.input.KeyManager;
import isaac3.states.GameState;
import isaac3.states.MenuState;
import isaac3.gfx.Assets;
import isaac3.display.Display;
import isaac3.gfx.GameCamera;
import isaac3.input.MouseManager;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 *
 * @author jordy
 */
public class Game implements Runnable{

    private Display display;
    private int width, height;
    
    private boolean running = false;
    private Thread thread;
    
    private BufferStrategy bs;
    private Graphics g;
    
    //States
    public State gameState;  //private
    public State menuState;
    
    //Input
    
    private KeyManager keyManager;
    private MouseManager mouseManager;
    
    //Camera
    
    private GameCamera gameCamera;
    
    private Handler handler;
    
    
    public Game(){
        this.width = 1000;
        this.height = 700;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
        
    }
    
    private void init(){
        display = new Display();
        display.getFenetre().addKeyListener(keyManager);
        display.getFenetre().addMouseListener(mouseManager);
        display.getFenetre().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        Assets.init();
        
        gameCamera = new GameCamera(this,0, 0);
        handler = new Handler(this);
        
        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        State.setState(menuState); //gameState
        
    }

    private void update(){
        keyManager.update();
        if(State.getState() != null) State.getState().update();
    }
    
    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Clear screen
        g.clearRect(0, 0, width, height);
        //********************Dessin***********************//
        
        if(State.getState() != null) State.getState().render(g);
        
        //*******************Dessin**********************//
        bs.show();
        g.dispose();
    }

    @Override
    public void run() {
        
        init();
        
        int fps = 60;
        double timePerUpdate = 1000000000/fps;
        double delta =0;
        long now;
        long lastTime = System.nanoTime();
        long timer =0;
        int updates =0;
        
        while(running){
            now = System.nanoTime();
            delta += (now - lastTime)/ timePerUpdate;
            timer += now - lastTime;
            lastTime = now;
            
            if (delta >= 1){                       
                update();
                render();
                updates++;
                delta--;
            }
            
            if(timer >= 1000000000){
                System.out.println("Updates and Frames: "+ updates);
                updates =0;
                timer =0;
            }
        }
        
        stop();
    }

    
    
    
    public synchronized void start(){
        if(running) return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    public synchronized void stop(){
        if(!running) return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
        }
    }
    
    //*************************GETTERS SETTERS***************************//
    
    public KeyManager getKeyManager(){
        return keyManager;
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }
    
    

    public GameCamera getGameCamera() {
        return gameCamera;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public State getGameState() {
        return gameState;
    }
    
    


    
    
    
    
    
    
}
