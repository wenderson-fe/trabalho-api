package com.trabalho.crud.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trabalho.crud.core.dto.HospedeDto;
import com.trabalho.crud.core.entity.BusinessException;
import com.trabalho.crud.core.mapper.UserMapper;
import com.trabalho.crud.core.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

  private final UserRepository repository;

  private final UserMapper mapper;

  public List<HospedeDto> findAll() {
    return repository.findAll().stream().map(user -> mapper.toDto(user)).toList();
  }

  public HospedeDto findById(Long id) {
    return repository.findById(id).map(user -> mapper.toDto(user))
        .orElseThrow(() -> BusinessException.notFoundException("Usuário não encontrado"));
  }

  public HospedeDto save(HospedeDto userDto) {
    var user = mapper.toEntity(userDto);
    return mapper.toDto(repository.save(user));
  }

  public HospedeDto update(Long id, HospedeDto userDto) {
    var existingUser = this.findById(id);
    userDto.setId(existingUser.getId());
    var user = mapper.toEntity(userDto);
    return mapper.toDto(repository.save(user));
  }

  public void deleteById(Long id) {
    this.findById(id);
    repository.deleteById(id);
  }

}
