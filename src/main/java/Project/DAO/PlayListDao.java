package Project.DAO;

import Project.Connection.ConnectionToDb;
import Project.Entity.PlayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayListDao {

    static Connection connection = ConnectionToDb.getConnection();

    public  List<PlayList> getAllPlaylist() throws SQLException {

        String query = "SELECT * FROM PlayList";

        List<PlayList> allPlayList = new ArrayList<>();

        PreparedStatement pst = connection.prepareStatement(query);
        ResultSet rst = pst.executeQuery();
        while(rst.next()){
            int playlist_Id = rst.getInt(1);
            String playlist_Name = rst.getString(2);

            allPlayList.add(new PlayList(playlist_Id,playlist_Name));

        }
        return allPlayList;
    }
}
