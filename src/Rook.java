import java.awt.Image;
import java.util.List;

public class Rook extends ChessPiece {

	public Rook(String name, Image image, ChessType type) {
		super(name, image, type);
	}

	public boolean isValide(Plate plate, Plate currPlate, List<List> plates) {
		if (isFriendly(plate, currPlate))
			return false;
		return isValideRook(plate,currPlate,plates);
	}

}
