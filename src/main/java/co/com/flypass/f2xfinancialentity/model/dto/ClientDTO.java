package co.com.flypass.f2xfinancialentity.model.dto;

import co.com.flypass.f2xfinancialentity.enums.IdentificationType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Ing. Danilo Montoya Hernandez;
 * Email: danilo9831montoya@gmail.com
 * @version Id: <b>j2x-financial-entity</b> 09/03/2024, 6:58 PM
 **/
@Data
@AllArgsConstructor
public class ClientDTO {
    private String id;
    private IdentificationType identificationType;
    private String identificationNumber;
    private String name;
    private String lastname;
    private String email;
    private LocalDate birthday;
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;
}
