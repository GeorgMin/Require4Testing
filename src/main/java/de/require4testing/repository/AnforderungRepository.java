package de.require4testing.repository;

import de.require4testing.model.Anforderung;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnforderungRepository extends JpaRepository<Anforderung, Long> {

}