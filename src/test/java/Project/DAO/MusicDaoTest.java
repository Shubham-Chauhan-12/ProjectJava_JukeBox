package Project.DAO;

import Project.Entity.Music;
import Project.Implementation.MusicDaoImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MusicDaoTest {

    MusicDao musicDao;
    MusicDaoImpl musicDaoImpl;

    @BeforeEach
    void setUp() {
        musicDao = new MusicDao();
        musicDaoImpl = new MusicDaoImpl();
    }

    @AfterEach
    void tearDown() {
        musicDao = null;
    }

    @Test
    void getAllSong() throws SQLException {
        List<Music> testList = musicDao.getAllSong();
        assertEquals(8,testList.size());
    }
}