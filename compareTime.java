/* Hamza Ilyas
 * hi3zk
 * HomeWork 4
 */

import java.util.Comparator;

public class compareTime implements Comparator<Playable> {

	//comparing 2 times; necessary for ordering playlists
	@Override
	public int compare(Playable p1, Playable p2) {
		if (p1.getPlayTimeSeconds() == p2.getPlayTimeSeconds()) return 0;
		if (p1.getPlayTimeSeconds() < p2.getPlayTimeSeconds()) return -1;
		if (p1.getPlayTimeSeconds() > p2.getPlayTimeSeconds()) return 1;
		else {
			return 0;
		}
	}
}
