package ch.elmermx.strategy_game.view;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.OverlayLayout;
import javax.swing.SwingUtilities;

import ch.elmermx.model.Game;
import ch.elmermx.model.GameObject;

public class GameFrame extends JFrame {
	private final Game game;

	public GameFrame(final Game game) {
		super("Game");
		this.game = game;
		initComponents();
		initFrame();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				setVisible(true);
				requestFocus(); // JPanel now receives key events
			}
		});
	}

	private void initFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.white);
		readyForTermination();
		setPreferredSize(game.getMapSize());
		setFocusable(true);
	}

	private void initComponents() {

		for (GameObject go : game.getGameObjects()) {
			GameComponent gc = GameComponentFactory.createGameComponent(go);
			add(gc);
		}

		// listen for mouse presses
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				// mousePressed(e.getX(), e.getY());
			}
		});
	}

	private void readyForTermination() {
		addKeyListener(new KeyAdapter() {
			// listen for esc, q, end, ctrl-c
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if ((keyCode == KeyEvent.VK_ESCAPE) || (keyCode == KeyEvent.VK_Q) || (keyCode == KeyEvent.VK_END) || ((keyCode == KeyEvent.VK_C) && e.isControlDown())) {
					game.stopGame();
					dispose();
				}
			}
		});
	}
}
