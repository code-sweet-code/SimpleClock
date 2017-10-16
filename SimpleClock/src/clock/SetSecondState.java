package clock;

public class SetSecondState extends ClockState {
	private StateName name = StateName.SECONDMODE;
	@Override
	public void cancel(Clock clock) {
		clock.setState(new SetMinuteState());
		super.cancel(clock);
	}

	@Override
	public void changeMode(Clock clock) {
		clock.setState(new DisplayTimeState());
		super.changeMode(clock);
	}

	@Override
	public void decrement(Clock clock) {
		int second = clock.getSecond();
		clock.setSecond(second-1);
		super.decrement(clock);
	}

	@Override
	public void increment(Clock clock) {
		int second = clock.getSecond();
		clock.setSecond(second+1);
		super.increment(clock);
	}
	
	@Override
	public StateName getName(){
		return name;
	}
}
