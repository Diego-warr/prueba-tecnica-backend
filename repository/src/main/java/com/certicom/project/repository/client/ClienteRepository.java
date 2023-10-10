package com.certicom.project.repository.client;

import com.certicom.project.entities.client.Cliente;
import com.certicom.project.repository.GenericMySqlEntityRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ClienteRepository extends GenericMySqlEntityRepository<Cliente,Integer> {

    @Query("SELECT C FROM Cliente C WHERE C.activo=true")
    List<Cliente> findAllActive();


}
