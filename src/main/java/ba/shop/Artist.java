
package ba.shop;

import javax.persistence.*;

@Entity
@Table(name = "Artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;

    @Column(name = "naziv")
    private String naziv;

    @Column(name = "tip")
    private String tip;

    @Column(name = "godina_formacije")
    private int godinaFormacije;

    @Column(name = "godina_raspada")
    private Integer godinaRaspada;

    @Column(name = "sajt")
    private String sajt;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public int getGodinaFormacije() {
        return godinaFormacije;
    }

    public void setGodinaFormacije(int godinaFormacije) {
        this.godinaFormacije = godinaFormacije;
    }

    public Integer getGodinaRaspada() {
        return godinaRaspada;
    }

    public void setGodinaRaspada(Integer godinaRaspada) {
        this.godinaRaspada = godinaRaspada;
    }

    public String getSajt() {
        return sajt;
    }

    public void setSajt(String sajt) {
        this.sajt = sajt;
    }
}
