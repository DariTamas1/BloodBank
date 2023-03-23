package Model;

import javax.persistence.*;

@Entity
public class Doctor{

    @Id

    @Column(name = "doctorId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    public Doctor() {
    }

    public Doctor(String name, String email, String address, User user) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return user.getUsername();
    }
    public String getPassword() {
        return user.getPassword();
    }

    public int getUserId() {
        return user.getId();
    }
}
