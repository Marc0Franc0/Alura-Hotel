package app.dto;


import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReserveDTO {
    private Date entryDate;
    private Date departureDate;
    private Double value;
    private String paymentMethod;
    
}
