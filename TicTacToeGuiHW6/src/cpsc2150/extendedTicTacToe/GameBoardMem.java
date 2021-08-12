package cpsc2150.extendedTicTacToe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.*;

/**
 *
 * @require A constructor with no parameters
 * @inviriant MIN_ROW <= row < MAX_ROW
 * @Inviriant MIN_COL <= col < MAX_COL
 * @Inviriant WIN_MIN <= win_num <= WIN_MAX
 * correspondence num_row = row
 * correspondence num_col = col
 * correspondence win_num = this.win_num
 * correspondence map = this.map
 * This class contains actual game board that would implement efficient. The board used hashmap to put the character as
 * a key List which has a datatype called BoardPosition.
 */

public class GameBoardMem extends AbsGameBoard implements IGameBoard  {


    private int row;
    private int col;
    private int win;


    private Map<Character,List<BoardPosition>> myMap;


    /**
     * @param row     the number of row created by player
     * @param col     the number of column created by player
     * @param win the number of markers in a row needed to win for the game created by player
     * @requires MIN_ROW<= row < MAX_ROW and MIN_COL < = col < MAX_COL and WIN_MIN < = win_num < = WIN_MAX
     */
    public GameBoardMem(int row, int col, int win) {
        this.row = row;
        this.col = col;
        this.win = win;
        myMap = new HashMap<> ();
    }

    /**
     *
     *
     * @return the number of rows in the GameBoard
     */
    public int getNumRows() {
        return row;
    }


    /**
     *
     * @return  the number of columns in the GameBoard
     */
    public int getNumColumns() {
        return col;
    }


    /**
     *
     * @return the number of tokens in a row needed to win the game
     */
    public int getNumToWin() {
        return win;
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

        if(myMap.containsKey(player)) {
            myMap.get(player).add(marker);

        } else{

            ArrayList<BoardPosition> bp = new ArrayList<>();
            bp.add(marker);
            myMap.put(player, bp);
        }
    }


    /**
     * @param pos is a position on the board
     * @return what is in the GameBoard at position pos,no marker is there it returns a blank space char ‘ ‘
     * @requires the GameBoard have position,
     */
    public char whatsAtPos(BoardPosition pos) {

        for(Map.Entry<Character, List<BoardPosition>> m: myMap.entrySet()) {
            if (m.getValue().contains(pos)) {
                return m.getKey();
            }
        }
        return ' ';
    }

    /**
     *
     * @param pos the position with letters
     * @param player letter has been markered
     * @return  returns true if the player is at position pos
     * note: this is a override method
     */
    public boolean isPlayerAtPos(BoardPosition pos, char player) {
        if(myMap.containsKey(whatsAtPos(pos)))
           return true;
        else
        return false;
    }
}
