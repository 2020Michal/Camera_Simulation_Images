package elements;

import primitives.Point3D;
import primitives.Vector;

import java.awt.*;
import java.util.Objects;

public class PointLight extends Light {

    protected Point3D _position;
    protected  double _kc;
    protected  double _kl;
    protected  double _kq;

    // ***************** Constructors ********************** //

    public PointLight(Point3D _position, double _kc, double _kl, double _kq) {
        super();
        this._position =new Point3D(_position);
        this._kc = _kc;
        this._kl = _kl;
        this._kq = _kq;
    }

    public PointLight(Color _color, Point3D _position, double _kc, double _kl, double _kq) {
        super(_color);
        this._position = new Point3D(_position);
        this._kc = _kc;
        this._kl = _kl;
        this._kq = _kq;
    }

    public PointLight(Light l, Point3D _position, double _kc, double _kl, double _kq) {
        super(l);
        this._position =new Point3D( _position);
        this._kc = _kc;
        this._kl = _kl;
        this._kq = _kq;
    }

    public PointLight(PointLight other) {
        super(other._color);
        this._position = new Point3D(other._position);
        this._kc = other._kc;
        this._kl = other._kl;
        this._kq = other._kq;
    }

    // ***************** Getters/Setters ********************** //
    public Point3D get_position() {
        return _position;
    }

    public double get_kc() {
        return _kc;
    }

    public double get_kl() {
        return _kl;
    }

    public double get_kq() {
        return _kq;
    }

    // ***************** Administration ******************** //

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PointLight that = (PointLight) o;
        return Double.compare(that._kc, _kc) == 0 &&
                Double.compare(that._kl, _kl) == 0 &&
                Double.compare(that._kq, _kq) == 0 &&
                _position.equals(that._position);
    }

    @Override
    public String toString() {
        return "PointLight{" +
                "_position=" + _position +
                ", _kc=" + _kc +
                ", _kl=" + _kl +
                ", _kq=" + _kq +
                ", _color=" + _color +
                '}';
    }

    // ***************** Operations ******************** //

    public Color getIntensity (Point3D point)
    {
        double d=_position.getDistance(point);
        double a=_kc+_kl*d+_kq*Math.pow(d, 2);
        if(a<1)
            a=1;
        int r=(int)(_color.getRed()/a);
        if(r>255)
            r=255;
        int g=(int)(_color.getGreen()/a);
        if(g>255)
            g=255;
        int b=(int)(_color.getBlue()/a);
        if(b>255)
            b=255;
        return new Color(r,g,b);
    }
    public  Vector getL(Point3D point)
    {
        Point3D tmp = point.subPoint(_position);
        return new Vector(tmp);//normelize
    }


}
