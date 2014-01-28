import java.util.Scanner;

public class Game {

    private static final String PLAYER1_NAME = "Player1";

    private static final String PLAYER2_NAME = "Player2";

    private static final int PLAYER1 = 1;

    private static final int PLAYER2 = 2;

    private int nowPlays = PLAYER1;

    private boolean endGame = true;

    Grid grid = new Grid();

    public Game(){
        start();
        grid.eraseField();
        grid.showField();
        play();
    }

    private void play(){
        do {
            whoPlay();
            Coordinates();
            grid.showField();
            //endGame = false;

        }
        while (endGame);
    }

    private void Coordinates(){
        int ox = 0;
        int oy = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите значение по оси Ox: ");
        if(sc.hasNextInt()) { // возвращает истинну если с потока ввода можно считать целое число
            ox = sc.nextInt(); // считывает целое число с потока ввода и сохраняем в переменную
        }
        else {
        System.out.println("Вы ввели неверное значение");
        }


        System.out.println("Введите значение по оси Oy");
        if(sc.hasNextInt()) { // возвращает истинну если с потока ввода можно считать целое число
            oy = sc.nextInt(); // считывает целое число с потока ввода и сохраняем в переменную
        }
        else {
            System.out.println("Вы ввели неверное значение");
        }

        grid.setCell(ox, oy, icon());

        nowPlays = nowPlays == PLAYER1 ? PLAYER2 : PLAYER1;
    }

    private char icon(){
        if(nowPlays == 1)
            return 'o';
        return 'x';


    }

    private void whoPlay(){
        if(nowPlays == 1) {
            System.out.println(PLAYER1_NAME + " ваш ход");
        }
        else {
            System.out.println(PLAYER2_NAME + " ваш ход");
        }
    }

    private void start(){
        System.out.println("***Игра крестики нолики!!!***");
        System.out.println("[FAQ]");
        System.out.println("- Для игры вводите сначало координаты по оси OX, затем OY");
        System.out.println("***");
    }


}
