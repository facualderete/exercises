package medallia;

public class Tateti {

	public static void main(String[] args) {
		Board b = new Board();
		System.out.println(b);
		System.out.println(b.isFinished());
	}
	
	private static enum Tile {
		CIRCLE, CROSS
	}
		
	private static class Board {
		private Tile[][] board = new Tile[3][3];
		
		public Board() {
			// XXX: generate random finished game
			for (int i = 0 ; i < board.length ; i++) {
				for (int j = 0 ; j < board[i].length ; j++) {
					board[i][j] = (Math.random() < 0.1) ? null : (Math.random() > 0.5) ? Tile.CIRCLE : Tile.CROSS ;
				}
			}
		}
		
		public boolean isFinished() {
			if (getHorizontalCandidates() > 0 || getVerticalCandidates() > 0
					|| getFrontDiagonalCandidates() > 0 || getReverseDiagonalCandidates() > 0) return false; 
			return true;
		}
		
		public int getHorizontalCandidates() {
			int result = 0;
			for (int i = 0 ; i < board.length ; i++) {
				int tNull = 0;
				int tCircle = 0;
				int tCross = 0;
				for (int j = 0 ; j < board[i].length ; j++) {
					if (board[i][j] == null) tNull++;
					if (board[i][j] == Tile.CIRCLE) tCircle++;
					if (board[i][j] == Tile.CROSS) tCross++;
				}
				
				if (tNull > 1 || (tNull == 1 && (tCircle == 2 || tCross == 2))) result++;
			}
			
			return result;
		}
		
		public int getVerticalCandidates() {
			int result = 0;
			for (int i = 0 ; i < board.length ; i++) {
				int tNull = 0;
				int tCircle = 0;
				int tCross = 0;
				for (int j = 0 ; j < board[i].length ; j++) {
					if (board[j][i] == null) tNull++;
					if (board[j][i] == Tile.CIRCLE) tCircle++;
					if (board[j][i] == Tile.CROSS) tCross++;
				}
				
				if (tNull > 1 || (tNull == 1 && (tCircle == 2 || tCross == 2))) result++;
			}
			
			return result;
		}
		
		public int getFrontDiagonalCandidates() {
			int result = 0;
			int tNull = 0;
			int tCircle = 0;
			int tCross = 0;
			for (int i = 0 ; i < board.length ; i++) {
				if (board[i][i] == null) tNull++;
				if (board[i][i] == Tile.CIRCLE) tCircle++;
				if (board[i][i] == Tile.CROSS) tCross++;
			}
			if (tNull > 1 || (tNull == 1 && (tCircle == 2 || tCross == 2))) result++;
			
			return result;
		}
		
		public int getReverseDiagonalCandidates() {
			int result = 0;
			int tNull = 0;
			int tCircle = 0;
			int tCross = 0;
			for (int i = 0 ; i < board.length ; i++) {
				if (board[i][board.length - 1 - i] == null) tNull++;
				if (board[i][board.length - 1 - i] == Tile.CIRCLE) tCircle++;
				if (board[i][board.length - 1 - i] == Tile.CROSS) tCross++;
			}
			if (tNull > 1 || (tNull == 1 && (tCircle == 2 || tCross == 2))) result++;
			
			return result;
		}
		
		@Override
		public String toString() {
			StringBuilder b = new StringBuilder();
			for (int i = 0 ; i < board.length ; i++) {
				for (int j = 0 ; j < board[i].length ; j++) {
					b.append(board[i][j] + "\t");
				}
				b.append("\n");
			}
			return b.toString();
		}
	}
}
