package Project.Entity;


public class Music {

    private int songId;
    private String title;
    private String genre;
    private String duration;
    private String artistName;
    private String releaseDate;

    public Music() {
    }

    public Music(int songId, String title, String genre, String duration, String artistName, String releaseDate) {
        this.songId = songId;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.artistName = artistName;
        this.releaseDate = releaseDate;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Music{" +
                "songId=" + songId +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", duration='" + duration + '\'' +
                ", artistName='" + artistName + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
}
