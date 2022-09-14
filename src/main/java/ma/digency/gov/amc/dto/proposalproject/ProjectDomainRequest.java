package ma.digency.gov.amc.dto.proposalproject;

import lombok.Getter;
import lombok.Setter;
import ma.digency.gov.amc.utils.enumeration.DomainComponent;

@Getter
@Setter
public class ProjectDomainRequest {

    private String shortName;

    private String longName;

    private String shortNameAr;

    private String longNameAr;

    DomainComponent component;

}
