package coordinate.controller;

import coordinate.domain.Figure.AreaCalculable;
import coordinate.domain.Figure.*;
import coordinate.domain.point.PointGroup;
import coordinate.util.CoordinateRepresentation;
import coordinate.view.InputView;
import coordinate.view.OutputView;

public class CoordinateApplication {
    public static void main(String[] args) {
        PointGroup points = createCoordinatesGroup();

        if (points.size() == 1) {
            OutputView.printCoordinatePlane(points);
            return;
        }
        Figure figure = FigureFactory.getInstance(points);

        if (figure instanceof Line) {
            double lineLength = ((Line) figure).length();
            OutputView.printCoordinatePlane(points);
            OutputView.printLineLength(lineLength);
            return;
        }

        OutputView.printCoordinatePlane(points);
        OutputView.printArea(figure.toString(), ((AreaCalculable)figure).area());
        return;
    }

    private static PointGroup createCoordinatesGroup() {
        try {
            return CoordinateRepresentation.convertCoordinatePair(InputView.inputCoordinates());
        } catch (NumberFormatException e) {
            System.out.println("좌표값은 정수만 가능합니다\n");
            return createCoordinatesGroup();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");
            return createCoordinatesGroup();
        }
    }
}
