package chess.pieces;

import boardgamer.Board;
import boardgamer.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {

	public Bishop(Board board, Color color) {
		super(board, color);
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColums()];

		Position p = new Position(0, 0);

		//nw
		p.setValue(position.getRow() - 1, position.getColum() - 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsApiece(p)) {
			mat[p.getRow()][p.getColum()] = true;
			p.setValue(p.getRow() - 1, p.getColum() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColum()] = true;
		}
		
		//ne
		p.setValue(position.getRow() - 1, position.getColum() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsApiece(p)) {
			mat[p.getRow()][p.getColum()] = true;
			p.setValue(p.getRow() - 1, p.getColum() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColum()] = true;
		}
		
        //se
		p.setValue(position.getRow() + 1, position.getColum() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsApiece(p)) {
			mat[p.getRow()][p.getColum()] = true;
			p.setValue(p.getRow() + 1, p.getColum() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColum()] = true;
		}
		
        //sw
		p.setValue(position.getRow() + 1, position.getColum() - 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsApiece(p)) {
			mat[p.getRow()][p.getColum()] = true;
			p.setValue(p.getRow() + 1, p.getColum() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColum()] = true;
		}
		
		
		return mat;
	}
	
	@Override
	public String toString() {
		return "B";
	}

}
