package kmv.editor.graphics.drawing.controler;

import kmv.editor.graphics.drawing.model.Segment;
import kmv.editor.graphics.drawing.view.CoordinatePlane;

/**
 * @author Mikhail Kovalev
 */
public class DDAAlgorithmController extends AlgorithmController {

    public DDAAlgorithmController(CoordinatePlane pCoordinatePlane) {
        super(pCoordinatePlane);
    }

    @Override
    public void startBuildSegment(Segment pSegment, boolean isCheckoutMode) {

    }
}
