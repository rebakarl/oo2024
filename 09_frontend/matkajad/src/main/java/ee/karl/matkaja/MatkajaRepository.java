package ee.karl.matkaja;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MatkajaRepository extends JpaRepository<Matkaja, Long> {

}
