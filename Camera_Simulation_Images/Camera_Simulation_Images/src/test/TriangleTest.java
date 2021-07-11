package test;

import geometries.Triangle;
import org.junit.Test;
import primitives.*;

import java.awt.*;

import static org.junit.Assert.*;

public class TriangleTest {
Triangle one=new Triangle(Color.CYAN, new Point3D(0,0,0),new Point3D(3,0,0),new Point3D(0,3,0));
    @Test
    public void getNormal() {
        Vector a = new Vector(3,0,0);
        Vector b = new Vector(0,3,0);
        Vector res = a.crossProduct(b).normalizeNew();
        assertEquals(res,one.getNormal(new Point3D(2,0,0)));
    }
}