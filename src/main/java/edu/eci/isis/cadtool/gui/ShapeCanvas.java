/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.isis.cadtool.gui;

import edu.eci.isis.cadtool.controller.Controller;
import edu.eci.isis.cadtool.shapes.EllipseRenderer;
import edu.eci.isis.cadtool.shapes.LineRenderer;
import edu.eci.isis.cadtool.shapes.RectangleRenderer;
import edu.eci.isis.cadtool.shapes.Renderer;
import edu.eci.isis.cadtool.shapes.Renderer;
import edu.eci.isis.cadtool.model.Line;
import edu.eci.isis.cadtool.model.Rectangle;
import edu.eci.isis.cadtool.model.Ellipse;
import edu.eci.isis.cadtool.model.Shape;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observer;
import javax.swing.JPanel;
import java.util.List;
import javax.swing.event.MouseInputListener;

/**
 *
 * @author fchaves
 */
public class ShapeCanvas extends JPanel implements MouseInputListener {
    Controller controller; 
    Renderer renderer;
    
    Point startDrag, endDrag;
    
    
    public ShapeCanvas(Controller controller) {
        this.renderer = new Renderer();
        this.controller = controller;
        this.addMouseListener(this);
    }
      
    
    public void duplicateShapes(){
        controller.duplicateShapes();
        this.repaint();
    }
    

    public void mirror(){
        controller.mirror(this.getWidth());
        this.repaint();
    }
    
    
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
                
        
        List<Shape> list = controller.getShapes();        
        
        LineRenderer lineRenderer = renderer.createLineRenderer();
        RectangleRenderer rectangleRenderer = renderer.createRectangleRenderer();
        EllipseRenderer ellipseRenderer = renderer.createEllipseRenderer();
        
        
        for(Shape shape : list) {
            switch(shape.getElementType()) {
                case Line: 
                    lineRenderer.draw(g2, (Line)shape);
                    
                    break;
                case Rectangle:
                    rectangleRenderer.draw(g2, (Rectangle)shape);
                    break;
                case Ellipse:
                    ellipseRenderer.draw(g2, (Ellipse)shape);                    
                    break;
            }
        }
    } 

    @Override
    public void mouseClicked(MouseEvent e) {
        startDrag = new Point(e.getX(), e.getY());

    }

    @Override
    public void mousePressed(MouseEvent e) {
        startDrag = new Point(e.getX(), e.getY());

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        endDrag = new Point(e.getX(), e.getY());
        if (Math.abs(endDrag.x - startDrag.x) > 2 && Math.abs(endDrag.y - startDrag.y) > 2) {
            controller.addShape(startDrag, endDrag);

            this.repaint();
        }
        startDrag = null;
        endDrag = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}