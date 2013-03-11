public class DefaultState implements PawnState {
	Pawn figure;
	int sign = 1;

	public DefaultState(Pawn figure) {
		this.figure = figure;
	}

	@Override
	public boolean isValide(Plate plate, Plate currPlate) {
		if (!plate.isEmpty()
				&& plate.getFigure().getChessType() == currPlate.getFigure()
						.getChessType())
			return false;
		if (figure.getChessType() == ChessType.WHITE)
			sign = 1;
		else if (figure.getChessType() == ChessType.BLACK)
			sign = -1;
		if (sign * plate.getY() > sign * currPlate.getY())
			return false;
		if (!plate.isEmpty()
				&& Math.abs((plate.getX() - currPlate.getX())) == 50
				&& sign * (currPlate.getY() - plate.getY()) == 50) {
			if (figure.isTouched())
				figure.setState(figure.getMainState());
			return true;
		}
		if (plate.getX() != currPlate.getX())
			return false;
		if (sign * (currPlate.getY() - plate.getY()) > 100)
			return false;

		if (!plate.isEmpty())
			return false;

		if (figure.isTouched())
			figure.setState(figure.getMainState());
		return true;
	}
}
