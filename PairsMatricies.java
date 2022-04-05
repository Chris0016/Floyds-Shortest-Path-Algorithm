public class PairsMatricies {
    private int[][][] all;
    private int mCount, mDimension;

    public PairsMatricies(int mCount){
        this.mCount = mCount;
        //this.mDimension = mDimension;
        all = new int[mCount][mCount][mCount]; //Assumes matrices are squared
    }
    //Ex:
    /*
        Given an adjency matrix(that is square) with 4 nodes the number of  short path matricies
        will be 4 as well and their dimensions will also be 4. Therefore the number of spm is 
        equivalent to the dimensions of the matrix. 
    */

    public int getItem(int matrix, int row, int col){
        return all[matrix][row][col];
    }

    public void setItem(int matrix, int row, int col, int item){
        all[matrix][row][col] = item;
    }


    public int[][] getMatrix(int k){
        return all[k];
    }

    public int getTotalMatricies(){
        return all.length;
    }
}
