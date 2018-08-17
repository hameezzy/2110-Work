import java.awt.Graphics;

import javax.swing.JComponent;

public class BubbleSortComponent extends JComponent{
	private BubbleSorter bubblesorter;
	
	public BubbleSortComponent(int[] b) {
			bubblesorter= new BubbleSorter(b,this);
			
		}
		public void paintComponent(Graphics g) {
			bubblesorter.draw(g);
			//insertsorter.draw(g);
			
		}
		public void startAnimation() 
		{
			class AnimationRunnable implements Runnable
			{
				public void run()
				{
					try
					{
						bubblesorter.sort();
				
						
					}
					catch(InterruptedException exception)
					{
						
					}
					
				}
				
			}
			Runnable r= new AnimationRunnable();
			Thread t= new Thread(r);
			t.start();
			
		}
	

}
/*import java.awt.Graphics;

import javax.swing.JComponent;

public class BubbleSortComponent extends JComponent {
	
	private BubbleSorter bubblesorter;
	
	public BubbleSortComponent(int[] array) {
		bubblesorter = new BubbleSorter(array, this);
	}
	
	public void paintComponent(Graphics g) {
		bubblesorter.draw(g);
	}
	
	public void startAnimation() {
		class AnimationRunnable implements Runnable {
			public void run() {
				try {
					bubblesorter.sort();
				}
				catch (InterruptedException exception) {
				}
			}
		}
		Runnable a = new AnimationRunnable();
		Thread b = new Thread(a);
		b.start();
	}
}*/
