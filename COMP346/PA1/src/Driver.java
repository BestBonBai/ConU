import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 *
 * @author Kerly Titus provides the template
 * @solution Duc Nguyen
 */
public class Driver{

    /** 
     * main class
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
    	
       // Set up IO stream to write output out to file
        try {
            PrintStream output = new PrintStream("outputWithDebug_3.txt");
            System.setOut(output);
        } catch (FileNotFoundException e) {
            System.out.println("File not found or could not be opened");
            System.exit(0);
        }

        //Starting up server, client, network
    	Network objNetwork = new Network("network");            /* Activate the network */
        objNetwork.start();
        Server objServer = new Server();                        /* Start the server */ 
        objServer.start();
        Client objClient1 = new Client("sending");              /* Start the sending client */
        objClient1.start();
        Client objClient2 = new Client("receiving");            /* Start the receiving client */
        objClient2.start();
    }
}
