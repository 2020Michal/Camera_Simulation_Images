package test;

import java.awt.*;

import elements.PointLight;
import geometries.Pentagon;
import org.junit.Test;

import elements.SpotLight;
import geometries.Sphere;
import geometries.Triangle;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import Scene.*;

public class RecursiveTest {


    @Test
    public void recursiveTest(){

        Scene scene = new Scene();
        scene.set_screenDistance(300);

        Sphere sphere = new Sphere(new Color(0, 0, 100),500, new Point3D(0.0, 0.0, -1000));
        Material m=new Material();
        m.set_n(20);
        m.set_Kt(0.5);
        sphere.set_material(m);
        scene.addGeometry(sphere);

        Sphere sphere2 = new Sphere(new Color(100, 20, 20),250, new Point3D(0.0, 0.0, -1000));
        Material m2=new Material();
        m2.set_n(20);
        m2.set_Kt(0);
        sphere2.set_material(m2);
        scene.addGeometry(sphere2);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150)
                , 0.1, 0.00001,0.000005,new Vector(2, 2, -3)));

        ImageWriter imageWriter = new ImageWriter("Recursive Test", 500, 500, 500, 500);

        Render render = new Render( scene,imageWriter);

        render.renderImage();
        render.get_imageWriter().writeToimage();


    }


    @Test
    public void recursiveTest2(){

        Scene scene = new Scene();
        scene.set_screenDistance(300);

        Sphere sphere = new Sphere(new Color(0, 0, 100),300, new Point3D(-550, -500, -1000));
        Material m=new Material();
        m.set_n(20);
        m.set_Kt(0.5);
        sphere.set_material(m);
        scene.addGeometry(sphere);

        Sphere sphere2 = new Sphere(new Color(100, 20, 20),150, new Point3D(-550, -500, -1000));
        Material m2=new Material();
        m2.set_n(20);
        m2.set_Kt(0);
        sphere2.set_material(m2);
        scene.addGeometry(sphere2);

        Triangle triangle = new Triangle(new Color(20, 20, 20),new Point3D(  1500, -1500, -1500),
                new Point3D( -1500,  1500, -1500),
                new Point3D(  200,  200, -375)
                );

        Triangle triangle2 = new Triangle(new Color(20, 20, 20),new Point3D(  1500, -1500, -1500),
                new Point3D( -1500,  1500, -1500),
                new Point3D( -1500, -1500, -1500));

        Material m3=new Material();
        Material m4=new Material();
        m3.set_Kr(1);
        m4.set_Kr(0.5);
        triangle.set_material(m3);
        triangle2.set_material(m4);
        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);

        scene.addLight(new SpotLight(new Color(255, 100, 100),  new Point3D(200, 200, -150)
                , 0, 0.00001, 0.000005,new Vector(-2, -2, -3)));

        ImageWriter imageWriter = new ImageWriter("Recursive Test 2", 500, 500, 500, 500);

        Render render = new Render( scene, imageWriter);

        render.renderImage();
        render.get_imageWriter().writeToimage();


    }

    @Test
    public void recursiveTest3(){

        Scene scene = new Scene();
        scene.set_screenDistance(300);

        Sphere sphere = new Sphere(new Color(0, 0, 100),300, new Point3D(0, 0, -1000));
        Material m=new Material();
        m.set_n(20);
        m.set_Kt(0.5);
        sphere.set_material(m);
        scene.addGeometry(sphere);

        Sphere sphere2 = new Sphere(new Color(100, 20, 20),150, new Point3D(0, 0, -1000));
        Material m1=new Material();
        m1.set_n(20);
        m1.set_Kt(0);
        sphere2.set_material(m1);
        scene.addGeometry(sphere2);

        Triangle triangle = new Triangle(new Color(20, 20, 20), new Point3D(  2000, -1000, -1500),
                new Point3D( -1000,  2000, -1500),
                new Point3D(  700,  700, -375));

        Triangle triangle2 = new Triangle(new Color(20, 20, 20),new Point3D(  2000, -1000, -1500),
                new Point3D( -1000,  2000, -1500),
                new Point3D( -1000, -1000, -1500));

        Material m2=new Material();
        m2.set_Kr(1);
        triangle.set_material(m2);

        Material m3=new Material();
        m3.set_Kr(0.5);
        triangle2.set_material(m3);


        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);

        scene.addLight(new SpotLight(new Color(255, 100, 100),  new Point3D(200, 200, -150),0.000005
                , 0, 0.00001, new Vector(-2, -2, -3)));

        ImageWriter imageWriter = new ImageWriter("Recursive Test 3", 500, 500, 500, 500);

        Render render = new Render( scene, imageWriter);

        render.renderImage();
        render.get_imageWriter().writeToimage();


    }

    @Test
    public void recursiveTest4(){

        Scene scene = new Scene();
        scene.set_screenDistance(300);

        Sphere sphere = new Sphere(new Color(0, 0, 100),300, new Point3D(0, 0, -1000));
        Material m=new Material();
        m.set_n(20);
        m.set_Kt(0.5);
        sphere.set_material(m);
        scene.addGeometry(sphere);

        Sphere sphere2 = new Sphere(new Color(100, 20, 20),150, new Point3D(0, 0, -1000));
        Material m1=new Material();
        m1.set_n(20);
        m1.set_Kt(0);
        sphere2.set_material(m1);
        scene.addGeometry(sphere2);

        Triangle triangle = new Triangle(new Color(20, 20, 20), new Point3D(  2000, -1000, -1500),
                new Point3D( -1000,  2000, -1500),
                new Point3D(  700,  700, -375));

        Triangle triangle2 = new Triangle(new Color(20, 20, 20),new Point3D(  2000, -1000, -1500),
                new Point3D( -1000,  2000, -1500),
                new Point3D( -1000, -1000, -1500));

        Material m2=new Material();
        m2.set_Kr(1);
        triangle.set_material(m2);

        Material m3=new Material();
        m3.set_Kr(0.5);
        triangle2.set_material(m3);


        Pentagon pentagon = new Pentagon(new Color(150, 88, 68), new Point3D(0,20,-100), new Point3D(100, 200, -300),
                new Point3D(0, 0, 0), new Point3D(800, 2000, -1000), new Point3D(600, 800, -1150));

        Material m4=new Material();
        m4.set_Kr(0.8);
        m4.set_n(15);
        pentagon.set_material(m4);

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);
        scene.addGeometry(pentagon);

        scene.addLight(new SpotLight(new Color(255, 100, 100),  new Point3D(200, 200, -150),0.000005
                , 0, 0.00001, new Vector(-2, -2, -3)));

        ImageWriter imageWriter = new ImageWriter("Recursive Test 4", 500, 500, 500, 500);

        Render render = new Render( scene, imageWriter);

        render.renderImage();
        render.get_imageWriter().writeToimage();


    }


    @Test
    public void recursiveTest5(){


        Pentagon pentagon1 = new Pentagon(new Color(56, 217, 32, 214), new Point3D(  -1250, 700, -500), new Point3D(-1750, 200, -500),
                new Point3D(-1750, -300, -500), new Point3D(  -1250,  -300, -500), new Point3D( -750, 200, -500));

        Scene scene = new Scene();
        scene.set_screenDistance(300);
        Material m4=new Material();
        m4.set_Kt(1);
        m4.set_n(15);
        m4.set_Kr(0.9);

        pentagon1.set_material(m4);

       Sphere sphere = new Sphere(new Color(0, 0, 100),300, new Point3D(0, 0, -1000));
        Material m=new Material();
        m.set_n(20);
        m.set_Kt(1);
        sphere.set_material(m);
        scene.addGeometry(sphere);

        Sphere sphere2 = new Sphere(new Color(100, 20, 20),150, new Point3D(0, 0, -1000));
        Material m1=new Material();
        m1.set_n(20);
        m1.set_Kt(0);
        sphere2.set_material(m1);
        scene.addGeometry(sphere2);

        Triangle triangle = new Triangle(new Color(20, 20, 20), new Point3D(  2000, -1000, -1500),
                new Point3D( -1000,  2000, -1500),
                new Point3D(  700,  700, -375));

        Triangle triangle2 = new Triangle(new Color(20, 20, 20),new Point3D(  2000, -1000, -1500),
                new Point3D( -1000,  2000, -1500),
                new Point3D( -1000, -1000, -1500));

        Material m2=new Material();
        m2.set_Kr(1);
        triangle.set_material(m2);

        Material m3=new Material();
        m3.set_Kr(0.5);
        triangle2.set_material(m3);

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);
        scene.addGeometry(pentagon1);

        scene.addLight(new SpotLight(new Color(255, 100, 100),  new Point3D(200, 200, -150),0.000005
                , 0, 0.00001, new Vector(-2, -2, -3)));

        ImageWriter imageWriter = new ImageWriter("Recursive Test 5", 500, 500, 500, 500);

        Render render = new Render( scene, imageWriter);

        render.renderImage();
        render.get_imageWriter().writeToimage();
    }

    @Test
    public void recursiveTest6(){
        Scene scene = new Scene();
        scene.set_screenDistance(300);

        Sphere sphere = new Sphere(new Color(0, 0, 100),300, new Point3D(-550, -500, -1000));
        Material m=new Material();
        m.set_n(20);
        m.set_Kt(0.5);
        sphere.set_material(m);
        scene.addGeometry(sphere);

        Sphere sphere2 = new Sphere(new Color(100, 20, 20),150, new Point3D(-550, -500, -1000));
        Material m2=new Material();
        m2.set_n(20);
        m2.set_Kt(0);
        sphere2.set_material(m2);
        scene.addGeometry(sphere2);

//        Triangle triangle = new Triangle(new Color(20, 20, 20),new Point3D(  1500, -1500, -1500),
//                new Point3D( -1500,  1500, -1500),
//                new Point3D(  200,  200, -375)
//        );

        Pentagon pentagon = new Pentagon(new Color(20, 20, 20),new Point3D(  1500, -1500, -1500),
                new Point3D( -1500,  1500, -1500),
                new Point3D( 100, 250, -375), new Point3D(  200,  200, -375), new Point3D(300, 120,  -375));

        Triangle triangle2 = new Triangle(new Color(20, 20, 20),new Point3D(  1500, -1500, -1500),
                new Point3D( -1500,  1500, -1500),
                new Point3D( -1500, -1500, -1500));

        Material m3=new Material();
        Material m4=new Material();
        m3.set_Kr(1);
        m4.set_Kr(0.5);
        pentagon.set_material(m3);
        triangle2.set_material(m4);
        scene.addGeometry(pentagon);
        scene.addGeometry(triangle2);

        scene.addLight(new SpotLight(new Color(255, 100, 100),  new Point3D(200, 200, -150)
                , 0, 0.00001, 0.000005,new Vector(-2, -2, -3)));

        ImageWriter imageWriter = new ImageWriter("Recursive Test 6", 500, 500, 500, 500);

        Render render = new Render( scene, imageWriter);

        render.renderImage();
        render.get_imageWriter().writeToimage();

    }

    @Test
    public void recursiveTest7() {
        Scene scene = new Scene();
        //scene.set_background(new Color(224, 248, 255));


//        Pentagon pentagon = new Pentagon(new Color(226, 105, 217), new Point3D(  0, 200, -149), new Point3D(-200, 0, -149),
//                new Point3D(-100, -200, -149), new Point3D(  100,  -200, -149), new Point3D( 200, 0, -149));
//
//        Material m1=new Material();
//        //m1.set_Kr(0.995);
//        m1.set_Kt(0.2);
//        m1.set_n(50);
//        pentagon.set_material(m1);
//        scene.addGeometry(pentagon);

        Triangle triangle = new Triangle(new Color(20, 20, 20),new Point3D(  1500, -1500, -1500),
                new Point3D( -1500,  1500, -1500),
                new Point3D(  1000,  1000, -375)
        );

        Triangle triangle2 = new Triangle(new Color(20, 20, 20),new Point3D(  1500, -1500, -1500),
                new Point3D( -1500,  1500, -1500),
                new Point3D( -1000,  -1000, -375));

        Material m2=new Material();
        Material m3=new Material();
        m2.set_Kr(1);
        m3.set_Kr(0.5);
        triangle.set_material(m2);
        triangle2.set_material(m3);
        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);
        scene.addLight(new SpotLight(new Color(244, 76, 255),  new Point3D(200, 200, -150)
                , 0, 0.00001, 0.000005,new Vector(-2, -2, -3)));

        Sphere sphere = new Sphere (new Color(0, 0, 100),500, new Point3D(0.0, 0.0, -1000));
        Material m=new Material();
        m.set_n(20);
        sphere.set_material(m);
        scene.addGeometry(sphere);
        scene.addLight(new PointLight(new Color(246, 255, 27), new Point3D(-200, -200, -100),
                0, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("recursive Test 7", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImage();
        render.get_imageWriter().writeToimage();
    }

    @Test
    public void recursiveTest8() {
        Scene scene = new Scene();
        //scene.set_background(new Color(224, 248, 255));
//        Sphere sphere = new Sphere (new Color(109, 56, 228),800, new Point3D(0.0, 0.0, -1000));
//        Material m=new Material();
//        m.set_n(20);
//        sphere.set_material(m);
//        scene.addGeometry(sphere);

        Pentagon pentagon = new Pentagon(Color.RED, new Point3D(  0, 200, -149), new Point3D(-200, 0, -149),
                new Point3D(-100, -200, -149), new Point3D(  100,  -200, -149), new Point3D( 200, 0, -149));

        Material m1=new Material();
        //m1.set_Kr(0.995);
        m1.set_Kt(0.2);
        m1.set_n(50);
        pentagon.set_material(m1);
        scene.addGeometry(pentagon);

        Pentagon pentagon1 = new Pentagon(new Color(250, 47, 161), new Point3D(  0, 160, -149), new Point3D(-160, 0, -149),
                new Point3D(-80, -170, -149), new Point3D(  80,  -170, -149), new Point3D( 160, 0, -149));

        Material m2=new Material();
        //m1.set_Kr(0.995);
        m2.set_Kt(0.2);
        m2.set_n(50);
        pentagon1.set_material(m2);
        scene.addGeometry(pentagon1);
//        Pentagon pentagon2 = new Pentagon(new Color(250, 138, 227), new Point3D(  0, 120, -149), new Point3D(-120, 0, -149),
//                new Point3D(-70, -160, -149), new Point3D(  70,  -160, -149), new Point3D( 120, 0, -149));
//
//        Material m3=new Material();
//        //m1.set_Kr(0.995);
//        m3.set_Kt(0.2);
//        m3.set_n(50);
//        pentagon1.set_material(m3);
//        scene.addGeometry(pentagon2);
        scene.addLight(new SpotLight(new Color(178, 255, 30),  new Point3D(200, 200, -150)
                , 0, 0.00001, 0.000005,new Vector(-2, -2, -3)));
        scene.addLight(new PointLight(new Color(255, 248, 42), new Point3D(-200, -200, -100),
                0, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("recursive Test 8", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImage();
        render.get_imageWriter().writeToimage();
    }

    @Test
    public void recursiveTest9(){

        Scene scene = new Scene();
        scene.set_screenDistance(300);

        Sphere sphere = new Sphere(new Color(0, 0, 100),300, new Point3D(0, 0, -1000));
        Material m=new Material();
        m.set_n(20);
        m.set_Kt(0.5);
        sphere.set_material(m);
        scene.addGeometry(sphere);

        Sphere sphere2 = new Sphere(new Color(100, 20, 20),150, new Point3D(0, 0, -1000));
        Material m1=new Material();
        m1.set_n(20);
        m1.set_Kt(0);
        sphere2.set_material(m1);
        scene.addGeometry(sphere2);

        Triangle triangle = new Triangle(new Color(20, 20, 20), new Point3D(  2000, -1000, -1500),
                new Point3D( -1000,  2000, -1500),
                new Point3D(  700,  700, -375));

        Triangle triangle2 = new Triangle(new Color(20, 20, 20),new Point3D(  2000, -1000, -1500),
                new Point3D( -1000,  2000, -1500),
                new Point3D( -1000, -1000, -1500));

        Material m2=new Material();
        m2.set_Kr(1);
        triangle.set_material(m2);

        Material m3=new Material();
        m3.set_Kr(0.5);
        triangle2.set_material(m3);


        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);

        scene.addLight(new SpotLight(new Color(255, 100, 100),  new Point3D(200, 200, -150),0.000005
                , 0, 0.00001, new Vector(-2, -2, -3)));

        ImageWriter imageWriter = new ImageWriter("Recursive Test 9", 500, 500, 500, 500);

        Render render = new Render( scene, imageWriter);

        render.renderImage();
        render.get_imageWriter().writeToimage();


    }

}
