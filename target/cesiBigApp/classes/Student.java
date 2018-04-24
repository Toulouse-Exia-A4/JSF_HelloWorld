package classes;

import javax.persistence.*;

@Entity
@Table(name = "etudiants")
public class Student {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long studentId;
    @Column(name = "prenom")
    private String firstname;
    @Column(name = "nom")
    private String lastname;
    @Column(name = "email")
    private String email;
    @Column(name = "motdepasse")
    private String password;

    public Long getStudentId() {
        return studentId;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getFirstname()
    {
        return this.firstname;
    }

    public String getLastname()
    {
        return  this.lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
