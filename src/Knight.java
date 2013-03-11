import java.awt.Image;
import java.util.List;

public class Knight extends ChessPiece {

	public Knight(String name, Image image, ChessType type) {
		super(name, image, type);
	}

	public boolean isValide(Plate plate, Plate currPlate, List<List> plates) {
		if (isFriendly(plate, currPlate))
			return false;
		if (Math.abs(plate.getX() - currPlate.getX()) == 50
				&& Math.abs(plate.getY() - currPlate.getY()) == 100)
			return true;
		if (Math.abs(plate.getX() - currPlate.getX()) == 100
				&& Math.abs(plate.getY() - currPlate.getY()) == 50)
			return true;
		return false;
	}

}
