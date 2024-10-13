package com.trabalho.crud.core.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.test.context.ActiveProfiles;

import com.trabalho.crud.core.entity.Hospede;

@ActiveProfiles("test")
@Repository
public class UserRepositoryMemo implements UserRepository {

  private final List<Hospede> users = new ArrayList<Hospede>();

  @Override
  public List<Hospede> findAll() {
    return users;
  }

  @Override
  public Optional<Hospede> findById(Long id) {
    return users.stream().filter(user -> user.getId().equals(id)).findFirst();
  }

  @Override
  public Hospede save(Hospede user) {
    var id = users.size() + 1;
    user.setId((long) id);
    users.add(user);
    return user;
  }

  @Override
  public void deleteById(Long id) {
    users.removeIf(user -> user.getId() == id);
  }
}
