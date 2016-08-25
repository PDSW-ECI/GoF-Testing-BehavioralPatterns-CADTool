/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.isis.cadtool.gui;

import edu.eci.isis.cadtool.controller.Controller;


/**
 *
 * @author fchaves
 */
public class Application {
    
    static public void main(String args[]) {
        Controller controller = new Controller();
        GUI gui = new GUI(controller);
        
    }
}
