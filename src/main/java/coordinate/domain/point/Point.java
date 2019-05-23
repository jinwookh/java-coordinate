package coordinate.domain.point;

import coordinate.domain.coordinate.Coordinate;
import coordinate.domain.coordinate.XCoordinate;
import coordinate.domain.coordinate.YCoordinate;

import java.util.Objects;

public class Point {
    private final Coordinate xCoordinate;
    private final Coordinate yCoordinate;

    private Point(Coordinate xCoordinate, Coordinate yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public static Point create(int xCoordinate, int yCoordinate) {
        return new Point(new XCoordinate(xCoordinate), new YCoordinate(yCoordinate));
    }

    public double getSquareDistanceWith(Point point) {
        return Math.pow(this.xCoordinate.getDiffWith(point.xCoordinate), 2)
                + Math.pow(this.yCoordinate.getDiffWith(point.yCoordinate), 2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return point.xCoordinate.equals(xCoordinate)
                && point.yCoordinate.equals(yCoordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate.hashCode() + yCoordinate.hashCode());
    }
}
