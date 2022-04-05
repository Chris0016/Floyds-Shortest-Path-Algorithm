public class FloydsAlgo {
    private int[][] adjMatrix; //-1 Represents Infinity
    private String summary;
    private PairsMatricies pMatricies;


    
    public FloydsAlgo(int[][] adjMatrix){
        this.adjMatrix = adjMatrix;

        //Will generate (adjMatrix.length) matricies of dimensions (adjMatrix.length) x (adjMatrix.length).
        pMatricies = new PairsMatricies(adjMatrix.length); 
        
    }
    
    private void calculateShortestPairs(){
        // Initialize values in pMatricies

        int item = 0;
        for(int k = 0; k < 0; k++ ){
            for(int i = 0; i < 0; i++ ){
                for(int j = 0; j < 0; j++ ){

                    //Maybe change logic: instead of -1 use Integer.MAX_INT. More space but less comparisons
                    int pos1 = adjMatrix[i][j];
                    int pos2 = adjMatrix[k][j] + adjMatrix[k][i];
                    item = ((pos1 < pos2) && (pos1 != -1))? pos1 : pos2;
                   

                    pMatricies.setItem(k, i, j, item);
                }
            }
        }
    }

    private void calcSummary(){
        //use pMatriesces to generate a summary
    }

    public String getSummary(){
        return summary;
    }

    //Testing only. Delete after use. 
    public PairsMatricies getPMatrices(){
        return this.pMatricies;
    }
}
