package chess.pieces;

import boardgamer.Board;
import boardgamer.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	private ChessMatch chessMath;
	
	public Pawn(Board board, Color color, ChessMatch chessMath) {
		super(board, color);
		this.chessMath = chessMath;
		
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColums()];

		Position p = new Position(0, 0);
		
		if(getColor() == Color.WHITE) {
			p.setValue(position.getRow() - 1, position.getColum());
			if(getBoard().positionExists(p) && !getBoard().thereIsApiece(p)) {
				mat[p.getRow()][p.getColum()] = true;
			}
			p.setValue(position.getRow() - 2, position.getColum());
			Position p2 = new Position(position.getRow() - 1, position.getColum());
			if(getBoard().positionExists(p) && !getBoard().thereIsApiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsApiece(p2) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColum()] = true;
		}
			p.setValue(position.getRow() - 1, position.getColum() - 1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColum()] = true;
			}
			
			p.setValue(position.getRow() - 1, position.getColum() + 1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColum()] = true;
			}
			
			//#specialmove en passant white
			if(position.getRow() == 3) {
				Position left = new Position(position.getRow(), position.getColum() - 1);
				if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMath.enPassantVulnerable()) {
					mat[left.getRow() - 1][left.getColum()] = true;
				}
				Position rigth = new Position(position.getRow(), position.getColum() + 1);
				if(getBoard().positionExists(rigth) && isThereOpponentPiece(rigth) && getBoard().piece(rigth) == chessMath.enPassantVulnerable()) {
					mat[rigth.getRow() - 1][rigth.getColum()] = true;
				}
			}
		}
		
		else {
			p.setValue(position.getRow() + 1, position.getColum());
			if(getBoard().positionExists(p) && !getBoard().thereIsApiece(p)) {
				mat[p.getRow()][p.getColum()] = true;
			}
			p.setValue(position.getRow() + 2, position.getColum());
			Position p2 = new Position(position.getRow() + 1, position.getColum());
			if(getBoard().positionExists(p) && !getBoard().thereIsApiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsApiece(p2) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColum()] = true;
		}
			p.setValue(position.getRow() + 1, position.getColum() - 1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColum()] = true;
			}
			
			p.setValue(position.getRow() + 1, position.getColum() + 1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColum()] = true;
			}
			
			//#specialmove en passant black
			if(position.getRow() == 4) {
				Position left = new Position(position.getRow(), position.getColum() - 1);
				if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMath.enPassantVulnerable()) {
					mat[left.getRow() + 1][left.getColum()] = true;
				}
				Position rigth = new Position(position.getRow(), position.getColum() + 1);
				if(getBoard().positionExists(rigth) && isThereOpponentPiece(rigth) && getBoard().piece(rigth) == chessMath.enPassantVulnerable()) {
					mat[rigth.getRow() + 1][rigth.getColum()] = true;
				}
			}
			
		}
		
		return mat;
	}
      @Override
      public String toString() {
    	  return "P";
      }
}
