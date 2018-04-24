package classes.logic;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import classes.Student;
import classes.logic.StudentDAO;
import javax.ejb.EJB;

/* Statefull Bean */

@Stateful
public class StudentService implements StudentServiceLocal {
    private Student student = new Student();

    @EJB
    StudentDAO studentDAO;

    @Override
    public void addStudent(String firstname, String lastname) {
        student.setFirstname(firstname);
        student.setLastname(lastname);
        System.out.println("Identité de l'étudiant: " + firstname + " " + lastname);
    }

    @Override
    public void addAuthenticationInformations(String email, String password) {
        student.setEmail(email);
        student.setPassword(password);
        System.out.println("Ajout des informations d'authentification: " + email + " " + password);
    }

    @Override
    @Remove // Indique au container EJB que l'instance du Session Bean associée au client doit être supprimée après invocation de la méthode Save()
    public void Save() {
        studentDAO.insert(student);
        System.out.println("Sauvegarde de l'étudiant créé");
    }
}
