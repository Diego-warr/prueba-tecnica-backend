package com.certicom.project.service.spec;

import java.util.List;
import java.util.Optional;

public abstract interface BasicService<T> {

    Optional<T> finById(Integer id);
    List<T> findAll();
    List<T> finAllActive();
    T saveOrUpdate(T t);
    void delete(Integer id);

}
