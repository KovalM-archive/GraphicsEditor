package kmv.editor.graphics.drawing.controler;

import kmv.editor.graphics.drawing.model.Hyperbola;
import kmv.editor.graphics.drawing.view.CoordinatePlane;
import kmv.editor.graphics.view.WorkingAreaPanel;

/**
 * @author Uladzislau Jum
 */
public class HyperbolaAlgorithController extends AlgorithmController {

    public HyperbolaAlgorithController(WorkingAreaPanel pWorkingAreaPanel) {
        super(pWorkingAreaPanel);
    }

    @Override
    public void buildGeometryObjectByAlgorithm() {
        Hyperbola hyperbola = (Hyperbola) mGeometryObject;
        CoordinatePlane coordinatePlane = mWorkingAreaPanel.getCoordinatePlane();
        coordinatePlane.clearCoordinatePlane();

        int a = hyperbola.getA();
        int b = hyperbola.getB();
        int x = hyperbola.getX();
        int y = hyperbola.getY();
        int bound = 20;
    }

}

