package clock;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.*;

public class ClockUI implements ClockObserver{
	private JFrame frame;
	private JButton plusButton;
	private JButton minusButton;
	private JButton changeModeButton;
	private JButton cancelButton;
	private JTextPane hourBox;
	private JTextPane minuteBox;
	private JTextPane secondBox;
	private Controller controller;
	private final int TIMERDELAY = 1000;
	
	public ClockUI(String name, Controller controller){
		frame = new JFrame(name);
		plusButton = new JButton("+");
		minusButton = new JButton("-");
		changeModeButton = new JButton("Change Mode");
		cancelButton = new JButton("Cancel");
		hourBox = new JTextPane();
		hourBox.setEditable(false);
		minuteBox = new JTextPane();
		minuteBox.setEditable(false);
		secondBox = new JTextPane();
		secondBox.setEditable(false);
		this.controller = controller;
		this.controller.setUI(this);
	}
	
	public void setButtonVisible(boolean isVisible){
		plusButton.setVisible(isVisible);
		minusButton.setVisible(isVisible);
		cancelButton.setVisible(isVisible);
	}
	
	public void setHourBoxActivated(){
		hourBox.setBackground(Color.GREEN);
		minuteBox.setBackground(Color.WHITE);
		secondBox.setBackground(Color.WHITE);
	}
	
	public void setMinuteBoxActivated(){
		hourBox.setBackground(Color.WHITE);
		minuteBox.setBackground(Color.GREEN);
		secondBox.setBackground(Color.WHITE);
	}
	
	public void setSecondBoxActivated(){
		hourBox.setBackground(Color.WHITE);
		minuteBox.setBackground(Color.WHITE);
		secondBox.setBackground(Color.GREEN);
	}
	
	public void setTimeBoxesUnactivated(){
		hourBox.setBackground(Color.WHITE);
		minuteBox.setBackground(Color.WHITE);
		secondBox.setBackground(Color.WHITE);
	}
	
	private void initComponents(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel timePanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		
		buttonPanel.add(plusButton);
		buttonPanel.add(minusButton);
		buttonPanel.add(changeModeButton);
		buttonPanel.add(cancelButton);
		timePanel.add(hourBox);
		timePanel.add(minuteBox);
		timePanel.add(secondBox);
		hourBox.setMargin(new Insets(10,30,10,30));
		minuteBox.setMargin(new Insets(10,30,10,30));
		secondBox.setMargin(new Insets(10,30,10,30));
        frame.getContentPane().add(timePanel, BorderLayout.CENTER);
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        setButtonVisible(false);
        setTimeBoxesUnactivated();
	}
	
	private void refreshData(){
		hourBox.setText(String.valueOf(controller.getHour()));
		minuteBox.setText(String.valueOf(controller.getMinute()));
		secondBox.setText(String.valueOf(controller.getSecond()));
	}
	
	private void startTimer(){
		Timer timer = new Timer(TIMERDELAY, controller);
		timer.setActionCommand(EventCommand.TIMERTICK);
		timer.start();
	}
	
	private void setButtonListener(){
		plusButton.setActionCommand(EventCommand.INCREMENT);
		plusButton.addActionListener(controller);
		minusButton.setActionCommand(EventCommand.DECREMENT);
		minusButton.addActionListener(controller);
		changeModeButton.setActionCommand(EventCommand.CHANGEMODE);
		changeModeButton.addActionListener(controller);
		cancelButton.setActionCommand(EventCommand.CANCEL);
		cancelButton.addActionListener(controller);
	}
	
	public void start(){
		initComponents();
		setButtonListener();
		refreshData();
		startTimer();
		initWindow();
	}
	
	public void initWindow() {
		frame.setSize(350, 150);
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	    frame.setVisible(true);
	}
	
	@Override
	public void update() {
		refreshData();
	}

	public static void main(String[] args) {
		Clock clock = new Clock();
		Controller controller = new Controller(clock);
		ClockUI ui = new ClockUI("SimpleClock", controller);
		clock.resigterObserver(ui);
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	ui.start();
            }
        });
		
	}




	

}
