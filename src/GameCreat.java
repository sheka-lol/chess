import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class GameCreat {
	public void start() {
		List<List> platesList = new ArrayList<List>();
		int id = 0;
		for (int i = 0; i < 8; i++) {
			List<Plate> plates = new ArrayList<Plate>();
			for (int j = 0; j < 8; j++) {
				Plate plate;
				if (id % 2 == 0)
					plate = new Plate(Color.BLACK, j * 50, i * 50);
				else
					plate = new Plate(Color.WHITE, j * 50, i * 50);
				plates.add(plate);
				id++;
				if (j == 7)
					id++;

			}
			platesList.add(plates);
		}
		List<ChessPiece> blackFigures = getBlackFigures();
		List<ChessPiece> whiteFigures = getWhiteFigures();
		for (int i = 0, k = 0; i < 2; i++)
			for (int j = 0; j < 8; j++) {
				List<Plate> plates = platesList.get(i);
				plates.get(j).setFigure(whiteFigures.get(k));
				k++;
			}
		for (int i = 7, k = 0; i > 5; i--)
			for (int j = 0; j < 8; j++) {
				List<Plate> plates = platesList.get(i);
				plates.get(j).setFigure(blackFigures.get(k));
				k++;
			}
		GUI gui = new GUI();
		ChessBoard board = null;
		try {
			board = new ChessBoard(platesList, gui.getFrame(),
					ImageIO.read(new File("res/green.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		gui.buildGUI(board);
	}

	public List getBlackFigures() {
		List<ChessPiece> figures = new ArrayList<ChessPiece>();
		BufferedImage img = null;
		ChessType type = ChessType.BLACK;
		try {
			img = ImageIO.read(new File("res/Black/Rook.png"));
			figures.add(0, new Rook("Black Rook", img, type));
			img = ImageIO.read(new File("res/Black/Knight.png"));
			figures.add(1, new Knight("Black Knight", img, type));
			img = ImageIO.read(new File("res/Black/Bishop.png"));
			figures.add(2, new Bishop("Black Bishop", img, type));
			img = ImageIO.read(new File("res/Black/Queen.png"));
			figures.add(3, new Queen("Black Queen", img, type));
			img = ImageIO.read(new File("res/Black/King.png"));
			figures.add(4, new King("Black King", img, type));
			img = ImageIO.read(new File("res/Black/Bishop.png"));
			figures.add(5, new Bishop("Black Bishop", img, type));
			img = ImageIO.read(new File("res/Black/Knight.png"));
			figures.add(6, new Knight("Black Knight", img, type));
			img = ImageIO.read(new File("res/Black/Rook.png"));
			figures.add(7, new Rook("Black Rook", img, type));
			img = ImageIO.read(new File("res/Black/Pawn.png"));
			for (int i = 8; i < 16; i++) {
				figures.add(i, new Pawn("Black Pawn", img, type));
			}

		} catch (IOException e) {
		}
		return figures;
	}

	public List getWhiteFigures() {
		List<ChessPiece> figures = new ArrayList<ChessPiece>();
		BufferedImage img = null;
		ChessType type = ChessType.WHITE;
		try {
			img = ImageIO.read(new File("res/White/Rook.png"));
			figures.add(0, new Rook("White Rook", img, type));
			img = ImageIO.read(new File("res/White/Knight.png"));
			figures.add(1, new Knight("White Knight", img, type));
			img = ImageIO.read(new File("res/White/Bishop.png"));
			figures.add(2, new Bishop("White Bishop", img, type));
			img = ImageIO.read(new File("res/White/Queen.png"));
			figures.add(3, new Queen("White Queen", img, type));
			img = ImageIO.read(new File("res/White/King.png"));
			figures.add(4, new King("White King", img, type));
			img = ImageIO.read(new File("res/White/Bishop.png"));
			figures.add(5, new Bishop("White Bishop", img, type));
			img = ImageIO.read(new File("res/White/Knight.png"));
			figures.add(6, new Knight("White Knight", img, type));
			img = ImageIO.read(new File("res/White/Rook.png"));
			figures.add(7, new Rook("White Rook", img, type));
			img = ImageIO.read(new File("res/White/Pawn.png"));
			for (int i = 8; i < 16; i++) {
				figures.add(i, new Pawn("White Pawn", img, type));
			}

		} catch (IOException e) {
		}
		return figures;
	}
}
