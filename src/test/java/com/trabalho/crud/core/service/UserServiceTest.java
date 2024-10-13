package com.trabalho.crud.core.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.trabalho.crud.core.entity.Hospede;
import com.trabalho.crud.core.repository.UserRepository;

@ActiveProfiles("test")
@SpringBootTest
class UserServiceTest {

  @Autowired
  private UserRepository repository;

  @Autowired
  private UserService service;

  @BeforeEach
  void populateRepository() {
    MockitoAnnotations.openMocks(this);
    repository.save(Hospede.builder().name("User 1").email("email1@email.com").build());
    repository.save(Hospede.builder().name("User 2").email("email2@email.com").build());
    repository.save(Hospede.builder().name("User 3").email("email3@email.com").build());
  }

  @Test
  @DisplayName("Busca todos os usuários")
  void testBuscarTodosOsUsuarios() {
    var allUsers = service.findAll();

    assertEquals(3, allUsers.size());
  }
}
