public class Grid {
    
    public final int FIELD_SIZE = 3;

    private static final int DEFAULT_CELL_VALUE = ' ';

    private char[][] field = new char[FIELD_SIZE][FIELD_SIZE];

    public void eraseField(){
        for (int i = 0; i < FIELD_SIZE; i++) {
            eraseLine(i);
        }
    }

    public void setCell(int x, int y, char enter) {
        field[x][y] = enter;
    }



    public boolean checkPlace(int x, int y) {
       if(field[x][y] == DEFAULT_CELL_VALUE) {
           return true;
       }
       return false;
    }

    public char getCell(int x, int y){
        return field[x][y];
    }

    private void eraseLine(int lineNumber) {
        for (int i = 0; i < FIELD_SIZE; i++) {
            field[i][lineNumber] = DEFAULT_CELL_VALUE;
        }
    }

    public void showField() {
        showOx();

        for (int i = 0; i < FIELD_SIZE; i++) {
            System.out.print(i);
            showLine(i);
            System.out.println();
        }
    }

    private void showLine(int lineNumber) {
        for (int i = 0; i < FIELD_SIZE; i++) {
            showCell(i,lineNumber);
        }
    }

    private void showOx() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            System.out.print("  ");
            System.out.print(i);
        }

        System.out.println();
    }

    private void showCell(int x, int y) {
        System.out.print("[" + field[x][y] + "]");
    }

}
