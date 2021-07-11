package primitives;
import java.awt.Color;

import geometries.*;

public class Main {

    public static void main(String[] args) {

        Point2D first= new Point2D(1.0, 2.0);
        Point2D second= new Point2D(2.0, 2.0);
        System.out.println(first.equals(second));

        Point3D first1= new Point3D(1.0, 2.0,1.0);
        Point3D second1= new Point3D(1.0, 2.0,2.0);

        Vector v1= new Vector(first1);
        Vector v2= new Vector(second1);

        v1.add(v2);
        v1.subtract(v2);
        System.out.println(v1.crossProduct(v2));
        System.out.println(v1.dotProduct(v2));
        System.out.println(v1.length());
        v1.scale(2.0);
        v1.normalize();
        Sphere s1=new Sphere(Color.BLACK, 5.0, new Point3D(0.0,0.0,0.0));
        System.out.println(s1.getNormal(new Point3D(5.0,0.0,0.0)));
        Sphere s2=new Sphere(Color.BLACK, 2.0, new Point3D(0.0,0.0,0.0));
        System.out.println(s1.equals(s2));
        Triangle t1=new Triangle(Color.BLUE, new Point3D(0.0, 0.0, 0.0), new Point3D(4.0, 0.0, 0.0), new Point3D(0.0, 4.0, 0.0));
        System.out.println(t1.getNormal(new Point3D(2.0, 0.0, 0.0)));




    }

}
