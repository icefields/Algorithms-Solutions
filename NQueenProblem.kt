/**
 * The n-queens puzzle is the problem of placing n queens on a (n×n) 
 * chessboard such that no two queens can attack each other.
 * 
 * Given an integer n, find all distinct solutions to the n-queens 
 * puzzle. Each solution contains distinct board configurations of the 
 * n-queens’ placement, where the solutions are a permutation of 
 * [1,2,3..n] in  increasing order, here the number in the ith place 
 * denotes that the ith-column queen is placed in the row with that 
 * number. 
 * 
 * Example 1:
 * Input: 1
 * Output:[1]
 * 
 * Explaination:
 * Only one queen can be placed in the single cell available.
 * 
 * Example 2:
 * Input: 4
 * Output: [2 4 1 3 ] [3 1 4 2 ]
 * 
 * Explaination:
 * These are the 2 possible solutions.
 * 
 * Your Task:
 * You do not need to read input or print anything. Your task is to 
 * complete the function nQueen() which takes n as input parameter and 
 * returns a list containing all the possible chessboard configurations 
 * in sorted order. Return an empty list if no solution exists.
 * 
 * Expected Time Complexity: O(n!)
 * Expected Auxiliary Space: O(n2) 
 * 
 * Constraints:
 * 1 ≤ n ≤ 10
 *  
**/
fun nQueen(n: Int) {
	val solution = listOf<List<Int>>()
	permutations(n).forEach { board ->
		if (verifyBoard(board)) {
			solution.add(board)
		}
	}
	return solution
}

fun permutations(board: ArrayList<Int>, storedBoard: List<Int>): List<List<Int>> {
	if(board.size == 1) {
		storedBoard.add(board[0])
		return storedBoard
	} else {
		for(i in str.indices) {
			storedBoard.add(board[i])
			permutations(board.splice(i, i + 1), storedBoard)
		}
	}
}

[2 1 4 3 ] [3 1 4 2 ]

col = 3
--- row = 3 ---
y = 1
x = 1


private fun verifyBoard(board: List<Int>): Boolean {
	board.forEachIndexed { col, row ->
		// verify the queen is not placed on the same row
		if (board.remove(col).contains(row)) {
			return false
		}
		
		// verify diagonals
		board.forEachIndexed { y, x ->
			if (y != col) {
				if (abs(row - x) == abs(y - col)) return false
			}
		}		
	}
	return true
}


