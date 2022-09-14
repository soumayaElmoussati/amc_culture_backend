package ma.digency.gov.amc.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentResponse {


    private String type;

    private String name;

    private byte[] data;


}
