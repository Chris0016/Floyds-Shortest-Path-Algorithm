public class Main {

    public static void main(String[] args){
        //Read matrix: File Reader

        String basePath = "C:\\Users\\8Cube\\Documents\\Floyds Shortest Path\\IO\\";
       
        String inputFile = basePath + "input.txt";
        String outputFile = basePath + "output.txt";

        FileReader io = new FileReader(inputFile, outputFile);

        int[][] adjMatrix = io.getMatrix();
        print2DArray(adjMatrix);
        io.printToFile();


        FloydsAlgo fAlgo = new FloydsAlgo(adjMatrix);
        PairsMatricies pMatricies = fAlgo.getPMatrices();

        int pMSizes = pMatricies.getTotalMatricies();
        
        for(int i = 0; i < pMSizes; i++){
            print2DArray( pMatricies.getMatrix(i) );
            System.out.println();
        }
          
        //Genarate all matricies
        //Get shortest path matrix -> print result in human readable form
        

    }

    static void print2DArray(int[][] arr){
        for(int[] e : arr){
            for(int f : e)
                System.out.print(f + " ");
            System.out.println();
        }
    }
}