package kmv.editor.graphics.view;

import java.awt.BorderLayout;
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
import kmv.editor.graphics.drawing.controler.CircleAlgorithmController;
import kmv.editor.graphics.drawing.controler.DDAAlgorithmController;
import kmv.editor.graphics.drawing.controler.EllipseAlgorithmController;
import kmv.editor.graphics.menu.ExitMenuListener;
import kmv.editor.graphics.menu.geometry.CircleBuildingListener;
import kmv.editor.graphics.menu.geometry.EllipseBuildingListener;
import kmv.editor.graphics.menu.geometry.SegmentListener;

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
		mainFrame.setSize(1200, 700);
		mainFrame.setLocationRelativeTo(null);

		JMenuBar mainMenuBar = new JMenuBar();
		JMenu fileMenu = new JMenu(MENU_FILE);
		fileMenu.setMnemonic(KeyEvent.VK_F);
		JMenuItem exitItem = new JMenuItem(EXIT, KeyEvent.VK_Q);
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		fileMenu.add(exitItem);
		mainMenuBar.add(fileMenu);
		mainFrame.setJMenuBar(mainMenuBar);
		exitItem.addActionListener(new ExitMenuListener());

		WorkingAreaPanel workingAreaPanel = new WorkingAreaPanel();
		mainFrame.add(workingAreaPanel, BorderLayout.CENTER);

		JMenu segmentsMenu = new JMenu(MENU_SEGMENTS);
		segmentsMenu.setMnemonic(KeyEvent.VK_E);
		JMenuItem ddaAlgoritmItem = new JMenuItem(MENU_SEGMENT_DDA, KeyEvent.VK_R);
		JMenuItem brenzenhemAlgoritmItem = new JMenuItem(MENU_SEGMENT_BRENZENHEM, KeyEvent.VK_A);
		JMenuItem byAlgoritmItem = new JMenuItem(MENU_SEGMENT_BY, KeyEvent.VK_D);

		segmentsMenu.add(ddaAlgoritmItem);
		segmentsMenu.add(brenzenhemAlgoritmItem);
		segmentsMenu.add(byAlgoritmItem);
		mainMenuBar.add(segmentsMenu);

		ddaAlgoritmItem.addActionListener(new SegmentListener(
				mainFrame,
				new DDAAlgorithmController(workingAreaPanel))
		);
		byAlgoritmItem.addActionListener(new SegmentListener(
				mainFrame,
				new BYAlgorithmController(workingAreaPanel))
		);
		brenzenhemAlgoritmItem.addActionListener(new SegmentListener(
				mainFrame,
				new BrezenhemAlgorithmController(workingAreaPanel))
		);

		JMenu secondOrderLinesMenu = new JMenu(MENU_TWO_ORDER_LINES);

		JMenuItem circleBuildingItem = new JMenuItem(MENU_CIRCLE);
		JMenuItem ellipseBuildingtem = new JMenuItem(MENU_ELLIPSE);
		JMenuItem hyperboleBuildingtem = new JMenuItem(MENU_HYPERBOLE);
		JMenuItem parabolaBuildingtem = new JMenuItem(MENU_PARABOLA);

		secondOrderLinesMenu.add(circleBuildingItem);
		secondOrderLinesMenu.add(ellipseBuildingtem);
		secondOrderLinesMenu.add(hyperboleBuildingtem);
		secondOrderLinesMenu.add(parabolaBuildingtem);
		mainMenuBar.add(secondOrderLinesMenu);

		circleBuildingItem.addActionListener(new CircleBuildingListener(
				mainFrame,
				new CircleAlgorithmController(workingAreaPanel))
		);

		ellipseBuildingtem.addActionListener(new EllipseBuildingListener(
				mainFrame,
				new EllipseAlgorithmController(workingAreaPanel))
		);

		mainFrame.setVisible(true);
	}
}
