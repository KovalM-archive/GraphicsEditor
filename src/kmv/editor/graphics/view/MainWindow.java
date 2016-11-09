package kmv.editor.graphics.view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import kmv.editor.graphics.drawing.controler.BYAlgorithmController;
import kmv.editor.graphics.drawing.controler.BrezenhemAlgorithmController;
import kmv.editor.graphics.drawing.controler.DDAAlgorithmController;
import kmv.editor.graphics.drawing.view.CoordinatePlane;
import kmv.editor.graphics.menu.ExitMenuListener;
import kmv.editor.graphics.menu.segement.CommonSegmentListener;

public class MainWindow implements ViewConstants {
    public MainWindow() {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        JFrame mainFrame = new JFrame(APPLICATION_NAME);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1000, 700);
        mainFrame.setLocationRelativeTo(null);

        JMenuBar mainMenuBar = new JMenuBar();
        JMenu fileMenu = new JMenu(MENU_FILE);
        fileMenu.setMnemonic(KeyEvent.VK_F);

        JMenuItem exitItem = new JMenuItem(EXIT, KeyEvent.VK_Q);
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));

        fileMenu.add(exitItem);
        mainMenuBar.add(fileMenu);

        JMenu segmentsMenu = new JMenu(MENU_SEGMENTS);
        fileMenu.setMnemonic(KeyEvent.VK_E);

        JMenuItem ddaAlgoritmItem = new JMenuItem(MENU_SEGMENT_DDA, KeyEvent.VK_R);
        JMenuItem brenzenhemAlgoritmItem = new JMenuItem(MENU_SEGMENT_BRENZENHEM, KeyEvent.VK_A);
        JMenuItem byAlgoritmItem = new JMenuItem(MENU_SEGMENT_BY, KeyEvent.VK_D);

        segmentsMenu.add(ddaAlgoritmItem);
        segmentsMenu.add(brenzenhemAlgoritmItem);
        segmentsMenu.add(byAlgoritmItem);
        mainMenuBar.add(segmentsMenu);
        mainFrame.setJMenuBar(mainMenuBar);
        exitItem.addActionListener(new ExitMenuListener());

        CoordinatePlane coordinatePlane = new CoordinatePlane();
        coordinatePlane.setBackground(Color.black);
        mainFrame.add(coordinatePlane, BorderLayout.CENTER);

        ddaAlgoritmItem.addActionListener(new CommonSegmentListener(
                mainFrame,
                new DDAAlgorithmController(coordinatePlane))
        );
        byAlgoritmItem.addActionListener(new CommonSegmentListener(
                mainFrame,
                new BYAlgorithmController(coordinatePlane))
        );
        brenzenhemAlgoritmItem.addActionListener(new CommonSegmentListener(
                mainFrame,
                new BrezenhemAlgorithmController(coordinatePlane))
        );

        mainFrame.setVisible(true);
    }
}
