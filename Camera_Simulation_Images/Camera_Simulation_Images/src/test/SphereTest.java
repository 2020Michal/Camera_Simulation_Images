package test;

import geometries.Sphere;
import org.junit.Test;
import primitives.Point3D;
import primitives.Vector;

import java.awt.*;

import static org.junit.Assert.*;

public class SphereTest {
    Sphere one=new Sphere(Color.BLUE,5,new Point3D(0,0,0));

    @Test
    public void getNormal() {
        assertEquals(new Vector(1,0,0),one.getNormal(new Point3D(5,0,0)));
        assertEquals(new Vector(0,1,0),one.getNormal(new Point3D(0,3,0)));

    }
}