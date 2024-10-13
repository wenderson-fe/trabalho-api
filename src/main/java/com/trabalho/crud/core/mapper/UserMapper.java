package com.trabalho.crud.core.mapper;

import org.mapstruct.Mapper;

import com.trabalho.crud.core.dto.HospedeDto;
import com.trabalho.crud.core.entity.Hospede;

@Mapper(componentModel = "spring")
public interface UserMapper {

  Hospede toEntity(HospedeDto dto);

  HospedeDto toDto(Hospede entity);
  
}
