package classes;

import classes.logic.StudentServiceLocal;

import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import javax.ejb.EJB;

@Named(value="studentModel")
@SessionScoped
public class StudentBean implements Serializable {

    private String firstname,lastname,email, password;

    @EJB // dans le WS : @Inject (n'est pas tout le temps reconnu par les IDE)
    private StudentServiceLocal studentService;

    //méthodes d'action
    public String addIdentity(){
        System.out.println(firstname+" "+lastname);
        studentService.addStudent(firstname, lastname);
        return "authentication";
    }

    public String addAuthentication(){
        System.out.println(email+" "+password);
        studentService.addAuthenticationInformations(email, password);
        return "summary";
    }

    public String create(){
        System.out.println("création de l'étudiant");
        studentService.Save();

        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
        return "index";    }

    //getters & setters
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}