import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Listener implements MouseListener {
	private ChessBoard board;
	private int clickNumb;

	public Listener(ChessBoard board) {
		this.board = board;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if (board.platePos(x, y).getFigure() != null
				&& board.getCurrPlayer() == board.platePos(x, y).getFigure()
						.getChessType()) {
			if (clickNumb == 0) {
				board.choosePlate(x, y);
				clickNumb++;
				System.out.println("The x-pos: " + x + " the y-pos: " + y);
				System.out.println(board.getCurrPlate());
				return;
			}
		}
		if (clickNumb > 0) {
			board.rearrange(x, y);
			clickNumb = 0;
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
