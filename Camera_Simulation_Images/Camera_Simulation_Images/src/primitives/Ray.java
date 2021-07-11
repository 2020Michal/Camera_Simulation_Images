package primitives;

public class Ray {

    protected Point3D _POO;
    protected Vector _direction;

    // ***************** Constructors ********************** //
    public Ray(Point3D _POO, Vector _direction) {
        super();
        this._POO =new Point3D( _POO);
        this._direction = new Vector(_direction);
    }

    public Ray(Vector _direction)
    {
        super();
        this._POO = new Point3D(0,0,0);
        this._direction = new Vector(_direction);
    }

    public Ray(Ray other) {
        super();
        this._POO = new Point3D(other._POO);
        this._direction = new Vector(other._direction);
    }

    // ***************** Getters/Setters ********************** //
    public Point3D get_POO() {
        return new Point3D(_POO);
    }

//	public void set_POO(Point3D _POO) {
//		this._POO = _POO;
//	}

    public Vector get_direction() {
        return new Vector(_direction.normalizeNew());
    }
//	public void set_direction(Vector _direction) {
//		this._direction = _direction;
//	}

    // ***************** Administration  ******************** //
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((_POO == null) ? 0 : _POO.hashCode());
//		result = prime * result + ((_direction == null) ? 0 : _direction.hashCode());
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
        Ray other = (Ray) obj;
        if (_POO == null) {
            if (other._POO != null)
                return false;
        } else if (!_POO.equals(other._POO))
            return false;
        if (_direction == null) {
            if (other._direction != null)
                return false;
        } else if (!_direction.equals(other._direction))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Ray [_POO=" + _POO + ", _direction=" + _direction + "]";
    }

    // ***************** Operations ******************** //









}
