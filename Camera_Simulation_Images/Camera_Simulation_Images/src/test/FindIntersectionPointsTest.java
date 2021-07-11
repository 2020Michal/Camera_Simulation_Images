package test;


import geometries.Plane;
import geometries.Sphere;
import geometries.Triangle;
import org.junit.Test;
import primitives.*;
import elements.*;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class FindIntersectionPointsTest {

        @Test
        public void testSphereIntersectionPoints(){

            Coordinate c0 = new Coordinate(0.0);
            Coordinate c1 = new Coordinate(1.0);
            Coordinate cminus = new Coordinate(-1.0);
            Coordinate cminus3 = new Coordinate(-3.0);

            Point3D p010 = new Point3D(c0, c1, c0);
            Point3D p00m1 = new Point3D(c0, c0, cminus);
            Point3D p00m3 = new Point3D(c0, c0, cminus3);

            final int WIDTH  = 3;
            final int HEIGHT = 3;

            Ray[][] rays = new Ray [HEIGHT][WIDTH];

            Camera camera = new Camera(new Point3D(c0 ,c0 ,c0),
                    new Vector (p010),
                    new Vector (p00m1));

            Sphere sphere  = new Sphere(new Color(0,0,0),1, new Point3D(p00m3));
            Sphere sphere2 = new Sphere(new Color(0,0,0), 10, new Point3D(p00m3));

            // Only the center ray intersect the sphere in two locations
            ArrayList<Point3D> intersectionPointsSphere = new ArrayList<Point3D>();

            // The sphere encapsulates the view plane - all rays intersect with the sphere once
            ArrayList<Point3D> intersectionPointsSphere2 = new ArrayList<Point3D>();

            System.out.println("Camera:\n" + camera);

            for (int i = 0; i < HEIGHT; i++){
                for (int j = 0; j < WIDTH; j++){

                    rays[i][j] = camera.costructRayThrowAPixel(
                            WIDTH, HEIGHT, (double)j, (double)i, 1.0, 3.0 * WIDTH, 3.0 * HEIGHT);

                    ArrayList<Point3D> rayIntersectionPoints  = sphere. findIntersections(rays[i][j]);
                    ArrayList<Point3D> rayIntersectionPoints2 = sphere2.findIntersections(rays[i][j]);

                    for (Point3D iPoint: rayIntersectionPoints)
                        intersectionPointsSphere.add(iPoint);

                    for (Point3D iPoint: rayIntersectionPoints2)
                        intersectionPointsSphere2.add(iPoint);

                }
            }
            assertEquals(2, intersectionPointsSphere. size());

            assertTrue(intersectionPointsSphere2.size() == 9);

            System.out.println("Intersection Points:");
            for (Point3D iPoint: intersectionPointsSphere){

                Coordinate cminus2 = new Coordinate(-2.0);
                Coordinate cminus4 = new Coordinate(-4.0);
                Point3D p00m2 = new Point3D(c0, c0, cminus2);
                Point3D p00m4 = new Point3D(c0, c0, cminus4);

                assertTrue(iPoint.equals(p00m2)||
                        iPoint.equals(p00m4) );

                System.out.println(iPoint);
            }
        }

        @Test
        public void testPlaneIntersectionPoints(){

            final int WIDTH  = 3;
            final int HEIGHT = 3;

            Ray[][] rays = new Ray [HEIGHT][WIDTH];

            Coordinate c0 = new Coordinate(0.0);
            Coordinate c1 = new Coordinate(1.0);
            Coordinate cminus = new Coordinate(-1.0);
            Coordinate cminus3 = new Coordinate(-3.0);


            Coordinate cminusquarter = new Coordinate(-0.25);



            Point3D p010 = new Point3D(c0, c1, c0);
            Point3D p00m1 = new Point3D(c0, c0, cminus);
            Point3D p00m3 = new Point3D(c0, c0, cminus3);
            Point3D p0minqrtmin1 = new Point3D(c0,cminusquarter, cminus);

            Camera camera = new Camera(new Point3D(c0 ,c0 ,c0),
                    new Vector (p010),
                    new Vector (p00m1));

// plane orthogonal to the view plane
            Plane plane = new Plane(new Color(0,0,0),  new Point3D (p00m3),new Vector(p00m1));



            // 45 degrees to the view plane

            Plane plane2 = new Plane(new Color(0,0,0),  new Point3D (p00m3),new Vector(p0minqrtmin1));

            ArrayList<Point3D> intersectionPointsPlane = new ArrayList<Point3D>();
            ArrayList<Point3D> intersectionPointsPlane2 = new ArrayList<Point3D>();


            for (int i = 0; i < HEIGHT; i++){
                for (int j = 0; j < WIDTH; j++){

                    rays[i][j] = camera.costructRayThrowAPixel(
                            WIDTH, HEIGHT, j, i, 1.0, 3.0 * WIDTH, 3.0 * HEIGHT);

                    ArrayList<Point3D> rayIntersectionPoints   = plane. findIntersections(rays[i][j]);
                    ArrayList<Point3D> rayIntersectionPoints2  = plane2.findIntersections(rays[i][j]);

                    for (Point3D iPoint: rayIntersectionPoints)
                        intersectionPointsPlane.add(iPoint);

                    for (Point3D iPoint: rayIntersectionPoints2)
                        intersectionPointsPlane2.add(iPoint);
                }
            }

            assertTrue(intersectionPointsPlane. size() == 9);
            assertTrue(intersectionPointsPlane2.size() == 9);

            for (Point3D iPoint: intersectionPointsPlane)
                System.out.println(iPoint);

            System.out.println("---");

            for (Point3D iPoint: intersectionPointsPlane2)
                System.out.println(iPoint);
        }


        @Test
        public void testTriangleIntersectionPoints(){

            final int WIDTH  = 3;
            final int HEIGHT = 3;

            Ray[][] rays = new Ray [HEIGHT][WIDTH];


            Coordinate c0 = new Coordinate(0.0);
            Coordinate c1 = new Coordinate(1.0);
            Coordinate cminus = new Coordinate(-1.0);

            Coordinate cminus2 = new Coordinate(-2.0);

            Coordinate c10 = new Coordinate(10.0);



            Point3D p010 = new Point3D(c0, c1, c0);
            Point3D p00m1 = new Point3D(c0, c0, cminus);

            Camera camera = new Camera(new Point3D(c0 ,c0 ,c0),
                    new Vector (p010),
                    new Vector (p00m1));



            Triangle triangle = new Triangle(new Color(0,0,0),
                    new Point3D(c0 ,c1 ,cminus2),
                    new Point3D(c1 ,cminus ,cminus2),
                    new Point3D(cminus ,cminus ,cminus2));


            Triangle triangle2 = new Triangle(new Color(0,0,0),
                    new Point3D(c0 ,c10 ,cminus2),
                    new Point3D(c1 ,cminus ,cminus2),
                    new Point3D(cminus ,cminus ,cminus2));

            ArrayList<Point3D> intersectionPointsTriangle = new ArrayList<Point3D>();
            ArrayList<Point3D> intersectionPointsTriangle2 = new ArrayList<Point3D>();

            System.out.println("Camera:\n" + camera);

            for (int i = 0; i < HEIGHT; i++){
                for (int j = 0; j < WIDTH; j++){

                    rays[i][j] = camera.costructRayThrowAPixel(
                            WIDTH, HEIGHT, j, i, 1.0, 3.0 * WIDTH, 3.0 * HEIGHT);

                    ArrayList<Point3D> rayIntersectionPoints   = triangle.  findIntersections(rays[i][j]);
                    ArrayList<Point3D> rayIntersectionPoints2  = triangle2. findIntersections(rays[i][j]);

                    for (Point3D iPoint: rayIntersectionPoints)
                        intersectionPointsTriangle.add(iPoint);

                    for (Point3D iPoint: rayIntersectionPoints2)
                        intersectionPointsTriangle2.add(iPoint);
                }
            }

            assertTrue(intersectionPointsTriangle.size() == 1);
            assertTrue(intersectionPointsTriangle2.size() == 2);

            System.out.println("Intersection Points of Triangles:");
            for (Point3D iPoint: intersectionPointsTriangle){
                System.out.println(iPoint);
            }
            System.out.println("--");
            for (Point3D iPoint: intersectionPointsTriangle2){
                System.out.println(iPoint);
            }

        }

}