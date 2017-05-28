/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carro;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Personaje principal
 */
public class Carro {
    private int x;
    private int y;

    public void setY(int y) {
        this.y = y;
    }
    private Image tileset;
   
        
    public Carro(int x, int y) {
        this.x = x;
        this.y = y;
        this.tileset = loadImage("characborrador.png");     
        
    }

    public Image getTileset() {
        return tileset;
    }

    public void setTileset(Image tileset) {
        this.tileset = tileset;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
    public Carro(){
       this.x=20;
       this.y=0;
    }
    public void dibujar(Graphics g, JPanel panel){
       g.setColor(Color.red);
       g.drawImage(tileset, x, y, null);
      // g.drawImage(tileset, x, y, panel);
    }
    
    
   protected Image loadImage(String imageName) {
       ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
         return image;
    }
    
    public void keyPressed(KeyEvent e, boolean Colision) {
        
          int key = e.getKeyCode();
          if(key == KeyEvent.VK_UP && (Colision == true)){
              y -= 50;
          }
           if(key == KeyEvent.VK_LEFT && (Colision == false)){
               x -= 10;
          }
           if(key ==KeyEvent.VK_RIGHT && (Colision == false)){
              x += 10;
          }
        
        
    }
     public void keyReleased(KeyEvent e,boolean Colision){
    
        int key = e.getKeyCode();
 
        if (key == KeyEvent.VK_UP && (Colision == true)) {
            y += 50;
        }

    
    }
    public void mover(){
       this.x+=1;
       //this.y+=1;
    }
    
     public Rectangle obtenerRectangulo(){
       return new Rectangle(x, y, 96, 96);
    }
}
