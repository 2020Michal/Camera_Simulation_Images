package test;

import org.junit.Test;

import elements.Camera;
import geometries.*;
import primitives.*;
import renderer.ImageWriter;
import renderer.Render;
import Scene.Scene;

import java.awt.*;
import java.util.ArrayList;

public class RenderTest {
    @Test
    public void basicRendering(){
        Scene scene = new Scene();
        scene.set_camera(new Camera(new Point3D(0, 0, 0), new Vector(0, -1, 0), new Vector(0, 0, 1)));
        scene.set_screenDistance(100);
        scene.set_background(new Color(0, 0, 0));
        ArrayList<Geometry> geometries = new ArrayList<Geometry>();
        scene.set_geometries(geometries);
        geometries.add(new Sphere(new Color(100, 100,100 ), 50, new Point3D(0, 0, 150)));

        geometries.add(new Triangle(new Color(100, 100,100 ), new Point3D( 100, 0, 149),
                new Point3D(  0, 100, 149),
                new Point3D( 100, 100, 149)));

        geometries.add(new Triangle(new Color(100, 100,100 ), new Point3D( 100, 0, 149),
                new Point3D(  0, -100, 149),
                new Point3D( 100,-100, 149)));

        geometries.add(new Triangle(new Color(100, 100,100 ), new Point3D(-100, 0, 149),
                new Point3D(  0, 100, 149),
                new Point3D(-100, 100, 149)));

        geometries.add(new Triangle(new Color(100, 100,100 ), new Point3D(-100, 0, 149),
                new Point3D(  0,  -100, 149),
                new Point3D(-100, -100, 149)));

        ImageWriter imageWriter = new ImageWriter("test0", 500, 500, 500, 500);
        Render render = new Render(scene, imageWriter );

        render.renderImage();
        render.printGrid(50);
        render.get_imageWriter().writeToimage();
    }

    @Test
    public void basicRendering2(){
        Scene scene = new Scene();
        scene.set_camera(new Camera(new Point3D(0, 0, 0), new Vector(0, -1, 0), new Vector(0, 0, 1)));
        scene.set_screenDistance(100);
        scene.set_background(new Color(0, 0, 0));
        ArrayList<Geometry> geometries = new ArrayList<Geometry>();
        scene.set_geometries(geometries);
        geometries.add(new Sphere(new Color(250, 30, 100), 50, new Point3D(0, 0, 150)));

        geometries.add(new Triangle(new Color(20, 200, 100), new Point3D( 100, 0, 149),
                new Point3D(  0, 100, 149),
                new Point3D( 100, 100, 149)));

        geometries.add(new Triangle(new Color(0, 0, 200), new Point3D( 100, 0, 149),
                new Point3D(  0, -100, 149),
                new Point3D( 100,-100, 149)));

        geometries.add(new Triangle(new Color(100, 100,100 ), new Point3D(-100, 0, 149),
                new Point3D(  0, 100, 149),
                new Point3D(-100, 100, 149)));

        geometries.add(new Triangle(new Color(50, 50,100 ), new Point3D(-100, 0, 149),
                new Point3D(  0,  -100, 149),
                new Point3D(-100, -100, 149)));

        ImageWriter imageWriter = new ImageWriter("test0", 500, 500, 500, 500);
        Render render = new Render(scene, imageWriter );

        render.renderImage();
        render.printGrid(50);
        render.get_imageWriter().writeToimage();
    }

    @Test
    public void basicRendering3(){
        Scene scene = new Scene();
        scene.set_camera(new Camera(new Point3D(0, 0, 0), new Vector(0, -1, 0), new Vector(0, 0, 1)));
        scene.set_screenDistance(100);
        scene.set_background(new Color(0, 0, 0));
        ArrayList<Geometry> geometries = new ArrayList<Geometry>();
        scene.set_geometries(geometries);
        geometries.add(new Sphere(new Color(50, 40,100 ), 50, new Point3D(0, 0, 150)));

        geometries.add(new Triangle(new Color(30, 0,255 ), new Point3D( 100, 0, 149),
                new Point3D(  0, 100, 149),
                new Point3D( 100, 100, 149)));

        geometries.add(new Triangle(new Color(150, 20,100 ), new Point3D( 100, 0, 149),
                new Point3D(  0, -100, 149),
                new Point3D( 100,-100, 149)));

        geometries.add(new Triangle(new Color(100, 0,30 ), new Point3D(-100, 0, 149),
                new Point3D(  0, 100, 149),
                new Point3D(-100, 100, 149)));

        geometries.add(new Triangle(new Color(100, 100,100 ), new Point3D(-100, 0, 149),
                new Point3D(  0,  -100, 149),
                new Point3D(-100, -100, 149)));

        ImageWriter imageWriter = new ImageWriter("test0", 500, 500, 500, 500);
        Render render = new Render(scene, imageWriter );

        render.renderImage();
        render.printGrid(50);
        render.get_imageWriter().writeToimage();
    }

}