package com.trabalho.crud.inbound.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalho.crud.core.dto.HospedeDto;
import com.trabalho.crud.core.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/hospede")
public class UserController {

  private final UserService userService;

  /**
   * Recupera uma lista de todos os hóspedes.
   * 
   * @return Uma lista de hóspedes e o status HTTP 200 OK
   */
  @GetMapping
  public ResponseEntity<List<HospedeDto>> getAllUsers() {
    return ResponseEntity.ok(userService.findAll());
  }

  /**
   * Recupera um hóspede específico pelo ID.
   * 
   * @param id id do hóspede a ser buscado
   * @return o hóspede correspondente e o status HTTP 200 OK 
   *         ou o status HTTP 404 Not Found se o hóspede não existir
   */
  @GetMapping("/{id}")
  public ResponseEntity<HospedeDto> getUserById(@PathVariable Long id) {
    return ResponseEntity.ok(userService.findById(id));
  }

  /**
   * Cria um novo hóspede.
   * 
   * @param userDTO os detalhes do hóspede a ser criado.
   * @return hóspede criado e o status HTTP 201 Created
   */
  @PostMapping
  public ResponseEntity<HospedeDto> createUser(@RequestBody HospedeDto userDTO) {
    return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userDTO));
  }

  /**
   * Atualiza um hóspede
   * 
   * @param id ID do hóspede a ser atualizado
   * @param userDTO os detalhes atualizados do hóspede
   * @return hóspede atualizado e o status HTTP 200 OK
   *         ou o status HTTP 404 Not Found se o hóspede não existir
   */
  @PutMapping("/{id}")
  public ResponseEntity<HospedeDto> updateUser(@PathVariable Long id, @RequestBody HospedeDto userDTO) {
    return ResponseEntity.ok(userService.update(id, userDTO));
  }

  /**
   * Remove um hóspede pelo ID.
   * 
   * @param id o ID do hóspede a ser removido
   * @return status HTTP 204 No Content
   *         ou o status HTTP 404 Not Found se o hóspede não existir
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    userService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
