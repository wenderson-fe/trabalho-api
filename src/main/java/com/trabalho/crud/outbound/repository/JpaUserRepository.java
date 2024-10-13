package com.trabalho.crud.outbound.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalho.crud.core.entity.Hospede;
import com.trabalho.crud.core.repository.UserRepository;

@Profile("!test")
public interface JpaUserRepository extends UserRepository, JpaRepository<Hospede, Long> {
}
