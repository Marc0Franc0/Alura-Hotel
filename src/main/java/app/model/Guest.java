package app.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Guest implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    Date birthdate;
    String nacionalidad;
    String phoneNumber;
    @ManyToOne
    Reserve reserve;

     //Se utiliza para poder mapear la lista deproductosy asi mostrarlos en la tabla

    public Object[] toArray() {

        Object[] obj = new Object[7];

        obj[0] = this.id;
        obj[1] = this.firstName;
        obj[2] = this.lastName;
        obj[3] = this.birthdate;
        obj[4]=this.nacionalidad;
        obj[5]=this.phoneNumber;
        obj[6]=this.reserve.getId();
        return obj;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Reserve getReserve() {
        return reserve;
    }

    public void setReserve(Reserve reserve) {
        this.reserve = reserve;
    }

    public Guest(Long id, String firstName, String lastName, Date birthdate, String nacionalidad, String phoneNumber, Reserve reserve) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.nacionalidad = nacionalidad;
        this.phoneNumber = phoneNumber;
        this.reserve = reserve;
    }
  public Guest( String firstName, String lastName, Date birthdate, String nacionalidad, String phoneNumber, Reserve reserve) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.nacionalidad = nacionalidad;
        this.phoneNumber = phoneNumber;
        this.reserve = reserve;
    }
    public Guest() {
    }

}
