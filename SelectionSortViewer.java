import java.awt.BorderLayout;

import javax.swing.JFrame;

public class SelectionSortViewer {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Selection Sorter");
		JFrame frame1 = new JFrame("Insertion Sorter");
		JFrame frame2 = new JFrame("Bubble Sorter");
		
		final int FRAME_WIDTH = 300;
		final int FRAME_HEIGHT = 400;
		
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame1.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame2.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int[] array = ArrayUtil.randomIntArray(50, 300);
		int[] array1 = array.clone();
		int[] array2 = array.clone();
		
		final SelectionSortComponent component = new SelectionSortComponent(array);
		final InsertionSortComponent component1 = new InsertionSortComponent(array1);
		final BubbleSortComponent component2 = new BubbleSortComponent(array2);
		
		frame.add(component, BorderLayout.CENTER);
		frame1.add(component1, BorderLayout.CENTER);
		frame2.add(component2, BorderLayout.CENTER);
		
		frame.setVisible(true);
		frame1.setVisible(true);
		frame2.setVisible(true);
		
		component.startAnimation();
		component1.startAnimation();
		component2.startAnimation();

	}

}
