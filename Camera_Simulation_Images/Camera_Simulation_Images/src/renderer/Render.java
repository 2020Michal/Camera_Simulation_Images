package renderer;


import Scene.*;
import elements.Light;
import primitives.*;
import geometries.*;
import primitives.Vector;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;


public class Render {

    int RECURSION_LEVEL=2;
    protected Scene _scene;
    protected ImageWriter _imageWriter;

    // ***************** Constructors ********************** //
    public Render(Scene _scene, ImageWriter _imageWriter) {
        this._scene = _scene;
        this._imageWriter = _imageWriter;
    }

    public Render(Render other) {
        this._scene = other._scene;
        this._imageWriter = other._imageWriter;
    }

    // ***************** Getters/Setters ********************** //
    public Scene get_scene() {
        return _scene;
    }

    public ImageWriter get_imageWriter() {
        return _imageWriter;
    }

    public void set_scene(Scene _scene) {
        this._scene = _scene;
    }

    public void set_imageWriter(ImageWriter _imageWriter) {
        this._imageWriter = _imageWriter;
    }

    // ***************** Administration ******************** //
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Render render = (Render) o;
        return _scene.equals(render._scene) &&
                _imageWriter.equals(render._imageWriter);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(_scene, _imageWriter);
//    }


    @Override
    public String toString() {
        return "Render{" +
                "_scene=" + _scene +
                ", _imageWriter=" + _imageWriter +
                '}';
    }

    // ***************** Operations ******************** //
    public void printGrid(int interval)
    {
        for (int i=0; i<_imageWriter.getHeight();i++)
        {
            for (int j = 0; j < _imageWriter.getWidth(); j++)
            {
                if (i % interval==0 || j % interval==0) _imageWriter.writePixel(i,j,Color.white);
            }
        }
        _imageWriter.writeToimage();
    }

    public void renderImage()
    {
        for (int i = 0; i < _imageWriter.getHeight(); i++)
            for (int j = 0; j < _imageWriter.getWidth(); j++) {
                Ray ray = _scene.get_camera().costructRayThrowAPixel(_imageWriter.getNx(),
                        _imageWriter.getNy(), j, i, _scene.get_screenDistance(), _imageWriter.getWidth(),
                        _imageWriter.getHeight());
                Map<Geometry, ArrayList<Point3D>> intersectionPoints = getSceneRayIntersections(ray);

                if (intersectionPoints.isEmpty())
                    _imageWriter.writePixel(j, i, _scene.get_background());
                else {
                    Map<Geometry, Point3D> closestPoint = getClosestPoint(intersectionPoints);
                    Map.Entry<Geometry, Point3D> cp = closestPoint.entrySet().iterator().next();

                    //check:
//                       if (i==j)
//                        System.out.println("");

                    _imageWriter.writePixel(j, i, calcColor(cp.getKey(),
                           cp.getValue(),ray));
                }
            }
    }

    private Map<Geometry, ArrayList<Point3D>> getSceneRayIntersections(Ray ray)
    {
        Iterator<Geometry> geometries = _scene.getIterator();
        Map<Geometry, ArrayList<Point3D>> intersectionPoints = new HashMap<Geometry, ArrayList<Point3D>>();
        while (geometries.hasNext())
        {
            Geometry geometry = geometries.next();

            ArrayList<Point3D> geometryIntersectionPoints =
                    geometry.findIntersections(ray);
            if(!geometryIntersectionPoints.isEmpty())
                intersectionPoints.put(geometry,geometryIntersectionPoints);        }
        return intersectionPoints;
    }

    private Map<Geometry, Point3D> getClosestPoint(Map<Geometry, ArrayList<Point3D>> list)
    {
        double distance = Double.MAX_VALUE;
        Point3D P0 = _scene.get_camera().get_P0();
        Map<Geometry, Point3D> minDistancePoint =new HashMap<Geometry, Point3D>();
        for (Map.Entry<Geometry,ArrayList<Point3D>> entry: list.entrySet()) {

            for (Point3D point:entry.getValue())
            {
                if (P0.getDistance(point) < distance) {
                    minDistancePoint.clear();
                    minDistancePoint.put(entry.getKey(),new Point3D(point));
                    distance = P0.getDistance(point);
                }
            }
        }
        return minDistancePoint;
    }

    private Color calcDiffusiveComp(double _kd, Vector _normal,Vector _l,Color _i)
    {
        _normal.normalize();
        _l.normalize();
        double nl=_normal.dotProduct(_l);
        nl=Math.abs(nl*_kd);
        int r=(int)(_i.getRed()*nl);
        if(r>255)
            r=255;
        int g=(int)(_i.getGreen()*nl);
        if(g>255)
            g=255;
        int b=(int)(_i.getBlue()*nl);
        if(b>255)
            b=255;
        return new Color( r, g, b);

    }

    private Color calcSpecularComp(double _ks, Vector _v,Vector _normal,Vector _l, double _nshining,Color _i)
    {
        if(_ks> 1) _ks=1;
        _v.normalize();
        _l.normalize();
        _normal.normalize();
        Vector r =_l.subtractNew(_normal.scaleNew(2*(_l.dotProduct(_normal)))).normalizeNew();
        double dot =_v.dotProduct(r);

        dot = (dot<=0 )? 0: dot;
        dot =_ks*(Math.pow(dot,_nshining));
        return  new Color((int)(_i.getRed()*dot),(int)(_i.getGreen()*dot),(int) (_i.getBlue()*dot));

    }

    private Ray constructRefractedRay(Geometry geometry, Point3D point, Ray inRay) {

        Vector normal = geometry.getNormal(point);
        normal.scale(-2);
        Point3D point3d = new Point3D(point);

        point3d.add(normal);

        if (geometry instanceof FlatGeometry){
            return new Ray (point, inRay.get_direction());
        } else {
// Here, Snell's law can be implemented.
// The refraction index of both materials had to be derived
            Vector d = new Vector(inRay.get_direction());
            return new Ray (point3d, d);
        }
    }

    // improvment ******************************************************************************************************
    private ArrayList<Ray> constructReflectedRay(Vector normal, Point3D point, Ray inRay) {

        Vector l = inRay.get_direction();
        l.normalize();
        normal.normalize();

        normal.scale(-2 * l.dotProduct(normal));
        l.add(normal);

        Vector R = new Vector(l);
        R.normalize();
        Vector R1 = new Vector(new Point3D(l.get_head().get_x().add(new Coordinate(0.001)), l.get_head().get_y(), l.get_head().get_z()));
        R1.normalize();
        Vector R2 = new Vector(new Point3D(l.get_head().get_x().subtract(new Coordinate(0.001)), l.get_head().get_y(), l.get_head().get_z()));
        R2.normalize();
        Vector R3 = new Vector(new Point3D(l.get_head().get_x().add(new Coordinate(0.002)), l.get_head().get_y(), l.get_head().get_z()));
        R1.normalize();
        Vector R4 = new Vector(new Point3D(l.get_head().get_x().subtract(new Coordinate(0.002)), l.get_head().get_y(), l.get_head().get_z()));
        R2.normalize();

        point.add(normal);

        Ray reflectedRay = new Ray(point, R);
        Ray reflectedRay1 = new Ray(point, R1);
        Ray reflectedRay2 = new Ray(point, R2);
        Ray reflectedRay3 = new Ray(point, R3);
        Ray reflectedRay4 = new Ray(point, R4);

        ArrayList<Ray> reflectedRays=new ArrayList<Ray>();
        reflectedRays.add(reflectedRay);
        reflectedRays.add(reflectedRay1);
        reflectedRays.add(reflectedRay2);
        reflectedRays.add(reflectedRay3);
        reflectedRays.add(reflectedRay4);

        return reflectedRays;
    }

    //envelope function:
    private Color calcColor(Geometry geometry, Point3D point, Ray inRay) {
        return calcColor(geometry, point, inRay, 0);
    }

    private Color calcColor(Geometry geometry, Point3D point, Ray inRay, int level)
    {
        if (level == RECURSION_LEVEL) return new Color(0, 0, 0);

        Color ambientLight = _scene.get_ambientLight().getIntensity(point);
        Color emissionLight = geometry.get_color();
        int a = ambientLight.getRed(); // check
        int r = (a+emissionLight.getRed());
        int g = (ambientLight.getGreen()+emissionLight.getGreen());
        int b = (ambientLight.getBlue()+emissionLight.getBlue());

        Iterator<Light> lights =_scene.getILightiterator();
        Point3D p0 = _scene.get_camera().get_P0();
        Vector vec = new Vector(p0.subPoint(point));
        while (lights.hasNext()) {
            Light light = lights.next();

            if (!occluded(light, point, geometry)) {

                Color inten = light.getIntensity(point);
                Color diffuseLight = calcDiffusiveComp(geometry.get_material().get_Kd(), geometry.getNormal(point), light.getL(point), inten);
                Color specularLight = calcSpecularComp(geometry.get_material().get_Ks(), vec, geometry.getNormal(point), light.getL(point),
                        geometry.get_material().get_n(), light.getIntensity(point));
                r += (diffuseLight.getRed() + specularLight.getRed());
                g += (diffuseLight.getGreen() + specularLight.getGreen());
                b += (diffuseLight.getBlue() + specularLight.getBlue());
            }
        }

        // Recursive call for a reflected ray
        ArrayList<Ray> reflectedRays = constructReflectedRay(geometry.getNormal(point), point, inRay);
        for (Ray reflectedRay : reflectedRays) {

            Map<Geometry,Point3D> reflectedMap = getClosestPoint(getSceneRayIntersections(reflectedRay));/////////
            if(!reflectedMap.isEmpty())
            {
                Map.Entry<Geometry, Point3D> reflectedEntry = reflectedMap.entrySet().iterator().next();
                Color reflectedColor = calcColor(reflectedEntry.getKey(), reflectedEntry.getValue(), reflectedRay, level + 1);
                double kr = geometry.get_material().get_Kr();
                r += reflectedColor.getRed()*kr/reflectedRays.size();
                g += reflectedColor.getGreen()*kr/reflectedRays.size();
                b += reflectedColor.getBlue()*kr/reflectedRays.size();
            }
        }

        // Recursive call for a refracted ray
        Ray refractedRay = constructRefractedRay(geometry, point, inRay);
        Map<Geometry,Point3D> refractedMap = getClosestPoint(getSceneRayIntersections(refractedRay));/////////
        if(!refractedMap.isEmpty())
        {
            Map.Entry<Geometry, Point3D> refractedEntry = refractedMap.entrySet().iterator().next();
            Color refractedColor = calcColor(refractedEntry.getKey(), refractedEntry.getValue(), reflectedRays.get(0), level + 1);//////////////
            double kt = geometry.get_material().get_Kt();

            r += refractedColor.getRed()*kt;
            g += refractedColor.getGreen()*kt;
            b += refractedColor.getBlue()*kt;
        }

        if (r > 255) r = 255;
        if (g > 255) g = 255;
        if (b > 255) b = 255;

        return new Color(r, g, b);
    }

    private boolean occluded(Light light, Point3D point, Geometry geometry) {
        Vector lightDirection = light.getL(point);
        lightDirection.scale(-1);
        Point3D geometryPoint = new Point3D(point);
        Vector epsVector = new Vector(geometry.getNormal(point));
        epsVector.scale(2);
        geometryPoint.add(epsVector);

        Ray lightRay = new Ray(geometryPoint, lightDirection);
        Map<Geometry, ArrayList<Point3D>> intersectionPoints =
                getSceneRayIntersections(lightRay);

        // Flat geometry cannot self intersect
        if (geometry instanceof FlatGeometry){
            intersectionPoints.remove(geometry);
        }

        for (Map.Entry<Geometry, ArrayList<Point3D>> entry : intersectionPoints.entrySet())
            if (entry.getKey().get_material().get_Kt()== 0)
                return true;

        return false;
    }

}
