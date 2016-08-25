package edu.eci.isis.cadtool.shapes;

import edu.eci.isis.cadtool.model.Line;
import java.awt.Color;
import java.awt.Graphics2D;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fchaves
 */
public class LineRenderer {

    public void draw(Graphics2D g2, Line line) {
        g2.setPaint(Color.black);
        g2.drawLine(line.getPoint1().getX(), line.getPoint1().getY(), line.getPoint2().getX(), line.getPoint2().getY());
    }
    
}
