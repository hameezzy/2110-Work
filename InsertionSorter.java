import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JComponent;

public class InsertionSorter {
	private int[] a;

	private int markedPosition = -1;
	private int alreadySorted = -1;

	private Lock sortStateLock;

	private JComponent component;

	private static final int DELAY = 120;

	public InsertionSorter(int[] anArray, JComponent aComponent) {
		a = anArray;
		sortStateLock = new ReentrantLock();
		component = aComponent;
	}
	public void sort() throws InterruptedException {
		for (int i = 1; i < a.length; i++) {
			sortStateLock.lock();
			try {
				int next = a[i];
				int j = i;
				while (j > 0 && a[j-1] > next) {
					a[j] = a[j-1];
					j--;
				}
				alreadySorted = i;
				a[j] = next;
				markedPosition = i;
			}

			finally {
				sortStateLock.unlock();
			}
			pause(1);
		}
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
}
