package primitives;

public class Point2D {

    protected Coordinate _x;
    protected Coordinate _y;

    //************************Constructors *********************//
    public Point2D(double d, double e)
    {
        super();
        this._x = new Coordinate(d);
        this._y = new Coordinate(e);
    }

    public Point2D(Coordinate d, Coordinate e)
    {
        super();
        this._x =new Coordinate(d);
        this._y = new Coordinate(e);
    }

    public Point2D(Point2D other)
    {
        //super();
        this._x = new Coordinate(other._x);
        this._y = new Coordinate(other._y);
    }

    // ***************** Getters/Setters ********************** //
    public Coordinate get_x() {
        return new Coordinate(_x) ;
    }

    public void set_x(Coordinate _x) {
        this._x = _x;
    }

    public Coordinate get_y() {
        return new Coordinate(_y) ;
    }

    public void set_y(Coordinate _y) {
        this._y = _y;
    }

    // ***************** Administration  ******************** //
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((_x == null) ? 0 : _x.hashCode());
//		result = prime * result + ((_y == null) ? 0 : _y.hashCode());
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
        Point2D other = (Point2D) obj;
        if (_x == null) {
            if (other._x != null)
                return false;
        } else if (!_x.equals(other._x))
            return false;
        if (_y == null) {
            if (other._y != null)
                return false;
        } else if (!_y.equals(other._y))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Point2D [_x=" + _x + ", _y=" + _y + "]";
    }

//	public void set_y(Coordinate _y) {
//		this._y = _y;
//	}
//


}
