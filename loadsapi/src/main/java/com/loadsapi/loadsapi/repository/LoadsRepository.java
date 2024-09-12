package com.loadsapi.loadsapi.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loadsapi.loadsapi.entities.Load;

public interface LoadsRepository extends JpaRepository<Load, Long> {

    List<Load> findByShipperId(UUID shipperId);
}
