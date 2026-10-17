package manhatan;

public final class Point {
    private final int x;
    private final int y;

    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }

    public static int manhattanDistance(Point p1,Point p2){
        if( p1==null || p2==null){
            throw new IllegalArgumentException("Los puntos no pueden ser nulos");
        }
        return Math.abs(p1.x-p2.x)+Math.abs(p1.y-p2.y);
    }

}
