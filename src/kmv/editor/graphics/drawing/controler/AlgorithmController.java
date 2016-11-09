package kmv.editor.graphics.drawing.controler;

import kmv.editor.graphics.drawing.model.Segment;
import kmv.editor.graphics.drawing.view.CoordinatePlane;

/**
 *  @author Mikhail Kovalev
 */
public abstract class AlgorithmController {
    private CoordinatePlane mCoordinatePlane;

    public AlgorithmController(CoordinatePlane pCoordinatePlane){
        mCoordinatePlane = pCoordinatePlane;
    }

    public abstract void startBuildSegment(Segment pSegment, boolean isCheckoutMode);

    public CoordinatePlane getCoordinatePlane() {
        return mCoordinatePlane;
    }

    public void setCoordinatePlane(CoordinatePlane pCoordinatePlane) {
        mCoordinatePlane = pCoordinatePlane;
    }
}
