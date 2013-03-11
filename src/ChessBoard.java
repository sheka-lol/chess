import java.awt.Image;
import java.util.List;

import javax.swing.JFrame;

class ChessBoard {
	private List<List> plates;
	private Plate currPlate;
	private JFrame frame;
	private Image greenLight;
	private ValidePlates validation;
	private List<Plate> validePlates;
	private ChessType currPlayer,nextPlayer;
	public ChessBoard(List<List> plates, JFrame frame, Image greenLight) {
		this.plates = plates;
		this.frame = frame;
		this.greenLight = greenLight;
		validation = new ValidePlates(plates);
		currPlayer=ChessType.WHITE;
		nextPlayer=ChessType.BLACK;
	}

	public List<List> getPlates() {
		return plates;
	}

	public Plate getCurrPlate() {
		return currPlate;
	}

	public void choosePlate(int x, int y) {
		
		currPlate = platePos(x, y);
		currPlate.setChoosen(true);
	//	System.out.println(currPlate.getFigure().getState());
		frame.repaint();
	}

	public Plate platePos(int x, int y) {
		Plate plateCurr = null;
		for (List<Plate> plateList : plates)
			for (Plate plate : plateList) {
				if (x <= (plate.getX() + 50) && y <= (plate.getY() + 50)) {
					plateCurr = plate;
					break;
				}
			}
		return plateCurr;
	}

	public void rearrange(int x, int y) {
		Plate plateDestination = platePos(x, y);
		//validePlates = validation.getValidePlates(currPlate);
		//if(currPlate.getFigure() instanceof Pawn) System.out.println(currPlate.getFigure().getState());
		if (validation.isValide(plateDestination, currPlate)&&!isCheck()) {
			plateDestination.setFigure(currPlate.getFigure());
			currPlate.setFigure(null);
			ChessType temp= currPlayer;
			currPlayer=nextPlayer;
			nextPlayer=temp;
		}
		currPlate.setChoosen(false);
		currPlate = null;
		frame.repaint();
		validePlates = null;

	}

	public List<Plate> getValidePlates() {
		return validePlates;
	}

	public Image getGreenLight() {
		return greenLight;
	}
	public ChessType getCurrPlayer(){
		return currPlayer;
	}
	public boolean isCheckMate(){
		return false;
	}
	public boolean isCheck(){
		return false;
	}
}
