package app.dto;


import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GuestCreateDTO {
    private String firstName;
    private String lastName;
    private Date birthdate;
    private String nacionalidad;
    private String phoneNumber;
   private Long reserveId;
    
}
