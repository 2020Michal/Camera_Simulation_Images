package primitives;

public class Vector {

    protected Point3D _head;

    // ***************** Constructors ********************** //
    public Vector(Point3D _head) {
        super();
        this._head =new Point3D( _head);    }

    public Vector(double x, double y, double z) {
        this._head = new Point3D(new Coordinate(x),new Coordinate(y),new Coordinate(z));
    }

    public Vector(Vector other) {
        super();
        this._head = new Point3D(other._head);
    }

    public Vector(Point3D p1, Point3D p2){

        this(p2.get_x().get() - p1.get_x().get(),
                p2.get_y().get() - p1.get_y().get(),
                p2.get_z().get() - p1.get_z().get());
    }


    // ***************** Getters/Setters ********************** //
    public Point3D get_head() {
        return _head;
    }
    public void set_head(Point3D _head) {
        this._head = _head;
    }

    // ***************** Administration  ******************** //
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((_head == null) ? 0 : _head.hashCode());
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
        Vector other = (Vector) obj;
        if (_head == null) {
            if (other._head != null)
                return false;
        } else if (!_head.equals(other._head))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Vector [_head=" + _head + "]";
    }

    // ***************** Operations ******************** //
    public void add (Vector vector )
    {
        this._head.add(vector);
    }

    public Vector addNew (Vector vector)
    {
        return new Vector(this._head.addPoint(vector._head));
    }

    public void subtract (Vector vector )
    {
        this._head.sub(vector);
    }

    public Vector subtractNew (Vector vector)
    {
        return new Vector(this._head.subPoint(vector._head));
    }

    public void scale(double scalingFacor)
    {
        this._head._x = this._head._x.scale(scalingFacor);
        this._head._y = this._head._y.scale(scalingFacor);
        this._head._z = this._head._z.scale(scalingFacor);

    }

    public Vector scaleNew(double scalingFacor)
    {
        double x = this._head._x.scale(scalingFacor).get();
        double y  = this._head._y.scale(scalingFacor).get();
        double z  = this._head._z.scale(scalingFacor).get();
        return new Vector(new Point3D(x,y,z));

    }

    public double length()
    {
        return this._head.getDistance(new Point3D(0.0,0.0,0.0));
    }

    public Vector normalizeNew()
    {
        double norma = this.length();
        double x = this._head._x.scale(1.0/norma).get();
        double y = this._head._y.scale(1.0/norma).get();
        double z = this._head._z.scale(1.0/norma).get();
        return new Vector(x,y,z);

    }
    public void normalize()
    {
        double norma = this.length();
        this._head._x = this._head._x.scale(1.0/norma);
        this._head._y = this._head._y.scale(1.0/norma);
        this._head._z = this._head._z.scale(1.0/norma);

    }
    public Vector crossProduct (Vector vector)
    {
        double x= this._head._y.get()*vector._head._z.get()-this._head._z.get()*vector._head._y.get();
        double y=this._head._z.get()*vector._head._x.get()-this._head._x.get()*vector._head._z.get();
        double z= this._head._x.get()*vector._head._y.get()-this._head._y.get()*vector._head._x.get();
        Point3D p=new Point3D(x, y, z);
        return new Vector(p);
    }
    public double dotProduct(Vector vector)
    {
        return (this._head._x.get()*vector._head._x.get()+this._head._y.get()*vector._head._y.get()+this._head._z.get()*vector._head._z.get());
    }


}
