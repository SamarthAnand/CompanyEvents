package com.org.organisation.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.organisation.dto.EventDto;
import com.org.organisation.entity.EventsEntity;
import com.org.organisation.exception.EmployeeException;
import com.org.organisation.repository.EventsRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EventServiceImpl implements EventService{
	
	@Autowired
	private EventsRepository eventRepo;
	

	@Override
	public String addEvent(EventDto eventDto) throws EmployeeException{
		// TODO Auto-generated method stub
		EventsEntity events = new EventsEntity();
		events.setEventId(eventDto.getEventId());
		events.setEventName(eventDto.getEventName());
		events.setEventDate(eventDto.getEventDate());
		events.setEventDescription(eventDto.getEventDescription());
		
		Optional<EventsEntity> eventExists = eventRepo.findById(eventDto.getEventId());
		if(eventExists.isPresent())
		{
			throw new EmployeeException("Event Already registered.");
		}
		eventRepo.save(events);
		return "saved Event....";
		
	}

	@Override
	public List<EventDto> showAllEvents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EventsEntity> findEventByDate(LocalDate date) {
		
		List<EventsEntity> eventsList = eventRepo.findByEventDate(date);
		
		return eventsList;
		
	}

}
