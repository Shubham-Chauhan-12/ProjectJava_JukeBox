package Project.Implementation;

import Project.Connection.ConnectionToDb;
import Project.Entity.PlayList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class PlayListDaoImpl {

    static Connection connection = ConnectionToDb.getConnection();

    public  List<PlayList> showAllPlaylist(List<PlayList> allPlaylist) throws SQLException {

        List<PlayList> showPlaylist = new ArrayList<>();
        for (PlayList content : allPlaylist) {
            showPlaylist.add(content);
        }
       // displayAllPlaylist(allPlaylist);
        return showPlaylist;

    }
    public void displayAllPlaylist(List<PlayList> allPlaylist) throws SQLException {

        if (allPlaylist.isEmpty())
            System.out.format("\n" + "\u001B[31m" + "%20s", "NO Playlist AVAILABLE" + "\u001B[0m" + "\n");

        else {
            System.out.format("\u001B[35m" + "%30s %50s",
                    "PlayList Id", "PlayList Name"+ "\u001B[0m" + "\n");
            Consumer<PlayList> printConsumer = obj -> System.out.format
                    ("%30s %45s", obj.getPlaylistId(), obj.getPlaylistName()+ "\n");
            System.out.println();

            //url adding left
            allPlaylist.forEach(printConsumer);
        }
    }


    public  void createAPlaylist(int playListId ,String playListName) throws SQLException {

        String query = "INSERT INTO PlayList(Playlist_Id,Playlist_Name) VALUES(?,?)";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setInt(1,playListId);
        pst.setString(2, playListName);
        int response = pst.executeUpdate();

        if (response > 0) {
            System.out.println("\u001B[32m" +"Playlist SuccessFully Created "+"\u001B[0m");
        } else System.out.println("\u001B[31m"+"Playlist Not Created"+"\u001B[0m");
    }

    public void displayIndividualPlayList(int playListId) {
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select Playlist_Id,Playlist_Name from Playlist where Playlist_Id =" + playListId);
            System.out.printf("%30s %50s\n","\u001B[35m" + "PlayList Id", "PlayList Name"+"\u001B[0m");
            while (rs.next()) {
                System.out.printf("%27s %40s\n", rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }

    }

    public  boolean addSongToPlaylist(int playlistId, int SongId) throws SQLException {
        String query = "INSERT INTO PlaylistData VALUES (?,?)";
                            PreparedStatement pst = connection.prepareStatement(query);
                            pst.setInt(1, playlistId);
                            pst.setInt(2, SongId);

                            int response = pst.executeUpdate();
                            if (response > 0) {
                            System.out.println("\u001B[32m" +"Song Added Successfully."+"\u001B[0m");
                            }
                            else {
                                System.out.println("\u001B[31m" +"Playlist Not Found"+"\u001B[0m");
                                return false;
                            }

        return true;
    }

    public void displayPlaylistData(int playlistId) throws  SQLException {
        try {

            System.out.printf("%-30s %30s\n","\u001B[35m" + "Song_Id", "Song_Title"+"\u001B[0m");
            Statement s = connection.createStatement();
            Statement s1 = connection.createStatement();
            ResultSet rs = s.executeQuery("select song_id from playlistdata where Playlist_Id=" + playlistId);
            while (rs.next()) {
                ResultSet rs1 = s1.executeQuery("select song_id,title from music where Song_Id = " + rs.getInt(1));
                while (rs1.next()) {
                    System.out.printf("%-30s %20s\n", rs1.getInt(1), rs1.getString(2));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





}
