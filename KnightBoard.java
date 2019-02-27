public class KnightBoard{
  private int[][] board;
  private int count = 0;

  public KnightBoard(int startingRows, int startingCols){
    isNegative(startingRows,startingCols);
    board = new int[startingRows][startingCols];
    clear();
  }

  private void clear(){
    for (int r = 0 ; r < board.length ; r++){
      for (int c = 0 ; c < board[r].length ; c++){
        board[r][c] = 0;
      }
    }
  }

  public String toString(){
    String boardString = "";
    for (int r = 0 ; r < board.length ; r++){
      for (int c = 0 ; c < board[r].length ; c++){
        if (board[r][c] == 0)
          boardString += "  _";
        else
          if (board[r][c] > 9){
            boardString += " " + board[r][c];
          }
          else{
            boardString += "  " + board[r][c];
          }
      }
      boardString += "\n";
    }
    return boardString;
  }

  public boolean solve(int startingRows, int startingCols){
    isNegative(startingRows,startingCols);
    isEmpty();
    return solve(startingRows,startingCols,1);
  }

  private boolean solve(int startingRows, int startingCols, int level){
    if (level == board.length * board[0].length){
      board[startingRows][startingCols] = level;
      return true;
    }
    board[startingRows][startingCols] = level;
    for (int d = 1 ; d < 9 ; d++){
      if (canmove(startingRows, startingCols, d)){
        int[] where = moveDist(d);
        if (solve(startingRows+where[0],startingCols+where[1],level+1)){
          return true;
        }
      }
    }
    board[startingRows][startingCols] = 0;
    return false;
  }

  public int countSolutions(int startingRow, int startingCol){
    isNegative(startingRow,startingCol);
    isEmpty();
    count = 0;
      if (multiSolve(startingRow,startingCol,1)){
        clear();
      }
    return count;
  }

  private boolean multiSolve(int startingRows, int startingCols, int level){
    if (level == board.length * board[0].length){
      return true;
    }
    board[startingRows][startingCols] = level;
    for (int d = 1 ; d < 9 ; d++){
      if (canmove(startingRows, startingCols, d)){
        int[] where = moveDist(d);
        if (multiSolve(startingRows+where[0],startingCols+where[1],level+1)){
          count++;
        }
      }
    }
    board[startingRows][startingCols] = 0;
    return false;
  }

  private boolean canmove(int row, int col, int direction){
    //remember rows are up and down, cols are left and right

    //up
    if (direction == 1){
      if (row - 2 >= 0 && col - 1 >= 0){
        return board[row-2][col-1] == 0;
      }
    }
    if (direction == 2){
      if (row - 2 >= 0 && col + 1 < board[row].length){
        return board[row-2][col+1] == 0;
      }
    }

    //right
    if (direction == 3){
      if (row - 1 >= 0 && col + 2 < board[row].length){
        return board[row-1][col+2] == 0;
      }
    }
    if (direction == 4){
      if (row + 1 < board.length && col + 2 < board[row].length){
        return board[row+1][col+2] == 0;
      }
    }

    //down
    if (direction == 5){
      if (row + 2 < board.length && col + 1 < board[row].length){
        return board[row+2][col+1] == 0;
      }
    }
    if (direction == 6){
      if (row + 2 < board.length && col - 1 >= 0){
        return board[row+2][col-1] == 0;
      }
    }

    //left
    if (direction == 7){
      if (row + 1 < board.length && col - 2 >= 0){
        return board[row+1][col-2] == 0;
      }
    }
    if (direction == 8){
      if (row - 1 >= 0 && col - 2 >= 0){
        return board[row-1][col-2] == 0;
      }
    }

    return false;
  }

  private int[] moveDist(int direction){
    int[] ans = new int[2];
    if (direction == 1){
      ans[0] = -2;
      ans[1] = -1;
    }
    if (direction == 2){
      ans[0] = -2;
      ans[1] = 1;
    }
    if (direction == 3){
      ans[0] = -1;
      ans[1] = 2;
    }
    if (direction == 4){
      ans[0] = 1;
      ans[1] = 2;
    }
    if (direction == 5){
      ans[0] = 2;
      ans[1] = 1;
    }
    if (direction == 6){
      ans[0] = 2;
      ans[1] = -1;
    }
    if (direction == 7){
      ans[0] = 1;
      ans[1] = -2;
    }
    if (direction == 8){
      ans[0] = -1;
      ans[1] = -2;
    }
    return ans;
  }

  private void isEmpty(){
    for (int r = 0 ; r < board.length ; r++){
      for (int c = 0 ; c < board[r].length ; c++){
        if (board[r][c] != 0){
          throw new IllegalStateException("BOARD IS NOT EMPTY");
        }
      }
    }
  }

  private void isNegative(int startingRows, int startingCols){
    if(startingRows < 0 || startingCols < 0){
      throw new IllegalArgumentException("PARAMETERS ARE NEGATIVE");
    }
  }


}
