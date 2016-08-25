/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.isis.cadtool.gui;

import edu.eci.isis.cadtool.controller.Controller;
import edu.eci.isis.cadtool.model.Shape;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

/**
 *
 * @author fchaves
 */
public class ShapeList extends JPanel {

    private final Controller controller;
    private DefaultListModel<String> listModel;
    private JList<String> shapeList;
    private JButton deleteButton;
    
    public ShapeList(Controller control) {
        super(new BorderLayout());
        this.listModel = new DefaultListModel();
        this.shapeList = new JList(listModel);
        this.controller = control;
        this.add(shapeList,BorderLayout.CENTER);
        shapeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.deleteButton = new JButton("Delete Shape");

        deleteButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = shapeList.getSelectedIndex();
                if (index >= 0) {
                    controller.deleteShape(index);
                }
            }
        });
        
        this.add(deleteButton,BorderLayout.SOUTH);
    }
    
}
