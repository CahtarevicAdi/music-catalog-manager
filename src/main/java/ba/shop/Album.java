// Album.java
package ba.shop;

import javax.persistence.*;

@Entity
@Table(name = "Album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @Column(name = "naslov")
    private String naslov;

    @Column(name = "godina_izdanja")
    private int godinaIzdanja;

    @Column(name = "izdavacka_kuca")
    private String izdavackaKuca;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public ba.shop.Artist getArtist() {
        return artist;
    }

    public void setArtist(ba.shop.Artist artist) {
        this.artist = artist;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public int getGodinaIzdanja() {
        return godinaIzdanja;
    }

    public void setGodinaIzdanja(int godinaIzdanja) {
        this.godinaIzdanja = godinaIzdanja;
    }

    public String getIzdavackaKuca() {
        return izdavackaKuca;
    }

    public void setIzdavackaKuca(String izdavackaKuca) {
        this.izdavackaKuca = izdavackaKuca;
    }
}
