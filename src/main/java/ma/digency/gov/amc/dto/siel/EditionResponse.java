package ma.digency.gov.amc.dto.siel;

import lombok.Getter;
import lombok.Setter;
import ma.digency.gov.amc.utils.enumeration.StatusEnum;
import ma.digency.gov.amc.utils.validation.annotation.NotEmptyString;

import java.time.LocalDate;

@Getter
@Setter
public class EditionResponse {

    private String refEdition;

    @NotEmptyString
    private String name;

    private LocalDate startedDate;

    private LocalDate endDate;

    private StatusEnum status;

    private String address;

    private String rib;
}
