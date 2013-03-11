import java.awt.Image;
import java.util.List;

public class Bishop extends ChessPiece {

	public Bishop(String name, Image image, ChessType type) {
		super(name, image, type);
	}

	public boolean isValide(Plate plate, Plate currPlate, List<List> plates) {
		if (isFriendly(plate, currPlate))
			return false;
		return isValideBishop(plate, currPlate, plates);
	}

}
