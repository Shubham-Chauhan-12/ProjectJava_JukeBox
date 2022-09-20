package Project.DAO;

import Project.Connection.ConnectionToDb;
import Project.Entity.Music;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MusicDao {



    static Connection connection = ConnectionToDb.getConnection();

    public  List<Music> getAllSong() throws SQLException {

        String query = "SELECT * FROM Music";

        List<Music> allSongList = new ArrayList<>();

        PreparedStatement pst = connection.prepareStatement(query);
        ResultSet rst = pst.executeQuery();


        while(rst.next()){
            int song_Id = rst.getInt(1);
            String title = rst.getString(2);
            String genre = rst.getString(3);
            String duration = rst.getString(4);
            String artist = rst.getString(5);
            String releaseDate = rst.getString(6);

            allSongList.add(new Music(song_Id,title,genre,duration,artist, releaseDate));
        }

        return allSongList;

    }

}
