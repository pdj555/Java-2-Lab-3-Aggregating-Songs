import java.util.Arrays;

public class Playlist {
	private Song[] songs;
	private int numSongs;
	final private static int MIN_CAPACITY = 3;
	
	public Playlist() {
		songs = new Song[MIN_CAPACITY];
		numSongs = 0;
	}
	
	public Playlist(int capacity) {
		numSongs = 0;
		
		if (capacity < MIN_CAPACITY) {
			songs = new Song[MIN_CAPACITY];
		}
		else {
			songs = new Song[capacity];
		}
	}
	
	public int getCapacity() {
		return songs.length;
	}
	
	public int getNumSongs() {
		return numSongs;
	}
	
	public Song getSong(int index) {
		if (index < 0 || index > (numSongs - 1)) {
			return null;
		}
		
		return songs[index];
	}
	
	public Song[] getSongs() {
		return Arrays.copyOf(songs, numSongs);
	}
	
	public boolean addSong(Song song) {
		if (numSongs != songs.length) {
			addSong(numSongs, song);
			return true;
		}
		return false;
		
	}
	
	public boolean addSong(int index, Song song) {
		if (songs[index] != null && song == null && index < 0 && index > songs.length) {
			songs[index] = song;
			++numSongs;
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public int addSongs(Playlist playlist) {
		int sA = 0;
		if (playlist == null || playlist.getNumSongs() == 0) {
			return 0;
		}
		else {
			Song[] nA = Arrays.copyOf(playlist.getSongs(), playlist.getNumSongs());
			
			for (int i = 0; i < (playlist.getCapacity() - playlist.getNumSongs()); i++) {
				addSong(nA[i]);
				sA++;
			}
			return sA;
		}
	}
	
	public Song removeSong() {
		return removeSong(numSongs - 1);
		
		for (int i = 0; i < )
	}
	
	public Song removeSong(int index) {
		if (index >= numSongs || index < 0) {
			return null;
		}
		
		Song x = songs[index]; 
		
		for (int i = index; i < numSongs - 1; ++i) {
			songs[i] = songs[i + 1];
		}
		
		songs[numSongs - 1] = null;
		--numSongs;
		
		return x;
	}
}
