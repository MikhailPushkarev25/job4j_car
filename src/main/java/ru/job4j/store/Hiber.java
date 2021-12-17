package ru.job4j.store;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.job4j.model.*;

import java.util.List;
import java.util.function.Function;

public class Hiber implements Store, AutoCloseable {

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    private Hiber() {
    }

    private static final class Lazy {
        private static final Store inst = new Hiber();
    }

    public static Store instOf() {
        return Lazy.inst;
    }

    private <T> T tx(final Function<Session, T> command) {
        final Session session = sf.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            T rsl = command.apply(session);
            tx.commit();
            return rsl;
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public List<BodyType> bodyTypesAll() {
        return this.tx(
                session -> session.createQuery("from BodyType", BodyType.class).list()
        );
    }

    @Override
    public List<Color> colorsAll() {
        return this.tx(
                session -> session.createQuery("from Color", Color.class).list()
        );
    }

    @Override
    public List<Mark> marksAll() {
        return this.tx(
                session -> session.createQuery("from Mark", Mark.class).list()
        );
    }

    @Override
    public void saveItem(Item item) {
        this.tx(session -> session.save(item));
    }

    public List<Item> itemJoin() {
        return this.tx(session ->
                session.createQuery(
                        "select distinct it from Item it left outer join fetch it.photos order by it.done, it.created desc", Item.class
                ).list());
    }

    @Override
    public void updateItem(int id) {
        this.tx(
                session -> {
            session.get(Item.class, id).setDone(true);
        return true;
        }
        );
    }

    @Override
    public User usersEmail(String email) {
        return this.tx(session ->
            session.createQuery("select u from User u where u.email=:uemail", User.class)
                    .setParameter("uemail", email).uniqueResult()
        );
    }

    @Override
    public void saveUser(User user) {
        this.tx(session -> session.save(user));
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
