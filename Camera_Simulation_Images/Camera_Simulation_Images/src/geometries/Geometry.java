package geometries;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import primitives.*;

public abstract class Geometry
{
    protected  Color _color;
    protected Material _material;

    // ***************** Constructors ********************** //
//    public Geometry(Color _color) {
//        super();
//        this._color = _color;
//    }

    public Geometry(Color _color) {
        this._color = _color;
        this._material = new Material();
    }

    public Geometry(Color _color, Material _material) {
        this._color = _color;
        this._material = new Material(_material);
    }

    // ***************** Getters/Setters ********************** //
    public Color get_color() {
        return _color;
    }

    public void set_color(Color _color) {
        this._color = _color;
    }

    public Material get_material() {
        return _material;
    }

    public void set_material(Material _material) {
        this._material = _material;
    }

    // ***************** Administration  ******************** //

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Geometry geometry = (Geometry) o;
        return Objects.equals(_color, geometry._color) &&
                Objects.equals(_material, geometry._material);
    }

    @Override
    public String toString() {
        return "Geometry{" +
                "_color=" + _color +
                ", _material=" + _material +
                '}';
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(_color, _material);
//    }


    // ***************** Operations ******************** //
    public abstract Vector getNormal(Point3D point);

    public abstract ArrayList<Point3D> findIntersections(Ray ray);


}
