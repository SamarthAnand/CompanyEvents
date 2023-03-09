package com.org.organisation.service;

import java.time.LocalDate;
import java.util.List;

import com.org.organisation.dto.EventDto;
import com.org.organisation.entity.EventsEntity;
import com.org.organisation.exception.EmployeeException;

public interface EventService  {
	
	String addEvent(EventDto eventDto) throws EmployeeException;
	 List<EventDto> showAllEvents();
	 List<EventsEntity> findEventByDate(LocalDate date);

	
}
