package elements;

import primitives.Point3D;
import primitives.Vector;

import java.awt.*;
import java.util.Objects;

public abstract  class  Light {
    protected Color _color;


    /********** Constructors ***********/
    public Light() {
        this._color = Color.white;
    }

    public Light(Color _color) {
        this._color = _color;
    }
    public Light(Light l) {
        this._color = l._color;
    }
    /************** Getters/Setters *******/

    public Color get_color() {
        return _color;
    }

//    public void set_color(Color _color) {
//        this._color = _color;
//    }

    /*************** Admin *****************/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Light light = (Light) o;
        return _color.equals(light._color);
    }

    @Override
    public String toString() {
        return "Light{" +
                "_color=" + _color +
                '}';
    }
    /************** Operations ***************/

     public abstract Color getIntensity (Point3D point);
     public abstract Vector getL(Point3D point);
}
