import java.awt.Color;

class Plate {
	private Color color;
	private int x, y;
	private ChessPiece figure;
	private boolean choosen;

	public Plate(Color color, int x, int y) {
		this.x = x;
		this.y = 350 - y;
		this.color = color;
	}
	public int getArrayXPos(){
		return x/50;
	}
	public int getArrayYPos(){
		return (350-y)/50;
	}
	public boolean isEmpty() {
		return (figure == null);
	}

	public void setFigure(ChessPiece figure) {
		if (figure != null && !figure.isTouched())
			figure.setTouched(true);
		this.figure = figure;
	}

	public ChessPiece getFigure() {
		return figure;
	}

	public Color getColor() {
		return color;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setChoosen(boolean choosen) {
		this.choosen = choosen;
	}

	public boolean isChoosen() {
		return choosen;
	}

	public String toString() {
		if (figure != null)
			return figure.getName() + " " + getX() + " " + getY() + " "
					+ isChoosen();
		return null;
	}
}