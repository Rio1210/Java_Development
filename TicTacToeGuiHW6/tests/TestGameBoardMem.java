import cpsc2150.extendedTicTacToe.BoardPosition;
import cpsc2150.extendedTicTacToe.GameBoard;
import cpsc2150.extendedTicTacToe.GameBoardMem;
import cpsc2150.extendedTicTacToe.IGameBoard;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestGameBoardMem {

    private int MIN = 3;
    private int MAX = 100;
    private int WIN_MAX = 25;
    private int WIN_MIN = 3;

    private IGameBoard Game(int row, int col, int win) {

        return new GameBoardMem(row, col, win);
    }


    @Test
    //1.constructor min board screen[boundary left]
    public void test_con_MIN() {

        IGameBoard bp = new GameBoard(MIN, MIN, WIN_MIN);
        String s = "    ";
        for (int number = 0; number < MIN; number++) {

            s += " " + number + "|";
        }
        s += "\n";

        for (int i = 0; i < MIN; i++) {

            s = s + "  " + i + "|";
            for (int j = 0; j < MIN; j++) {

                s += "  " + "|";
            }
            s += "\n";
        }
        assertEquals(bp.toString(), s);
    }


    @Test
    //2.constructor min board screen[boundary left]
    public void test_con_MAX() {

        IGameBoard bp = new GameBoard(MAX, MAX, WIN_MAX);
        String s = "    ";
        for (int number = 0; number < MAX; number++) {
            if (number < 10) {
                s += " " + number + "|";

            } else {
                s += number + "|";
            }
        }
        s += "\n";

        for (int i = 0; i < MAX; i++) {

            if (i < 10) {
                s = s + "  " + i + "|";
            } else {
                s = s + " " + i + "|";
            }
            for (int j = 0; j < MAX; j++) {

                s += "  " + "|";
            }
            s += "\n";
        }

        assertEquals(bp.toString(), s);
    }


    @Test
    //3.constructor min board screen middle
    public void test_con_MIDDLE() {
        int row = 50;
        int col = 50;


        IGameBoard bp = new GameBoard(row, col, WIN_MIN);
        String s = "    ";
        for (int number = 0; number < 50; number++) {

            if (number < 10) {
                s += " " + number + "|";
            } else {
                s += number + "|";
            }
        }
        s += "\n";

        for (int i = 0; i < 50; i++) {

            if (i < 10) {
                s = s + "  " + i + "|";
            } else {
                s = s + " " + i + "|";
            }

            for (int j = 0; j < 50; j++) {

                s += "  " + "|";
            }
            s += "\n";
        }

        assertEquals(bp.toString(), s);
    }


    @Test //1.check space without no marker
    public void testRate_checkspace_left_boundary() {

        int row = 10;
        int col = 10;
        int win = 10;

        IGameBoard bp = Game(row, col, win);

        String s = "    ";
        for (int number = 0; number < row; number++) {

            s += " " + number + "|";
        }
        s += "\n";

        for (int i = 0; i < row; i++) {

            s = s + "  " + i + "|";
            for (int j = 0; j < col; j++) {

                s += "  " + "|";
            }
            s += "\n";
        }
        assertEquals(bp.toString(), s);
    }


    @Test //2. check space with no marker
    public void testRate_checkspace_right_boundary() {

        int row = 100;
        int col = 100;
        int win = 25;

        IGameBoard bp = Game(row, col, win);

        String s = "    ";
        for (int number = 0; number < row; number++) {
            if (number < 10) {
                s += " " + number + "|";
            } else {
                s += number + "|";
            }
        }
        s += "\n";
        for (int i = 0; i < row; i++) {
            if (i < 10) {
                s = s + "  " + i + "|";
            } else {
                s = s + " " + i + "|";
            }
            for (int j = 0; j < col; j++) {

                s += " " + " " + "|";
            }
            s += "\n";
        }

        assertEquals(bp.toString(), s);
    }


    @Test
    //3.place 'X' in this position, checkspace should be false
    public void test_checkspace() {

        int row = 3;
        int col = 3;
        int win = 3;

        IGameBoard bp = Game(row, col, win);

        BoardPosition pos = new BoardPosition(2, 2);

        bp.placeMarker(pos, 'X');

        assertEquals(bp.checkSpace(pos), false);

    }


    @Test //1.place marker on the lest bountary
    public void test_MINscreen_placemarker_leftup() {

        IGameBoard bp = Game(MIN, MIN, WIN_MIN);

        String s = "    ";
        for (int number = 0; number < MIN; number++) {

            s += " " + number + "|";
        }
        s += "\n";

        for (int i = 0; i < MIN; i++) {
            s = s + "  " + i + "|";
            for (int j = 0; j < MIN; j++) {
                if (j == 0 && i == 0) {
                    s += " X" + "|";
                } else {
                    s += "  " + "|";
                }
            }
            s += "\n";
        }


        BoardPosition pos = new BoardPosition(0, 0);

        bp.placeMarker(pos, 'X');

        assertEquals(bp.toString(), s);
    }


    @Test //2.place marker on the right bountary
    public void test_MAXscreen_placemarker_rightdown() {

        IGameBoard bp = Game(MAX, MAX, WIN_MAX);

        BoardPosition pos = new BoardPosition(99, 99);
        bp.placeMarker(pos, 'Q');

        String s = "    ";
        for (int number = 0; number < MAX; number++) {
            if (number < 10) {
                s += " " + number + "|";

            } else {
                s += number + "|";
            }
        }
        s += "\n";

        for (int i = 0; i < MAX; i++) {
            if (i < 10) {
                s = s + "  " + i + "|";
            } else {
                s = s + " " + i + "|";
            }
            for (int j = 0; j < MAX; j++) {
                if ((i == 99) && (j == 99)) {
                    s += " Q" + '|';
                } else {
                    s += "  " + "|";
                }
            }
            s += "\n";
        }
        assertEquals(bp.toString(), s);
    }

    @Test //3. place marker in the middle
    public void test_MINscreen_placemarker_MIDDLE() {

        IGameBoard bp = Game(MIN, MIN, WIN_MIN);

        BoardPosition pos = new BoardPosition(1, 1);

        bp.placeMarker(pos, 'A');

        String s = "    ";
        for (int number = 0; number < MIN; number++) {

            s += " " + number + "|";
        }
        s += "\n";

        for (int i = 0; i < MIN; i++) {
            s = s + "  " + i + "|";
            for (int j = 0; j < MIN; j++) {
                if (j == 1 && i == 1) {
                    s += " A" + "|";
                } else {
                    s += "  " + "|";
                }
            }
            s += "\n";
        }

        assertEquals(bp.toString(), s);
    }


    @Test  //4.place marker on the top [up boundary
    public void test_MIDDLE_screen_placemarker_left() {

        IGameBoard bp = Game(25, 25, 25);


        BoardPosition pos = new BoardPosition(0, 2);

        bp.placeMarker(pos, 'O');
        String s = "    ";
        for (int number = 0; number < 25; number++) {
            if (number < 10) {
                s += " " + number + "|";
            } else {
                s += number + "|";
            }
        }
        s += "\n";
        for (int i = 0; i < 25; i++) {

            if (i < 10) {
                s = s + "  " + i + "|";
            } else {
                s = s + " " + i + "|";
            }
            for (int j = 0; j < 25; j++) {
                if (j == 2 && i == 0) {
                    s += " O" + "|";
                } else {
                    s += "  " + "|";
                }
            }
            s += "\n";
        }

        assertEquals(bp.toString(), s);
    }


    @Test //5.place marker in the middle of screen
    public void test_MIIDDLE_screen_placemarker_middle() {
        int row = 50;
        int col = 50;
        int win = 50;

        IGameBoard bp = Game(row, col, win);

        BoardPosition pos = new BoardPosition(30, 30);

        bp.placeMarker(pos, 'W');
        String s = "    ";
        for (int number = 0; number < row; number++) {
            if (number < 10) {
                s += " " + number + "|";

            } else {
                s += number + "|";
            }
        }
        s += "\n";

        for (int i = 0; i < row; i++) {
            if (i < 10) {
                s = s + "  " + i + "|";
            } else {
                s = s + " " + i + "|";
            }
            for (int j = 0; j < col; j++) {
                if ((i == pos.getRow()) && (j == pos.getColumn())) {
                    s += " W" + '|';
                } else {
                    s += "  " + "|";
                }
            }
            s += "\n";
        }

        assertEquals(bp.toString(), s);
    }


    @Test  //6.place marker on the right [right bountary
    public void test_Middle_screen_placemarker_right() {

        int row = 50;
        int col = 50;
        int win = 50;

        IGameBoard bp = Game(row, col, win);

        BoardPosition pos = new BoardPosition(40, 49);

        bp.placeMarker(pos, 'L');

        String s = "    ";
        for (int number = 0; number < row; number++) {
            if (number < 10) {
                s += " " + number + "|";

            } else {
                s += number + "|";
            }
        }
        s += "\n";

        for (int i = 0; i < row; i++) {
            if (i < 10) {
                s = s + "  " + i + "|";
            } else {
                s = s + " " + i + "|";
            }
            for (int j = 0; j < col; j++) {
                if ((i == pos.getRow()) && (j == pos.getColumn())) {
                    s += " L" + '|';
                } else {
                    s += "  " + "|";
                }
            }
            s += "\n";
        }

        assertEquals(bp.toString(), s);
    }


    @Test //7.place marker in the bottom of screen
    public void test_MIDDLE_screen_placemarker_middle() {

        IGameBoard bp = Game(MAX, 50, WIN_MAX);

        BoardPosition pos = new BoardPosition(99, 20);

        bp.placeMarker(pos, 'Z');
        String s = "    ";
        for (int number = 0; number < 50; number++) {
            if (number < 10) {
                s += " " + number + "|";

            } else {
                s += number + "|";
            }
        }
        s += "\n";

        for (int i = 0; i < MAX; i++) {
            if (i < 10) {
                s = s + "  " + i + "|";
            } else {
                s = s + " " + i + "|";
            }
            for (int j = 0; j < 50; j++) {
                if ((i == pos.getRow()) && (j == pos.getColumn())) {
                    s += " Z" + '|';
                } else {
                    s += "  " + "|";
                }
            }
            s += "\n";
        }
        assertEquals(bp.toString(), s);
    }

    @Test //8.place marker on the left bottom bountary
    public void test_MINscreen_placemarker_leftdown () {

        IGameBoard bp = Game( MIN, MIN, WIN_MIN );

        String s = "    ";
        for(int number = 0; number < MIN; number++) {

            s += " " +  number + "|";
        }
        s += "\n";

        for(int i = 0; i< MIN; i++) {
            s = s + "  " + i + "|";
            for (int j = 0; j < MIN; j++) {
                if(j==0 && i==2) {
                    s += " X" +  "|";
                }else {
                    s += "  " + "|";
                }
            }
            s += "\n";
        }


        BoardPosition pos = new BoardPosition(2 ,0);

        bp.placeMarker(pos, 'X');

        assertEquals(bp.toString(), s);
    }




    @Test // win top Horizontal [boundary
    public void test_top_Horizontal_last_marker_left() {
        IGameBoard bp = Game(MIN, MIN, WIN_MIN);

        BoardPosition pos = new BoardPosition(0, 0);

        bp.placeMarker(pos, 'X');
        bp.placeMarker(new BoardPosition(0, 1), 'X');
        bp.placeMarker(new BoardPosition(0, 2), 'X');

        assertEquals(bp.checkHorizontalWin(pos, 'X'), true);

    }

    @Test   //win lest
    public void test_CheckHorizWin_win_last_marker_right() {
        IGameBoard bp = Game(MIN, MIN, WIN_MIN);

        BoardPosition pos = new BoardPosition(0, 0);

        bp.placeMarker(pos, 'X');
        bp.placeMarker(new BoardPosition(1, 1), 'O');
        bp.placeMarker(new BoardPosition(1, 2), 'O');
        bp.placeMarker(new BoardPosition(0, 1), 'X');
        bp.placeMarker(new BoardPosition(0, 2), 'X');

        assertEquals(bp.checkHorizontalWin(new BoardPosition(0, 2), 'X'), true);


    }


    @Test   //ensure it can count left and right
    public void test_CheckHorizWin_win_last_marker_middle() {
        int row = 5;
        int col = 5;
        int win = 4;

        IGameBoard bp = Game(row, col, win);

        BoardPosition pos = new BoardPosition(3, 3);

        bp.placeMarker(pos, 'X');
        bp.placeMarker(new BoardPosition(3, 1), 'O');
        bp.placeMarker(new BoardPosition(3, 0), 'O');
        bp.placeMarker(new BoardPosition(3, 2), 'O');
        bp.placeMarker(new BoardPosition(2, 0), 'X');
        bp.placeMarker(new BoardPosition(2, 1), 'X');
        bp.placeMarker(new BoardPosition(2, 3), 'X');
        BoardPosition middle = new BoardPosition(2, 2);
        bp.placeMarker(middle, 'X');

        assertEquals(bp.checkHorizontalWin(middle, 'X'), true);

    }


    @Test  //boundary
    public void test_CheckHorizWin_Max_win_last_marker_right_bottom() {
        int row = 25;
        int col = 25;

        IGameBoard bp = Game(row, col, WIN_MAX);

        BoardPosition pos = new BoardPosition(24, 24);// = new BoardPosition(3 ,3);

        for (int i = 0; i < col; i++) {
            pos = new BoardPosition(24, i);
            bp.placeMarker(pos, 'Q');
        }
        assertEquals(bp.checkHorizontalWin(pos, 'X'), true);

    }

    @Test  //boundary
    public void test_CheckHorizWin_Max_SIZE_last_marker_left_bottom() {

        IGameBoard screen = Game(MAX, MAX, WIN_MAX);

        BoardPosition pos = new BoardPosition(99, 99);// = new BoardPosition(3 ,3);

        for (int i = 99; i >= MAX - WIN_MAX; i--) {
            pos = new BoardPosition(99, i);
            screen.placeMarker(pos, 'Q');
        }
        assertEquals(screen.checkHorizontalWin(pos, 'Q'), true);

    }


    @Test // win left corner [boundary
    public void test_top_Vertical_last_marker_top() {
        IGameBoard screen = Game(MIN, MIN, WIN_MIN);

        BoardPosition pos = new BoardPosition(0, 0);

        screen.placeMarker(pos, 'X');
        screen.placeMarker(new BoardPosition(1, 0), 'X');
        screen.placeMarker(new BoardPosition(2, 0), 'X');

        assertEquals(screen.checkVerticalWin(pos, 'X'), true);

    }

    @Test   //win lest
    public void test_CheckVerticalWin_win_last_marker_down() {
        IGameBoard screen = Game(MIN, MIN, WIN_MIN);

        BoardPosition pos = new BoardPosition(2, 2);

        screen.placeMarker(pos, 'X');
        screen.placeMarker(new BoardPosition(1, 1), 'O');
        screen.placeMarker(new BoardPosition(1, 2), 'X');
        screen.placeMarker(new BoardPosition(0, 2), 'X');


        assertEquals(screen.checkVerticalWin(pos, 'X'), true);


    }


    @Test   //ensure it can count left and right
    public void test_CheckVerticalWin_win_last_marker_middle() {
        int row = 5;
        int col = 5;
        int win = 4;

        IGameBoard screen = Game(row, col, win);

        BoardPosition pos = new BoardPosition(3, 3);

        screen.placeMarker(pos, 'X');
        screen.placeMarker(new BoardPosition(1, 3), 'O');
        screen.placeMarker(new BoardPosition(2, 3), 'O');
        screen.placeMarker(new BoardPosition(3, 3), 'O');
        screen.placeMarker(new BoardPosition(0, 2), 'X');
        screen.placeMarker(new BoardPosition(1, 2), 'X');
        screen.placeMarker(new BoardPosition(3, 2), 'X');
        BoardPosition middle = new BoardPosition(2, 2);
        screen.placeMarker(middle, 'X');

        assertEquals(screen.checkVerticalWin(middle, 'X'), true);

    }


    @Test  //boundary
    public void test_CheckVerticalWin_Max_win_last_marker_right_bottom() {
        int row = 25;
        int col = 25;

        IGameBoard screen = Game(row, col, WIN_MAX);

        BoardPosition pos = new BoardPosition(24, 24);// = new BoardPosition(3 ,3);

        for (int i = 0; i < row; i++) {
            pos = new BoardPosition(i, 24);
            screen.placeMarker(pos, 'Q');
        }
        assertEquals(screen.checkVerticalWin(pos, 'X'), true);

    }

    @Test  //boundary
    public void test_CheckVerticalWin_Max_SIZE_last_marker_left_bottom() {

        IGameBoard screen = Game(MAX, MAX, WIN_MAX);

        BoardPosition pos = new BoardPosition(99, 99);// = new BoardPosition(3 ,3);

        for (int i = 99; i >= MAX - WIN_MAX; i--) {
            pos = new BoardPosition(i, 99);
            screen.placeMarker(pos, 'Q');
        }
        assertEquals(screen.checkVerticalWin(pos, 'Q'), true);

    }


    @Test // Draw with X and Q
    public void test_checkforDraw_MIN_SIZE() {
        IGameBoard screen = Game(MIN, MIN, WIN_MIN);
        screen.placeMarker(new BoardPosition(0, 0), 'X');
        screen.placeMarker(new BoardPosition(1, 1), 'X');
        screen.placeMarker(new BoardPosition(2, 2), 'X');
        screen.placeMarker(new BoardPosition(0, 1), 'Q');
        screen.placeMarker(new BoardPosition(0, 2), 'Q');
        screen.placeMarker(new BoardPosition(1, 2), 'Q');
        screen.placeMarker(new BoardPosition(1, 0), 'Q');
        screen.placeMarker(new BoardPosition(2, 0), 'Q');
        screen.placeMarker(new BoardPosition(2, 1), 'X');

        assertEquals(screen.checkForDraw(), true);
    }


    @Test // Draw with  letters
    public void test_checkforDraw_MIN_SIZE_multi_markers() {
        IGameBoard screen = Game(MIN, MIN, WIN_MIN);
        screen.placeMarker(new BoardPosition(0, 0), 'X');
        screen.placeMarker(new BoardPosition(0, 1), 'A');
        screen.placeMarker(new BoardPosition(0, 2), 'Q');
        screen.placeMarker(new BoardPosition(1, 1), 'X');
        screen.placeMarker(new BoardPosition(1, 2), 'W');
        screen.placeMarker(new BoardPosition(1, 0), 'T');
        screen.placeMarker(new BoardPosition(2, 0), 'Q');
        screen.placeMarker(new BoardPosition(2, 1), 'U');
        screen.placeMarker(new BoardPosition(2, 2), 'B');

        assertEquals(screen.checkForDraw(), true);
    }


    @Test // Draw with  letters
    public void test_checkforDraw_MIDDLE_multi_markers() {
        IGameBoard screen = Game(25, 25, WIN_MAX);


        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                screen.placeMarker(new BoardPosition(i, j), 'X');
            }
        }

        assertEquals(screen.checkForDraw(), true);
    }


    @Test // Draw with  letters
    public void test_checkforDraw_MAXSIZE_multi_markers() {
        IGameBoard screen = Game(MAX, MAX, WIN_MAX);

        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                screen.placeMarker(new BoardPosition(i, j), 'L');
            }
        }

        assertEquals(screen.checkForDraw(), true);
    }



    @Test // 1.win left corner [boundary
    public void test_checkDiagonal_MIN_last_marker_topleft() {
        IGameBoard screen = Game( MIN, MIN, WIN_MIN );

        BoardPosition pos = new BoardPosition(0 ,0);

        screen.placeMarker(pos, 'X');
        screen.placeMarker(new BoardPosition(1,1), 'X');
        screen.placeMarker(new BoardPosition(2,2), 'X');

        assertEquals(screen.checkDiagonalWin(pos,'X'), true);

    }


    @Test // 2.win middle
    public void test_checkDiagonal_MIN_last_marker_middlem() {
        IGameBoard screen = Game( MIN, MIN, WIN_MIN );

        BoardPosition pos = new BoardPosition(1 ,1);

        screen.placeMarker(pos, 'X');
        screen.placeMarker(new BoardPosition(2,2), 'X');
        screen.placeMarker(new BoardPosition(0,0), 'X');

        assertEquals(screen.checkDiagonalWin(pos,'X'), true);

    }

    @Test // 3.win right corner [boundary
    public void test_checkDiagonal_MIN_last_marker_righttop() {
        IGameBoard screen = Game( MIN, MIN, WIN_MIN );

        BoardPosition pos = new BoardPosition(0 ,2);

        screen.placeMarker(pos, 'X');
        screen.placeMarker(new BoardPosition(1,1), 'X');
        screen.placeMarker(new BoardPosition(2,0), 'X');

        assertEquals(screen.checkDiagonalWin(pos,'X'), true);

    }

    @Test  //4.lefttop to rightdown last position in the middle
    public void test_checkDiagonal_MAXSIZE_MIDDLE_marker() {
        IGameBoard screen = Game(MAX, MAX, WIN_MAX );

        BoardPosition pos = new BoardPosition(50 ,50);

        for(int i = 40; i < pos.getRow(); i++) {
            screen.placeMarker(new BoardPosition(i,i), 'A');
        }
        for(int i = pos.getRow(); i < 65; i++) {
            screen.placeMarker(new BoardPosition(i,i), 'A');
        }

        assertEquals(screen.checkDiagonalWin(pos, 'A'),true);

    }


    @Test  //5.leftdown to righttop last position in the middle
    public void test_checkDiagonal_MAXSIZE_MIDDLE_marker_left_to_right() {
        IGameBoard screen = Game(MAX, MAX, WIN_MAX );

        BoardPosition pos = new BoardPosition(15 ,10);

        for(int i = 0; i < 25; i++) {
            screen.placeMarker(new BoardPosition(25 - i, i ), 'A');
        }

        assertEquals(screen.checkDiagonalWin(pos, 'A'),true);

    }


    @Test  //6.leftdown to righttop last position on the left down  [boundary
    public void test_checkDiagonal_MAXSIZE_midd_last_marker_left_to_right() {
        IGameBoard screen = Game(MAX, MAX, WIN_MAX );

        BoardPosition pos = new BoardPosition(25 ,0);

        for(int i = 0; i < 25; i++) {
            screen.placeMarker(new BoardPosition(25 - i, i ), 'X');
        }

        assertEquals(screen.checkDiagonalWin(pos, 'X'),true);

    }


    @Test  //7.leftdown to righttop last position on the top right  [boundary
    public void test_checkDiagonal_MAXSIZE_midd_last_marker_righttop() {
        IGameBoard screen = Game(MAX, MAX, WIN_MAX );
        BoardPosition pos = new BoardPosition(0 ,25);

        for(int i = 1; i <= 25; i++) {
            screen.placeMarker(new BoardPosition(25 - i, i ), 'A');
        }

        assertEquals(screen.checkDiagonalWin(pos, 'O'),true);

    }

    @Test  //8.leftdown to righttop last position on the top right with 'x' and 'O' multi letter test
    public void test_checkDiagonal_MAXSIZE_multi_letters_last_marker_righttop() {
        IGameBoard screen = Game(MAX, MAX, WIN_MAX );
        BoardPosition pos = new BoardPosition(1 ,24);
        for(int i = 0; i< 25; i++) {
            screen.placeMarker(new BoardPosition(i,i + 1),'Y');
        }

        for(int i = 0; i < 25; i++) {
            screen.placeMarker(new BoardPosition(25 - i, i ), 'A');
        }

        assertEquals(screen.checkDiagonalWin(pos, 'A'),true);

    }


    @Test  //1.place the marker at left top, and check whatatpos[boundary
    public void test_whatAtPos_letter_at_lefttop_MINSIZE() {
        IGameBoard screen = Game(MIN,MIN,WIN_MAX);
        BoardPosition pos = new BoardPosition(0,0);
        screen.placeMarker(pos,'A');
        screen.whatsAtPos(pos);

        String s = "    ";
        for(int number = 0; number < MIN; number++) {

            s += " " +  number + "|";
        }
        s += "\n";

        for(int i = 0; i< MIN; i++) {
            s = s + "  " + i + "|";
            for (int j = 0; j < MIN; j++) {
                if(j==0 && i==0) {
                    s += " A" +  "|";
                }else {
                    s += "  " + "|";
                }
            }
            s += "\n";
        }

        assertEquals(screen.toString(), s);

    }

    @Test  //2.place the marker at left top, and check whatatpos[ boundary
    public void test_whatAtPos_letter_at_lefttop_MAXSIZE() {
        IGameBoard screen = Game(MAX,MAX,WIN_MAX);
        BoardPosition pos = new BoardPosition(99,99);
        screen.placeMarker(pos,'O');
        screen.whatsAtPos(pos);

        String s = "    ";
        for(int number = 0; number < MAX; number++) {
            if(number < 10) {
                s += " " +  number + "|";

            }else {
                s +=  number + "|";
            }
        }
        s += "\n";

        for(int i = 0; i< MAX; i++) {
            if(i < 10) {
                s = s +  "  " + i + "|";
            }else {
                s = s + " " + i + "|";
            }
            for (int j = 0; j < MAX; j++) {
                if((i==99)&&(j == 99)) {
                    s+= " O" + '|';
                }else {
                    s += "  " + "|";
                }
            }
            s += "\n";
        }
        assertEquals(screen.toString(), s);


    }

    @Test  //3.lace the marker at LEFT bottom, and check whatatpos[ bountary
    public void test_whatAtPos_letter_at_LEFTbottom_MINSIZE() {
        IGameBoard screen = Game(MIN,MIN,WIN_MAX);
        BoardPosition pos = new BoardPosition(2,0);
        screen.placeMarker(pos,'Z');
        screen.whatsAtPos(pos);

        String s = "    ";
        for(int number = 0; number < MIN; number++) {

            s += " " +  number + "|";
        }
        s += "\n";

        for(int i = 0; i< MIN; i++) {
            s = s + "  " + i + "|";
            for (int j = 0; j < MIN; j++) {
                if(j==0 && i==2) {
                    s += " Z" +  "|";
                }else {
                    s += "  " + "|";
                }
            }
            s += "\n";
        }

        assertEquals(screen.toString(), s);


    }

    @Test  //4.place the marker at  bottom, and check whatatpos[ bountary
    public void test_whatAtPos_letter_at_bottom_MINSIZE() {
        IGameBoard screen = Game(MIN,MIN,WIN_MAX);
        BoardPosition pos = new BoardPosition(2,1);
        screen.placeMarker(pos,'Z');
        screen.whatsAtPos(pos);

        String s = "    ";
        for(int number = 0; number < MIN; number++) {

            s += " " +  number + "|";
        }
        s += "\n";

        for(int i = 0; i< MIN; i++) {
            s = s + "  " + i + "|";
            for (int j = 0; j < MIN; j++) {
                if(j==1 && i==2) {
                    s += " Z" +  "|";
                }else {
                    s += "  " + "|";
                }
            }
            s += "\n";
        }

        assertEquals(screen.toString(), s);
    }

    @Test  //5.place the marker at  bottom, and check whatatpos[ bountary
    public void test_whatAtPos_letter_at_top_MINSIZE() {
        IGameBoard screen = Game(MIN,MIN,WIN_MAX);
        BoardPosition pos = new BoardPosition(0,1);
        screen.placeMarker(pos,'Z');
        screen.whatsAtPos(pos);

        String s = "    ";
        for(int number = 0; number < MIN; number++) {

            s += " " +  number + "|";
        }
        s += "\n";

        for(int i = 0; i< MIN; i++) {
            s = s + "  " + i + "|";
            for (int j = 0; j < MIN; j++) {
                if(j==1 && i==0) {
                    s += " Z" +  "|";
                }else {
                    s += "  " + "|";
                }
            }
            s += "\n";
        }

        assertEquals(screen.toString(), s);
    }

    @Test  //6.place the marker at middle screen, and check whatatpos[ bountary
    public void test_whatAtPos_letter_at_middle_MAXSIZE() {
        IGameBoard screen = Game(MAX,MAX,WIN_MAX);
        BoardPosition pos = new BoardPosition(50,50);
        screen.placeMarker(pos,'Z');
        screen.whatsAtPos(pos);

        String s = "    ";
        for (int number = 0; number < MAX; number++) {
            if (number < 10) {
                s += " " + number + "|";

            } else {
                s += number + "|";
            }
        }
        s += "\n";

        for (int i = 0; i < MAX; i++) {

            if (i < 10) {
                s = s + "  " + i + "|";
            } else {
                s = s + " " + i + "|";
            }
            for (int j = 0; j < MAX; j++) {

                if(i==50 && j ==50) {
                    s += " Z" + "|";
                }else {
                    s += "  " + "|";

                }
            }
            s += "\n";
        }

        assertEquals(screen.toString(), s);
    }

    @Test  //7.place the marker at LEFT bottom, and check whatatpos[ bountary
    public void test_whatAtPos_letter_at_ttop_MINSIZE() {
        IGameBoard screen = Game(MIN,MIN,WIN_MAX);
        BoardPosition pos = new BoardPosition(0,1);
        screen.placeMarker(pos,'Z');
        screen.whatsAtPos(pos);

        String s = "    ";
        for(int number = 0; number < MIN; number++) {

            s += " " +  number + "|";
        }
        s += "\n";

        for(int i = 0; i< MIN; i++) {
            s = s + "  " + i + "|";
            for (int j = 0; j < MIN; j++) {
                if(j==1 && i==0) {
                    s += " Z" +  "|";
                }else {
                    s += "  " + "|";
                }
            }
            s += "\n";
        }

        assertEquals(screen.toString(), s);
    }






}
