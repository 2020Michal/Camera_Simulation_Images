package primitives;

import java.util.Objects;

public class Material {

    private  double _Kd;
    private  double _Ks;
    private  double _n;
    private double _Kr;
    private double _Kt;

    // ***************** Constructors ********************** //
    public Material() {
        this._Kd = 1;
        this._Ks = 1;
        this._n = 1;
        this._Kr = 0;
        this._Kt = 0;
    }


    public Material(double _Kd, double _Ks, double _n, double _Kr,double _Kq) {
        this._Kd = _Kd;
        this._Ks = _Ks;
        this._n = _n;
        this._Kr = _Kr;
        this._Kt = _Kq;
    }

    public Material(Material other)
    {
        this._Kd = other._Kd;
        this._Ks = other._Ks;
        this._n = other._n;
        this._Kr = other._Kr;
        this._Kt = other._Kt;
    }
    // ***************** Getters/Setters ********************** //

    public void set_Kd(double _Kd) {
        this._Kd = _Kd;
    }

    public void set_Ks(double _Ks) {
        this._Ks = _Ks;
    }

    public void set_n(double _n) {
        this._n = _n;
    }

    public double get_Kd() {
        return _Kd;
    }

    public double get_Kr() {
        return _Kr;
    }

    public void set_Kr(double _Kr) {
        this._Kr = _Kr;
    }

    public double get_Kt() {
        return _Kt;
    }

    public void set_Kt(double _Kt) {
        this._Kt = _Kt;
    }

    public double get_Ks() {
        return _Ks;
    }

    public double get_n() {
        return _n;
    }



    // ***************** Administration  ******************** //
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Material material = (Material) o;
        return Double.compare(material._Kd, _Kd) == 0 &&
                Double.compare(material._Ks, _Ks) == 0 &&
                Double.compare(material._n, _n) == 0 &&
                Double.compare(material._Kr, _Kr) == 0 &&
                Double.compare(material._Kt, _Kt) == 0;
    }

    @Override
    public String toString() {
        return "Material{" +
                "_Kd=" + _Kd +
                ", _Ks=" + _Ks +
                ", _n=" + _n +
                ", _Kr=" + _Kr +
                ", _Kt=" + _Kt +
                '}';
    }



}
