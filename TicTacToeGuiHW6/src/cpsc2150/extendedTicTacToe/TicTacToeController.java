package cpsc2150.extendedTicTacToe;
import java.util. *;

/**
 * The TicTacToe controller class will handle communication between our TicTacToeView and our Model (IGameBoard and BoardPosition)
 *
 * You will need to include your BoardPosition class, the IGameBoard interface
 * and the implementations from previous homeworks
 */
public class TicTacToeController{
    //our current game that is being played
    private IGameBoard curGame;

    //The screen that provides our view
    private TicTacToeView screen;
    private int change_player;

    public static final int MAX_PLAYERS = 10;
    private int num_player;
    private BoardPosition bp;
    private int count = 0;
    private List<Character> player = new ArrayList<>();
    private boolean flag = false;


    /**
     *
     * @param model the board implementation
     * @param view the screen that is shown
     * @param np The number of players for the game
     * @post the controller will respond to action on the view using the model.
     */
    TicTacToeController(IGameBoard model, TicTacToeView view, int np){
        this.curGame = model;
        this.screen = view;
        this.num_player = np;

    }

    /**
     *
     * @param row the row of the activated button
     * @param col the column of the activated button
     * @pre row and col are in the bounds of the game represented by the view
     * @post The button pressed will show the right token and check if a player has won.
     */
    public void processButtonClick(int row, int col) {


        // adding 10 markers in the arraylist
        player.add('X');
        player.add('L');
        player.add('E');
        player.add('V');
        player.add('K');
        player.add('R');
        player.add('Z');
        player.add('B');
        player.add('H');
        player.add('O');

        if(!flag) {
                bp = new BoardPosition(row,col);

            if(curGame.checkSpace(bp)) {

                //player from index 0-9
                change_player = count % num_player;

                screen.setMessage("It is " + player.get((count+1) % num_player) + "\'s turn. ");
                curGame.placeMarker(bp, player.get(change_player));

                screen.setMarker(row, col, player.get(change_player));
                //index++
                count++;



            } else {
              screen.setMessage("Space already taken.");
         }

            if(curGame.checkForWinner(bp))
            {
                screen.setMessage("Player " + player.get(change_player) + " wins.");
                flag = true;
            }
            else if(curGame.checkForDraw())
            {
                screen.setMessage("Game ended with a draw");
                flag = true;
            }


        }else
        newGame();
}


    private void newGame()
    {
        screen.dispose();
        GameSetupScreen screen = new GameSetupScreen();
        GameSetupController controller = new GameSetupController(screen);
        screen.registerObserver(controller);
    }
}
