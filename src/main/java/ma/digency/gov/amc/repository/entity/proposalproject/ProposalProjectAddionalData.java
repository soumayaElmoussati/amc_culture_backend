package ma.digency.gov.amc.repository.entity.proposalproject;

import lombok.Getter;
import lombok.Setter;
import ma.digency.gov.amc.repository.entity.AcmAbstractEntity;
import ma.digency.gov.amc.repository.entity.shared.NomenclatureValues;
import ma.digency.gov.amc.utils.enumeration.AccountType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class ProposalProjectAddionalData extends AcmAbstractEntity {

    @Column(name = "ref_Project")
    private String refProject;

    @Column(name = "account_type")
    @Enumerated(EnumType.STRING)
    private AccountType typeAccount;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ref_additional_info", referencedColumnName = "id")
    private AdditionalInformation data;

}
