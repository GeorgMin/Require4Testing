package de.require4testing.repository;

import de.require4testing.model.Testfall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestfallRepository extends JpaRepository<Testfall, Long> {
}