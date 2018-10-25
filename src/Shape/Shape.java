package Shape;

public class Shape {
    private int id;
    private String shapeName;
    private double length;
    private double width;
    private double height;
    private double ray;

    public Shape(String shapeName){
        this.shapeName = shapeName;
    }

    public Shape(String shapeName, double length, double width, double height, double ray){
        this(0, shapeName, length, width, height, ray);
    }

    public Shape(int id, String shapeName, double length, double width, double height, double ray) {
        super();
        this.id = id;
        this.shapeName = shapeName;
        this.length = length;
        this.width = width;
        this.height = height;
        this.ray =  ray;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getShapeName() {
        return shapeName;
    }

    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width){
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getRay() {
        return ray;
    }

    public void setRay(double ray) {
        this.ray = ray;
    }

    @Override
    public String toString() {
        return String.format("Shape [id=%s, shapeName=%s, length=%s, width=%s, height=%s, ray=%s]",
            id, shapeName, length, width, height, ray);
    }
}
