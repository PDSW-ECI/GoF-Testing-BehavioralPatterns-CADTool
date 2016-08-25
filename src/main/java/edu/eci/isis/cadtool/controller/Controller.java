/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.isis.cadtool.controller;

import edu.eci.isis.cadtool.model.ElementType;
import edu.eci.isis.cadtool.model.ShapeFactory;
import edu.eci.isis.cadtool.model.Point;
import edu.eci.isis.cadtool.model.Shape;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 *
 * @author fchaves
 */
public class Controller {
    private ElementType selectedElement = ElementType.Line;
    
    private final ShapeFactory shapeFactory = new ShapeFactory();
    
    private final List<Shape> shapes = new ArrayList();
    
    public Controller() {
        
    }
    
    /**
     * Duplica todas las figuras, y las ubica en una nueva posicion.
     * @pre la coleccion 'shapes' no tiene referencias duplicadas
     * @pos la coleccion 'shapes' contiene el doble de figuras
     * @pos la coleccion 'shapes' no tiene referencias duplicadas
     */
    public void duplicateShapes(){
        
        List<Shape> newShapes=new LinkedList<>();
        
        int displacementDelta=10+new Random(System.currentTimeMillis()).nextInt(50);
        
        for (Shape s:shapes){
            Shape ns=s.cloneShape();
            ns.setPoint1(new Point(s.getPoint1().getX(),s.getPoint1().getY()+displacementDelta));
            ns.setPoint2(new Point(s.getPoint2().getX(),s.getPoint2().getY()+displacementDelta));
            newShapes.add(ns);
        }
        for (Shape ns:newShapes){
            shapes.add(ns);
        }
        
                    
        
    }
    
    


    /**
     * Crea una imagen espejo, en la mitad derecha del canvas, con las figuras 
     * de la mitad izquierda del mismo. Aquellas figuras que se esten en 
     * ambas mitades (es decir, que son intersectadas por la linea imaginaria
     * vertical del centro de la pantalla) no se tienen en cuenta para la 
     * imagen espejo.
     * 
     * @pre la coleccion 'shapes' no contiene referencias duplicadas.
     * @pos la coleccion 'shapes' tendra tantas figuras adicionales como
     *      figuras existentes a la izquierda del canvas, y estas 
     *      seran una imagen invertida de las originales.
     * 
     */
    /*
                      |
      +-------+       |       +-------+
      |       |       |       |       |
      |       |   +   |   +   |       |
      |       |   |   |   |   |       |
      |       |   +   |   +   |       |
      +-------+       |       +-------+
                      |
                      |
           +-------+  | +--------+
                      |
                      |
                      |
                      |
                      +
    */        
    public void mirror(int canvasWidth){

        LOG.info("Generating mirror image with canvas width of "+canvasWidth);
        
    }

    private static final Logger LOG = Logger.getLogger(Controller.class.getName());
    
    
    
    public void addShape(java.awt.Point ap1,java.awt.Point ap2) {
        Point p1 = Point.newPoint(ap1.x, ap1.y);
        Point p2 = Point.newPoint(ap2.x, ap2.y);
        
        shapes.add(shapeFactory.createShape(selectedElement, p1, p2));
    }
    
    public void addShape(Integer index, Shape shape) {
        shapes.add(index,shape);
    }   
    
    public void deleteShape(Integer index) {
        int idx = index;
        shapes.remove(idx);
    }

    public void deleteShape(Shape shape) {        
        shapes.remove(shape);
    }
    
    public List<Shape> getShapes() {
        return shapes;
    }
    
    public void setSelectedElementType(ElementType elementType) {
        this.selectedElement = elementType;
    }  
    
    public ElementType getSelectedElementType() {
        return this.selectedElement;
    }
}
