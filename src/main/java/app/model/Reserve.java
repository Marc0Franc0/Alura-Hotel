package app.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.ToString;

@Entity
@ToString
public class Reserve implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date entryDate;
    private Date departureDate;
    private Double value;
    private String paymentMethod;

    public Reserve(Long id, Date entryDate, Date departureDate, Double value, String paymentMethod) {
        this.id = id;
        this.entryDate = entryDate;
        this.departureDate = departureDate;
        this.value = value;
        this.paymentMethod = paymentMethod;
    }

    public Reserve(Date entryDate, Date departureDate,
            Double value, String paymentMethod) {
        this.entryDate = entryDate;
        this.departureDate = departureDate;
        this.value = value;
        this.paymentMethod = paymentMethod;
    }
    //Se utiliza para poder mapear la lista deproductosy asi mostrarlos en la tabla

    public Object[] toArray() {

        Object[] obj = new Object[5];

        obj[0] = this.id;
        obj[1] = this.entryDate;
        obj[2] = this.departureDate;
        obj[3] = this.value;
        obj[4]=this.paymentMethod;
        return obj;
    }

    public Reserve() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

}
