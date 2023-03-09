package com.org.organisation.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.organisation.entity.EventsEntity;

@Repository
public interface EventsRepository extends JpaRepository<EventsEntity, Integer>{

	List<EventsEntity> findByEventDate(LocalDate date);
}
