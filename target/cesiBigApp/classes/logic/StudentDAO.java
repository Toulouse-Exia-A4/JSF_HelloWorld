package classes.logic;

import javax.ejb.Stateless;
import classes.Student;
import javax.persistence.*;

@Stateless
public class StudentDAO {
    @PersistenceContext(unitName = "bigAppPU")
    private EntityManager em;

    public void insert(Student student)
    {
        em.persist(student);
    }
}
