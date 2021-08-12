package cpsc2150.extendedTicTacToe;//contract
/**
 *
 * @require A constructor with 3 parameters
 * @inviriant MIN_ROW <= row < MAX_ROW
 * @Inviriant MIN_COL <= col < MAX_COL
 * @Inviriant WIN_MIN <= win_num <= WIN_MAX
 * correspondence num_row = row
 * correspondence num_col = col
 * correspondence win_num = this.win_num
 * correspondence this = on_Board[0...num_row - 1 ][0...num_col - 1]
 * correspondence player = this.play
 * This class contains actual game board. The board is a 2-dimensional num_row * num_col array of characters.
 * Each position will have a single blank space character (“ “) until a player plays on that position.
 */
public class GameBoard extends AbsGameBoard implements IGameBoard {

    private int row;
    private int col;
    private int win_num;
    private char[][] on_Board;
    private char player;

    /**
     * @param row     the number of row created by player
     * @param col     the number of column created by player
     * @param win_num the number of markers in a row needed to win for the game created by player
     * @requires MIN_ROW<= row <= MAX_ROW and MIN_COL < = col <= MAX_COL and WIN_MIN < = win_num < = WIN_MAX
     * @ensure the MIX_SIZE, WIN_NUM are from the input from player, the gameboard 2d-array wiil be created with ' '
     */
    public GameBoard(int row, int col, int win_num) {
        this.row = row;
        this.col = col;
        this.win_num = win_num;

        on_Board = new char[this.row][this.col];
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                on_Board[i][j] = ' ';
            }
        }
    }


    /**
     * @return the number of rows in the GameBoard
     * @ensure getNumRows = row
     */
    public int getNumRows() {


        return this.row;
    }


    /**
     * @return the number of columns in the GameBoard
     * @ensure getNumColumns = col
     */
    public int getNumColumns() {

        return this.col;
    }


    /**
     * @return the number of tokens in a row needed to win the game
     * @ensure getNumToWin = win_num
     */
    public int getNumToWin() {

        return this.win_num;
    }



    /**
     * @param marker is a BoardPosition object argument contains the player
     * @param player uppercase letters would be printed in board
     * @require marker == ' '
     * @ensure places the character in marker on the position specified by marker,
     * and should not be called if the space is not available.
     * @pre board position is ' '
     * @post marker by player with uppercase letter
     */
    public void placeMarker(BoardPosition marker, char player) {

        for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {

            if (player == alphabet) {
                on_Board[marker.getRow()][marker.getColumn()] = alphabet;
            }
        }

    }

    /**
     * @param pos is a position on the board
     * @return what is in the GameBoard at position pos,no marker is there it returns a blank space char ‘ ‘
     * @requires the GameBoard have position,
     */
    public char whatsAtPos(BoardPosition pos) {
        return on_Board[pos.getRow()][pos.getColumn()];
    }




}





