package geometries;

import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class Pentagon extends Geometry implements FlatGeometry {

    protected Point3D _p1;
    protected Point3D _p2;
    protected Point3D _p3;
    protected Point3D _p4;
    protected Point3D _p5;

    // ***************** Constructors ********************** //

    public Pentagon(Color _color, Point3D _p1, Point3D _p2, Point3D _p3, Point3D _p4, Point3D _p5) {
        super(_color);
        this._p1 = new Point3D(_p1);
        this._p2 = new Point3D(_p2);
        this._p3 = new Point3D(_p3);
        this._p4 = new Point3D(_p4);
        this._p5 = new Point3D(_p5);
    }

    public Pentagon(Color _color, Material _material, Point3D _p1, Point3D _p2, Point3D _p3, Point3D _p4, Point3D _p5) {
        super(_color, _material);
        this._p1 = new Point3D(_p1);
        this._p2 = new Point3D(_p2);
        this._p3 = new Point3D(_p3);
        this._p4 = new Point3D(_p4);
        this._p5 = new Point3D(_p5);
    }

    public Pentagon(Pentagon other) {
        super(other._color, other._material);
        this._p1 = new Point3D(other._p1);
        this._p2 = new Point3D(other._p2);
        this._p3 = new Point3D(other._p3);
        this._p4 = new Point3D(other._p4);
        this._p5 = new Point3D(other._p5);
    }

    // ***************** Getters/Setters ********************** //

    public Point3D get_p1() {
        return new Point3D(_p1);
    }

    public void set_p1(Point3D _p1) {
        this._p1 = new Point3D(_p1);
    }

    public Point3D get_p2() {
        return new Point3D(_p2);
    }

    public void set_p2(Point3D _p2) {
        this._p2 = new Point3D(_p2);
    }

    public Point3D get_p3() {
        return new Point3D(_p3);
    }

    public void set_p3(Point3D _p3) {
        this._p3 = new Point3D(_p3);
    }

    public Point3D get_p4() {
        return new Point3D(_p4);
    }

    public void set_p4(Point3D _p4) {
        this._p4 = new Point3D(_p4);
    }

    public Point3D get_p5() {
        return new Point3D(_p5);
    }

    public void set_p5(Point3D _p5) {
        this._p5 = new Point3D(_p5);
    }

    // ***************** Administration  ******************** //
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pentagon pentagon = (Pentagon) o;
        return Objects.equals(_p1, pentagon._p1) &&
                Objects.equals(_p2, pentagon._p2) &&
                Objects.equals(_p3, pentagon._p3) &&
                Objects.equals(_p4, pentagon._p4) &&
                Objects.equals(_p5, pentagon._p5);
    }

    @Override
    public String toString() {
        return "Pentagon{" +
                "_p1=" + _p1 +
                ", _p2=" + _p2 +
                ", _p3=" + _p3 +
                ", _p4=" + _p4 +
                ", _p5=" + _p5 +
                ", _color=" + _color +
                ", _material=" + _material +
                '}';
    }

    // ***************** Operations ******************** //
    @Override
    public Vector getNormal(Point3D point) {
        Vector u = new Vector(this._p1, this._p2);
        Vector v = new Vector(this._p1, this._p3);
        Vector n = new Vector(u.crossProduct(v));
        n.normalize();
        n.scale(-1);
        return n;
    }

    @Override
    public ArrayList<Point3D> findIntersections(Ray ray) {
        Triangle t1 =new Triangle(_color,_p1,_p2,_p3);
        Triangle t2 =new Triangle(_color,_p3,_p4,_p5);
        Triangle t3 =new Triangle(_color,_p1,_p3,_p5);

        ArrayList<Point3D> intesection1=t1.findIntersections(ray);
        ArrayList<Point3D> intesection2=t2.findIntersections(ray);
        ArrayList<Point3D> intesection3=t3.findIntersections(ray);

        ArrayList<Point3D> combined = new ArrayList<Point3D>();
        combined.addAll(intesection1);
        combined.addAll(intesection2);
        combined.addAll(intesection3);

        return combined;

    }
}
