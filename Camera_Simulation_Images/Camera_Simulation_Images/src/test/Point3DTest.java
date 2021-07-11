package test;

import static org.junit.Assert.*;
import primitives.*;

public class Point3DTest {

    Point3D one = new Point3D(-1, -5, 2);
    Point3D two = new Point3D(2, -5, 0);

    @org.junit.Test
    public void add() {
        one.add(new Vector(two));
        assertEquals(new Point3D(1, -10, 2),one);
    }

    @org.junit.Test
    public void addPoint() {
        Point3D result = one.addPoint(two);
        assertEquals(new Point3D(1, -10, 2),result);
    }

    @org.junit.Test
    public void sub() {
        one.sub(new Vector(two));
        assertEquals(new Point3D(-3, 0, 2),one);
    }

    @org.junit.Test
    public void subPoint() {
        Point3D result = one.subPoint(two);
        assertEquals(new Point3D(-3, 0, 2),result);
    }
}