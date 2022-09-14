package ma.digency.gov.amc.dto.card;

import lombok.Getter;
import lombok.Setter;
import ma.digency.gov.amc.utils.enumeration.AccountType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
@Getter
@Setter
public class AccountResponse {

    private String refAccount;
    private String firstName;
    private String lastName;
    private String cin;
    private String login;
    private String email;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;






}
