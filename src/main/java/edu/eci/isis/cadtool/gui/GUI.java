/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.isis.cadtool.gui;

import edu.eci.isis.cadtool.controller.Controller;
import edu.eci.isis.cadtool.model.ElementType;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;

/**
 *
 * @author fchaves
 */
public class GUI extends JFrame {

    private final ShapeCanvas canvas; 
    private final ShapeList shapeList;
    private final ShapeNumber shapeNumber;
    private final JSplitPane splitPane;
    private final Controller controller;
    
    public final JMenuBar menu() {
        JMenuBar result = new JMenuBar();
        JMenu shapeMenu = new JMenu("Shape");
        JMenu transformsMenu = new JMenu("Transformations");
        
        for(final ElementType elem : ElementType.values()) {
            JMenuItem shapeMenuItem = new JMenuItem(new AbstractAction(elem.name()) {
                @Override
                public void actionPerformed(ActionEvent e) {
                     controller.setSelectedElementType(elem);
                }
            });
            shapeMenu.add(shapeMenuItem);                    
        }

        JMenu styleMenu = new JMenu("View Style");
        
        
        JMenuItem emptyStyle = new JMenuItem(new AbstractAction("Empty Style") {

            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });

        JMenuItem fillStyle = new JMenuItem(new AbstractAction("Fill Style") {

            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });

        styleMenu.add(emptyStyle);
        styleMenu.add(fillStyle);
        
        JMenuItem undoMenu = new JMenuItem(new AbstractAction("Undo") {

            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });

        JMenuItem redoMenu = new JMenuItem(new AbstractAction("Redo") {

            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });

        JMenuItem duplicate = new JMenuItem(new AbstractAction("Duplicate") {

            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.duplicateShapes();
            }
            
        });
        
        transformsMenu.add(duplicate);
        
        result.add(shapeMenu);
        result.add(styleMenu);
        result.add(undoMenu);
        result.add(redoMenu);
        result.add(transformsMenu);
        result.setLayout(new FlowLayout(FlowLayout.LEFT));       
        return result;
    }
    
    public GUI(Controller controller) {
        super("ARSW Shape");
        this.controller = controller;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.add(menu(),BorderLayout.NORTH);
        this.canvas = new ShapeCanvas(controller);
        this.shapeList = new ShapeList(controller);
        this.shapeNumber = new ShapeNumber(controller);
        this.add(shapeNumber,BorderLayout.SOUTH);
        this.splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                           canvas, shapeList);
        this.add(splitPane,BorderLayout.CENTER);
        this.setVisible(true);
        splitPane.setDividerLocation(0.80);
    }
    
}

