public class PairsMatrices {
    private int[][][] all;
    private int mCount;
    static int MAXN = (int) 1e7;

    public PairsMatrices(int mCount) {
        this.mCount = mCount;
        all = new int[mCount][mCount][mCount]; // Assumes matrices are squared
    }
    // Ex:
    /*
     * Given an adjency matrix(that is square) with 4 nodes the number of short path
     * matricies
     * will be 4 as well and their dimensions will also be 4. Therefore the number
     * of spm is
     * equivalent to the dimensions of the matrix.
     */

    public int getItem(int matrix, int row, int col) {
        return all[matrix][row][col];
    }

    public void setItem(int matrix, int row, int col, int item) {
        all[matrix][row][col] = item;
    }

    public int[][] getMatrix(int k) {
        return all[k];
    }

    public int getTotalMatricies() {
        return all.length;
    }

    public void cleanMatrices() {
        for (int k = 0; k < mCount; k++)
            for (int i = 0; i < mCount; i++)
                for (int j = 0; j < mCount; j++)
                    if (all[k][i][j] == MAXN)
                        all[k][i][j] = -1;
    }
}
