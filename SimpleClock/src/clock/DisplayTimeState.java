package clock;

public class DisplayTimeState extends ClockState {
	
	private StateName name = StateName.DISPLAY;

	@Override
	public void timerTick(Clock clock) {
		int hour = clock.getHour();
		int minute = clock.getMinute();
		int second = clock.getSecond();
		if(second++ == 59){
			if(minute++ == 59){
				hour++;
			}
		}
		clock.setHour(hour);
		clock.setMinute(minute);
		clock.setSecond(second);
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
