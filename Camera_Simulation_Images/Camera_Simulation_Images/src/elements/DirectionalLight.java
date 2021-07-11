package elements;

import primitives.Point3D;
import primitives.Vector;

import java.awt.*;
import java.util.Objects;

public class DirectionalLight extends Light{

    protected Vector _direction;

    // ***************** Constructors ********************** //

    public DirectionalLight(Color _color, Vector _direction) {
        super(_color);
        this._direction = new Vector(_direction);
    }

    public DirectionalLight(Vector _direction) {
        super();
        this._direction = new Vector(_direction);
    }

    public DirectionalLight(DirectionalLight d) {
        super(d._color);
        this._direction = new Vector(d._direction);
    }

    // ***************** Getters/Setters ********************** //

    public Vector get_direction() {
        return _direction;
    }

    public void set_direction(Vector _direction) {
        this._direction = _direction;
    }

    // ***************** Administration ******************** //

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DirectionalLight that = (DirectionalLight) o;
        return _direction.equals(that._direction);
    }

    @Override
    public String toString() {
        return "DirectionalLight{" +
                "_direction=" + _direction +
                ", _color=" + _color +
                '}';
    }

    // ***************** Operations ******************** //

    public Color getIntensity (Point3D point)
    {
        return _color;
    }

    @Override
    public Vector getL(Point3D point) {
        return _direction;
    }

}
