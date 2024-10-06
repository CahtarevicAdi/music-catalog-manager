// ArtistDAO.java
package ba.shop;

import java.util.List;

public interface ArtistDAO {
    void dodajIzvodjaca(Artist artist);
    void azurirajIzvodjaca(Artist artist);
    void obrisiIzvodjaca(int ID);
    Artist dohvatiIzvodjaca(int ID);
    List<Artist> dohvatiSveIzvodjace();
    List<Artist> dohvatiIzvodjacePoTipu(String tip);
    List<Album> dohvatiAlbumePoIzvodjacu(int izvodjacId);
}
