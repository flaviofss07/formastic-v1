package com.gapnt.formastic.repository;

import com.gapnt.formastic.model.Efetivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EfetivoRepository extends JpaRepository<Efetivo, Long> {

    List<Efetivo> findByFone(String fone);

    @Query("FROM Efetivo e WHERE e.fone LIKE %:fone%")
    List<Efetivo> findByFonePart(@Param("fone") String fone);

}
