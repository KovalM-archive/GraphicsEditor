package kmv.editor.graphics.drawing.controler;

import kmv.editor.graphics.drawing.model.GeometryObject;
import kmv.editor.graphics.view.WorkingAreaPanel;

/**
 *  @author Mikhail Kovalev
 */
public abstract class AlgorithmController implements Runnable {
	protected Thread mThread;
	protected WorkingAreaPanel mWorkingAreaPanel;
	protected GeometryObject mGeometryObject;
	protected boolean mCheckoutMod;

	public AlgorithmController(WorkingAreaPanel pWorkingAreaPanel){
		mWorkingAreaPanel = pWorkingAreaPanel;
	}

	public void startBuildSegment(GeometryObject pGeometryObject, boolean pCheckoutMode){
		mGeometryObject = pGeometryObject;
		mCheckoutMod = pCheckoutMode;
        mThread = new Thread(this);
		mThread.start();
	}

	public abstract void buildGeometryObjectByAlgorithm();

	@Override
	public void run() {
		clearLogPanel();
		buildGeometryObjectByAlgorithm();
	}

	public void logInfo(String pLogInfo){
		mWorkingAreaPanel.getLogPanel().append(pLogInfo+"\n");
	}

	public void clearLogPanel(){
		mWorkingAreaPanel.getLogPanel().setText(null);
	}
}
