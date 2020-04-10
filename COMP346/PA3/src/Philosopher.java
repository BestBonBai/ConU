import common.BaseThread;

/**
 * Class Philosopher.
 * Outlines main subrutines of our virtual philosopher.
 *
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca
 */
public class Philosopher extends BaseThread
{

    public Philosopher(int TID) {
        super(TID);
    }

	/**
	 * Max time an action can take (in milliseconds)
	 */
	public static final long TIME_TO_WASTE = 1000;

	/**
	 * The act of eating.
	 * - Print the fact that a given phil (their TID) has started eating.
	 * - yield
	 * - Then sleep() for a random interval.
	 * - yield
	 * - The print that they are done eating.
	 */
	public void eat()
	{
		try
		{
			System.out.println("I ... the great philosopher number " + this.iTID+ " eating...");
			yield();
			sleep((long)(Math.random() * TIME_TO_WASTE));
      yield();
			System.out.println("I am philosopher number " + this.iTID + " done eating. This is a waste of time !");
		}
		catch(InterruptedException e)
		{
			System.err.println("Philosopher.eat():");
			DiningPhilosophers.reportException(e);
			System.exit(1);
		}
	}

	/**
	 * The act of thinking.
	 * - Print the fact that a given phil (their TID) has started thinking.
	 * - yield
	 * - Then sleep() for a random interval.
	 * - yield
	 * - The print that they are done thinking.
	 */
	public void think()
	{
		try
		{
			System.out.println("THINKING is what I, the great philosopher number " + this.iTID+ " ...");
			yield();
			sleep((long)(Math.random() * TIME_TO_WASTE));
      yield();
			System.out.println("I am done with THINKING, I am philosopher number " + this.iTID + ". This is a enlightmen!");
		}
		catch(InterruptedException e)
		{
			System.err.println("Philosopher.think():");
			DiningPhilosophers.reportException(e);
			System.exit(1);
		}
	}

	/**
	 * The act of talking.
	 * - Print the fact that a given phil (their TID) has started talking.
	 * - yield
	 * - Say something brilliant at random
	 * - yield
	 * - The print that they are done talking.
	 */
	public void talk()
	{
    System.out.println("I am TALKING now, I am the great philosopher number " + this.iTID+ " ...");
    yield();
    saySomething();
    yield();
    System.out.println("I am done with TALKING, I am philosopher number " + this.iTID + ". This has been a pleasure!");
	}

	/**
	 * No, this is not the act of running, just the overridden Thread.run()
   * Okay..
   *
	 */
	public void run()
	{
		for(int i = 0; i < DiningPhilosophers.DINING_STEPS; i++)
		{
			DiningPhilosophers.sharedMonitor.pickUp(getTID());

			eat();

			DiningPhilosophers.sharedMonitor.putDown(getTID());

			think();

			/*
			 * TODO:
			 * A decision is made at random whether this particular
			 * philosopher is about to say something terribly useful.
			 */
			if(DiningPhilosophers.sharedMonitor.state[getTID()] != Monitor.STATES.eating)
			{
        DiningPhilosophers.sharedMonitor.requestTalk();
				talk();
        DiningPhilosophers.sharedMonitor.endTalk();
			}
			yield();
		}
	} // run()

	/**
	 * Prints out a phrase from the array of phrases at random.
	 * Feel free to add your own phrases.
	 */
	public void saySomething()
	{
		String[] astrPhrases =
		{
			"Eh, it's not easy to be a philosopher: eat, think, talk, eat...",
			"You know, true is false and false is true if you think of it",
			"2 + 2 = 5 for extremely large values of 2...",
			"If thee cannot speak, thee must be silent",
			"My number is " + getTID() + "",
      "The opposite of isolate is actually yousoearly.."
		};

		System.out.println
		(
			"Philosopher " + getTID() + " says: " +
			astrPhrases[(int)(Math.random() * astrPhrases.length)]
		);
	}
}

// EOF
