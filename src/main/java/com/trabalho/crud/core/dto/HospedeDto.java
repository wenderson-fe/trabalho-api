package com.trabalho.crud.core.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class HospedeDto {

  private Long id;

  private String name;

  private String email;

  private String phone;

	private String address;

	private String birthDate;

	private LocalDate checkIn;

	private LocalDate checkOut;

}
