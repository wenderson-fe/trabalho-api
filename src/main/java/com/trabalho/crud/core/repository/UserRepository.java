package com.trabalho.crud.core.repository;

import java.util.List;
import java.util.Optional;

import com.trabalho.crud.core.entity.Hospede;

public interface UserRepository {

  List<Hospede> findAll();

  Optional<Hospede> findById(Long id);

  Hospede save(Hospede user);

  void deleteById(Long id);
}
