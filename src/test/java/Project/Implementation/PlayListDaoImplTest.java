package Project.Implementation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class PlayListDaoImplTest {

    PlayListDaoImpl plaDaoImplTest;


    @BeforeEach
    void setUp() {
        plaDaoImplTest = new PlayListDaoImpl();
    }

    @AfterEach
    void tearDown() {
        plaDaoImplTest = null;
    }

    @Test
    void addSongToPlaylist() throws SQLException {
        assertEquals(true,plaDaoImplTest.addSongToPlaylist(2,3));
        assertEquals(true,plaDaoImplTest.addSongToPlaylist(1,3));

    }
}