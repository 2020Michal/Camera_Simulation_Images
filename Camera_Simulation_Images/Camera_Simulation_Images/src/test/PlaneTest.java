package test;

import geometries.Plane;
import org.junit.Test;
import primitives.Point3D;
import primitives.Vector;

import java.awt.*;

import static org.junit.Assert.*;

public class PlaneTest {
    Plane one=new Plane(Color.BLACK,new Point3D(2,5,1),new Vector(1,0,0));
    @Test
    public void getNormal() {
        assertEquals(new Vector(1,0,0),one.getNormal(new Point3D(3,1,1)));

    }
}