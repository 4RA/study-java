import java.awt.Font;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TimeThread extends JLabel implements Runnable{
	private Thread timerThread = null;
	public TimeThread() {
		setText(makeClockText());
		setFont(new Font("TimesRoman",Font.ITALIC,20));
		setHorizontalAlignment(JLabel.CENTER);
		timerThread = new Thread(TimeThread.this);
		timerThread.start();
	}
	
	public String makeClockText() {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		month= month+1;
		int day = c.get(Calendar.DAY_OF_MONTH);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int min = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		String clockText = Integer.toString(year);
		clockText = clockText.concat("³â ");
		clockText = clockText.concat(Integer.toString(month));
		clockText = clockText.concat("¿ù ");
		clockText = clockText.concat(Integer.toString(day));
		clockText = clockText.concat("ÀÏ ");
		clockText = clockText.concat(Integer.toString(hour));
		clockText = clockText.concat(":");
		clockText = clockText.concat(Integer.toString(min));
		clockText = clockText.concat(":");
		clockText = clockText.concat(Integer.toString(second));
		//System.out.println(clockText);
		return clockText;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e){return;}
			setText(makeClockText());
		}
	}
}
