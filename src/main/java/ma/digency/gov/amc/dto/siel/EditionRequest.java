package ma.digency.gov.amc.dto.siel;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
public class EditionRequest {

    @NotBlank
    private String name;

    private LocalDate startedDate;

    private LocalDate endDate;

    private String address;

    private String rib;

}
