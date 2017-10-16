package clock;

public class SetHourState extends ClockState {
	private StateName name = StateName.HOURMODE;

	@Override
	public void cancel(Clock clock) {
		clock.setState(new DisplayTimeState());
		super.cancel(clock);
	}

	@Override
	public void changeMode(Clock clock) {
		clock.setState(new SetMinuteState());
		super.changeMode(clock);
	}

	@Override
	public void decrement(Clock clock) {
		int hour = clock.getHour();
		clock.setHour(hour-1);
		super.decrement(clock);
	}

	@Override
	public void increment(Clock clock) {
		int hour = clock.getHour();
		clock.setHour(hour+1);
		super.increment(clock);
	}

	@Override
	public StateName getName(){
		return name;
	}
}
