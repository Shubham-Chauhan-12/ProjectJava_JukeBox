package Project.Main;

import Project.AudioPlayer.AudioStream;
import Project.DAO.MusicDao;
import Project.DAO.PlayListDao;
import Project.Entity.Music;
import Project.Entity.PlayList;
import Project.Implementation.MusicDaoImpl;
import Project.Implementation.PlayListDaoImpl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class Main {

    static Scanner scanner = new Scanner(System.in);
    static AudioStream audioStream = new AudioStream();

    public static void main(String[] args) throws SQLException, UnsupportedAudioFileException, LineUnavailableException, IOException {
        int choice;
        do {
            System.out.println();
            System.out.println("================================================================================================================================================================================");
            System.out.println("<--------------------------------------------------------||            WELCOME   TO    JUKEBOX   PLAYER            ||---------------------------------------------------------->");
            System.out.println("================================================================================================================================================================================");
            System.out.println();
            System.out.println("TYPE ---->                   [ 1 - Play Songs ]                          [ 2 - Playlist ]                        [ 3 - Exit ]");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Enter the Choice ?");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    MusicDao dao1 = new MusicDao();
                    List<Music> musicList = dao1.getAllSong();
                    MusicDaoImpl daoImpl1 = new MusicDaoImpl();

                    char response;
                    do {
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("TYPE ---->     A - Display All Song    ||    " + " B - Search By Artist    ||    " +
                                " C- Search By Genre    ||    " + " D - Search By Title    ||    " +
                                " E - Exit from Song Menu");
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        response = scanner.next().charAt(0);
                        switch (response) {

                            case 'A':
                                daoImpl1.displayAllSongList(musicList);
                                System.out.println("Enter the Song Id from the Above List");
                                int songNo = scanner.nextInt();
                                audioStream.playPlayer(songNo);
                                while (true) {
                                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                                    System.out.println("<---------------------------------------P - Play || Q - Pause || L - Previous || F - Next Song || R - Resume Song || S - Stop || E - Exit---------------------------------------->");
                                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                                    char res = scanner.next().charAt(0);
                                    audioStream.gotoPlayerChoice(res);
                                    if (res == 'E')
                                        break;
                                }

                                break;

                            case 'B':
                                System.out.println("Enter the Artist name");
                                scanner.nextLine();
                                String artist = scanner.nextLine();
                                daoImpl1.searchFromArtist(artist, musicList);
                                System.out.println("Enter the Song Id from the Above List");
                                songNo = scanner.nextInt();
                                audioStream.playPlayer(songNo);
                                while (true) {
                                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                                    System.out.println("<---------------------------------------P - Play || Q - Pause || L - Previous || F - Next Song || R - Resume Song || S - Stop || E - Exit---------------------------------------->");
                                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                                    char res = scanner.next().charAt(0);
                                    audioStream.gotoPlayerChoice(res);
                                    if (res == 'E')
                                        break;
                                }
                                break;

                            case 'C':
                                System.out.println("Enter the Genre");
                                scanner.nextLine();
                                String genre = scanner.next();
                                daoImpl1.searchFromGenre(genre, musicList);
                                System.out.println("Enter the Song Id from the Above List");
                                songNo = scanner.nextInt();
                                audioStream.playPlayer(songNo);
                                while (true) {
                                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                                    System.out.println("<---------------------------------------P - Play || Q - Pause || L - Previous || F - Next Song || R - Resume Song || S - Stop || E - Exit---------------------------------------->");
                                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                                    char res = scanner.next().charAt(0);
                                    audioStream.gotoPlayerChoice(res);
                                    if (res == 'E')
                                        break;
                                }
                                break;

                            case 'D':
                                System.out.println("Enter the Music Title");
                                scanner.nextLine();
                                String title = scanner.nextLine();
                                daoImpl1.searchFromTitle(title, musicList);
                                System.out.println("Enter the Song Id from the Above List");
                                songNo = scanner.nextInt();
                                audioStream.playPlayer(songNo);
                                while (true) {
                                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                                    System.out.println("<---------------------------------------P - Play || Q - Pause || L - Previous || F - Next Song || R - Resume Song || S - Stop || E - Exit---------------------------------------->");
                                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                                    char res = scanner.next().charAt(0);
                                    audioStream.gotoPlayerChoice(res);
                                    if (res == 'E')
                                        break;
                                }
                                break;

                            case 'E':
                                System.out.println("Exiting from Song Menu ........");
                                break;


                            default:
                                System.out.println("Wrong-Input ( Please Gave a Valid Input )!");
                        }
                    } while (response != 'E');
                    break;
                case 2:char response2;
                    do {
                    PlayListDao dao2 = new PlayListDao();
                    List<PlayList> playLists = dao2.getAllPlaylist();
                    PlayListDaoImpl daoImpl2 = new PlayListDaoImpl();
                    List<PlayList> newplaylist = daoImpl2.showAllPlaylist(playLists);


                        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("TYPE ----> A - Display All Playlist  ||  " + "B - Create PlayList  ||  " + "C- Add Song to Playlist  ||  " +
                                "D-Display Any Particular Playlist  ||  " + "E-Play Song From the Playlist  " +"|| F-Exit");
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        response2 = scanner.next().charAt(0);
                        switch (response2) {
                            case 'A':
                                dao2.getAllPlaylist();
                                daoImpl2.showAllPlaylist(playLists);
                                daoImpl2.displayAllPlaylist(newplaylist);
                                break;

                            case 'B':
                                System.out.println("Enter the Name and Id For Playlist Creation");
                                System.out.println("Enter the ID ?");
                                int id = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Enter the Name ?");
                                String playName = scanner.nextLine();
                                daoImpl2.createAPlaylist(id, playName);
                                break;

                            case 'C':
                                char entry = 0;

                                do {
                                    System.out.println("Do You Want to Add More Songs\n" +
                                            "Type --> Y - Yes    ||    N - No");
                                    entry = scanner.next().charAt(0);

                                    switch (entry) {

                                        case 'Y':
                                            dao2.getAllPlaylist();
                                            daoImpl2.showAllPlaylist(playLists);
                                            daoImpl2.displayAllPlaylist(newplaylist);
                                            System.out.println("Enter the Playlist ID from options");
                                            int pid = scanner.nextInt();
                                            MusicDao dao12 = new MusicDao();
                                            List<Music> musicList2 = dao12.getAllSong();
                                            MusicDaoImpl daoImpl3 = new MusicDaoImpl();
                                            daoImpl3.displayAllSongList(musicList2);
                                            System.out.println("Enter the Song Id for Adding");
                                            int songid = scanner.nextInt();
                                            daoImpl2.addSongToPlaylist(pid, songid);
                                            break;

                                        case 'N':
                                            break;

                                        default:
                                            System.out.println("Invalid Input Please Try Again !....");
                                    }

                                } while (entry != 'N');
                                break;

                            case 'D':
                                System.out.println("Enter the PlayList Id to Display");
                                int pid2 = scanner.nextInt();
                                dao2.getAllPlaylist();
                                daoImpl2.displayIndividualPlayList(pid2);
                                break;

                            case 'E':dao2.getAllPlaylist();
                                daoImpl2.displayAllPlaylist(newplaylist);
                                System.out.println("Enter the Playlist ID To view Song List");
                                int pid3 = scanner.nextInt();
                                daoImpl2.displayPlaylistData(pid3);
                                System.out.println("Enter the Song Id from the Above List");
                                int songNo = scanner.nextInt();
                                audioStream.playPlayer(songNo);
                                while (true) {
                                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                                    System.out.println("<---------------------------------------P - Play || Q - Pause || L - Previous || F - Next Song || R - Resume Song || S - Stop || E - Exit---------------------------------------->");
                                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                                    char res = scanner.next().charAt(0);
                                    audioStream.gotoPlayerChoice(res);
                                    if (res == 'E')
                                        break;
                                }
                                break;

                            case 'F': break;

                            default:
                                System.out.println("wrong Input Try again");
                        }

                    } while (response2 != 'F') ;


                case 3:
                    System.out.println("Exiting .............From Juke-box");
                    break;
                default:
                    System.out.println("Please try Again with valid choice");

            }
        } while (choice != 3);
    }
}



 
