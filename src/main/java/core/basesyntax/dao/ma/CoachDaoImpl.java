package core.basesyntax.dao.ma;

import core.basesyntax.model.ma.Coach;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class CoachDaoImpl extends PersonDaoImpl implements CoachDao {
    public CoachDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<Coach> findByExperienceGreaterThan(int years) {
        String query = "From Coach c where c.experience > :years";
        try (Session session = sessionFactory.openSession()) {
            Query<Coach> sessionQuery = session.createQuery(query, Coach.class);
            sessionQuery.setParameter("years", years);
            return sessionQuery.getResultList();
        }
    }
}
