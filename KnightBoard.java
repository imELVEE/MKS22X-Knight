public class KnightBoard{
  private int[][] board;

  public KnightBoard(int startingRows, int startingCols){
    if(startingRows < 0 || startingCols < 0){
      throw new IllegalArgumentException("PARAMETERS ARE NEGATIVE");
    }
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

}
