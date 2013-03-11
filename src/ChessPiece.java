import java.awt.Image;
import java.util.List;

public abstract class ChessPiece {
	private String name;
	private Image image;
	private Plate currPlate;
	private boolean touched;
	private ChessType type;

	public ChessPiece(String name, Image image, ChessType type) {
		this.name = name;
		this.image = image;
		this.type = type;
	}

	public boolean isTouched() {
		return touched;
	}

	public void setTouched(boolean touched) {
		this.touched = touched;
	}

	public String getName() {
		return name;
	}

	public boolean isValide(Plate plate, Plate currPlate, List<List> plates) {
		return false;
	}

	public Image getImage() {
		return image;
	}

	public ChessType getChessType() {
		return type;
	}

	public boolean isFriendly(Plate plate, Plate currPlate) {
		if (!plate.isEmpty()
				&& plate.getFigure().getChessType() == currPlate.getFigure()
						.getChessType())
			return true;
		return false;
	}

	public boolean isValideBishop(Plate plate, Plate currPlate,
			List<List> plates) {
		if (Math.abs(plate.getArrayXPos() - currPlate.getArrayXPos()) == Math
				.abs(plate.getArrayYPos() - currPlate.getArrayYPos())) {
			int currX = currPlate.getArrayXPos();
			int x = plate.getArrayXPos();
			int currY = currPlate.getArrayYPos();
			int y = plate.getArrayYPos();
			for (int i = Math.min(x, currX) + 1, j = Math.min(y, currY) + 1; i < Math
					.max(x, currX); i++, j++) {
				Plate plateDisc = (Plate) plates.get(j).get(i);
				if (!plateDisc.isEmpty())
					return false;
			}
			return true;
		}
		return false;
	}

	public boolean isValideRook(Plate plate, Plate currPlate, List<List> plates) {
		if (plate.getArrayYPos() == currPlate.getArrayYPos()) {
			int y = plate.getArrayYPos();
			List<Plate> platesY = plates.get(y);
			for (int i = Math.min(currPlate.getArrayXPos(),
					plate.getArrayXPos()) + 1; i < (Math.max(
					currPlate.getArrayXPos(), plate.getArrayXPos())); i++)
				if (!platesY.get(i).isEmpty())
					return false;
			return true;
		}
		if (plate.getArrayXPos() == currPlate.getArrayXPos()) {
			int x = plate.getArrayXPos();
			for (int i = Math.min(currPlate.getArrayYPos(),
					plate.getArrayYPos()) + 1; i < (Math.max(
					currPlate.getArrayYPos(), plate.getArrayYPos())); i++) {
				Plate plateDisc = (Plate) plates.get(i).get(x);
				if (!plateDisc.isEmpty())
					return false;
			}
			return true;
		}
		return false;
	}

}
