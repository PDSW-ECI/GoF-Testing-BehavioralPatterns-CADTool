/*
 * Copyright (C) 2016 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.isi.cadtool.test;

import edu.eci.isis.cadtool.controller.Controller;
import edu.eci.isis.cadtool.model.ElementType;
import edu.eci.isis.cadtool.model.Point;
import edu.eci.isis.cadtool.model.Shape;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * CLASES DE EQUIVALENCIA
 * 
 * mirror()
 * 
 * Clase 1: Bla Bla Bla
 *      Tipo: Valida 
 *
 * Clase 2: Bla Bla Bla
 *      Tipo: Valida / Frontera
 * 
 * Clase 1: Bla Bla Bla
 *      Tipo: Invalida / Frontera
 
 * 
 */

public class ControllerTest {
    
    public ControllerTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void duplicateTest(){
        Controller guictrl=new Controller();        
        guictrl.setSelectedElementType(ElementType.Line);
        guictrl.addShape(new java.awt.Point(10,10),new java.awt.Point(100, 100));
        guictrl.addShape(new java.awt.Point(20,20),new java.awt.Point(120, 120));
        
        guictrl.duplicateShapes();
        
        
        assertEquals("duplicateShapes in not duplicating the amount of shapes",guictrl.getShapes().size(), 4);
        
        List<Shape> shapes=guictrl.getShapes();
        
        
        for (Shape si:shapes){
            int refcount=0;
            for (Shape sj:shapes){
                if (si==sj) refcount++;
            }
            if (refcount>1){
                fail("duplicateShapes method is generating duplicated references");                        
            }
        }
        
    }

    
    @Test
    public void mirrorTest() {

    }

    
}
