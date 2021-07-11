package geometries;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Plane extends Geometry implements FlatGeometry{

    protected Point3D _Q;
    protected Vector N;

    // ***************** Constructors ********************** //

    public Plane(Color _color, Point3D _Q, Vector n, Material _material) {
        super(_color, _material);
        this._Q = new Point3D(_Q);
        this.N = new Vector(n);
    }

    public Plane(Color _color, Point3D _Q, Vector n) {
        super(_color);
        this._Q = new Point3D(_Q);
        this.N = new Vector(n);
    }

    public Plane(Plane other) {
        super(other.get_color(), other.get_material());
        this._Q = new Point3D(other.getQ());
        this.N = new Vector(other.getNormal(null));
    }

    // ***************** Getters/Setters ********************** //
    public Vector getNormal(Point3D point) { return new Vector(N).normalizeNew(); }
    public Point3D getQ()                  { return new Point3D(_Q);	 }

    public void setNormal(Vector normal) {	this.N = new Vector(normal); }
    public void setQ(Point3D d)          { this._Q = new Point3D(d);           }

    // ***************** Administration  ******************** //
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((N == null) ? 0 : N.hashCode());
//		result = prime * result + ((_O == null) ? 0 : _O.hashCode());
//		return result;
//	}


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Plane other = (Plane) obj;
        if (N == null) {
            if (other.N != null)
                return false;
        } else if (!N.equals(other.N))
            return false;
        if (_Q == null) {
            if (other._Q != null)
                return false;
        } else if (!_Q.equals(other._Q))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "Plane{" +
                "_Q=" + _Q +
                ", N=" + N +
                ", _color=" + _color +
                ", _material=" + _material +
                '}';
    }



    // ***************** Operations ******************** //
//    @Override
//    public Vector getNormal(Point3D point) {
//        return N.normalizeNew();
//    }

    @Override
    public ArrayList<Point3D> findIntersections(Ray ray) {
        ArrayList<Point3D> intersectionPoint = new ArrayList<Point3D>(1);

        Point3D P0 = ray.get_POO();
        Point3D Q0 = this.getQ();
        Vector N = this.getNormal(null);
        Vector V = ray.get_direction();

        Vector v = new Vector (Q0, P0);
        double t = (N.dotProduct(v) * -1) / N.dotProduct(V);

        if (t >= 0){
            V.scale(t);
            P0.add(V);
            intersectionPoint.add(P0);
        }

        return intersectionPoint;
    }


}
