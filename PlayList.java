/* Hamza Ilyas
 * hi3zk
 * HomeWork 4
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class PlayList implements Playable, Comparator <Playable> {
	//creating fields with variable names
	private String name;
	private ArrayList<Playable>playableList;

	//empty playlist constructor
	public PlayList() {
		this.name = "Untitled";
		this.playableList= new ArrayList<Playable>();
	}

	//playlist constructor setting to a name
	public PlayList(String newName) {
		this.name = newName;
		this.playableList= new ArrayList<Playable>();		}

	//returns the name of the playlist
	public String getName() {
		return this.name;
	}
	
	//modifies the name of the playlist
	public void setName(String name) {
		this.name = name;
	}
	
	//returns a list that is playable
	public ArrayList<Playable> getPlayableList() {
		return playableList;
	}
	
	//modifies the playable list
	public void setPlayableList(ArrayList<Playable> playableList) {
		this.playableList = playableList;
	}
	
	//returns a string of the Playlist and songs in the playlist
	public String toString() {
		String x = this.getName() + "\n";

		for (Playable s :this.playableList) {
			x = x + s.toString() + "\n";
		}
		return x;
	}
	
	//will run songs in a playlist file
	public boolean loadSongs(String fileName) {
		File file = new File (fileName);
		Scanner input = null;
		try {
			input =new Scanner (file);

		}
		catch (Exception e) {
			return false;
		}
		int x = 0;
		String artist = "";
		String title = "";
		int intMinute = 0;
		int intSecond = 0;
		while(input.hasNextLine()){
			String a = input.nextLine();
			x = x + 1;
			a = a.trim();
			if(x == 1){
				title = a;
			}
			else if(x == 2){
				artist = a;
			}
			else if(x == 3){
				int i = a.indexOf(":");
				String min = a.substring(0, i);
				String sec = a.substring(i + 1);
				intMinute = Integer.parseInt(min);
				intSecond = Integer.parseInt(sec);
				if(intSecond >= 60){
					int addMinute = intSecond/60;
					intMinute = intMinute + addMinute;
					intSecond = intSecond - (addMinute * 60);
				}
			}
			else if(x == 4){
				x = 0;
				Song s = new Song(artist, title, intMinute, intSecond);
				this.playableList.add(s);
			}
		}
		input.close();
		return true;
	}
	
	//clears a playlist	
	public boolean clear() {
		boolean x = false;
		playableList.clear();
		if(playableList.size() == 0){
			x = true;
		}
		return x;

	}
	
	//adds a song to a playlist
	public boolean addSong(Song s) {
		playableList.add(s);
		return playableList.contains(s);
	}
	
	//removes a song using an index from a playlist
	public Playable removePlayable(int index) {
		if(0 <= index && index < playableList.size()){
			Playable p = playableList.get(index);
			playableList.remove(index);
			return p;
		}
		else{
			return null;
		}
	}
	
	//removes a song using a song variable from a playlist
	public Playable removePlayable(Playable p) {
		if(playableList.contains(p)){
			for(int i = 0; i<playableList.size(); i++){
				if(playableList.get(i).equals(p)){
					playableList.remove(i);
				}
			}
			return p;
		}
		else{
			return null;
		}
	}
	
	//returns a song from a playlist
	public Playable getPlayable(int index) {
		if(0 <= index && index < playableList.size()){
			Playable p = playableList.get(index);
			return p;
		}
		else{
			return null;
		}
	}
	
	//adds a song to the playList and increases its size
	public boolean addPlayList(PlayList pl) {
		if (playableList.contains(pl)) {
			return false;
		}
		if(! playableList.contains(pl)) {
			playableList.add(playableList.size(),(Playable) pl);
			return true;
		}
		return false;

	}
	
	//doesn't return anything; plays the song
	public void play () {
		for(int i = 0; i<playableList.size(); i++){
			playableList.get(i).play();
		}
	}

	//boolean of two playlist objects being equal
	public boolean equals(Object o) {
		if (o instanceof PlayList) {
			PlayList pl = (PlayList) o;
			if (pl.getName().equals(this.getName())) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}

	//sorts playlist by name;  uses compareName class
	public void sortByName()  {
		Collections.sort(playableList, new compareName()); 

	}
	
	//sorts playlist by time; uses compareTime class
	public void sortByTime() {
		Collections.sort(playableList, new compareTime());
	}
	
	//compares two different playlist; necessary for sorting
	@Override
	public int compare(Playable o1, Playable o2) {
		if (o1.numberOfSongs() == o2.numberOfSongs()) return 0;
		if (o1.numberOfSongs() < o2.numberOfSongs()) return 1;
		if (o1.numberOfSongs() > o2.numberOfSongs()) return -1;
		else return 0;
	}
	
	//returns the play time of a song
	@Override
	public int getPlayTimeSeconds() {
		int x = 0;
		for(Playable p : playableList){
			if(p instanceof Song){
				Song s = (Song) p;
				x = x + s.getSeconds() + (s.getMinutes() * 60);
			}
			if(p instanceof PlayList){
				PlayList q = (PlayList) p;
				x = x + q.getPlayTimeSeconds();
			}
		}
		return x;
	}
	
	//returns the number of songs in a playlist
	@Override
	public int numberOfSongs() { 
		/*
		int i = 0;
		for (Playable p: playableList) {
			i++;
		}
		return i;
		*/
		int counter = 0;
		for (int i = 0; i < playableList.size(); i++) {
			counter++;
		}
		return counter;
	}
}