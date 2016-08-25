/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.isis.cadtool.shapes;

/**
 *
 * @author fchaves
 */
public class Renderer {
    
    public LineRenderer createLineRenderer() {
        return new LineRenderer();
    }

    
    public RectangleRenderer createRectangleRenderer() {
        return new RectangleRenderer();
    }

    public EllipseRenderer createEllipseRenderer() {
        return new EllipseRenderer();
    }

}
