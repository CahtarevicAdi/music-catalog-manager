// AlbumDAO.java
package ba.shop;

import java.util.List;

public interface AlbumDAO {
    void dodajAlbum(Album album);
    void azurirajAlbum(Album album);
    void obrisiAlbum(int ID);
    Album dohvatiAlbum(int ID);
    List<Album> dohvatiSveAlbume();
    List<Album> dohvatiAlbumePoIzvodjacu(int izvodjacId);
}
