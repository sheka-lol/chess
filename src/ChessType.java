public enum ChessType {
	BLACK, WHITE;
	public String toString() {
		switch (this) {
		case BLACK:
			return "Black";
		case WHITE:
			return "White";
		default:
			return null;

		}
	}
}
