package elements;

import primitives.Point3D;
import primitives.Vector;

import java.awt.*;

public class SpotLight extends PointLight {

    protected Vector _direction;

    // ***************** Constructors ********************** //

    public SpotLight(Point3D _position, double _kc, double _kl, double _kq, Vector _direction) {
        super(_position, _kc, _kl, _kq);
        this._direction = _direction.normalizeNew();
    }

    public SpotLight(Color _color, Point3D _position, double _kc, double _kl, double _kq, Vector _direction) {
        super(_color, _position, _kc, _kl, _kq);
        this._direction = _direction.normalizeNew();
    }

    // ***************** Getters/Setters ********************** //

    public Vector get_direction() {
        return _direction;
    }

    // ***************** Administration ******************** //
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SpotLight spotLight = (SpotLight) o;
        return _direction.equals(spotLight._direction);
    }

    @Override
    public String toString() {
        return "SpotLight{" +
                "_direction=" + _direction +
                ", _position=" + _position +
                ", _kc=" + _kc +
                ", _kl=" + _kl +
                ", _kq=" + _kq +
                ", _color=" + _color +
                '}';
    }

    // ***************** Operations ******************** //

    public Color getIntensity (Point3D point)
    {
       // double d=_position.getDistance(point);
        Vector l= getL(point);
        l.normalize();
        double dot=Math.abs(_direction.dotProduct(l));
        Color tmp=super.getIntensity(point);
        //dot  = (dot <= 0) ? 0 : dot;
        dot= (dot >= 1) ? 1 : dot;
        int r=(int)(tmp.getRed()*dot);
        int g=(int)(tmp.getGreen()*dot);
        int b=(int)(tmp.getBlue()*dot);
        return new Color(r,g,b);

    }
}
