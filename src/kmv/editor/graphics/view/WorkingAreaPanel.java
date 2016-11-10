package kmv.editor.graphics.view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import kmv.editor.graphics.drawing.view.CoordinatePlane;

/**
 * @author Mikhail Kovalev
 */
public class WorkingAreaPanel extends JPanel {
    private CoordinatePlane mCoordinatePlane;

    public WorkingAreaPanel(){
        setLayout(new BorderLayout());
        mCoordinatePlane= new CoordinatePlane();
        mCoordinatePlane.setBackground(Color.white);
        add(mCoordinatePlane, BorderLayout.CENTER);
    }

    public CoordinatePlane getCoordinatePlane() {
        return mCoordinatePlane;
    }

    public void setCoordinatePlane(CoordinatePlane pCoordinatePlane) {
        mCoordinatePlane = pCoordinatePlane;
    }
}
