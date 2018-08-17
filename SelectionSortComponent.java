import java.awt.Graphics;
import javax.swing.JComponent;

public class SelectionSortComponent extends JComponent {
	
	private SelectionSorter sorter;
	
	public SelectionSortComponent(int[] array) {
		sorter = new SelectionSorter(array, this);
	}
	
	public void paintComponent(Graphics g) {
		sorter.draw(g);
	}
	
	public void startAnimation() {
		class AnimationRunnable implements Runnable {
			public void run() {
				try {
					sorter.sort();
				}
				catch (InterruptedException exception) {
				}
			}
		}
		Runnable e = new AnimationRunnable();
		Thread f = new Thread(e);
		f.start();
	}
}
