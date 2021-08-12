package cpsc2150.extendedTicTacToe;

/**
 *
 * IGameBoard represent us a 2D-array row * col gameboard with the character in.
 *  In Tic-Tac-Toe, players take turn placing letters on a grid that user
 *  has to choose the size of it. Also, choose the number to win.
 *  Players have to get win in a row either vertically, horizontally, or diagonally. If they do, then they win. if the
 *  grid is fall, but no one wins, it will tell player, game is tied.
 * @Initialize ensures: GameBoard contains only blank characters and is between MAX_ROL * MAX_COL to MIN_ROW * MIN_COL,
 * all the check methods are from interface(default methods)
 * @defines  num_row: Z - the number of row in the GameBoard
 *           num_col: Z - the number of column in the GameBoard
 *           win_num: Z - the number of the same 'X' or 'O' in the continuous row
 *           player: - the player will mark their unique letter with uppercase on the GameBoard
 *
 * @constrait  MIN_ROW < num_row <= MAX_ROW
 *             MIN_COL < num_col <= MAX_COL
 *             WIN_MAX <= win_num <= WIN_MAX
 */

public interface IGameBoard {

    /**
     *
     *
     * @return the number of rows in the GameBoard
     */
    public int getNumRows();


    /**
     *
     * @return  the number of columns in the GameBoard
     */
    public int getNumColumns();


    /**
     *
     * @return the number of tokens in a row needed to win the game
     */
    public int getNumToWin();


    /**
     *
     * @param pos pos is a BoardPosition object argument,which include row and column
     *
     *@return return true if the position specified in pos is available
     */
    default boolean checkSpace(BoardPosition pos) {

        return whatsAtPos(pos) == ' ';
    }


    /**
     * @param marker is a BoardPosition object argument contains the player
     * @param player 'O' or 'X' would be printed in board
     * @require marker == ' '
     * @ensure places the character in marker on the position specified by marker,
     *         and should not be called if the space is not available.
     * @pre board position is ' '
     * @post marker by player with 'X' or 'O'
     */
    public void placeMarker(BoardPosition marker, char player);


    /**
     * @param lastPos contains the row, column
     * @return this function will check to see if the lastPos placed resulted in a winner.
     * It so it will return true, otherwise false.
     * @post check whether the player wins or not
     */
    default boolean checkForWinner(BoardPosition lastPos) {
        char player = whatsAtPos(lastPos);
         return checkHorizontalWin(lastPos, player) || checkVerticalWin(lastPos, player) || checkDiagonalWin(lastPos, player);


        }

    /**
     * this function will check to see if the game has resulted in a tie.
     * if there are no free board positions remaining, game is a tie
     * @return true if the game is tied, and false otherwise.
     * @post see if the game has resulted in a tie.
     */
    default boolean checkForDraw() {
        for(int i = 0; i < getNumRows(); i++) {
            for(int j = 0; j < getNumColumns(); j++) {
                if (whatsAtPos(new BoardPosition(i,j))==' ') {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * @param lastPos is a argument contains row and column
     * @param player who are making the marker 'O' or 'X'
     * @return checks to see if the last marker placed resulted in 5 same markers in a row horizontally. Returns true if it does, otherwise false
     * @requires player who make the marker
     */
    default boolean checkHorizontalWin(BoardPosition lastPos, char player) {
        player = whatsAtPos(lastPos);

        int rows = getNumRows();
        int cols = getNumColumns();
        int drow = lastPos.getRow();
        int dcol = lastPos.getColumn();
        int count = 1;

        if(isPlayerAtPos(lastPos,player)) {
            for (int i = 0; i < dcol; i++) {
                if( whatsAtPos(new BoardPosition(drow,dcol - i -1)) != player){
                        break;
                    }
                if (whatsAtPos(new BoardPosition(drow,dcol - i - 1)) == player) {
                    count++;
                }
            }
            if(count == getNumToWin()) {
                return true;
            }
            for(int j = 0; j <cols - dcol - 1; j++) {
                if(whatsAtPos(new BoardPosition(drow, dcol + j +1)) != player) {
                    break;
                }
                if(whatsAtPos(new BoardPosition(drow, dcol + j +1)) == player) {
                    count++;
                }
            }
            if(count == getNumToWin()) {
                return true;
            }
        }
        return false;
    }


    /**
     *
     * @param lastPos contains row and column
     * @param player  who are making the marker 'O' or 'X'
     * @return checks to see if the last marker placed resulted in 5 same markers in a row vertically.
     * Returns true if it does, otherwise false
     */
    default boolean checkVerticalWin(BoardPosition lastPos, char player) {
        player = whatsAtPos(lastPos);
        int count = 1;
        int rows = getNumRows();
        int cols = getNumColumns();
        int drow = lastPos.getRow();
        int dcol = lastPos.getColumn();
        if (isPlayerAtPos(lastPos, player)) {
            for (int i = 0; i < drow; i++) {
                if (whatsAtPos(new BoardPosition(drow - i - 1, dcol)) != player) {
                    break;
                }
                if (whatsAtPos(new BoardPosition(drow - i - 1, dcol)) == player) {
                    count++;
                }
            }
            if (count == getNumToWin()) {
                return true;
            }

            for (int j = 0; j < rows - drow - 1; j++) {
                if (whatsAtPos(new BoardPosition(drow + j + 1, dcol)) != player) {
                    break;
                }
                if (whatsAtPos(new BoardPosition(drow + j +1, dcol)) == player) {
                    count++;
                }
            }

            if (count == getNumToWin()) {
                return true;
            }
        }
        return false;
    }



    /**
     * @param lastPos is a argument
     * @return checks to see if the last marker placed resulted in 5 in a row diagonally. Returns true if it does, otherwise false
     * @requires player who make the marker
     */
    default boolean checkDiagonalWin(BoardPosition lastPos, char player) {
        player = whatsAtPos(lastPos);
        int rows = getNumRows();
        int cols = getNumColumns();
        int drow = lastPos.getRow();
        int dcol = lastPos.getColumn();

        if (isPlayerAtPos(lastPos, player)) {
            int count1 = 1;
            int count2 = 1;

            //first 2 for loops check the diagonal from left top to right bottom
            for (int i = 0; i < drow ; i++) {
                if (((dcol - i - 1) >= 0) && (whatsAtPos(new BoardPosition(drow - i - 1, dcol - i - 1)) == player)) {
                    count1++;

                } else {
                    break;
                }
            }
            for (int i = 0; i < rows - drow - 1; i++) {
                if (((dcol + i + 1) < cols) && whatsAtPos(new BoardPosition(drow + i + 1, dcol + i + 1)) == player) {
                    count2++;
                } else {
                    break;
                }
            }
            int counttol = count1 + count2 -1;
            if (counttol == getNumToWin()) {
                return true;
            }

            int c1 = 1;
            int c2 = 1;

            //in if codition, two loops count the winner from left bottom to top right
            if((drow  >=0) &&(drow  < rows) && (dcol >= 0)&&(dcol < cols )) {

                for(int i = 0; i <rows ; i++) {

                    if((dcol + i + 1  < cols)&&(drow - i -1) >=0 &&( whatsAtPos(new BoardPosition(drow - i -1 , dcol + i + 1  )) == player)) {
                        c1++;
                    }
                }

                for(int j = 0; j < cols; j++ ) {
                    if((((drow + j + 1) <rows) && ((dcol - j - 1) >=0) && (whatsAtPos(new BoardPosition(drow + j + 1 , dcol - j - 1  )) == player) )) {
                        c2++;
                    }
                }
            }
            int countto = c1 + c2 -1;

            if (countto == getNumToWin()) {
                return true;
            }
        }
        return false;
    }




    /**
     * @param pos is a position on the board
     * @return what is in the GameBoard at position pos,no marker is there it returns a blank space char ‘ ‘
     * @requires the GameBoard have position,
     */
    public char whatsAtPos(BoardPosition pos);

    /**
     *
     * @param pos
     * @param player
     * @return  returns true if the player is at position pos
     */
    default boolean isPlayerAtPos(BoardPosition pos, char player) {

        return (whatsAtPos(pos) != ' ') && (player != ' ');

    }
}
