package Project.Implementation;

import Project.DAO.MusicDao;
import Project.Entity.Music;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MusicDaoImplTest {

    MusicDaoImpl musicImplTest;
    MusicDao musicDao;

    Music music;

    @BeforeEach
    void setUp() {
        musicDao = new MusicDao();
        musicImplTest = new MusicDaoImpl();
        music = new Music();
    }

    @AfterEach
    void tearDown() {
        musicImplTest = null;
        musicDao = null;
    }

    @Test
    void showMusicList() throws SQLException {
        List<Music> tempList = musicDao.getAllSong();
        List<Music> tempList2 = musicImplTest.showMusicList(tempList);
        assertEquals(8,tempList2.size());
    }

    @Test
    void searchFromArtist() throws SQLException {
        List<Music> tempList = musicDao.getAllSong();
        List<Music> tempList2 = musicImplTest.searchFromArtist("APdhillon",tempList);
        assertEquals(1,tempList2.size());


    }

    @Test
    void searchFromGenre() throws SQLException {
        List<Music> tempList = musicDao.getAllSong();
        List<Music> tempList2 = musicImplTest.searchFromGenre("Devotional",tempList);
        assertEquals(2,tempList2.size());

    }


    @Test
    void searchFromTitle() throws SQLException {
        List<Music> tempList = musicDao.getAllSong();
        List<Music> tempList2 = musicImplTest.searchFromTitle("PirateOfCaribean",tempList);
        assertEquals(1,tempList2.size());
    }

}