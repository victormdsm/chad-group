package com.eventflow.project.repositories;

import com.eventflow.project.entities.AttendancesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendancesRepository extends JpaRepository<AttendancesEntity, Long> {
}
