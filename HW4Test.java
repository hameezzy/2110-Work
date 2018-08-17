/* Hamza Ilyas
 * hi3zk
 * HomeWork 4
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class HW4Test {

	@Test
	public void toStringTest() {
		Song s = new Song ("Post Malone", "Rockstar");
		assertEquals(s.toString(), "{Song:title = Rockstar artist = Post Malone}");
	}
	
	@Test
	public void toStringTest2() {
		Song s = new Song ("Post Malone", "Rockstar");
		Song s1 = new Song ("Rae Sremmard", "Swang");
		PlayList p = new PlayList("My PlayList");
		p.addSong(s);
		p.addSong(s1);
		assertEquals(p.toString(), "My PlayList\n" + "{Song:title = Rockstar artist = Post Malone}\n"
		+ "{Song:title = Swang artist = Rae Sremmard}\n");
	}
	
	@Test
	public void loadSongsTest() {
		PlayList p = new PlayList("Post Malone");
		p.loadSongs("new.txt");
		assertFalse(p.loadSongs("new.txt"));
	}
	
	@Test
	public void loadSongsTest2() {
		PlayList p1 = new PlayList("Rae Sremmard");
		p1.loadSongs("new.txt");
		assertFalse(p1.loadSongs("new.txt"));
	}
	
	@Test
	public void clearTest() {
		Song a = new Song ("Post Malone", "Rockstar");
		Song b = new Song ("Rae Sremmard", "Swang");
		PlayList p = new PlayList("My PlayList");
		p.addSong(a);
		p.addSong(b);
		p.clear();
		assertEquals(p.clear(), true);
	}
	
	@Test
	public void clearTest2() {
		Song c = new Song ("Ellie Goulding", "Lights");
		Song d = new Song ("Kanye West", "Amazing");
		PlayList p1 = new PlayList ("My PlayList2");
		p1.addSong(c);
		p1.addSong(d);
		p1.clear();
		assertEquals(p1.clear(), true);
	}
	
	@Test
	public void addSongTest() {
		Song b = new Song ("Rae Sremmard", "Swang");
		PlayList p = new PlayList ("My PlayList");
		assertTrue(p.addSong(b));
	}
	
	@Test
	public void addSongTest2() {
		Song a = new Song ("Post Malone", "Rockstar");
		PlayList p = new PlayList ("My PlayList");
		assertTrue(p.addSong(a));
	}
	
	@Test
	public void removePlayableIndexTest() {
		Song a = new Song ("Post Malone", "Rockstar");
		Song b = new Song ("Rae Sremmard", "Swang");
		PlayList p = new PlayList ("My PlayList");
		p.addSong(a);
		p.addSong(b);
		assertEquals(p.removePlayable(1), b);
	}
	
	@Test
	public void removePlayableIndexTest2() {
		Song c = new Song ("Ellie Goulding", "Lights");
		Song d = new Song ("Kanye West", "Amazing");
		PlayList p1 = new PlayList ("My PlayList");
		p1.addSong(c);
		p1.addSong(d);
		assertEquals(p1.removePlayable(0), c);
	}
	
	@Test
	public void removePlayableSongTest() {
		Song a = new Song ("Post Malone", "Rockstar");
		Song b = new Song ("Rae Sremmard", "Swang");
		PlayList p = new PlayList ("My PlayList");
		p.addSong(a);
		p.addSong(b);
		assertEquals(p.removePlayable(a), a);
	}
	
	@Test
	public void removePlayableSongTest2() {
		Song c = new Song ("Ellie Goulding", "Lights");
		Song d = new Song ("Kanye West", "Amazing");
		PlayList p1 = new PlayList ("My PlayList");
		p1.addSong(c);
		p1.addSong(d);
		assertEquals(p1.removePlayable(c), c);
	}
	
	@Test
	public void getPlayableTest() {
		Song c = new Song ("Ellie Goulding", "Lights");
		Song d = new Song ("Kanye West", "Amazing");
		PlayList p2 = new PlayList("My PlayList");
		p2.addSong(c);
		p2.addSong(d);
		assertEquals(p2.getPlayable(0),c);
	}
	
	@Test
	public void getPlayableTest2() {
		Song a = new Song ("Post Malone", "Rockstar");
		Song b = new Song ("Rae Sremmard", "Swang");
		PlayList p1 = new PlayList("My PlayList");
		p1.addSong(a);
		p1.addSong(b);	
		assertEquals(p1.getPlayable(1),b);
	}
	
	@Test
	public void addPlayListTest() {
		Song c = new Song ("Ellie Goulding", "Lights");
		Song d = new Song ("Kanye West", "Amazing");
		PlayList p2 = new PlayList("My PlayList2");
		
		PlayList pl = new PlayList("My PlayList");
		PlayList p3 = new PlayList("My PlayList3");
		
		p2.addSong(c);
		p2.addSong(d);
		
		assertEquals(pl.addPlayList(p3),true);
		assertEquals(pl.addPlayList(p2),true);
	}
	
	@Test
	public void equalsTest() {
		Song a = new Song ("Post Malone", "Rockstar");
		Song b = new Song ("Rae Sremmard", "Swang");
		PlayList p1 = new PlayList("My PlayList");
		p1.addSong(a);
		p1.addSong(b);
		Song c = new Song ("Ellie Goulding", "Lights",5,12);
		Song d = new Song ("Kanye West", "Amazing",4,17);
		PlayList p2 = new PlayList("My PlayList2");
		p2.addSong(c);
		p2.addSong(d);
		Song e = new Song("Chris", "Insane");
		Song f = new Song("John", "Fire");
		Song g = new Song("Jacob", "Smile");
		PlayList p3 = new PlayList("My PlayList2");
		p3.addSong(e);
		p3.addSong(f);
		p3.addSong(g);
		
		assertEquals(p1.equals(p2), false);
		assertEquals(p2.equals(p3), true);
		assertEquals(a.equals(e), false);
		assertEquals(a.equals(c), false);
	}
	
	@Test
	public void compareTest() {
		Song a = new Song ("Post Malone", "Rockstar");
		Song b = new Song ("Rae Sremmard", "Swang");
		PlayList p1 = new PlayList("My PlayList");
		p1.addSong(a);
		p1.addSong(b);
		Song c = new Song ("Ellie Goulding", "Lights");
		Song d = new Song ("Kanye West", "Amazing");
		PlayList p2 = new PlayList("My PlayList2");
		p2.addSong(c);
		p2.addSong(d);
		Song e = new Song("Chris", "Insane");
		Song f = new Song("John", "Fire");
		Song g = new Song("Jacob", "Smile");
		PlayList p3 = new PlayList("My PlayList2");
		p3.addSong(e);
		p3.addSong(f);
		p3.addSong(g);
		
		assertEquals(p1.compare(p1, p2),0);
		assertEquals(p2.compare(p2, p3),1);

	}
	
	@Test
	public void compareToTest() {
		Song a = new Song ("Post Malone", "Rockstar");
		Song b = new Song ("Rae Sremmard", "Swang");
		Song c = new Song ("Ellie Goulding", "Lights");
		assertEquals(a.compareTo(b), -2);
		assertEquals(a.compareTo(c),11);
	
	}
	
	@Test
	public void sortByTimeTest() {
		Song a = new Song ("Post Malone", "Rockstar",4,16);
		Song b = new Song ("Rae Sremmard", "Swang",3,12);
		PlayList p1 = new PlayList("My PlayList");
		p1.addSong(a);
		p1.addSong(b);
		p1.sortByTime();
		
		assertTrue(p1.addSong(b));
		System.out.println(p1);
	}
	
	@Test
	public void numberOfSongsTest() {
		Song c = new Song ("Ellie Goulding", "Lights");
		Song d = new Song ("Kanye West", "Amazing");
		PlayList p1 = new PlayList("My PlayList");
		p1.addSong(c);
		p1.addSong(d);
		
		Song e = new Song("Chris", "Insane");
		Song f = new Song("John", "Fire");
		Song g = new Song("Jacob", "Smile");
		PlayList p3 = new PlayList("My PlayList2");
		p3.addSong(e);
		p3.addSong(f);
		p3.addSong(g);
		
		assertEquals(p1.numberOfSongs(),2);
		assertEquals(p3.numberOfSongs(),3);

	}
	
	
	@Test
	public void getPlayTimeSecondsTest() {
		Song c = new Song ("Ellie Goulding", "Lights",5,12);
		Song d = new Song ("Kanye West", "Amazing",4,17);
		assertEquals(c.getPlayTimeSeconds(),312);
		assertEquals(d.getPlayTimeSeconds(),257);
	}
	
	@Test
	public void getPlayTimeSecondsTest2() {
		Song a = new Song ("Post Malone", "Rockstar", 4, 16);
		Song b = new Song ("Rae Sremmard", "Swang", 3, 12);
		assertEquals(a.getPlayTimeSeconds(),256);
		assertEquals(b.getPlayTimeSeconds(),192);
	}

}
