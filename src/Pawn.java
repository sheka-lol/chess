import java.awt.Image;
import java.util.List;

class Pawn extends ChessPiece {
	private PawnState state;
	private DefaultState defaultState;
	private MainState mainState;

	public Pawn(String name, Image image, ChessType type) {
		super(name, image, type);
		defaultState = new DefaultState(this);
		mainState = new MainState(this);
		state = defaultState;
	}

	public boolean isValide(Plate plate, Plate currPlate, List<List> plates) {
		if (isFriendly(plate, currPlate))
			return false;
		return state.isValide(plate, currPlate);
	}

	public void setState(PawnState state) {
		this.state = state;
	}

	public PawnState getMainState() {
		return mainState;
	}

	public String getState() {
		if (state instanceof MainState)
			return "MainState";
		return "Default State";
	}
}