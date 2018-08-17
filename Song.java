/* Hamza Ilyas
 * hi3zk
 * HomeWork 4
 */

public class Song implements Playable {
	
	//creating variables necessary for the class
	private String artist;
	private String title; 
	private int minutes;
	private int seconds;

	//song constructor with artist and title parameters
	public Song(String artist, String title) {
		this.artist = artist;
		this.minutes = minutes;
		this.seconds = seconds;
		this.title = title;
	}
	
	//song constructor with artist, title, and time parameters
	public Song(String artist, String title, int minutes, int seconds) {
		this.artist = artist;
		this.minutes = minutes;
		this.seconds = seconds;
		this.title = title;
	}
	
	//song constructor with Song object parameter
	public Song(Song s) {
		this.artist = s.getArtist();
		this.minutes = s.getMinutes();
		this.seconds = s.getSeconds();
		this.title = s.getTitle();
	}

	//comparing two songs with each other; necessary for sorting
	public int compareTo(Song s){
		int x = this.artist.compareTo(s.getArtist());
		if(x != 0){
			return x;
		}
		x = this.title.compareTo(s.getTitle());
		if(x != 0){
			return x;
		}
		return x;
	}
	
	//outputs what song is currently playing
	@Override
	public void play() {
		System.out.printf("Playing Song: artist = %-20s title = %s\n", artist, title);		
	}

	//returns the name of the song
	@Override
	public String getName() {
		return getTitle();
	}

	//returns the play time of a song
	@Override
	public int getPlayTimeSeconds() {
		int a = getSeconds() + getMinutes() * 60;
		return a;
	}
	
	@Override
	public int numberOfSongs() {
		return 0;
	}

	//returns artist of a song
	public String getArtist() {
		return artist;
	}
	
	//modifies artist of a song
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	//returns the title of a song
	public String getTitle() {
		return title;
	}
	
	//modifies the title of a song
	public void setTitle(String title) {
		this.title = title;
	}
	
	//returns the minutes of the song
	public int getMinutes() {
		if(this.seconds >= 60){
			this.minutes += this.seconds/60;
		}
		return this.minutes;
	}
	
	//modifies minutes of the song
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	
	//returns seconds of the song
	public int getSeconds() {
		if (this.seconds >= 60) {
			this.seconds =this.seconds%60;}
		return this.seconds;
	}
	
	//modifies seconds of the song
	public void setSeconds(int seconds) {
		int x = seconds;
		if(seconds >= 60){
			seconds = seconds/60;
		}
		this.minutes = this.minutes + seconds;
		this.seconds = x%60;
	}
	
	//determines if 2 songs objects are the same 
	public boolean equals(Object o) {
		if (o instanceof Song) {
			Song s = (Song) o;
			if (s.artist.equals(this.artist) && (s.title.equals(this.title) && (s.minutes == (this.minutes) && (s.seconds == this.seconds)))){
				return true;
			}

		}
		return false;
	}

	//returns a string of a song's title and artist
	public String toString() {
		return "{Song:title = " + title +" " + "artist = " + artist  +'}';
	}
}



