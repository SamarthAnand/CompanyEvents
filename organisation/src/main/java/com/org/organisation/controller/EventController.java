package com.org.organisation.controller;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.PastOrPresent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.organisation.dto.EventDto;
import com.org.organisation.entity.EventsEntity;
import com.org.organisation.exception.EmployeeException;
import com.org.organisation.repository.EventsRepository;
import com.org.organisation.service.EventService;

@RestController
@RequestMapping("/api/events")
@CrossOrigin("*")
public class EventController {
	
	@Autowired
	private EventService eventService;
	@Autowired
	private EventsRepository eventsRepo;
	
	@GetMapping("/all-events")
	public List<EventsEntity> showAllEvents(){
		return eventsRepo.findAll();
	}
	
	@PostMapping("/event")
	public ResponseEntity<String> addEvents(@RequestBody EventDto event)throws EmployeeException {
		
		String ret = eventService.addEvent(event);
		return new ResponseEntity<>(ret, HttpStatus.CREATED);
	}
	
	@GetMapping("/{eventDate}")
	public ResponseEntity<List<EventsEntity>> findEventsByDate(@PathVariable(name="eventDate")
			@PastOrPresent(message = "past dates not allowed.")
	@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date)throws EmployeeException{
		List<EventsEntity> ret = eventService.findEventByDate(date);
		return new ResponseEntity<>(ret,HttpStatus.OK);
	}
}
