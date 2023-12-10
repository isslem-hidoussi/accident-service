package com.isslem.accidentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.isslem.accidentservice.model.Accident;

@Repository
public interface AccidentRepo extends JpaRepository<Accident,Long> {
}
