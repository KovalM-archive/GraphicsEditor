package kmv.editor.graphics.drawing.controler;

import kmv.editor.graphics.drawing.model.Parabola;
import kmv.editor.graphics.drawing.view.CoordinatePlane;
import kmv.editor.graphics.view.WorkingAreaPanel;

import java.awt.*;

/**
 * @author Uladzislau Jum
 */
public class ParabolaAlgorithController extends AlgorithmController {

    public ParabolaAlgorithController(WorkingAreaPanel pWorkingAreaPanel) {
        super(pWorkingAreaPanel);
    }

    @Override
    public void buildGeometryObjectByAlgorithm() {
        Parabola parabola = (Parabola) mGeometryObject;
        CoordinatePlane coordinatePlane = mWorkingAreaPanel.getCoordinatePlane();
        coordinatePlane.clearCoordinatePlane();
        int pause = mCheckoutMod ? 1000 : 0;

        int p = parabola.getP();
        int x = parabola.getX();
        int y = parabola.getY();
        int y1 = y;
        int bound = 20;
        int d, p2, p4;
        p2 = 2 * p;
        p4 = p2 * 2;
        d = 1 - p;
        int i = 0;

        while ((y < p) && (x <= bound)) {
            try {
                Thread.sleep(pause);
            } catch (InterruptedException pE) {
                pE.printStackTrace();
            }
            coordinatePlane.drawPlot(x, y, Color.black);
            coordinatePlane.drawPlot(x, y1, Color.black);
            System.out.println("i " + ++i + " d " + d + " " + x + " " + y);
            if (d >= 0) {
                x++;
                d -= p2;
            }
            y++;
            y1--;
            d += 2 * y + 1;
        }
        if (d == 1) {
            d = 1 - p4;
        } else {
            d = 1 - p2;
        }
        while (x <= bound) {
            try {
                Thread.sleep(pause);
            } catch (InterruptedException pE) {
                pE.printStackTrace();
            }
            coordinatePlane.drawPlot(x, y, Color.black);
            coordinatePlane.drawPlot(x, y1, Color.black);
            System.out.println("i " + ++i + " d " + d + " " + x + " " + y);
            if (d <= 0) {
                y++;
                y1--;
                d += 4 * y;
            }
            x++;
            d -= p4;
        }
    }
}

