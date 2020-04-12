import common.BaseThread;

/**
 * Class Philosopher.
 * Outlines main subrutines of our virtual philosopher.
 *
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca
 */
public class Philosopher extends BaseThread
{

    public Philosopher(int id) {
        super(id);
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
			System.out.println("\nEATING is what I ... the great philosopher number " + this.iTID+ " doing ...");
			yield();
			sleep((long)(Math.random() * TIME_TO_WASTE));
      yield();
			System.out.println("\nDONE EATING, I am philosopher no." + this.iTID + ". Gotta think now  !");
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
			System.out.println("\nTHINKING is what I, the great philosopher number " + this.iTID+ " doing");
			yield();
			sleep((long)(Math.random() * TIME_TO_WASTE));
      yield();
			System.out.println("\nDONE THINKING, I am philosopher number " + this.iTID + ". This is an enlightmen!");
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
    try {
        System.out.println("\nTALKING now, I am the great philosopher number " + this.iTID+ " ...");
        yield();
        saySomething();
        sleep((long)(Math.random() * TIME_TO_WASTE));
        yield();
        System.out.println("\nDONE TALKING, I am philosopher number " + this.iTID + ". This has been a pleasure!");
    } catch(InterruptedException e) {
        System.err.println("Philosopher.talk():");
        DiningPhilosophers.reportException(e);
        System.exit(1);
    }
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
			"2 + 2 = 5 for extremely large values of 2...",
      "omg, lol, lgtm, tbh",
      "The opposite of isolate is actually yousoearly..",
      "We should not gather here because of Corona ..."
		};

		System.out.println
		(
			"\nPhilosopher " + getTID() + " says: " +
			astrPhrases[(int)(Math.random() * astrPhrases.length)]
		);
	}
}

// EOF
