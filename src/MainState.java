public class MainState implements PawnState {
	private Pawn figure;
	private int sign = 1;

	public MainState(Pawn figure) {
		this.figure = figure;
	}

	@Override
	public boolean isValide(Plate plate, Plate currPlate) {

		if (figure.getChessType() == ChessType.WHITE)
			sign = 1;
		else if (figure.getChessType() == ChessType.BLACK)
			sign = -1;
		if (sign * plate.getY() > sign * currPlate.getY())
			return false;
		if (!plate.isEmpty()
				&& Math.abs((plate.getX() - currPlate.getX())) == 50
				&& sign * (currPlate.getY() - plate.getY()) == 50) {
			return true;
		}
		if (plate.getX() != currPlate.getX())
			return false;
		if (sign * (currPlate.getY() - plate.getY()) > 50)
			return false;

		if (!plate.isEmpty())
			return false;

		return true;
	}

}
