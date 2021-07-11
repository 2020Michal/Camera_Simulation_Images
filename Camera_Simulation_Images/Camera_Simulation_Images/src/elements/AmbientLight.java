package elements;

import primitives.Point3D;
import primitives.Vector;

import java.awt.*;
import java.util.Objects;

public class AmbientLight extends Light {


    protected double _Ka;

    // ***************** Constructors ********************** //

    public AmbientLight(Color _color) {
        super(_color);
        this._Ka = 0.1;
    }
    public AmbientLight() {
        super();
        this._Ka = 0.1;
    }

    // ***************** Getters/Setters ********************** //

    public double get_Ka() {
        return _Ka;
    }

    public void set_Ka(double _Ka) {
        this._Ka = _Ka;
    }

    // ***************** Administration ******************** //

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AmbientLight that = (AmbientLight) o;
        return Double.compare(that._Ka, _Ka) == 0;
    }

    @Override
    public String toString() {
        return "AmbientLight{" +
                "_Ka=" + _Ka +
                ", _color=" + _color +
                '}';
    }

    // ***************** Operations ******************** //

    public Color getIntensity (Point3D point)
    {
        if (_Ka > 1) _Ka = 1;
        int r=(int)(_color.getRed()*_Ka);
        int g=(int)(_color.getGreen()*_Ka);
        int b=(int)(_color.getBlue()*_Ka);
        return new Color(r, g, b);
    }

    @Override
    public Vector getL(Point3D point) {
        return null;
    }

}
