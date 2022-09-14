package ma.digency.gov.amc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
@AllArgsConstructor
public class WarningResponse {

    private HashMap<Integer,String> warnings;

}
