package ma.digency.gov.amc.repository;

import ma.digency.gov.amc.repository.entity.Docum;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DocumentRepository extends GenericRepository<Docum, Long> {
    Optional<Docum> findByRefDocument(String refDocument);

    List<Docum> findByRefObject(String refObject);

    List<Docum> findByRefObjectAndRefParent(String refObject,String refParent);
}
