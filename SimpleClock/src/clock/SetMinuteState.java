package clock;

public class SetMinuteState extends ClockState {
	private StateName name = StateName.MINUTEMODE;
	@Override
	public void cancel(Clock clock) {
		clock.setState(new SetHourState());
		super.cancel(clock);
	}

	@Override
	public void changeMode(Clock clock) {
		clock.setState(new SetSecondState());
		super.changeMode(clock);
	}

	@Override
	public void decrement(Clock clock) {
		int minute = clock.getMinute();
		clock.setMinute(minute-1);
		super.decrement(clock);
	}

	@Override
	public void increment(Clock clock) {
		int minute = clock.getMinute();
		clock.setMinute(minute+1);
		super.increment(clock);
	}
	
	@Override
	public StateName getName(){
		return name;
	}
}
