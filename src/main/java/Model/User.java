package Model;

import javax.persistence.*;

@Entity
@Table (name = "user")
public class User {
    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Column(name = "rol")
    public String rol;
    @Column(name = "username")
    public String username;
    @Column(name = "password")
    public String password;

    public User() {
    }

    public User(String rol, String usernamme, String password) {
        this.rol = rol;
        this.username = usernamme;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsernamme(String usernamme) {
        this.username = usernamme;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", rol='" + rol + '\'' +
                ", usernamme='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
