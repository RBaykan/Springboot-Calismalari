import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SudokoSolver {

	public static void main(String[] args) {
		// Sudoku tahtasını tanımla
	
		int a = 2;
		
		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };


		// Çözülmüş Sudoku tahtasını yazdır
		
		board = solveSudoku(board);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {

				System.out.print(board[i][j] + " ");
				}
			}
		
		

	}
	


	public static char[][] solveSudoku(char[][] boards) {

		
		char[][] board = boards;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {

				if (board[i][j] == '.') {

					

					board[i][j] = change(board[i][j], i, j, board);
					
				}
			}
			
		}

		return board;

	}

	public static char change(char c, int i, int j, char[][] board) {

		List<Character> charList = new ArrayList<Character>();
		List<Character> add = new ArrayList<Character>();

		// Kendi

	
		int tempI = (i%3 == 0 && i > 0) ? i-3 : i - i%3;
		int tempJ = (j%3 == 0 && j > 0) ? j-3 : j - j%3;
		

		for (int x = 0; x <= 2; x++) {

			for (int y = 0; y <= 2; y++) {
				if(board[tempI + x][tempJ + y] != '.')
				charList.add(board[tempI + x][tempJ + y]);
				
			}

		}

		// Diğer satır ve stunlar
		for(int x = 0; x<board.length; x++ ) {
            
			if(board[x][j] != '.'){
                charList.add(board[x][j]);
            }
		}
		
		for(int x = 0; x<board[0].length; x++ ) {
            if(board[i][x] != '.')
			charList.add(board[i][x]);
		}
				
		int sayac = 0;
		for(char f = '1'; f<= '9'; f++) {
			sayac = 0;
			for(Character d: charList) {
				if(f == d) {
					sayac++;
					break;
				}
			}
			if(sayac == 0) {
				System.out.println(f);
				add.add(f);
			}
			
		}
		
		
			return add.get(new Random().nextInt(add.size()));
		
		
		
		
		
	}

}

class Node {
	char val;
	Node ileri;
	Node geri;
}
