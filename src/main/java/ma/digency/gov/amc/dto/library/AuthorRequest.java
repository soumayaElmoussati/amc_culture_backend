package ma.digency.gov.amc.dto.library;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@Validated
public class AuthorRequest {

    @NotBlank
    private String fullName;

    @NotBlank
    private String gender;

    private LocalDate birthDate;

    private LocalDate dateOfDeath;

    @NotBlank
    private String address;

    @NotBlank
    private String countryOfResidence;

    @NotBlank
    private String city;

    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String fax;

    @Email
    private String email;

    private String webPage;

    private String biography;

    private String writingLanguage;

    private String areasOfWriting;

    private String publishedBooks;

    private String publishedArticles;

    private byte[] picture;

}
