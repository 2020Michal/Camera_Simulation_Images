package geometries;

import java.awt.Color;
import java.util.ArrayList;

import primitives.*;

public class Triangle extends Geometry implements FlatGeometry {

        protected Point3D _p1;
        protected Point3D _p2;
        protected Point3D _p3;

        // ***************** Constructors ********************** //
        public Triangle(Color _color, Point3D _p1, Point3D _p2, Point3D _p3,Material _material)
        {
                super(_color,_material);
                this._p1 = new Point3D(_p1);
                this._p2 = new Point3D(_p2);
                this._p3 = new Point3D(_p3);
        }

        public Triangle(Color _color, Point3D _p1, Point3D _p2, Point3D _p3)
        {
                super(_color);
                this._p1 = new Point3D(_p1);
                this._p2 = new Point3D(_p2);
                this._p3 = new Point3D(_p3);
        }

        public Triangle(Triangle other)
        {
                super(other._color,other._material);
                this._p1 = new Point3D(other._p1);
                this._p2 = new Point3D(other._p2);
                this._p3 =new Point3D(other._p3);
        }

        // ***************** Getters/Setters ********************** //
        public Point3D getP1() { return new Point3D(_p1); }
        public Point3D getP2() { return new Point3D(_p2); }
        public Point3D getP3() { return new Point3D(_p3); }

        public void setP1(Point3D p1) {	this._p1 = new Point3D(p1);	}
        public void setP2(Point3D p2) {	this._p2 = new Point3D(p2);	}
        public void setP3(Point3D p3) {	this._p3 = new Point3D(p3);	}

        // ***************** Administration  ******************** //
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((_p1 == null) ? 0 : _p1.hashCode());
//		result = prime * result + ((_p2 == null) ? 0 : _p2.hashCode());
//		result = prime * result + ((_p3 == null) ? 0 : _p3.hashCode());
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
                Triangle other = (Triangle) obj;
                if (_p1 == null) {
                        if (other._p1 != null)
                                return false;
                } else if (!_p1.equals(other._p1))
                        return false;
                if (_p2 == null) {
                        if (other._p2 != null)
                                return false;
                } else if (!_p2.equals(other._p2))
                        return false;
                if (_p3 == null) {
                        if (other._p3 != null)
                                return false;
                } else if (!_p3.equals(other._p3))
                        return false;
                return true;
        }


        @Override
        public String toString() {
                return "Triangle{" +
                        "_p1=" + _p1 +
                        ", _p2=" + _p2 +
                        ", _p3=" + _p3 +
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

//               Vector v1 = new Vector(_p1.subPoint(ray.get_POO()));
//                Vector v2 = new Vector(_p2.subPoint(ray.get_POO()));
//                Vector v3 = new Vector(_p3.subPoint(ray.get_POO()));
//
//                Vector N1 = v2.crossProduct(v1).normalizeNew();
//                Vector N2 = v1.crossProduct(v3).normalizeNew();
//                Vector N3 = v3.crossProduct(v2).normalizeNew();
//
//                Plane plane = new Plane(this._color, _p1, this.getNormal(_p1),this._material);
//                Point3D p = plane.findIntersections(ray).get(0);
//                Vector vec = new Vector(p.subPoint(ray.get_POO()));
//
//                double sign1 = vec.dotProduct(N1);
//                double sign2 = vec.dotProduct(N2);
//                double sign3 = vec.dotProduct(N3);
//
//                ArrayList<Point3D> list = new ArrayList<Point3D>();
//
//                if (    (sign1 > 0 && sign2 > 0 && sign3 > 0) || (sign1 < 0 && sign2 < 0 && sign3 < 0)  ) {
//                        list.add(p);
//                        return list;
//                }
//                return list;
                ArrayList<Point3D> intersectionPoints = new ArrayList<Point3D>(1);

                // Intersecting the triangular plane

                Point3D P0 = ray.get_POO();

                Vector N = getNormal(null);
                Plane plane = new Plane(new Color(0,0,0), _p3, N);

                ArrayList<Point3D> intersectionPlaneList = plane.findIntersections(ray);
                if (intersectionPlaneList.isEmpty())
                        return intersectionPoints;

                Point3D intersectionPlane = intersectionPlaneList.get(0);

                // Checking if the interseculating point is bounded by the triangle
                Vector P_P0 = new Vector(P0, intersectionPlane);

                // Checking 1/3 triangular side
                Vector V1_1 = new Vector(P0, this._p1);
                Vector V2_1 = new Vector(P0, this._p2);
                Vector N1 = V1_1.crossProduct(V2_1);
                N1.normalize();
                double S1 = -P_P0.dotProduct(N1);

                // Checking 2/3 triangular side
                Vector V1_2 = new Vector(P0, this._p2);
                Vector V2_2 = new Vector(P0, this._p3);
                Vector N2 = V1_2.crossProduct(V2_2);
                N2.normalize();
                double S2 = -P_P0.dotProduct(N2);

                // Checking 1/3 triangular side
                Vector V1_3 = new Vector(P0, this._p3);
                Vector V2_3 = new Vector(P0, this._p1);
                Vector N3 = V1_3.crossProduct(V2_3);
                N3.normalize();
                double S3 = -P_P0.dotProduct(N3);

                if (((S1 > 0) && (S2 > 0) && (S3 > 0)) ||
                        ((S1 < 0) && (S2 < 0) && (S3 < 0))){
                        intersectionPoints.add(intersectionPlane);
                }

                return intersectionPoints;

        }
}
