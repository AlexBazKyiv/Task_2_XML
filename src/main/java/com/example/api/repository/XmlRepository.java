package com.example.api.repository;

import com.example.api.model.Currency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface XmlRepository extends CrudRepository <Currency, Long> {
    List<Currency> findAllByOrderByIdDesc();
}
