package clock;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controller implements ActionListener{
	private Clock myClock;
	private ClockUI myUI;
	
	public Controller(Clock clock){
		myClock = clock;
	}
	
	public void setUI(ClockUI ui){
		myUI = ui;
	}
	
	public void plusButtonOnClick(){
		myClock.increment();
	}
	
	public void minusButtonOnClick(){
		myClock.decrement();
	}
	
	public void changeModeButtonOnClick(){
		myClock.changeMode();
		changeUI();
	}
	
	public void cancelButtonOnClick(){
		myClock.cancel();
		changeUI();
	}
	
	public int getHour(){
		return myClock.getHour();
	}
	
	public int getMinute(){
		return myClock.getMinute();
	}
	
	public int getSecond(){
		return myClock.getSecond();
	}
	
	public void timerTick(){
		myClock.timerTick();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		switch(command){
		case EventCommand.TIMERTICK:{
			timerTick();
			break;
		}
		case EventCommand.INCREMENT:{
			plusButtonOnClick();
			break;
		}
		case EventCommand.DECREMENT:{
			minusButtonOnClick();
			break;
		}
		case EventCommand.CHANGEMODE:{
			changeModeButtonOnClick();
			break;
		}
		case EventCommand.CANCEL:{
			cancelButtonOnClick();
			break;
		}
		}
	}
	
	private void changeUI(){
		switch(myClock.getStateName()){
		case DISPLAY:{
			myUI.setButtonVisible(false);
			myUI.setTimeBoxesUnactivated();
			break;
		}
		case HOURMODE:{
			myUI.setButtonVisible(true);
			myUI.setHourBoxActivated();
			break;
		}
		case MINUTEMODE:{
			myUI.setButtonVisible(true);
			myUI.setMinuteBoxActivated();
			break;
		}
		case SECONDMODE:{
			myUI.setButtonVisible(true);
			myUI.setSecondBoxActivated();
			break;
		}
		default: break;
		}
	}
}
