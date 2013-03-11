import javax.swing.JFrame;

class GUI {
	private JFrame frame;
	private MyJPanel panel;

	public GUI() {
		frame = new JFrame();
	}

	public void buildGUI(ChessBoard board) {
		panel = new MyJPanel(board);
		panel.addMouseListener(new Listener(board));
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(405, 425);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public JFrame getFrame() {
		return frame;
	}
}
