/*
Input:
user = {  
   "David": ["song1", "song2", "song3", "song4", "song8"],
   "Emma":  ["song5", "song6", "song7"]
},
Genres = {  
   "Rock":    ["song1", "song3"],
   "Dubstep": ["song7"],
   "Techno":  ["song2", "song4"],
   "Pop":     ["song5", "song6"],
   "Jazz":    ["song8", "song9"]
}

Output: {  
   "David": ["Rock", "Techno"],
   "Emma":  ["Pop"]
}
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Approach is simple: initialize a mapping of songsToGenre.
// Then, using our mapping, we iterate through each song (we don't know if songs have multiple genres, so we handle that here), and count up the genres while keeping a 'maximum count'.
// After that, we find out all of the songs that are equal to our maximum mapping. 

class Solution {
	public Map<String, List<String>> favoriteGenre (Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
		// name, genres
        Map<String, List<String>> result = new HashMap<>();
        // songName, genres
        Map<String, List<String>> songsToGenre = new HashMap<>();
        
        // Initialize songsToGenre
        for (String genre : genreMap.keySet()) {
            List<String> songList = genreMap.get(genre);
            for (String song : songList) {
                if(songsToGenre.containsKey(song)) {
                    songsToGenre.get(song).add(genre);   // add a new genre to the list.
                }
                else {
                    List<String> songGenres = new ArrayList<String>(); // initialize list of songs, and add to list
                    songGenres.add(genre);
                    songsToGenre.put(song, songGenres);
                }
            }
        }
        
        // Iterate through userMap, lookup song, and keep a running count for each genre that appears for each song.
        for (String user : userMap.keySet()) {
            List<String> favoriteSongs = userMap.get(user);
            
            // <Genre, Count>
            Map<String, Integer> genreCount = new HashMap<>();
            int maxCount = 0;
            List<String> favoriteGenres = new ArrayList<String>();

            for(String song : favoriteSongs) {
                if(songsToGenre.containsKey(song)) { 
                    // Loop through every genre, iterate the count. While we iterate, we check if it's the max value.
                    List<String> genresInSong = songsToGenre.get(song);
                    for (String genre : genresInSong) {
                        if(genreCount.containsKey(genre)) {
                            genreCount.replace(genre, genreCount.get(genre) + 1); // just iterate by 1
                            
                            // if the getCount is the same as the maxCount, go ahead and add it in to the list.
                            if(maxCount == genreCount.get(genre)) {
                                favoriteGenres.add(genre);
                            }
                            // otherwise, clear the favorite genre list, and update the list. 
                            else if ( maxCount < genreCount.get(genre)) {
                                favoriteGenres.clear();
                                maxCount = genreCount.get(genre);
                                favoriteGenres.add(genre);
                            }
                        }
                        else {
                            genreCount.put(genre, 1);
                        }
                    }
                }
            }
            
            result.put(user, favoriteGenres);
        }
        
        return result;
    }
}


public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> userMap = new HashMap<>();
		List<String> list1 = Arrays.asList("song1", "song2", "song3", "song4", "song8");
		List<String> list2 = Arrays.asList("song5", "song6", "song7");
		userMap.put("David", list1);
		userMap.put("Emma", list2);
		
		Map<String, List<String>> genreMap = new HashMap<>();
		List<String> list3 = Arrays.asList("song1", "song3");
		List<String> list4 = Arrays.asList("song7");
		List<String> list5 = Arrays.asList("song2", "song4");
		List<String> list6 = Arrays.asList("song5", "song6");
		List<String> list7 = Arrays.asList("song8", "song9");
		genreMap.put("Rock", list3);
		genreMap.put("Dubstep", list4);
		genreMap.put("Techno", list5);
		genreMap.put("Pop", list6);
		genreMap.put("Jazz", list7);
        
        /*Map<String, List<String>> userMap = new HashMap<>();
		List<String> list1 = Arrays.asList("song1", "song2");
		List<String> list2 = Arrays.asList("song3", "song4");
		userMap.put("David", list1);
		userMap.put("Emma", list2);
		
		Map<String, List<String>> genreMap = new HashMap<>();*/
        
        System.out.println(new Solution().favoriteGenre(userMap, genreMap));
    }
}
