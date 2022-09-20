package Project.AudioPlayer;

import Project.Connection.ConnectionToDb;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AudioStream {
    private File file ;
    private AudioInputStream audioInputStream;
    private Clip clip;

    int songNo;


    public void playPlayer(int songId) throws SQLException, UnsupportedAudioFileException, IOException, LineUnavailableException {
        songNo = songId; // updating for previous Id
        Connection connection = ConnectionToDb.getConnection();
        Statement statement= connection.createStatement();
        ResultSet resultSet = statement.executeQuery("Select title from music where song_Id = " + songId + ";");

        if (resultSet.next()) {
            file = new File("src/main/resources/" + resultSet.getString("title")+".wav");
            audioInputStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            System.out.println("\nCurrent Playing Song : "+resultSet.getString("title"));
            clip.start();

        }

    }
    public void pauseThePlayer() {
        clip.stop();
    }


    public void resumeAudio() {
        clip.start();
    }


    public void closePlayer(){
        clip.close();
    }

    public void stopThePlayer() {
        long currentFrame = 0L;
        clip.stop();
        clip.close();
    }

    public void gotoPlayerChoice(char resp) throws IOException, LineUnavailableException, UnsupportedAudioFileException, SQLException {


        switch (resp)
        {
            case 'P':
                playPlayer(songNo);
                break;
            case 'Q':
                pauseThePlayer();
                break;
            case 'L': stopThePlayer();
                if(songNo>0){
                playPlayer(songNo-1);
                }
                else System.out.println("Your Current Song is 1st Song of the List");
                break;
            case 'F': stopThePlayer();
                if(songNo < 8) {

                    playPlayer(songNo+1);
                }
                else System.out.println("Your Current song is the Last Song of the List");
                break;

            case 'R': resumeAudio();
                break;
            case 'S':  stopThePlayer();
                break;
            case 'E' :
                stopThePlayer();
                System.out.println("Exiting !.......From Player");
                break;
            default: System.out.println("Please Enter the Correct Input");



        }


    }
}
