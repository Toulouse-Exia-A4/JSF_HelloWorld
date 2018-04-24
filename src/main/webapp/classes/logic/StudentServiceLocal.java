package classes.logic;

import javax.ejb.Local;

@Local
public interface StudentServiceLocal {
    public void addStudent(String firstname, String lastname);
    public void addAuthenticationInformations(String email, String password);
    public void Save();
}
