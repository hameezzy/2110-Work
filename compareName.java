/* Hamza Ilyas
 * hi3zk
 * HomeWork 4
 */

import java.util.Comparator;

public class compareName implements Comparator <Playable> {

	//comparing playlist names; necessary for sorting
	@Override
	public int compare(Playable o1, Playable o2) {
				
				if (o1.getName().equals(o2.getName())) return 0;
				if (o1.getName().compareTo(o2.getName())<0) return -1;
				if(o1.getName().compareTo(o2.getName())>0) return 1;
			
		return 0;
	}

}

