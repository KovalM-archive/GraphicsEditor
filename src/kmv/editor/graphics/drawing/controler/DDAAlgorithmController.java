package kmv.editor.graphics.drawing.controler;

import java.awt.Color;
import kmv.editor.graphics.drawing.model.Segment;
import kmv.editor.graphics.drawing.view.CoordinatePlane;
import kmv.editor.graphics.view.WorkingAreaPanel;

/**
 * @author Mikhail Kovalev
 */
public class DDAAlgorithmController extends AlgorithmController {

    public DDAAlgorithmController(WorkingAreaPanel pWorkingAreaPanel) {
        super(pWorkingAreaPanel);
    }

    @Override
    public void startBuildSegment(Segment pSegment, boolean isCheckoutMode) {
        CoordinatePlane coordinatePlane = getWorkingAreaPanel().getCoordinatePlane();
        coordinatePlane.clearCoordinatePlane();

        double x1 = pSegment.getStartX();
        double y1 = pSegment.getStartY();
        double x2 = pSegment.getFinishX();
        double y2 = pSegment.getFinishY();
        int length = (int)Math.max(Math.abs(x1-x2), Math.abs(y1-y2));
        double dx = (x2-x1) / length;
        double dy = (y2-y1) / length;
        double x = x1 + 0.5;
        double y = y1 + 0.5;

        System.out.println(0 + " " + x + " " + y + " " + (int)x + " " + (int)y);
        for (int i = 1; i < length+1; i++) {
            coordinatePlane.drawPlot((int)x, (int)y, Color.gray);
            coordinatePlane.drawSegment(x, y, x+dx, y+dy, Color.black);
            x+=dx;
            y+=dy;
            System.out.println(i + " " + x + " " + y + " " + (int)x + " " + (int)y);
        }
        coordinatePlane.drawPlot((int)x, (int)y, Color.gray);
    }
}
