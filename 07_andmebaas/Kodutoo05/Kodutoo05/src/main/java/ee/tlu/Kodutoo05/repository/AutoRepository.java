package ee.tlu.Kodutoo05.repository;

import ee.tlu.Kodutoo05.entity.AutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoRepository extends JpaRepository<AutoEntity, String> {
}
