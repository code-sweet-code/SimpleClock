package clock;

public class DisplayTimeState extends ClockState {
	
	private StateName name = StateName.DISPLAY;

	@Override
	public void timerTick(Clock clock) {
		int second = clock.getSecond();
		clock.setSecond(second+1);
		super.timerTick(clock);
	}

	@Override
	public void changeMode(Clock clock) {
		clock.setState(new SetHourState());
		super.changeMode(clock);
	}

	@Override
	public StateName getName(){
		return name;
	}

}
