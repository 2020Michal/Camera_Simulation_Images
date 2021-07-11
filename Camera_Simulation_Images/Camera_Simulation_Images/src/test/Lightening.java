package test;

import java.awt.Color;


import geometries.Pentagon;
import org.junit.Test;

import elements.PointLight;
import elements.SpotLight;
import geometries.Sphere;
import geometries.Triangle;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import Scene.*;

public class Lightening {


    @Test
    public void emmissionTest(){

        Scene scene = new Scene();

        scene.addGeometry(new Sphere( new Color(255,0,0),50, new Point3D(0.0, 0.0, -149)));

        Triangle triangle = new Triangle(new Color(0,255,0), new Point3D( 100, 0, -149),
                new Point3D(  0, 100, -149),
                new Point3D( 100, 100, -149));

        Triangle triangle2 = new Triangle(new Color(0,0,255), new Point3D( 100, 0, -149),
                new Point3D(  0, -100, -149),
                new Point3D( 100,-100, -149));

        Triangle triangle3 = new Triangle(new Color(255,255,0), new Point3D(-100, 0, -149),
                new Point3D(  0, 100, -149),
                new Point3D(-100, 100, -149));

        Triangle triangle4 = new Triangle(new Color(255,0,255), new Point3D(-100, 0, -149),
                new Point3D(  0,  -100, -149),
                new Point3D(-100, -100, -149));

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);
        scene.addGeometry(triangle3);
        scene.addGeometry(triangle4);

        ImageWriter imageWriter = new ImageWriter("Emmition test", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImage();
        render.printGrid(50);
        imageWriter.writeToimage();
    }


    @Test
    public void emmissionTest2(){

        Scene scene = new Scene();

        scene.addGeometry(new Sphere( new Color(255,0,0),50, new Point3D(0.0, 0.0, -149)));



        Pentagon pentagon = new Pentagon(new Color(150, 97, 22), new Point3D(  0, 100, -149), new Point3D(-100, 0, -149),
                new Point3D(-100, -100, -149), new Point3D(  0,  -100, -149), new Point3D( 100, 0, -149));

        Material m4=new Material();
        m4.set_Kr(0.8);
        m4.set_n(15);
        pentagon.set_material(m4);

        scene.addGeometry(pentagon);

        ImageWriter imageWriter = new ImageWriter("Emmition test2", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImage();
        render.printGrid(50);
        imageWriter.writeToimage();
    }

    @Test
    public void spotLightTest2(){

        Scene scene = new Scene();
        scene.set_screenDistance(200);
        Sphere sphere = new Sphere(new Color(0, 0, 100),500, new Point3D(0.0, 0.0, -1000));
        Material m=new Material();
        m.set_n(20);
        sphere.set_material(m);
        scene.addGeometry(sphere);

        Triangle triangle = new Triangle(   new Color (0, 0, 100), new Point3D(-125, -225, -260),
                new Point3D(-225, -125, -260),
                new Point3D(-225, -225, -270));

        Material m1=new Material();
        m1.set_n(20);
        triangle.set_material(m);
        scene.addGeometry(triangle);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150),
                0.1, 0.00001, 0.000005, new Vector(2, 2, -3)));

        ImageWriter imageWriter = new ImageWriter("Spot test 2", 500, 500, 500, 500);

        Render render = new Render( scene,imageWriter);

        render.renderImage();
        imageWriter.writeToimage();

    }


    @Test
    public void spotLightTest(){

        Scene scene = new Scene();
        Sphere sphere = new Sphere(new Color(0, 0, 100), 800,new Point3D(0.0, 0.0, -1000));
        Material m=new Material();
        m.set_n(20);
        sphere.set_material(m);
        scene.addGeometry(sphere);
        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -100),
                 0, 0.00001, 0.000005,new Vector(2, 2, -3)));

        ImageWriter imageWriter = new ImageWriter("Spot test", 500, 500, 500, 500);

        Render render = new Render( scene,imageWriter);

        render.renderImage();
        imageWriter.writeToimage();

    }


    @Test
    public void pointLightTest(){

        Scene scene = new Scene();
        Sphere sphere = new Sphere (new Color(0, 0, 100),800, new Point3D(0.0, 0.0, -1000));
        Material m=new Material();
        m.set_n(20);
        sphere.set_material(m);
        scene.addGeometry(sphere);
        scene.addLight(new PointLight(new Color(255,100,100), new Point3D(-200, -200, -100),
                0, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("Point test", 500, 500, 500, 500);

        Render render = new Render(scene,imageWriter);

        render.renderImage();
        imageWriter.writeToimage();


    }

    @Test
    public void spotLightTest3(){

        Scene scene = new Scene();

        Triangle triangle = new Triangle(new Color(0,0,0),new Point3D(  3500,  3500, -2000),
                new Point3D( -3500, -3500, -1000),
                new Point3D(  3500, -3500, -2000));

        Triangle triangle2 = new Triangle(new Color(0,0,0),new Point3D(  3500,  3500, -2000),
                new Point3D( -3500,  3500, -1000),
                new Point3D( -3500, -3500, -1000));

        Material m=new Material();
        m.set_n(1);
        triangle.set_material(m);
        triangle2.set_material(m);

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100),
                 0, 0.000001, 0.0000005,new Vector(-2, -2, -3)));


        ImageWriter imageWriter = new ImageWriter("Spot test 3", 500, 500, 500, 500);

        Render render = new Render( scene,imageWriter);

        render.renderImage();
        imageWriter.writeToimage();

    }

    @Test
    public void pointLightTest2(){

        Scene scene = new Scene();
        Sphere sphere = new Sphere(new Color(0, 0, 100),500, new Point3D(0.0, 0.0, -900));
        Material m=new Material();
        m.set_n(20);
        sphere.set_material(m);
        scene.addGeometry(sphere);


        Triangle triangle = new Triangle(new Color(0,0,0),new Point3D(  3500,  3500, -2000),
                new Point3D( -3500, -3500, -1000),
                new Point3D(  3500, -3500, -2000));

        Triangle triangle2 = new Triangle(new Color(0,0,0),new Point3D(  3500,  3500, -2000),
                new Point3D( -3500,  3500, -1000),
                new Point3D( -3500, -3500, -1000));

        m=new Material();
        m.set_n(1);
        triangle.set_material(m);
        triangle2.set_material(m);

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);

        scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(200, 200, -100),
                0, 0.000001, 0.0000005));


        ImageWriter imageWriter = new ImageWriter("Point test 2", 500, 500, 500, 500);

        Render render = new Render( scene,imageWriter);

        render.renderImage();
        imageWriter.writeToimage();

    }


}
