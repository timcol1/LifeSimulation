package avlyakulov.timur.tic_tac;

import java.util.*;

public class Main {
    private static int ROW_COUNT = 3;
    private static int COL_COUNT = 3;
    private static String CELL_EMPTY = " ";
    private static String CELL_X = "X";
    private static String CELL_O = "O";

    private static String GAME_STATE_X_WON = "The player won";
    private static String GAME_STATE_O_WON = "The bot won";
    private static String GAME_STATE_DRAW = "Draw";
    private static String GAME_STATE_NOT_FINISHED = "The game isn't finished";

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        while (true) {
            startGameRound();
        }
    }

    public static void startGameRound() {
        System.out.println("The game is starting");
        String[][] board = createBoard();
        startGameLoop(board);
    }

    public static String[][] createBoard() {
        String[][] board = new String[ROW_COUNT][COL_COUNT];


        for (int row = 0; row < ROW_COUNT; ++row) {
            for (int col = 0; col < COL_COUNT; ++col) {
                board[row][col] = CELL_EMPTY;
            }
        }
        return board;
    }

    public static void startGameLoop(String[][] board) {
        boolean playerTurn = true;
        do {
            if (playerTurn) {
                makePlayerTurn(board);
                printBoard(board);
            } else {
                makeBotTurn(board);
                printBoard(board);
            }
            playerTurn = !playerTurn;

            String gameState = checkGameState(board);
            if (!gameState.equals(GAME_STATE_NOT_FINISHED)) {
                System.out.println(gameState);
                return;
            }
        } while (true);
    }

    public static void makePlayerTurn(String[][] board) {
        int[] coordinates = inputCellCoordinates(board);

        board[coordinates[0]][coordinates[1]] = CELL_X;
    }

    public static void makeBotTurn(String[][] board) {
        System.out.println("Bot turn");
        int[] coordinates = getEmptyRandomCellCoordinates(board);
        board[coordinates[0]][coordinates[1]] = CELL_O;
    }

    public static int[] getEmptyRandomCellCoordinates(String[][] board) {
        do {
            //проверка на пустое поле
            int row = random.nextInt(ROW_COUNT);
            int column = random.nextInt(COL_COUNT);
            if (board[row][column].equals(CELL_EMPTY)) {
                return new int[]{row, column};
            }
        } while (true);
    }

    public static int[] inputCellCoordinates(String[][] board) {
        System.out.println("Enter coordinate with space from (0,2):");
        do {
            //exit by return;
            String[] input = scanner.nextLine().split(" ");

            int row = Integer.parseInt(input[0]);
            int col = Integer.parseInt(input[1]);
            if ((row < 0) || (row >= ROW_COUNT) || (col < 0) || (col >= COL_COUNT)) {
                System.out.println("Incorrect value! Enter the value from 0 to 2 with space:");
            } else if (!Objects.equals(board[row][col], CELL_EMPTY)) {
                System.out.println("This cell is already busy");
            } else {
                return new int[]{row, col};
            }
        } while (true);
    }

    public static String checkGameState(String[][] board) {
        List<Integer> sums = new ArrayList<>();
        //iterate rows
        for (int row = 0; row < ROW_COUNT; row++) {
            int rowSum = 0;
            for (int col = 0; col < COL_COUNT; col++) {
                rowSum += calculateNumValue(board[row][col]);
            }
            sums.add(rowSum);
        }
        //iterate cols
        for (int col = 0; col < COL_COUNT; col++) {
            int colSum = 0;
            for (int row = 0; row < ROW_COUNT; row++) {
                colSum += calculateNumValue(board[row][col]);
            }
            sums.add(colSum);
        }
        //iterate diagonal
        int leftDiagonalSum = 0;
        int rightDiagonalSum = 0;
        for (int i = 0; i < ROW_COUNT; i++) {
            leftDiagonalSum += calculateNumValue(board[i][i]);
            rightDiagonalSum += calculateNumValue(board[i][ROW_COUNT - i - 1]);
        }
        sums.add(leftDiagonalSum);
        sums.add(rightDiagonalSum);
        if (sums.contains(3))
            return GAME_STATE_X_WON;
        else if (sums.contains(-3))
            return GAME_STATE_O_WON;
        else if (areAllCellsTaken(board))
            return GAME_STATE_DRAW;
        else {
            return GAME_STATE_NOT_FINISHED;
        }
    }

    private static int calculateNumValue(String cellState) {
        if (cellState.equals(CELL_X))
            return 1;
        else if (cellState.equals(CELL_O)) {
            return -1;
        } else {
            return 0;
        }
    }

    public static boolean areAllCellsTaken(String[][] board) {
        for (int row = 0; row < ROW_COUNT; ++row)
            for (int col = 0; col < COL_COUNT; col++) {
                if (Objects.equals(board[row][col], CELL_EMPTY)) {
                    return false;
                }
            }
        return true;
    }

    public static void printBoard(String[][] board) {
        System.out.println("---------");
        for (int row = 0; row < ROW_COUNT; ++row) {
            String line = "| ";
            for (int col = 0; col < COL_COUNT; ++col) {
                line = line.concat(board[row][col] + " ");
            }
            line += "|";
            System.out.println(line);
        }
        System.out.println("---------");
    }

}