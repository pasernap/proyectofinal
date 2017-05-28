/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Equipo1
 */
public class atdtfr implements ActionListener{
    private Tablero board;
    @Override
    
    public void actionPerformed(ActionEvent e) {
        boolean boton= this.board.getSwap1().isSelected();
        System.out.println("hola");
        if(boton==true){
        this.board.remove(this.board.firstPanel);
        this.board.add(this.board.getSecondPanel());
        }
    }
    
}
