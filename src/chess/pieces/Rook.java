package chess.pieces;

import boardgamer.Board;
import boardgamer.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece{

	public Rook(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "R";
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColums()];
		
		Position p = new Position(0, 0);
		
		//above
		p.setValue(position.getRow() - 1, position.getColum());
		while(getBoard().positionExists(p) && !getBoard().thereIsApiece(p)) {
			mat[p.getRow()][p.getColum()] = true;
			p.setRow(p.getRow() - 1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColum()] = true;		
		}
		
		// left
		p.setValue(position.getRow(), position.getColum() - 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsApiece(p)) {
			mat[p.getRow()][p.getColum()] = true;
			p.setColum(p.getColum() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColum()] = true;
		}
		
		// right
		p.setValue(position.getRow(), position.getColum() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsApiece(p)) {
			mat[p.getRow()][p.getColum()] = true;
			p.setColum(p.getColum() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColum()] = true;
		}
		
		// below
		p.setValue(position.getRow() + 1, position.getColum());
		while(getBoard().positionExists(p) && !getBoard().thereIsApiece(p)) {
			mat[p.getRow()][p.getColum()] = true;
			p.setRow(p.getRow() + 1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColum()] = true;		
		}
		

		return mat;
	}

}
