package com.certicom.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericMySqlEntityRepository<T,ID> extends JpaRepository<T,ID> {
}
