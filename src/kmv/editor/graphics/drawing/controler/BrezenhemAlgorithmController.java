package kmv.editor.graphics.drawing.controler;

import java.awt.Color;
import kmv.editor.graphics.drawing.model.Segment;
import kmv.editor.graphics.drawing.view.CoordinatePlane;
import kmv.editor.graphics.view.WorkingAreaPanel;

/**
 * @author Mikhail Kovalev
 */
public class BrezenhemAlgorithmController extends AlgorithmController {
	public BrezenhemAlgorithmController(WorkingAreaPanel pWorkingAreaPanel) {
		super(pWorkingAreaPanel);
	}

	@Override
	public void buildSegmentByAlgorithm() {
		CoordinatePlane coordinatePlane = mWorkingAreaPanel.getCoordinatePlane();
		coordinatePlane.clearCoordinatePlane();
		int pause = mCheckoutMod?1000:0;
		int x1 = (int)mSegment.getStartX();
		int y1 = (int)mSegment.getStartY();
		int x2 = (int)mSegment.getFinishX();
		int y2 = (int)mSegment.getFinishY();
		int x = x1;
		int y = y1;
		int dx = x2-x1;
		int dy = y2-y1;
		int e = 2*dy - dx;
		int nx, ny, ne;

		logInfo("i    e    x    y   e'  plot(x, y)");
		logInfo(0 + "   -    " + x + "   " + y + "   " + e + "  (" + x + " " + y + ")");
		int i = 1;
		while (i <= dx) {
			coordinatePlane.drawPlot(x, y, Color.black);

			try {
				Thread.sleep(pause);
			} catch (InterruptedException pE) {
				pE.printStackTrace();
			}
			ny = y;
			nx = x+1;
            ne = e;
			if (e >= 0){
				ny = ny + 1;
				ne -= 2*dx;
			}
            ne += 2*dy;
//			coordinatePlane.drawSegment(x, y, nx, ny, Color.black);
			x = nx; y = ny;
			logInfo(i + "   " + e + "   " + x + "   " + y + "   " + ne + "  (" + x + " " + y + ")");
			e = ne;
            i++;
		}
		coordinatePlane.drawPlot(x, y, Color.black);
	}
}
