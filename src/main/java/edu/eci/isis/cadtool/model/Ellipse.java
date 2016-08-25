/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.isis.cadtool.model;

/**
 *
 * @author fchaves
 */
public class Ellipse extends Shape {
  
    @Override
    public ElementType getElementType() {
        return ElementType.Ellipse;
    }

    private Ellipse(Point p1, Point p2) {
        super(p1,p2);        
    }
    
    static public Ellipse newEllipse(Point p1,Point p2) {
        return new Ellipse(p1,p2);
    }

    @Override
    public Shape cloneShape() {
        return new Ellipse(this.getPoint1(), this.getPoint2());
    }

}
