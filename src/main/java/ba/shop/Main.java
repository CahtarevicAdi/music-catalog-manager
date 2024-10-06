package ba.shop;

public class Main {
    public static void main(String[] args) {
        ArtistDAO artistDAO = new ArtistDAOImpl();

        // 1. Demonstracija CRUD funkcionalnosti
        dodajIzvodjaca(artistDAO);
        azurirajIzvodjaca(artistDAO);
        obrisiIzvodjaca(artistDAO);
        prikaziSveIzvodjace(artistDAO);

        // 2. Dodajte u demonstraciju još dvije funkcionalnosti
        prikaziSoloIzvodjace(artistDAO);
        prikaziIzvodjacePosleGodine(artistDAO);

        // 3. Kreiranje objekata klase Artist za prikazivanje podataka umjesto direktnog ispisivanja iz ResultSet-a
        prikaziSveIzvodjaceKrozObjekte(artistDAO);

        // 4. Demonstracija funkcionalnosti za čitanje i prikazivanje svih albuma izvođača
        prikaziDiscography(artistDAO);

        // 5. Demonstracija funkcionalnosti za čitanje i prikazivanje svih albuma koje je izdala određena izdavačka kuća
        prikaziAlbumeIzdavackeKuce(artistDAO);
    }

    private static void dodajIzvodjaca(ArtistDAO artistDAO) {
        /*Dodavanje novog izvođača
        ArtistDAO artistDAO = new ArtistDAOImpl();
        Artist noviIzvodjac = new Artist(0, "Aerosmith", "Bend", 1986, 2013, "www.aerosmith.com");
        artistDAO.dodajIzvodjaca(noviIzvodjac);*/
    }

    private static void azurirajIzvodjaca(ArtistDAO artistDAO) {
        /*Ažuriranje postojećeg izvođača
        ArtistDAO artistDAO = new ArtistDAOImpl();
        Artist izvodjacZaAzuriranje = artistDAO.dohvatiIzvodjaca(1);
        izvodjacZaAzuriranje.setNaziv("Novo Ime Izvodjaca");
        izvodjacZaAzuriranje.setTip("Solo");
        izvodjacZaAzuriranje.setGodinaFormacije(2000);
        izvodjacZaAzuriranje.setSajt("www.novisajt.com");
        artistDAO.azurirajIzvodjaca(izvodjacZaAzuriranje);*/
    }

    private static void obrisiIzvodjaca(ArtistDAO artistDAO) {
        /*Brisanje postojećeg izvođača
        ArtistDAO artistDAO = new ArtistDAOImpl();
        artistDAO.obrisiIzvodjaca(1);1*/
    }

    private static void prikaziSveIzvodjace(ArtistDAO artistDAO) {
        /*Prikazivanje svih izvođača
        ArtistDAO artistDAO = new ArtistDAOImpl();
        List<Artist> sviIzvodjaci = artistDAO.dohvatiSveIzvodjace();
        for (Artist izvodjac : sviIzvodjaci) {
            System.out.println(izvodjac);*/
    }

    private static void prikaziSoloIzvodjace(ArtistDAO artistDAO) {
        /*Implementacija prikazivanja izvođača čiji je tip "solo"
        List<Artist> soloIzvodjaci = artistDAO.dohvatiSveIzvodjace().stream()
        .filter(artist -> "solo".equalsIgnoreCase(artist.getTip()))
        .collect(Collectors.toList());
        soloIzvodjaci.forEach(System.out::println);*/
    }

    private static void prikaziIzvodjacePosleGodine(ArtistDAO artistDAO) {
        /*Implementacija prikazivanja izvođača formiranih posle zadate godine
        List<Artist> izvodjaciPosleGodine = artistDAO.dohvatiSveIzvodjace().stream()
        .filter(artist -> artist.getGodinaFormacije() > godina)
        .collect(Collectors.toList());
        izvodjaciPosleGodine.forEach(System.out::println);
         */
    }

    private static void prikaziSveIzvodjaceKrozObjekte(ArtistDAO artistDAO) {
        /*Implementacija kreiranja objekata klase Artist za prikazivanje podataka
        List<Artist> izvodjaci = artistDAO.dohvatiSveIzvodjace();
        izvodjaci.forEach(artist -> {
        System.out.println("ID: " + artist.getID());
        System.out.println("Naziv: " + artist.getNaziv());
        System.out.println("Tip: " + artist.getTip());
        System.out.println("Godina formacije: " + artist.getGodinaFormacije());
        System.out.println("Godina raspada: " + artist.getGodinaRaspada());
        System.out.println("Sajt: " + artist.getSajt());
        System.out.println();
        });
         */
    }

    private static void prikaziDiscography(ArtistDAO artistDAO) {
        /*Implementacija funkcionalnosti za čitanje i prikazivanje svih albuma izvođača
        List<Artist> izvodjaci = artistDAO.dohvatiSveIzvodjace();
        izvodjaci.forEach(artist -> {
        System.out.println("Izvođač: " + artist.getNaziv());
        List<Album> albumi = albumDAO.dohvatiSveAlbumeIzvodjaca(artist.getID());
        albumi.forEach(album -> {
        System.out.println("Naslov: " + album.getNaslov());
        System.out.println("Godina izdanja: " + album.getGodinaIzdanja());
        System.out.println("Izdavačka kuća: " + album.getIzdavačkaKuća());
        System.out.println();
        });
    });
         */
    }

    private static void prikaziAlbumeIzdavackeKuce(ArtistDAO artistDAO) {
        /*Implementacija funkcionalnosti za čitanje i prikazivanje svih albuma koje je izdala određena izdavačka kuća
        List<Album> albumi = albumDAO.dohvatiAlbumeIzdavackeKuce(izdavackaKuca);
        albumi.forEach(album -> {
        System.out.println("Naslov: " + album.getNaslov());
        System.out.println("Izvođač: " + album.getIzvodjac().getNaziv());
        System.out.println("Godina izdanja: " + album.getGodinaIzdanja());
        System.out.println();
        });
         */
    }
}




