package test;

import elements.Camera;
import org.junit.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static org.junit.Assert.*;

public class CameraTest {

//    double screenWidth=150;
//    double screenHight=150;
//    double screenDist=100;

//
//    int Nx=3;
//    int Ny=3;

    Camera camera=new Camera(new Vector(0,1,0),new Vector(0,0,-1));

    @Test
    public void costructRayThrowAPixel() {
        Ray ray=camera.costructRayThrowAPixel(3,3,1,1,100,90,90);
        assertEquals(new Ray((new Vector(0,0,-1)).normalizeNew()),ray);
        ray=camera.costructRayThrowAPixel(3,3,3,3,100,150,150);
        double d = Math.sqrt(1.0/3.0);
        double dm = -1*Math.sqrt(1.0/3.0);
        Vector v=new Vector(d,dm,dm);
        Ray r=new Ray(v);
        assertEquals(r,ray);

    }
}