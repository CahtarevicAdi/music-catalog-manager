
package ba.shop;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AlbumDAOImpl implements AlbumDAO {
    private final SessionFactory sessionFactory;

    public AlbumDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void dodajAlbum(Album album) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(album);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void azurirajAlbum(Album album) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(album);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void obrisiAlbum(int ID) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Album album = session.get(Album.class, ID);
            if (album != null) {
                session.delete(album);
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
    public Album dohvatiAlbum(int ID) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Album.class, ID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Album> dohvatiSveAlbume() {
        try (Session session = sessionFactory.openSession()) {
            Query<Album> query = session.createQuery("FROM Album", Album.class);
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
