package geometries;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Objects;

import primitives.*;

public class Sphere extends Geometry{

    protected Point3D _center;
    protected double _radius;

    // ***************** Constructors ********************** //
    public Sphere(Color _color, double _radius, Point3D _center, Material _material) {
        super(_color, _material);
        this._center = new Point3D(_center);
        this._radius = _radius;
    }

    public Sphere(Color _color, double _radius, Point3D _center ) {
        super(_color);
        this._center = new Point3D(_center);
        this._radius = _radius;
    }

    public Sphere(Sphere other) {
        super(other._color, other._material);
        this._center = new Point3D(other._center);
        this._radius = other._radius;

    }

    // ***************** Getters/Setters ********************** //
    public Point3D get_center() {
        return _center;
    }

    public void set_center(Point3D _center) {
        this._center = _center;
    }

    public double get_radius() {
        return _radius;
    }

    public void set_radius(double _radius) {
        this._radius = _radius;
    }

// ***************** Administration  ******************** //


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Sphere sphere = (Sphere) o;
        return Double.compare(sphere._radius, _radius) == 0 &&
                _center.equals(sphere._center);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(_center, _radius);
//    }


    @Override
    public String toString() {
        return "Sphere{" +
                "_center=" + _center +
                ", _radius=" + _radius +
                ", _color=" + _color +
                ", _material=" + _material +
                '}';
    }

    // ***************** Operations ******************** //
    @Override
    public Vector getNormal(Point3D point) {
        Vector v = new Vector(point);
        v.subtract(new Vector(_center));
        v.scale(1/v.length());
        return v;
    }

    @Override
    public ArrayList<Point3D> findIntersections(Ray ray) {
        Vector L = new Vector(_center.subPoint(ray.get_POO()));
        double tm = L.dotProduct(ray.get_direction());
        double d = Math.sqrt(Math.pow(L.length(), 2) - Math.pow(tm, 2)    );
        ArrayList<Point3D> list = new ArrayList<Point3D>();
        if (d > _radius)
            return  list;
        double th = Math.sqrt(Math.pow(_radius, 2) - Math.pow(d, 2));
        double t1 = tm - th;
        double t2 = tm + th;
        if (t1 > 0)
        {
            Point3D p1 = ray.get_POO().addVector(ray.get_direction().scaleNew(t1));
            list.add(p1);
        }
        if (t2 > 0)
        {
            Point3D p2 = ray.get_POO().addVector(ray.get_direction().scaleNew(t2));
            list.add(p2);
        }
        return list;
    }


}
