package ek.pluralsight.dasboot.repository;

import ek.pluralsight.dasboot.model.Shipwreck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipwreckRepository extends JpaRepository<Shipwreck, Long> {
}
