package kmv.editor.graphics.drawing.controler;

import java.awt.Color;
import kmv.editor.graphics.drawing.view.CoordinatePlane;
import kmv.editor.graphics.view.WorkingAreaPanel;

public class BYAlgorithmController extends AlgorithmController {
    public BYAlgorithmController(WorkingAreaPanel pWorkingAreaPanel) {
        super(pWorkingAreaPanel);
    }

    @Override
    public void buildSegmentByAlgorithm() {
        CoordinatePlane coordinatePlane = mWorkingAreaPanel.getCoordinatePlane();
        coordinatePlane.clearCoordinatePlane();
        int pause = mCheckoutMod?1000:0;

        double buffer, x, x1, y1, x2, y2, dx, dy, gradient, xend, yend, xgap, xpxl1, ypxl1, xpxl2, ypxl2, intery;
        x1 = mSegment.getStartX();
        y1 = mSegment.getStartY();
        x2 = mSegment.getFinishX();
        y2 = mSegment.getFinishY();
        if (x1 > x2){
            buffer = x1; x1 = x2; x2 = buffer;
            buffer = y1; y1 = y2; y2 = buffer;
        }
        dx = x2 - x1;
        dy = y2 - y1;
        gradient = dy/dx;
        xend = Math.round(x1);
        yend = y1 + gradient*(xend - x1);
        xgap = 1 - fpart(x1+0.5);
        xpxl1 = xend;
        ypxl1 = ipart(xend);
        coordinatePlane.drawPlot((int)xpxl1, (int)ypxl1, new Color(0, 0, 0, (int)(255*(1 - fpart(yend)*xgap))));
        coordinatePlane.drawPlot((int)xpxl1, (int)(ypxl1+1), new Color(0, 0, 0, (int)(255*(fpart(yend)*xgap))));

        intery = yend + gradient;
        xend = Math.round(x2);
        yend = y2 + gradient*(xend - x2);
        xgap = fpart(x2 + 0.5);
        xpxl2 = xend;
        ypxl2 = ipart(yend);
        coordinatePlane.drawPlot((int)xpxl2, (int)ypxl2, new Color(0, 0, 0, (int)(255*(1 - fpart(yend)*xgap))));
        coordinatePlane.drawPlot((int)xpxl2, (int)(ypxl2+1), new Color(0, 0, 0, (int)(255*(fpart(yend)*xgap))));

        x = xpxl1 + 1;
        while (x < (xpxl2)){
            coordinatePlane.drawPlot((int)x, (int)ipart(intery), new Color(0, 0, 0, (int)(255*(1 - fpart(intery)))));
            coordinatePlane.drawPlot((int)x, (int)ipart(intery), new Color(0, 0, 0, (int)(255*(fpart(intery)))));
            intery = intery + gradient;
            x++;
        }
    }

    private double ipart(double pValue){
        return Math.round(pValue);
    }

    private double fpart(double pValue){
        return pValue - (int)pValue;
    }

}
