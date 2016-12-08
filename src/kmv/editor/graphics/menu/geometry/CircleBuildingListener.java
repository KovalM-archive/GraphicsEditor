package kmv.editor.graphics.menu.geometry;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import kmv.editor.graphics.drawing.controler.AlgorithmController;
import kmv.editor.graphics.drawing.controler.CircleAlgorithmController;
import kmv.editor.graphics.view.BuildSegmentPanel;
import kmv.editor.graphics.view.twoorderline.BuildCirclePanel;

/**
 * @author Mikhail Kovalev
 */
public class CircleBuildingListener implements ActionListener {
    private JFrame mainWindow;
    private AlgorithmController mAlgorithmController;

    public CircleBuildingListener(JFrame pMainWindow, AlgorithmController pAlgorithmController){
        this.mainWindow = pMainWindow;
        this.mAlgorithmController = pAlgorithmController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog dialogPanel = new JDialog(mainWindow, "Enter parameters window", false);
        dialogPanel.setSize(300, 300);
        dialogPanel.setLocationRelativeTo(mainWindow);
        dialogPanel.setVisible(true);
        dialogPanel.setLayout(new BorderLayout());
        dialogPanel.add(new BuildCirclePanel(mAlgorithmController, dialogPanel), BorderLayout.NORTH);
    }
}
