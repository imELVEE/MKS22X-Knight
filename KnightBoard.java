public class KnightBoard{
  private int[][] board;

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
          boardString += "_ ";
        else
          boardString += board[r][c] + " ";
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
    if (level == startingRows * startingCols){
      return true;
    }
    for (int d = 1 ; d < 9 ; d++){
      System.out.println(canmove(startingRows, startingCols, d));
    }
    return false;
  }

  private boolean canmove(int row, int col, int direction){
    //remember rows are up and down, cols are left and right

    //up
    if (direction == 1){
      if (row - 2 >= 0 && col - 1 >= 0){
        return true;
      }
    }
    if (direction == 2){
      if (row - 2 >= 0 && col + 1 < board[row].length){
        return true;
      }
    }

    //right
    if (direction == 3){
      if (row - 1 >= 0 && col + 2 < board[row].length){
        return true;
      }
    }
    if (direction == 4){
      if (row + 1 < board.length && col + 2 < board[row].length){
        return true;
      }
    }

    //down
    if (direction == 5){
      if (row + 2 < board.length && col + 1 < board[row].length){
        return true;
      }
    }
    if (direction == 6){
      if (row + 2 < board.length && col - 1 >= 0){
        return true;
      }
    }

    //left
    if (direction == 7){
      if (row - 1 >= 0 && col - 2 >= 0){
        return true;
      }
    }
    if (direction == 8){
      if (row - 1 >= 0 && col - 2 >= 0){
        return true;
      }
    }

    return false;
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
