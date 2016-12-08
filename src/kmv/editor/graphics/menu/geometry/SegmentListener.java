package kmv.editor.graphics.menu.geometry;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import kmv.editor.graphics.drawing.controler.AlgorithmController;
import kmv.editor.graphics.view.BuildSegmentPanel;

/**
 * @author Mikhail Kovalev
 */
public class SegmentListener implements ActionListener {
    private JFrame mMainWindow;
    private AlgorithmController mAlgorithmController;

    public SegmentListener(JFrame pMainWindow, AlgorithmController pAlgorithmController){
        mMainWindow = pMainWindow;
        mAlgorithmController = pAlgorithmController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JDialog buildSegmentDialog = new JDialog(mMainWindow, "Enter parameters window", false);
        buildSegmentDialog.setSize(300, 300);
        buildSegmentDialog.setLocationRelativeTo(mMainWindow);
        buildSegmentDialog.setVisible(true);
        buildSegmentDialog.setLayout(new BorderLayout());

        buildSegmentDialog.add(new BuildSegmentPanel(mAlgorithmController, buildSegmentDialog), BorderLayout.NORTH);
    }

    public AlgorithmController getAlgorithmController() {
        return mAlgorithmController;
    }
}
