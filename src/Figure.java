import java.awt.Image;
import java.util.List;

class Figure extends ChessPiece {

	public Figure(String name, Image image, ChessType type) {
		super(name, image, type);
	}

	public boolean isValide(Plate plate, Plate currPlate, List<List> plates) {
		return true;
	}

}