package backtracking;

public class EightQueens {

    final static Integer ARRAY_SIZE = 8;

    int[] result = new int[ARRAY_SIZE];

    public EightQueens() {
    }

    public void cal8queens(int row) {
        if (row == 8) {
            printQueens(result);
            return;
        }
        for (int column = 0; column < ARRAY_SIZE; column++) {
            if (isOk(row, column)) {
                result[row] = column;
                cal8queens(row + 1);
            }
        }
    }

    public boolean isOk(int row, int column) {
        int leftUp = column - 1;
        int rightUp = column + 1;
        for (int i = row - 1; i >= 0; i--) {
            if (result[i] == column) return false;    // 同一列有
            if (leftUp >= 0) {
                if (result[i] == leftUp) return false;
            }
            if (rightUp < 8){
                if (result[i] == rightUp) return false;
            }
            leftUp--;
            rightUp++;
        }
        return true;
    }

    public void printQueens(int[] result) {
        for (int row = 0; row < ARRAY_SIZE; row++) {
            for (int column = 0; column < ARRAY_SIZE; column++) {
                if (result[row] == column) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}
