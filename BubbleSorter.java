import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JComponent;

public class BubbleSorter {
	private int[] a;
	private int markedPosition=-1;
	private int alreadySorted=-1;
	private Lock sortStateLock;

	private JComponent component;
	private static final int DELAY=120;


	public BubbleSorter(int[] anArray, JComponent aComponent) {
		a= anArray;
		sortStateLock=new ReentrantLock();
		component=aComponent;

	}
	public void sort() throws InterruptedException{
		int n = a.length;  
		int temp = 0;  
		for(int i=0; i < n; i++){  
			
			sortStateLock.lock();
			try
			{
				for(int j=1; j < (n-i); j++){  
					if(a[j-1] > a[j]){  
						//swap elements  
						temp = a[j-1];  
						a[j-1] = a[j];  
						a[j] = temp;  
						//markedPosition = i;
						
					}
				
								
				}  
				alreadySorted=i;
				markedPosition=i;
				
				
			}
				finally {
					sortStateLock.unlock();

				}
			pause(10);
			}  



	}

	public void draw(Graphics g) {
		sortStateLock.lock();
		try
		{
			int deltaX=component.getWidth()/a.length;
			for(int i=0; i<a.length ; i++) {
				if(i==markedPosition) 
				{
					
					g.setColor(Color.RED);	

				}
				else if(i<=alreadySorted)
				{
					g.setColor(Color.BLUE);

				}
				else
				{
					g.setColor(Color.BLACK);

				}
				g.drawLine(i*deltaX, 0, i*deltaX, a[i]);
			}

		}
		finally
		{
			sortStateLock.unlock();

		}
	}
	public void pause(int steps) 
			throws InterruptedException
	{
		component.repaint();
		Thread.sleep(steps*DELAY);

	}

}
/*import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JComponent;

public class BubbleSorter {
	private int[] a;

	private int markedPosition = -1;
	private int alreadySorted = -1;
	private Lock sortStateLock;
	private JComponent component;

	private static final int DELAY = 120;

	public BubbleSorter(int[] anArray, JComponent aComponent) {
		a = anArray;
		sortStateLock = new ReentrantLock();
		component = aComponent;
	}
	public void sort() throws InterruptedException {
		int n = a.length;
		int temp = 0;
		for (int i = 0; i < n; i++) {
			sortStateLock.lock();
			try {
				for (int j = 1; j < (n-i); j++) {
					if(a[j-1] > a[j]) {
						temp = a[j-1];
						a[j-1] = a[j];
						a[j] = temp;
					}
				}
				alreadySorted = i;
				markedPosition = i;
			}
			
			finally {
				sortStateLock.unlock();
			}
		}
		pause(10);
	}

	public void draw (Graphics g) {
		sortStateLock.lock();
		try {
			int deltaX = component.getWidth()/ a.length;
			for (int i = 0; i < a.length; i++) {
				
					if (i == markedPosition) {
						g.setColor(Color.RED);
					}
					else if (i <= alreadySorted) {
						g.setColor(Color.BLUE);
					}
					else {
						g.setColor(Color.BLACK);
					}
					g.drawLine(i * deltaX, 0, i * deltaX, a[i]);
			}
		}
		finally {
			sortStateLock.unlock();
		}
	}

	public void pause (int steps) throws InterruptedException {
		component.repaint();
		Thread.sleep(steps * DELAY);
	}
}*/
