package kmv.editor.graphics.drawing.controler;

import kmv.editor.graphics.drawing.model.Segment;
import kmv.editor.graphics.view.WorkingAreaPanel;

/**
 *  @author Mikhail Kovalev
 */
public abstract class AlgorithmController implements Runnable {
	protected Thread mThread;
	protected WorkingAreaPanel mWorkingAreaPanel;
	protected Segment mSegment;
	protected boolean mCheckoutMod;

	public AlgorithmController(WorkingAreaPanel pWorkingAreaPanel){
		mWorkingAreaPanel = pWorkingAreaPanel;
	}

	public void startBuildSegment(Segment pSegment, boolean pCheckoutMode){
		mSegment = pSegment;
		mCheckoutMod = pCheckoutMode;
        mThread = new Thread(this);
		mThread.start();
	}

	public abstract void buildSegmentByAlgorithm();

	@Override
	public void run() {
		clearLogPanel();
		buildSegmentByAlgorithm();
	}

	public void logInfo(String pLogInfo){
		mWorkingAreaPanel.getLogPanel().append(pLogInfo+"\n");
	}

	public void clearLogPanel(){
		mWorkingAreaPanel.getLogPanel().setText(null);
	}
}
