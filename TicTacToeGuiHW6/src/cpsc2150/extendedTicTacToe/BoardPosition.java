package cpsc2150.extendedTicTacToe;

/**
 *
 * This class will be used to keep track of an individual cell for a board.
 * BoardPosition has variables to represent Row and column position. There is one constructor for the class,
 * which takes in an int for the Row position, and an int for the Column position
 *
 * @Invrariant MAX_ROW = 100 and MAX_COL = 100 and MIN_ROW = 0 and MAX_COL = 0
 * @Inviriant MIN_ROW <= row < MAX_ROWS and MIN_COL <= col < MAX_COL
 *
 */

public class BoardPosition {
    private int row;
    private int column;

    /**
     * @param r the row the position in the Board
     * @param col the column of the position in the Board
     * @require MIN_ROW <= row < MAX_ROWS and MIN_COL <= col < MAX_COL
     *
     *
     */
    public BoardPosition(int r, int col) {
        row = r;
        column = col;
    }

    /**
     *
     * @return the row of the BoardPosition
     * @ensure getRow = row
     */
    public int getRow() {
        return row;
    }


    /**
     *
     * @return the row of the BoardPosition
     * @ensure getColumn = col
     */
    public int getColumn() {
        return column;
    }


    /**
     *
     * @param obj is the object from outside
     * @return if the memory location is the same
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof BoardPosition))
            return false;
        else
        {
            BoardPosition board = (BoardPosition) obj;
            if (row == (board.row) && column == (board.column))
                return true;
        }
        return super.equals(obj);
    }


    /**
     * get row and col from the position and print out
     */
    public String toString() {
        String s = "[" + row + "," + column + "]";
        return s;

    }
}


