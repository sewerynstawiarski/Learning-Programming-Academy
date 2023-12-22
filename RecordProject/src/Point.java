public class Point {
    private int x;
    private int y;
    public Point() {
    }
    public Point (int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public double distance(Point another){
        return Math.sqrt((double)(another.getX() - x)*(double)(another.getX() - x) + (double) (another.getY() - y) * (double) (another.getY() - y));
    }
    public double distance (int x, int y) {
        Point point = new Point(x,y);
        return distance(point);
    }
    public double distance() {
        Point point = new Point(0,0);
        return distance(point);
    }
}
