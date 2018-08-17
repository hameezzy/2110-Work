import java.awt.Graphics;

import javax.swing.JComponent;

public class InsertionSortComponent extends JComponent {
	
	private InsertionSorter insertsorter;
	
	public InsertionSortComponent(int[] array1) {
		insertsorter = new InsertionSorter(array1, this);
	}
	
	public void paintComponent(Graphics g) {
		insertsorter.draw(g);
	}
	
	public void startAnimation() {
		class AnimationRunnable implements Runnable {
			public void run() {
				try {
					insertsorter.sort();
				}
				catch (InterruptedException exception) {
				}
			}
		}
		Runnable c = new AnimationRunnable();
		Thread d = new Thread(c);
		d.start();
	}
}
