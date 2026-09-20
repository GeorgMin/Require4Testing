package de.require4testing.repository;

import de.require4testing.model.Testlauf;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestlaufRepository extends JpaRepository<Testlauf, Long> {
}