package Scene;

import elements.*;
import elements.Camera;
import elements.Light;
import geometries.Geometry;
import primitives.Vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;


public class Scene {
    String _sceneName;
    Color _background;
    AmbientLight _ambientLight;
    ArrayList<Light> _lights;
     ArrayList<Geometry> _geometries;
    Camera _camera;
    double _screenDistance;

    // ***************** Constructors ********************** //
    //**************************!!!!!!!!!!!!***********************************************************************************
    public Scene() {
        this._sceneName = "";
        this._ambientLight=new AmbientLight();
        this._background = Color.black;
        this._geometries = new ArrayList<Geometry>();
        this._camera=new Camera(new Vector(0,1,0),new Vector(0,0,-1));
        this._screenDistance = 100.0; //****************************
        this._lights=new ArrayList<Light>();
    }

    public Scene(String _sceneName, Color _background, ArrayList<Geometry> _geometries, Camera _camera, double _screenDistance,AmbientLight a,ArrayList<Light> _l) {
        this._sceneName = _sceneName;
        this._background = _background;
        this._geometries = _geometries;
        this._camera = _camera;
        this._screenDistance = _screenDistance;
        this._lights=_l;
        this._ambientLight=a;

    }

    public Scene(Scene other) {
        this._sceneName = other._sceneName;
        this._background = other._background;
        this._geometries = other._geometries;
        this._camera = other._camera;
        this._screenDistance = other._screenDistance;
        this._lights=other._lights;
        this._ambientLight=other._ambientLight;
    }


    // ***************** Getters/Setters ********************** //
    public String get_sceneName() {
        return _sceneName;
    }

    public Color get_background() {
        return _background;
    }

    public ArrayList<Geometry> get_geometries() {
        return _geometries;
    }

    public Camera get_camera() {
        return _camera;
    }

    public double get_screenDistance() {
        return _screenDistance;
    }

    public void set_sceneName(String _sceneName) {
        this._sceneName = _sceneName;
    }

    public void set_background(Color _background) {
        this._background = _background;
    }

    public void set_geometries(ArrayList<Geometry> _geometries) {
        this._geometries = _geometries;
    }

    public void set_camera(Camera _camera) {
        this._camera = _camera;
    }

    public void set_screenDistance(double _screenDistance) {
        this._screenDistance = _screenDistance;
    }

    public AmbientLight get_ambientLight() {
        return _ambientLight;
    }

    public void set_ambientLight(AmbientLight _ambientLight) {
        this._ambientLight = _ambientLight;
    }

    public ArrayList<Light> get_lights() {
        return _lights;
    }

    public void set_lights(ArrayList<Light> _lights) {
        this._lights = _lights;
    }

    // ***************** Administration  ******************** //


//    @Override
//    public int hashCode() {
//        return Objects.hash(_sceneName, _background, _geometries, _camera, _screenDistance);
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scene scene = (Scene) o;
        return Double.compare(scene._screenDistance, _screenDistance) == 0 &&
                Objects.equals(_sceneName, scene._sceneName) &&
                Objects.equals(_background, scene._background) &&
                Objects.equals(_ambientLight, scene._ambientLight) &&
                Objects.equals(_lights, scene._lights) &&
                Objects.equals(_geometries, scene._geometries) &&
                Objects.equals(_camera, scene._camera);
    }


    @Override
    public String toString() {
        return "Scene{" +
                "_sceneName='" + _sceneName + '\'' +
                ", _background=" + _background +
                ", _ambientLight=" + _ambientLight +
                ", _lights=" + _lights +
                ", _geometries=" + _geometries +
                ", _camera=" + _camera +
                ", _screenDistance=" + _screenDistance +
                '}';
    }

    // ***************** Operations ******************** //
    public void addGeometry(Geometry other)
    {
        _geometries.add(other);
    }

    public Iterator<Geometry> getIterator()
    {
        return _geometries.iterator();
    }

    public Iterator<Light> getILightiterator()
    {
        return _lights.iterator();
    }

    public void addLight(Light other){ _lights.add(other);}

}

