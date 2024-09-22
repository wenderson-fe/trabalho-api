package com.trabalho.crud.core.mapper;

import org.mapstruct.Mapper;

import com.trabalho.crud.core.dto.UserDto;
import com.trabalho.crud.core.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

  User toEntity(UserDto dto);

  UserDto toDto(User entity);
  
}
