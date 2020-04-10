import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

/**
 * Class Monitor
 * To synchronize dining philosophers.
 *
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca
 */
public class Monitor
{
	/*
	 * ------------
	 * Data members
	 * ------------
	 */
	enum STATES {eating, hungry, thinking, talking};
	int numberOfChopsticks;
  private int NumberOfPhilosophers;
  final Lock lock;
	public static STATES[] state;
	public static Condition [] self;

	/**
	 * Constructor
	 */
	public Monitor(int NumberOfPhilosophers)
	{
    this.NumberOfPhilosophers = NumberOfPhilosophers;
    lock = new ReentrantLock();
		numberOfChopsticks = NumberOfPhilosophers;
		state = new STATES[NumberOfPhilosophers];
		self = new Condition [NumberOfPhilosophers];
    //Set initial states
    for(int i = 0; i < NumberOfPhilosophers; ++i) {
        state[i] = STATES.thinking;
        self[i] = lock.newCondition();
    }
	}

	/*
	 * -------------------------------
	 * User-defined monitor procedures
	 * -------------------------------
	 */

  // A method used to test 2 sides of a philosopher
  public synchronized void test(int piTID) {
    lock.lock();
    if((state[(piTID - 1) % NumberOfPhilosophers] != STATES.eating)
            && (state[piTID] == STATES.hungry)
            && (state[(piTID + 1) % NumberOfPhilosophers] != STATES.eating)) {

            //Eating
            state[piTID] = STATES.eating;
            self[piTID].signal();
            }
    lock.unlock();
  }

	/**
	 * Grants request (returns) to eat when both chopsticks/forks are available.
	 * Else forces the philosopher to wait()
	 */
	public synchronized void pickUp(final int piTID) {
      lock.lock();
      state[piTID] = STATES.hungry;
      test(piTID);
      try {
          if(state[piTID] != STATES.eating) {
              self[piTID].await();
          }
      } catch (InterruptedException e) {
          e.printStackTrace();
      } finally {
          lock.unlock();
      }

	}

	/**
	 * When a given philosopher's done eating, they put the chopstiks/forks down
	 * and let others know they are available.
	 */
	public synchronized void putDown(final int piTID)
	{
      state[piTID] = STATES.thinking;
      //Check and let right, left philosophers to pick up chopstick
      test((piTID - 1) % NumberOfPhilosophers);
      test((piTID - 1) % NumberOfPhilosophers);
	}

	/**
	 * Only one philosopher at a time is allowed to philosophy
	 * (while she is not eating).
	 */
	public synchronized void requestTalk()
	{

	}

	/**
	 * When one philosopher is done talking stuff, others
	 * can feel free to start talking.
	 */
	public synchronized void endTalk()
	{
		// ...
	}
}

// EOF
