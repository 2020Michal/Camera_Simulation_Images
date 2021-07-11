package test;

import org.junit.Test;
import primitives.Point3D;
import primitives.Vector;

import static org.junit.Assert.*;

public class VectorTest {

    Vector first = new Vector(new Point3D(5,2,0));
    Vector second = new Vector(new Point3D(-5,-3,-1));
    Vector third = new Vector(new Point3D(1,0,0));
    static double DELTA = 0.01;

    @Test
    public void scaleNew() {
        Vector other=new Vector(first.scaleNew(-2));
        assertEquals(new Vector(-10, -4, 0),other);
        other=second.scaleNew(-2);
        assertEquals(new Vector(10, 6, 2),other);
        other=third.scaleNew(0);
        assertEquals(new Vector(0, 0, 0),other);

    }

    @Test
    public void normalizeNew() {
        double l1 = first.length();
        assertEquals(new Vector(5/l1, 2/l1, 0),first.normalizeNew());
        double l2= second.length();
        assertEquals(new Vector(-5/l2, -3/l2, -1/l2),second.normalizeNew());
        double l3= third.length();
        assertEquals(new Vector(1/l3, 0, 0),third.normalizeNew());
    }
    @Test
    public void scale() {
        first.scale(-2);
        assertEquals(new Vector(-10, -4, 0),first);
        second.scale(-2);
        assertEquals(new Vector(10, 6, 2),second);
        third.scale(0);
        assertEquals(new Vector(0, 0, 0),third);
    }

    @Test
    public void length() {
        assertEquals(Math.sqrt(29),first.length(), 0.01);
        assertEquals(Math.sqrt(35),second.length(), 0.01);
        assertEquals(Math.sqrt(1),third.length(), 0.01);
    }

    @Test
    public void normalize() {
        double l1 = first.length();
        first.normalize();
        assertEquals(new Vector(5 / l1, 2 / l1, 0), first);
        double l2 = second.length();
        second.normalize();
        assertEquals(new Vector(-5 / l2, -3 / l2, -1 / l2), second);
        double l3 = third.length();
        third.normalize();
        assertEquals(new Vector(1 / l3, 0, 0), third);
    }

    @Test
    public void crossProduct() {
        Vector result=first.crossProduct(second);
        assertEquals(new Vector(-2,5,-5), result);
        result=second.crossProduct(third);
        assertEquals(new Vector(0,-1,3), result);
        result=first.crossProduct(third);
        assertEquals(new Vector(0,0,-2), result);

    }

    @Test
    public void dotProduct() {
        double dot=first.dotProduct(second);
        assertEquals(-31, dot, DELTA);
        dot=second.dotProduct(third);
        assertEquals(-5, dot, DELTA);
        dot=third.dotProduct(first);
        assertEquals(5, dot, DELTA);
    }

    @Test
    public void add() {
        first.add(second);
        assertEquals(new Vector(new Point3D(0,-1,-1)),first);
        second.add(third);
        assertEquals(new Vector(new Point3D(-4,-3,-1)),second);
    }

    @Test
    public void subtract() {
        first.subtract(second);
        assertEquals(new Vector(new Point3D(10,5,1)),first);
        second.subtract(third);
        assertEquals(new Vector(new Point3D(-6,-3,-1)),second);

    }

    @Test
    public void addNew() {
        Vector other=first.addNew(second);
        assertEquals(new Vector(new Point3D(0,-1,-1)),other);
        other=second.addNew(third);
        assertEquals(new Vector(new Point3D(-4,-3,-1)),other);
    }

    @Test
    public void subtractNew() {
        Vector other=first.subtractNew(second);
        assertEquals(new Vector(new Point3D(10,5,1)),other);
        other=second.subtractNew(third);
        assertEquals(new Vector(new Point3D(-6,-3,-1)),other);
    }


}