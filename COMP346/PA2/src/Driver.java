/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 *
 * @author Kerly Titus
 */
public class Driver {

    /** 
     * main class
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Set up IO stream to write output to a file
        try {
            PrintStream output = new PrintStream("./output/output-semaphore1.txt");
            System.setOut(output);
        } catch (FileNotFoundException e) {
            System.out.println("Output file not found or cannot be opened");
            System.exit(0);
        }

    	Network objNetwork = new Network( );            /* Activate the network */
        objNetwork.start();

        Server server1 = new Server("serverThread1");
        server1.start();
        Server server2 = new Server("serverThread2");
        server2.start();

        Client objClient1 = new Client("sending");          /* Start the sending client thread */
        objClient1.start();
        Client objClient2 = new Client("receiving");        /* Start the receiving client thread */
        objClient2.start();
        
      /*..............................................................................................................................................................*/
       
    }
    
 }
