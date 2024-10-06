package ba.shop;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArtistDAOImplTest {
    private static SessionFactory sessionFactory;

    @BeforeAll
    public static void setUp() {

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception ex) {
            StandardServiceRegistryBuilder.destroy(registry);
            ex.printStackTrace();
        }
    }

    @AfterAll
    public static void tearDown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    @Test
    public void testDodajIzvodjaca() {
        ArtistDAO artistDAO = new ArtistDAOImpl(sessionFactory);

        Artist noviArtist = new Artist();

        assertDoesNotThrow(() -> artistDAO.dodajIzvodjaca(noviArtist));
    }

    @Test
    public void testAzurirajIzvodjaca() {
        ArtistDAO artistDAO = new ArtistDAOImpl(sessionFactory);
        Artist artist = artistDAO.dohvatiIzvodjaca(1);
        assertNotNull(artist);
        artist.setSajt("www.newurl.com");

        assertDoesNotThrow(() -> artistDAO.azurirajIzvodjaca(artist));
    }

    @Test
    public void testObrisiIzvodjaca() {
        ArtistDAO artistDAO = new ArtistDAOImpl(sessionFactory);
        assertDoesNotThrow(() -> artistDAO.obrisiIzvodjaca(3));
    }

    @Test
    public void testDohvatiIzvodjaca() {
        ArtistDAO artistDAO = new ArtistDAOImpl(sessionFactory);
        Artist artist = artistDAO.dohvatiIzvodjaca(2);
        assertNotNull(artist);
        assertEquals("MichaelJackson", artist.getNaziv());
    }

    @Test
    public void testDohvatiSveIzvodjace() {
        ArtistDAO artistDAO = new ArtistDAOImpl(sessionFactory);
        List<Artist> artists = artistDAO.dohvatiSveIzvodjace();
        assertNotNull(artists);
        assertFalse(artists.isEmpty());
    }

    @Test
    public void testDohvatiIzvodjacePoTipu() {
        ArtistDAO artistDAO = new ArtistDAOImpl(sessionFactory);
        List<Artist> soloArtists = artistDAO.dohvatiIzvodjacePoTipu("Solo");
        assertNotNull(soloArtists);
        assertFalse(soloArtists.isEmpty());
        assertEquals(2, soloArtists.size());
    }
}
