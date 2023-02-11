package boardgame;

public class Board {
	private int rows;
	private int columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardException(
					"error creating board it is necessary that there is at least one row and one column");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public Piece piece(int row, int column) {
		if (!positionExist(row, column)) {
			throw new BoardException("Positon not on the board");
		}
		return pieces[row][column];
	}

	public Piece piece(Position position) {
		if (!positionExist(position)) {
			throw new BoardException("Positon not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}

	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("There is already a  piece on position" + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}

	private boolean positionExist(int row, int column) {
		return row >= 0 && row < columns && column >= 0 && column < columns;
	}

	public boolean positionExist(Position position) {
		return positionExist(position.getRow(), position.getColumn());
	}

	public boolean thereIsAPiece(Position position) {
		if (!positionExist(position)) {
			throw new BoardException("Positon not on the board");
		}
		return piece(position) != null;
	}
}
