package Project.Implementation;

import Project.Entity.Music;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class MusicDaoImpl {


    public  List<Music> showMusicList(List<Music> allSongList) throws SQLException {
        List<Music> showList = new ArrayList<>();
        for(Music content : allSongList){
            showList.add(content);
        }
        displayAllSongList(showList);
        return sortTheList(showList);
    }


    public  List<Music> searchFromArtist(String artistName ,List<Music> allSongList) throws SQLException {
        List<Music> artistList = new ArrayList<>();
        for(Music content : allSongList){
            if(content.getArtistName().equalsIgnoreCase(artistName)){
                artistList.add(content);
            }
        }
        displayAllSongList(artistList);

        return artistList;
    }

    public  List<Music> searchFromGenre(String genreName,List<Music> allSongList) throws SQLException {
        List<Music> genreList = new ArrayList<>();
        for(Music content : allSongList){
            if(content.getGenre().equalsIgnoreCase(genreName)){
                genreList.add(content);
            }
        }
        displayAllSongList(genreList);
        return genreList;
    }

    public  List<Music> searchFromTitle(String titleName ,List<Music> allSongList) throws SQLException {
        List<Music> titleList = new ArrayList<>();

        for(Music content : allSongList){
            if (content.getTitle().equalsIgnoreCase(titleName)){
                titleList.add(content);
            }
        }
        displayAllSongList(titleList);
        return titleList;
    }

    public  List<Music> sortTheList(List<Music> allSongList){

        Comparator<Music> musicComparator = (obj1,obj2) -> CharSequence.compare(obj1.getTitle(),obj2.getTitle());

        Collections.sort(allSongList,musicComparator);
        return allSongList;

    }

    public  void displayAllSongList(List<Music> songsList) throws SQLException {

        if (songsList.isEmpty())
            System.out.format("\n" + "\u001B[31m" + "%20s", "NO SONG AVAILABLE" + "\u001B[0m" + "\n");

        else {
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.format("\u001B[35m" + "%10s %30s %30s %25s %25s %30s",
                    "Song Id", "Title", "Genre", "Duration", "Artist","Release date" + "\u001B[0m" + "\n");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            Consumer<Music> printConsumer = t -> System.out.format
                    ("%10s %30s %30s %25s %25s %30s",
                            t.getSongId(),t.getTitle(),t.getGenre(),t.getDuration(),t.getArtistName(),t.getReleaseDate() + "\n");


            // Song Adding left and Print
            songsList.forEach(printConsumer);
            System.out.println();
        }
    }
}
