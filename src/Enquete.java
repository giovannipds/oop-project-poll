/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.applet.Applet;
import java.awt.*;

/**
 *
 * @author giovannipds
 */
public class Enquete extends Applet {

    public static void main(String[] args) {
        Enquete e = new Enquete();
        e.start();
    }

    /**
     * Inicia o Applet.
     *
     * @see java.applet.Applet#start()
     */
    public void start() {
        super.start();
        // Interface que altera o estado do modelo
        TelaVotacao votacao = new TelaVotacao();
        votacao.setLocation(5, 5);
    }

}
