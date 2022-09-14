package ma.digency.gov.amc.service.attributionsPrix1;

import ma.digency.gov.amc.repository.entity.Demand;
import ma.digency.gov.amc.repository.entity.attributionsPrix1.DemandPrice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DemandPriceService {

    DemandPrice createOrUpdateDemandPrice(DemandPrice demandPrice);

    DemandPrice findDemandPriceByRef(String refDemand);

    Void deleteDemandPrice(DemandPrice demandPrice);

    Page<DemandPrice> findDemandPageableAwardHassan2(Pageable pageable);

    Page<DemandPrice> findDemandPageableAwardHonorary(Pageable pageable);

    Page<DemandPrice> findDemandPageableAwardTheater(Pageable pageable);

    Page<DemandPrice> findDemandPageableAwardBook(Pageable pageable);

    List<DemandPrice> findAllDemandAwardHassa2();

    List<DemandPrice> findAllDemandAwardHassan2ByRefArtistAccount(String refArtistAccount);

    List<DemandPrice> findAllDemandAwardTheater();

    List<DemandPrice> findAllDemandAwardTheaterByRefArtistAccount(String refArtistAccount);

    List<DemandPrice> findAllDemandAwardHonorary();

    List<DemandPrice> findAllDemandAwardHonoraryByRefArtistAccount(String refArtistAccount);

    List<DemandPrice> findAllDemandAwardBook();

    List<DemandPrice> findAllDemandAwardBookByRefArtistAccount(String refArtistAccount);
}

