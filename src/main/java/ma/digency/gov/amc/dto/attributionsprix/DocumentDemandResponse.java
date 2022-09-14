package ma.digency.gov.amc.dto.attributionsprix;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentDemandResponse {

    private String refDocument;

    private String type;

    private String name;

    private String nature;

    private byte[] data;

}
