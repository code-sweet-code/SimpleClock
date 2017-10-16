package clock;

public class Clock {
	private ClockState state;
	private int hour;
	private int minute;
	private int second;
	private ClockObserver observer;
	private final int MAXHOUR = 12;
	private final int MAXMINUTE = 60;
	private final int MAXSECOND = 60;
	
	public Clock(){
		setState(new DisplayTimeState());
		hour = 0;
		minute = 0;
		second = 0;
	}
	
	public void increment(){
		state.increment(this);
	}
	
	public void decrement(){
		state.decrement(this);
	}
	
	public void changeMode(){
		state.changeMode(this);
	}
	
	public void cancel(){
		state.cancel(this);
	}
	
	public void timerTick(){
		state.timerTick(this);
	}

	public void resigterObserver(ClockObserver observer) {
		this.observer = observer;
	}
	
	public void setState(ClockState newState){
		this.state = newState;
	}
	
	public StateName getStateName(){
		return this.state.getName();
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = (hour+MAXHOUR)%MAXHOUR;
		notifyObserver();
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = (minute+MAXMINUTE)%MAXMINUTE;
		notifyObserver();
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = (second+MAXSECOND)%MAXSECOND;
		notifyObserver();
	}

	private void notifyObserver(){
		if(observer != null){
			observer.update();
		}
	}
}
