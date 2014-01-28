import java.util.Scanner;

public class Game {

    private static final String PLAYER1_NAME = "Player1";

    private static final String PLAYER2_NAME = "Player2";

    private static final String HORIZONTAL_AXIS_NAME = "OX";

    private static final String VERTICAL_AXIS_NAME = "OY";

    private static final int PLAYER1 = 1;

    private static final int PLAYER2 = 2;

    private static final char PLAYER1_ICON = 'x';

    private static final char PLAYER2_ICON = 'o';

    private int nowPlays = PLAYER1;

    private boolean endGame = false;

    Grid grid = new Grid();

    public Game(){
        start();
        grid.eraseField();
        grid.showField();
        play();
    }

    private void play(){
        do {

           System.out.println(whoPlaysNow() + " ваш ход:");
            Coordinates();
            grid.showField();
            if(checkWin()) {
               endGame =  true;
               System.out.println("Выйграл " + whoPlaysNow() + "!!!");
            }

        }
        while (!endGame);
    }


    private boolean checkWin() {
        int counter = 0;

        if((grid.getCell(0,0)==PLAYER1_ICON && grid.getCell(1,1)==PLAYER1_ICON && grid.getCell(2,2)==PLAYER1_ICON) || (grid.getCell(2,0)==PLAYER1_ICON && grid.getCell(1,1)==PLAYER1_ICON && grid.getCell(0,2)==PLAYER1_ICON))
            return true;

        if((grid.getCell(0,0)==PLAYER2_ICON && grid.getCell(1,1)==PLAYER2_ICON && grid.getCell(2,2)==PLAYER2_ICON) || (grid.getCell(2,0)==PLAYER2_ICON && grid.getCell(1,1)==PLAYER2_ICON && grid.getCell(0,2)==PLAYER2_ICON))
            return true;

        if(nowPlays == PLAYER1){

            for(int x = 0; x < grid.FIELD_SIZE; x++){
                for (int y = 0; y < grid.FIELD_SIZE; y++) {
                    if(grid.getCell(x,y) == PLAYER1_ICON) {
                       counter++;
                       if(counter == grid.FIELD_SIZE) {
                           return true;
                       }
                    }
                }
            }

            counter = 0;

            for(int x = 0; x < grid.FIELD_SIZE; x++){
                for (int y = 0; y < grid.FIELD_SIZE; y++) {
                    if(grid.getCell(y,x) == PLAYER1_ICON) {
                        counter++;
                        if(counter == grid.FIELD_SIZE) {
                            return true;
                        }
                    }
                }
            }


        }

        else{
            counter = 0;

            for(int x = 0; x < grid.FIELD_SIZE; x++){
                for (int y = 0; y < grid.FIELD_SIZE; y++) {
                    if(grid.getCell(x,y) == PLAYER2_ICON) {
                        counter++;
                        if(counter == grid.FIELD_SIZE) {
                            return true;
                        }
                    }
                }
            }

            counter = 0;

            for(int x = 0; x < grid.FIELD_SIZE; x++){
                for (int y = 0; y < grid.FIELD_SIZE; y++) {
                    if(grid.getCell(y,x) == PLAYER1_ICON) {
                        counter++;
                        if(counter == grid.FIELD_SIZE) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;

    }

    private void Coordinates(){

        int x = 0;
        int y = 0;

        do{
            x = enterValue(HORIZONTAL_AXIS_NAME);
            y = enterValue(VERTICAL_AXIS_NAME);
        }
        while(!grid.checkPlace(x,y));

        grid.setCell(x, y, icon());

        nowPlays = nowPlays == PLAYER1 ? PLAYER2 : PLAYER1;
    }

    private int enterValue(String axis){

        int coordinate = 0;
        boolean error = false;

        do{
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите значение по оси " + axis + ":");

            if(sc.hasNextInt()) { //sc.hasNextInt() возвращает истинну если с потока ввода можно считать целое число
                coordinate = sc.nextInt(); // считывает целое число с потока ввода и сохраняем в переменную
                if(validate(coordinate))
                error = true;

            }
            else {
                System.out.println("Вы ввели неверное значение!!!");

            }
        }
        while(!error);

        return coordinate;
    }

    private boolean validate(int coordinate){
        if(coordinate >= 0 && coordinate < grid.FIELD_SIZE) {
            return true;
        }
        return false;
    }

    private char icon(){
        if(nowPlays == PLAYER1)
            return PLAYER1_ICON;
        return PLAYER2_ICON;
    }

    private String whoPlaysNow(){
        if(nowPlays == PLAYER1) {
            return PLAYER1_NAME;
        }
        return PLAYER2_NAME;
    }

    private void start(){

        System.out.println("***Игра крестики нолики!!!***");
        System.out.println("[FAQ]");
        System.out.println("- Для игры вводите сначало координаты по оси OX, затем OY");
        System.out.println("***");
    }


}
