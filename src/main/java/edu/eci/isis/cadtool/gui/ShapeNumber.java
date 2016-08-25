/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.isis.cadtool.gui;

import edu.eci.isis.cadtool.controller.Controller;
import edu.eci.isis.cadtool.model.Shape;
import java.util.List;
import javax.swing.JLabel;


/**
 *
 * @author fchaves
 */
public class ShapeNumber extends JLabel {

    private Controller controller;
    
    public ShapeNumber(Controller controller) {
        super(" ");
        this.controller = controller;
    }
    
}
