package ma.digency.gov.amc.repository.entity.proposalproject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.digency.gov.amc.repository.entity.AcmAbstractAuditEntity;
import ma.digency.gov.amc.utils.enumeration.StatusEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AdditionalInformation extends AcmAbstractAuditEntity {

    @Column(name = "ref_additional_info")
    private String refAdditionalInformation;

    private String typeColumn;

    private boolean isObligatoire;

    private boolean isDisplayed;

    private String nameFr;

    private String nameAr;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

}
