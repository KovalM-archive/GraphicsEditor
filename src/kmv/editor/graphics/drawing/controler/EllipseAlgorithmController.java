package kmv.editor.graphics.drawing.controler;

import kmv.editor.graphics.drawing.model.Circle;
import kmv.editor.graphics.drawing.view.CoordinatePlane;
import kmv.editor.graphics.view.WorkingAreaPanel;

/**
 *  @author Mikhail Kovalev
 */
public class EllipseAlgorithmController extends AlgorithmController {
    public EllipseAlgorithmController(WorkingAreaPanel pWorkingAreaPanel) {
        super(pWorkingAreaPanel);
    }

    @Override
    public void buildGeometryObjectByAlgorithm() {
        Circle circle = (Circle) mGeometryObject;
        CoordinatePlane coordinatePlane = mWorkingAreaPanel.getCoordinatePlane();
        coordinatePlane.clearCoordinatePlane();
        int pause = mCheckoutMod?1000:0;


    }
}
