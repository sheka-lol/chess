import java.awt.Image;
import java.util.List;

public class Queen extends ChessPiece {

	public Queen(String name, Image image, ChessType type) {
		super(name, image, type);
	}

	public boolean isValide(Plate plate, Plate currPlate, List<List> plates) {
		if (isFriendly(plate, currPlate))
			return false;
		if (isValideBishop(plate, currPlate, plates))
			return true;
		if (isValideRook(plate, currPlate, plates))
			return true;
		return false;
	}

}
