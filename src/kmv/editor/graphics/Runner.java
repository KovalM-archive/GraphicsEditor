package kmv.editor.graphics;

import javax.swing.SwingUtilities;

import kmv.editor.graphics.view.MainWindow;

public class Runner {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainWindow());
    }
}
