package ma.digency.gov.amc.dto.searchParticipant;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
public class AuthorSearchCriteria {


    private String fullName;


    private String city;


    private String gender;


    private String email;
}
