package Lesson4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final char DOT_EMPTY = '•';
    private static final int SIZE = 3;

    public static final String AI_WIN_MSG = "Победил компьютер!";
    public static final String HUMAN_WIN_MSG = "Победил человек!";
    public static final String DRAW_MSG = "Ничья!";
    private static Scanner scanner = new Scanner(System.in);
    private static char[][] map;

    public static void main(String[] args) {
        initMap();
        printMap();
        startGameLoop();
    }

    private static void startGameLoop() {
        while (true) {
            humanTurn();
            printMap();
            if (checkEndGame(DOT_X)) {
                break;
            }

            aiTurn();
            printMap();
            if (checkEndGame(DOT_O)) {
                break;
            }
        }
    }

    private static boolean checkEndGame(char symbol) {
        if (isMapFull()) {
            System.out.println(DRAW_MSG);
            return true;
        }
        if (isWin(symbol)) {
            System.out.println(getWinMassageBy(symbol));
            return true;
        }
        return false;
    }

    private static String getWinMassageBy(char symbol) {
        return symbol == DOT_X ? HUMAN_WIN_MSG : AI_WIN_MSG;

    }

    private static boolean isWin(char symbol) {
        int countRow = 0;
        int countCol = 0;
        int countDiagonal = 0;
        int countReverseDiagonal = 0;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == symbol) {
                    countRow++;
                } else countRow = 0;

            }
            if (countRow == SIZE) return true;
        }

        for (int j = 0; j < SIZE; j++) {
            for (int i = 0; i < SIZE; i++) {
                if (map[i][j] == symbol) {
                    countCol++;
                } else countCol = 0;

            }
            if (countCol == SIZE) return true;
        }


            for (int i = 0; i < SIZE; i++) {
                if (map[i][i] == symbol) {
                    countDiagonal++;
                } else countDiagonal = 0;
            if (countDiagonal == SIZE) return true;
        }

        for (int i = 0; i < SIZE; i++) {
                if (map[i][map.length - 1 - i] == symbol) {
                    countReverseDiagonal++;
                    System.out.println(countReverseDiagonal);
                } else countReverseDiagonal = 0;


            if (countReverseDiagonal == SIZE) return true;
        }


        // check rows
     /*   if (map[0][0] == symbol && map[0][1] == symbol && map[0][2] == symbol) return true;
        if (map[1][0] == symbol && map[1][1] == symbol && map[1][2] == symbol) return true;
        if (map[2][0] == symbol && map[2][1] == symbol && map[2][2] == symbol) return true;

        // check columns
        if (map[0][0] == symbol && map[1][0] == symbol && map[2][0] == symbol) return true;
        if (map[0][1] == symbol && map[1][1] == symbol && map[2][1] == symbol) return true;
        if (map[0][2] == symbol && map[1][2] == symbol && map[2][2] == symbol) return true;

        // check diagonals
        if (map[0][0] == symbol && map[1][1] == symbol && map[2][2] == symbol) return true;
        if (map[0][2] == symbol && map[1][1] == symbol && map[2][0] == symbol) return true;
*/
        return false;
    }

    private static boolean isMapFull() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (isEmptyCell(row, col)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void aiTurn() {
        int row, col;
        Random random = new Random();
        do {
            row = random.nextInt(SIZE);
            col = random.nextInt(SIZE);
        } while (!isEmptyCell(row, col));

        map[row][col] = DOT_O;
    }

    private static void humanTurn() {
        System.out.println("Введите координаты row col: ");
        int row = 0;
        int col = 0;
        do {
            row = readIndex();
            col = readIndex();


            if (!checkRange(row) || !checkRange(col)) {
                System.out.println("Координаты должны быть в диапазоне от 1 до " + SIZE);
                continue;
            }

            if (isEmptyCell(row - 1, col - 1)) {
                break;
            } else {
                System.out.println("Клетка уже занята!");
            }
        } while (true);

        map[row - 1][col - 1] = DOT_X;
    }

    private static boolean isEmptyCell(int row, int col) {
        return map[row][col] == DOT_EMPTY;
    }

    private static int readIndex() {
        while (!scanner.hasNextInt()) {
            System.out.println("Координаты должны иметь целочисленное значение!");
            scanner.nextInt();
        }
        return scanner.nextInt();
    }

    private static boolean checkRange(int index) {
        return index >= 1 && index <= SIZE;
    }


    private static void initMap() {
        map = new char[SIZE][SIZE];

        for (int row = 0; row < map.length; row++) {
            Arrays.fill(map[row], DOT_EMPTY);
        }
    }

    private static void printMap() {
        printMapHeader();
        printMapState();
        System.out.println();
    }

    private static void printMapState() {
        for (int row = 0; row < map.length; row++) {
            printRowNumber(row);
            printRow(map[row]);
            System.out.println();
        }
    }

    private static void printRow(char[] chars) {
        for (int col = 0; col < chars.length; col++) {
            System.out.print(chars[col] + " ");
        }
    }

    private static void printRowNumber(int rowNumber) {
        System.out.print((rowNumber + 1) + " ");
    }

    private static void printMapHeader() {
        for (int col = 0; col <= SIZE; col++) {
            System.out.print(col + " ");
        }
        System.out.println();
    }
}
