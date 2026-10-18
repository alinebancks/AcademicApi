package app;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phoneNumber;
    private String emailAddress;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

    public Person() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getEmailAddress() { return emailAddress; }
    public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
    public List<Address> getAddresses() { return addresses; }
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
        if (addresses != null) {
            for (Address address : addresses) {
                address.setPerson(this);
            }
        }
    }
}