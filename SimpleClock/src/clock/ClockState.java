package clock;

public abstract class ClockState {

	public void timerTick(Clock clock) {
		
	}

	public void cancel(Clock clock) {
		
	}

	public void changeMode(Clock clock) {
		
	}

	public void decrement(Clock clock) {
		
	}

	public void increment(Clock clock) {
		
	}

	public abstract StateName getName();
}
