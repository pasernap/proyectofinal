/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Usuario9
 */
public class Tablero extends JPanel implements ActionListener, KeyListener{
    private Timer timer; 
    private ArrayList<Circulo> circulo;
    private Carro personajePrincipal;
    private Sound sonido;
    protected boolean colision=false;
    
    private int puntaje = 0;
    JButton swap1 = new JButton("SwapToYellow");

    public boolean getColision() {
        return colision;
    }

    public void setColision(boolean colision) {
        this.colision = colision;
    }

    public JButton getSwap1() {
        return swap1;
    }

    public void setSwap1(JButton swap1) {
        this.swap1 = swap1;
    }
          
      protected JPanel firstPanel = new JPanel();

    public JPanel getSecondPanel() {
        return secondPanel;
    }

    public void setSecondPanel(JPanel secondPanel) {
        this.secondPanel = secondPanel;
    }
      protected JPanel secondPanel = new JPanel();
      
    public Tablero(){
              super(new BorderLayout());
        
      this.sonido = new Sound("ball.wav");
      this.setFocusable(true);
      this.addKeyListener(this);
      this.personajePrincipal = new Carro(100,743-96);
      
      this.circulo = new ArrayList<Circulo>();
      
      this.circulo.add(new Circulo(680,720));
      this.circulo.add(new Circulo(740,720));
      this.circulo.add(new Circulo(800,720));
      
      this.timer = new Timer(50, this);
      this.sonido.loop();
      this.timer.start();
        
    }

    public JPanel getFirstPanel() {
        return firstPanel;
    }

    public void setFirstPanel(JPanel firstPanel) {
        this.firstPanel = firstPanel;
    }
    
    
    protected void paintComponent(Graphics g) {
         super.paintComponent(g);
         //omagen---------
         
       
         
         Image fondo = loadImage("fondoA1.png");//omagen---------
        g.drawImage(fondo, 0, 0, null);
        g.drawRect(720, 700, 43, 43);
         for(Circulo c: this.circulo)
            c.dibujar(g,this);
         
         this.personajePrincipal.dibujar(g,this);
         g.drawString("Puntaje " + puntaje, 40, 40);
         
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        validarColisiones();
         for(Circulo c: this.circulo){
            c.mover();
            
            if(personajePrincipal.getY()== 800){
            
            }else
                
            personajePrincipal.setY(800);
         }
            repaint();
        
    }
     
    
    public void validarColisiones(){
        
        Rectangle recPersonaje= this.personajePrincipal.obtenerRectangulo();
        ArrayList<Circulo> copia = (ArrayList<Circulo>) this.circulo.clone();
        for(Circulo c : circulo){
           Rectangle RecCir = c.obtenerRectangulo();
           if(recPersonaje.intersects(RecCir)){
               this.puntaje++;
               this.colision=true;
           }
           this.circulo=copia;
       
        }
            if(puntaje==0){
               this.colision=false;
           }
              
           this.puntaje=0;
    }

    @Override
    public void keyTyped(KeyEvent e) {
     
    }

    @Override
    public void keyPressed(KeyEvent e) {
       this.personajePrincipal.keyPressed(e,this.colision);
    }

    @Override
    public void keyReleased(KeyEvent e) {
       this.personajePrincipal.keyReleased(e,this.colision);
    }
     public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
}
