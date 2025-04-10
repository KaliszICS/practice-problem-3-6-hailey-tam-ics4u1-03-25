public class PracticeProblem {

	public static void main(String args[]) {

	}

	public static int searchMazeMoves(String[][] arr) {
 
	
		int row = arr.length - 1;
		int col = 0;

		int noOfMoves = 0;

		return searchMazeMovesHelper(arr, row, col, noOfMoves);
		
	}

	public static int searchMazeMovesHelper(String[][] arr, int row, int col, int moves) {

		if ( row < 0 || row >= arr.length || col < 0 || col >= arr[row].length){
			return -1;
		}

	
		if (arr[row][col].equals("F")){
			// return number of moves
			return moves;
		}

		
		if(arr[row][col].equals("*")){
			return -1;
		}

		
		int rightMoves = searchMazeMovesHelper(arr, row, col + 1, moves + 1);
		
		
		int upMoves = searchMazeMovesHelper(arr, row - 1, col, moves + 1);

		
		if (rightMoves != -1 && upMoves != - 1){
			return Math.min(rightMoves, upMoves);
		}
		else if (rightMoves == -1) {
			return upMoves;
		}
		else {
			return rightMoves;
		}
	}

	public static int noOfPaths(String[][] arr) {

		
		int row = arr.length - 1;
		int col = 0;

		return noOfPathsHelper(arr, row, col);
		
	}

	public static int noOfPathsHelper(String[][] arr, int row, int col) {

		if ( row < 0 || row >= arr.length || col < 0 || col >= arr[row].length){
			return -1;
		}

		if (arr[row][col].equals("F")){
			return 1; 
		}

		
		if(arr[row][col].equals("*")){
			return -1;
		}
	
		int rightPaths = noOfPathsHelper(arr, row, col + 1);
		int upPaths = noOfPathsHelper(arr, row - 1, col);

		if (rightPaths == -1){
			rightPaths = 0;
		}
		if (upPaths == -1){
			upPaths = 0;
		}
			return rightPaths + upPaths;
	}
}
