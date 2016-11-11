package kmv.editor.graphics.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import kmv.editor.graphics.drawing.view.CoordinatePlane;

/**
 * @author Mikhail Kovalev
 */
public class WorkingAreaPanel extends JPanel{
    private CoordinatePlane mCoordinatePlane;
    private JTextArea mLogPanel;

    public WorkingAreaPanel(){
        setLayout(new BorderLayout());
        mCoordinatePlane= new CoordinatePlane();
        mCoordinatePlane.setBackground(Color.white);
        mLogPanel = new JTextArea();
        mLogPanel.setPreferredSize(new Dimension(200, 700));
        add(mCoordinatePlane, BorderLayout.CENTER);
        add(mLogPanel, BorderLayout.EAST);
    }

    public CoordinatePlane getCoordinatePlane() {
        return mCoordinatePlane;
    }

    public void setCoordinatePlane(CoordinatePlane pCoordinatePlane) {
        mCoordinatePlane = pCoordinatePlane;
    }

    public JTextArea getLogPanel() {
        return mLogPanel;
    }

    public void setLogPanel(JTextArea pLogPanel) {
        mLogPanel = pLogPanel;
    }
}
