import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

class MyJPanel extends JPanel {
	private ChessBoard board;

	public MyJPanel(ChessBoard board) {
		this.board = board;
	}

	public void paintComponent(Graphics g) {
		List<List> plates = board.getPlates();
		for (List<Plate> plateList : plates) {
			for (Plate plate : plateList) {
				g.setColor(plate.getColor());
				g.fillRect(plate.getX(), plate.getY(), 50, 50);
				if (plate.isChoosen())
					g.drawImage(board.getGreenLight(), plate.getX(),
							plate.getY(), null);
				if (!plate.isEmpty()) {
					g.drawImage(plate.getFigure().getImage(),
							plate.getX() + 12, plate.getY(), null);
				}
			}
		}
		if(board.isCheckMate()){
			Font font=new Font("Arial",Font.BOLD,64);
			g.setFont(font);
			g.setColor(Color.RED);
			g.drawString("GAME OVER", 0, this.getHeight()/2);
		}
		

	}
}