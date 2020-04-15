import java.util.InputMismatchException;
import java.io.*;
/**
 * Class DiningPhilosophers
 * The main starter.
 * @author Duc Nguyen -- student
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca
 */
public class DiningPhilosophers
{
	/*
	 * ------------
	 * Data members
	 * ------------
	 */

	/**
	 * This default may be overridden from the command line
	 */
	public static final int DEFAULT_NUMBER_OF_PHILOSOPHERS = 4;

	/**
	 * Dining "iterations" per philosopher thread
	 * while they are socializing there
	 */
	public static final int DINING_STEPS = 10;

	/**
	 * Our shared monitor for the philosophers to consult
	 */
	public static Monitor sharedMonitor = null;

  /*
   * A group of philosophers
   */
  public static Philosopher[] groupPhilosopher = null;

	/*
	 * -------
	 * Methods
	 * -------
	 */

	/**
	 * Main system starts up right here
	 */
	public static void main(String[] argv)
	{
		try
		{
			/*
			 * Is settable from the command line
			 * or the default if no arguments supplied.
			 */
			int iPhilosophers = 0;
      try {
          int num = Integer.parseInt(argv[0]);
        if(num >= 1 ) {
            iPhilosophers = num;
        } else {
            throw new InputMismatchException();
        }
      } catch(Exception e) {
          System.out.println("Input mismatches or no input found. Using the default number of philosophers");
          iPhilosophers = DEFAULT_NUMBER_OF_PHILOSOPHERS;
      } finally {
          System.out.println("Starting processess...");
      }

      // Direct output to file
      PrintStream console = System.out;

      String fileName = "../output/output-" + iPhilosophers + "-philosophers.txt"; 
      File outputFile = new File(fileName);
      PrintStream output = null;
      try {
          output = new PrintStream(outputFile);
          System.setOut(output);
      } catch(FileNotFoundException e) {
          System.out.println("Output file is missing or cannot be openned");
          System.exit(0);
      }

			System.out.println (iPhilosophers + " philosopher(s) came in for a dinner.");

			// Make the monitor aware of how many philosophers there are
			sharedMonitor = new Monitor(iPhilosophers);

			// Space for all the philosophers
			groupPhilosopher = new Philosopher[iPhilosophers];

			// Let 'em sit down
			for(int j = 0; j < iPhilosophers; j++)
			{
				groupPhilosopher[j] = new Philosopher(j);
				groupPhilosopher[j].start();
			}

			// Main waits for all its children to die...
			// I mean, philosophers to finish their dinner.
			for(int j = 0; j < iPhilosophers; j++)
				groupPhilosopher[j].join();
        System.out.println("\n\nAll philosophers have left the party. \nSystem terminates normally.");

        //Direct output back to console 
        System.setOut(console);
        System.out.println("\n\nAll philosophers have left the party. \nSystem terminates normally.");
        System.out.println("Output file has been written in output folder");
		}
		catch(InterruptedException e)
		{
			System.err.println("main():");
			reportException(e);
			System.exit(1);
		}
   
	} 

	/**
	 * Outputs exception information to STDERR
	 * @param poException Exception object to dump to STDERR
	 */
	public static void reportException(Exception poException)
	{
		System.err.println("Caught exception : " + poException.getClass().getName());
		System.err.println("Message          : " + poException.getMessage());
		System.err.println("Stack Trace      : ");
		poException.printStackTrace(System.err);
	}
}
