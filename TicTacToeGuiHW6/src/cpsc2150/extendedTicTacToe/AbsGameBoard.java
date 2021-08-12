package cpsc2150.extendedTicTacToe;

/**
 *
 * this AbsGameBoard class will have toString method which is implemented by calling getNumColumns method to get the
 * number of cols and getNumRows method to get the number of the cols and whatAtPos method to get position on board,
 * position is marked with letter or ' '
 */
abstract class AbsGameBoard implements IGameBoard{


    /**
     *
     * @require player will make the board
     * @return the gameboard with character ' ' or letters
     */
    public String toString() {
        String s = "    ";
        for(int number = 0; number < getNumColumns(); number++) {
            if(number < 10) {
                s += " " +  number + "|";
            }else {
                s += number + "|";
            }
        }
        s += "\n";
        for(int i = 0; i< getNumRows(); i++) {
            if(i < 10) {
                s = s +  "  " + i + "|";
            }else {
                s = s + " " + i + "|";
            }
            for (int j = 0; j < getNumColumns(); j++) {

              s += " " + whatsAtPos(new BoardPosition(i ,j)) + "|";
            }
            s += "\n";
        }
        return s;
    }



}
