package elements;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.Objects;

public class Camera
{
    protected Point3D _P0;
    protected Vector _vUp;
    protected Vector _vTo;
    protected Vector _vRright;

    // ***************** Constructors ********************** //
    public Camera(Point3D _P0, Vector _vUp, Vector _vTo, Vector _vRright) {
        this._P0 = new Point3D(_P0);
        this._vUp = new Vector(_vUp);
        this._vTo = new Vector(_vTo);
        this._vRright = new Vector(_vRright);
    }

    public Camera(Vector _vUp, Vector _vTo, Vector _vRright) {
        this._P0 = new Point3D(0,0,0);
        this._vUp = new Vector(_vUp);
        this._vTo = new Vector(_vTo);
        this._vRright = new Vector(_vRright);
    }

    public Camera(Vector _vUp, Vector _vTo) {
        this._P0 = new Point3D(0,0,0);
        this._vUp = new Vector(_vUp);
        this._vTo = new Vector(_vTo);
        this._vRright = _vTo.crossProduct(_vUp);
    }

    public Camera(Point3D _P0,Vector _vUp, Vector _vTo) {
        this._P0 = new Point3D(_P0);
        this._vUp = new Vector(_vUp);
        this._vTo = new Vector(_vTo);
        this._vRright = _vTo.crossProduct(_vUp);
    }

    public Camera(Camera other) {
        this._P0 = new Point3D(other._P0);
        this._vUp = new Vector(other._vUp);
        this._vTo = new Vector(other._vTo);
        this._vRright = new Vector(other._vRright);
    }

    // ***************** Getters/Setters ********************** //
//    public void set_P0(Point3D _P0) {
//        this._P0 = _P0;
//    }
//
//    public void set_vUp(Vector _vUp) {
//        this._vUp = _vUp;
//    }
//
//    public void set_vTo(Vector _vTo) {
//        this._vTo = _vTo;
//    }
//
//    public void set_vRright(Vector _vRright) {
//        this._vRright = _vRright;
//    }

    public Point3D get_P0() {
        return _P0;
    }

    public Vector get_vUp() {
        return _vUp;
    }

    public Vector get_vTo() {
        return _vTo;
    }

    public Vector get_vRright() {
        return _vRright;
    }

    // ***************** Administration  ******************** //
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Camera camera = (Camera) o;
        return _P0.equals(camera._P0) &&
                _vUp.equals(camera._vUp) &&
                _vTo.equals(camera._vTo) &&
                _vRright.equals(camera._vRright);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(_P0, _vUp, _vTo, _vRright);
//    }
//


    @Override
    public String toString() {
        return "Camera{" +
                "_P0=" + _P0 +
                ", _vUp=" + _vUp +
                ", _vTo=" + _vTo +
                ", _vRright=" + _vRright +
                '}';
    }

    // ***************** Operations ******************** //
    public Ray costructRayThrowAPixel(int Nx,int Ny,double i,double j,double screenDist, double screenWidth,double screenHight)
    {
        Point3D Pc=new Point3D(_P0.addVector(_vTo.scaleNew(screenDist)));
        double Rx=(double)(screenWidth/Nx);
        double Ry=(double)(screenHight/Ny);
        Vector vR=_vRright.scaleNew((i-0.5*Nx)*Rx+0.5*Rx);
        Vector vU=_vUp.scaleNew((j-0.5*Ny)*Ry+0.5*Ry);
        Point3D p=Pc.addVector(vR.subtractNew(vU));
        Vector direction=new Vector(p.subPoint(_P0));
        direction.normalize();
        return new Ray(p,direction);
    }
}
