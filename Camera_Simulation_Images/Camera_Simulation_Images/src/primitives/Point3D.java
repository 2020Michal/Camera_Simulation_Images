package primitives;

public class Point3D extends Point2D {


    protected Coordinate _z;

    // ***************** Constructors ********************** //
    public Point3D(double d, double e,double f) {
        super(d, e);
        this._z=new Coordinate(f);
    }

    public Point3D(Coordinate d, Coordinate e, Coordinate f) {
        super(d, e);
        this._z = new Coordinate(f);
    }

    public Point3D(Point3D other) {

        super(other._x.get(),other._y.get());
        this._z=new Coordinate(other._z);

    }

    // ***************** Getters/Setters ********************** //
    public Coordinate get_z() {
        return new Coordinate(_z) ;
    }
    public void set_z(Coordinate _z) {
        this._z = _z;
    }
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((_z == null) ? 0 : _z.hashCode());
//		return result;
//	}

    // ***************** Administration  ********************** //
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Point3D other = (Point3D) obj;
        if (_z == null) {
            if (other._z != null)
                return false;
        } else if (!_z.equals(other._z))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Point3D [_x=" + _x + ", _y=" + _y + ", _z=" + _z + "]";
    }

    // ***************** Operations ******************** //
    public double getDistance(Point3D p)
    {
        return Math.sqrt(Math.pow(this._x.subtract(p.get_x()).get() , 2) + Math.pow(this._y.subtract(p.get_y()).get(), 2) + Math.pow(this._z.subtract(p.get_z()).get(), 2));

    }

    public void add(Vector vector) {

        this._x = this._x.add(vector.get_head().get_x());
        this._y=this._y.add(vector.get_head().get_y());
        this._z=this._z.add(vector.get_head().get_z());

    }

    public Point3D addVector(Vector vector) {

        Point3D result= new Point3D(0, 0, 0);

        result._x = this._x.add(vector.get_head().get_x());
        result._y=this._y.add(vector.get_head().get_y());
        result._z=this._z.add(vector.get_head().get_z());
        return  result;
    }

    public Point3D addPoint(Point3D other) {

        Point3D result= new Point3D(0, 0, 0);

        result._x = this._x.add(other.get_x());
        result._y=this._y.add(other.get_y());
        result._z=this._z.add(other.get_z());
        return result;

    }
    public void sub (Vector vector) {

        this._x=this._x.subtract(vector.get_head().get_x());
        this._y=this._y.subtract(vector.get_head().get_y());
        this._z=this._z.subtract(vector.get_head().get_z());

    }
    public Point3D subVector (Vector vector) {

        Point3D result= new Point3D(0, 0, 0);

        result._x=new Coordinate(this._x.get()-vector.get_head().get_x().get());
        result._y=new Coordinate(this._y.get()-vector.get_head().get_y().get());
        result._z=new Coordinate(this._z.get()-vector.get_head().get_z().get());
        return  result;

    }

    public Point3D subPoint(Point3D other) {

        Point3D result= new Point3D(0, 0, 0);

        result._x = new Coordinate(this._x.get()-(other.get_x().get()));
        result._y=new Coordinate(this._y.get()-(other.get_y().get()));
        result._z=new Coordinate(this._z.get()-(other.get_z().get()));
        return result;

    }

}
