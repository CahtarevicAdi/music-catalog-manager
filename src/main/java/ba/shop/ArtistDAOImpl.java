// ArtistDAOImpl.java
package ba.shop;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ArtistDAOImpl implements ArtistDAO {
    private final SessionFactory sessionFactory;

    public ArtistDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void dodajIzvodjaca(Artist artist) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(artist);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void azurirajIzvodjaca(Artist artist) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(artist);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void obrisiIzvodjaca(int ID) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Artist artist;
            artist = session.get(Artist.class, ID);
            if (artist != null) {
                session.delete(artist);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Artist dohvatiIzvodjaca(int ID) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Artist.class, ID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Artist> dohvatiSveIzvodjace() {
        try (Session session = sessionFactory.openSession()) {
            Query<Artist> query = session.createQuery("FROM Artist", Artist.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Artist> dohvatiIzvodjacePoTipu(String tip) {
        try (Session session = sessionFactory.openSession()) {
            Query<Artist> query = session.createQuery("FROM Artist WHERE tip = :tip", Artist.class);
            query.setParameter("tip", tip);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Album> dohvatiAlbumePoIzvodjacu(int izvodjacId) {
        try (Session session = sessionFactory.openSession()) {
            Query<Album> query = session.createQuery("FROM Album WHERE artist.id = :izvodjacId", Album.class);
            query.setParameter("izvodjacId", izvodjacId);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
