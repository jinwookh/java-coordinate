package coordinate.domain;

import coordinate.domain.Figure.Triangle;
import coordinate.domain.point.Point;
import coordinate.domain.point.PointGroup;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest {
    @Test
    void 삼각형_넓이() {
        List<Point> points = Arrays.asList(
                Point.create(1, 1), Point.create(2, 2),
                Point.create(1, 3)
        );
        assertThat(new Triangle(new PointGroup(points)).area());
    }

    @Test
    void 일직선_세_점() {
        List<Point> points = Arrays.asList(
                Point.create(1, 1), Point.create(1, 2),
                Point.create(1, 3)
        );
        assertThrows(IllegalStateException.class, () -> {
            new Triangle(new PointGroup(points));
        });
    }

}
