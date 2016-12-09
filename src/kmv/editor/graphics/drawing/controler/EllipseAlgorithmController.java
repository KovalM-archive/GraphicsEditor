package kmv.editor.graphics.drawing.controler;

import kmv.editor.graphics.drawing.model.Ellipse;
import kmv.editor.graphics.drawing.view.CoordinatePlane;
import kmv.editor.graphics.view.WorkingAreaPanel;

/**
 * @author Mikhail Kovalev
 * @author Uladzislau Jum
 */
public class EllipseAlgorithmController extends AlgorithmController {
    public EllipseAlgorithmController(WorkingAreaPanel pWorkingAreaPanel) {
        super(pWorkingAreaPanel);
    }

    @Override
    public void buildGeometryObjectByAlgorithm() {
        Ellipse ellipse = (Ellipse) mGeometryObject;
        CoordinatePlane coordinatePlane = mWorkingAreaPanel.getCoordinatePlane();
        coordinatePlane.clearCoordinatePlane();
        int pause = mCheckoutMod ? 1000 : 0;

        double centerX, centerY, delta, x, y, limit, sigma, a, b;
        centerX = ellipse.getEclipseX();
        centerY = ellipse.getEclipseY();
        a = ellipse.getEclipseA();
        b = ellipse.getEclipseB();
        double powA = Math.pow(a, 2);
        double powB = Math.pow(b, 2);

        x = centerX;
        y = b;
        limit = centerY;
        delta = powA + powB - 2 * powA * b;

        coordinatePlane.drawInAllQuarter(x, y, centerX, centerY);

        logInfo("D - 0");
        logInfo("H - 1");
        logInfo("V - 2");
        logInfo("a - " + (int) a);
        logInfo("b - " + (int) b);
        logInfo("  i  Di  s  s*  p   x  y  Di+1");
        String logTemplate = "---- ---- ---- ---- ---- ---- ---- ----";
        String tableRow = logTemplate;
        tableRow = insertLogInfo(tableRow, 0, 0);
        tableRow = insertLogInfo(tableRow, 5, (int) x);
        tableRow = insertLogInfo(tableRow, 6, (int) y);
        tableRow = insertLogInfo(tableRow, 7, (int) delta);
        logInfo(tableRow);
        int i = 1;
        while (y > limit) {
            try {
                Thread.sleep(pause);
            } catch (InterruptedException pE) {
                pE.printStackTrace();
            }

            tableRow = logTemplate;
            tableRow = insertLogInfo(tableRow, 0, i);
            tableRow = insertLogInfo(tableRow, 1, (int) delta);

            if (delta == 0) {
                x += 1;
                y -= 1;
                delta += powB * (2 * x + 1) + powA * (1 - 2 * y);
                tableRow = insertLogInfo(tableRow, 4, 0);
            } else if (delta > 0) {
                sigma = 2 * (delta - powB * x) - 1;
                tableRow = insertLogInfo(tableRow, 3, (int) sigma);
                if (sigma > 0) {
                    y -= 1;
                    delta += powA * (1 - 2 * y);
                    tableRow = insertLogInfo(tableRow, 4, 0);
                } else {
                    x += 1;
                    y -= 1;
                    delta += powB * (2 * x + 1) + powA * (1 - 2 * y);
                    tableRow = insertLogInfo(tableRow, 4, 2);
                }
            } else if (delta < 0) {
                sigma = 2 * (delta + powA * y) - 1;
                tableRow = insertLogInfo(tableRow, 2, (int) sigma);
                if (sigma <= 0) {
                    x += 1;
                    delta += powB * (2 + x + 1);
                    tableRow = insertLogInfo(tableRow, 4, 1);
                } else {
                    x += 1;
                    y -= 1;
                    delta += powB * (2 * x + 1) + powA * (1 - 2 * y);
                    tableRow = insertLogInfo(tableRow, 4, 2);
                }
            }
            tableRow = insertLogInfo(tableRow, 5, (int) x);
            tableRow = insertLogInfo(tableRow, 6, (int) y);
            tableRow = insertLogInfo(tableRow, 7, (int) delta);
            coordinatePlane.drawInAllQuarter(x, y, centerX, centerY);
            i++;
            logInfo(tableRow);
        }
    }

    private String insertLogInfo(String template, int cell, int info) {
        String answer;
        String insertInfo = String.valueOf(info);
        int left, right;
        left = 5 * cell;
        right = left + 3;
        while (insertInfo.length() < 4) {
            insertInfo += " ";
        }
        answer = template.substring(0, left) + insertInfo + template.substring(right + 1, template.length());
        return answer;
    }
}
