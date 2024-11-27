package umc.spring.repository.store;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
}
