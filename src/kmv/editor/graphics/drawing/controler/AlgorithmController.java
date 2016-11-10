package kmv.editor.graphics.drawing.controler;

import kmv.editor.graphics.drawing.model.Segment;
import kmv.editor.graphics.view.WorkingAreaPanel;

/**
 *  @author Mikhail Kovalev
 */
public abstract class AlgorithmController {
    private WorkingAreaPanel mWorkingAreaPanel;

    public AlgorithmController(WorkingAreaPanel pWorkingAreaPanel){
        mWorkingAreaPanel = pWorkingAreaPanel;
    }

    public abstract void startBuildSegment(Segment pSegment, boolean isCheckoutMode);

    public WorkingAreaPanel getWorkingAreaPanel() {
        return mWorkingAreaPanel;
    }

    public void setWorkingAreaPanel(WorkingAreaPanel pWorkingAreaPanel) {
        mWorkingAreaPanel = pWorkingAreaPanel;
    }
}
