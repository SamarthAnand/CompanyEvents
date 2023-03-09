package com.org.organisation.dto;

import java.time.LocalDate;
import java.util.Objects;

import com.org.organisation.entity.EventsEntity;
import com.org.organisation.entity.UserEntity;
import com.org.organisation.service.UserServiceImpl;

import jakarta.validation.constraints.NotEmpty;

public class EventDto {
	
	private int eventId;
	@NotEmpty
	private String eventName;
	@NotEmpty
	private String eventDescription;
	@NotEmpty
	private LocalDate eventDate;
	private UserDto userDto;
	public UserDto getUserDto() {
		return userDto;
	}
	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}
	public static EventDto entityToDto(EventsEntity eventEntity){
		EventDto events = new EventDto();
		events.setEventId(eventEntity.getEventId());
		events.setEventName(eventEntity.getEventName());
	events.setEventDate(eventEntity.getEventDate());
		events.setEventDescription(eventEntity.getEventDescription());
		
		UserEntity user = eventEntity.getUsers();
		if(user == null) {
			events.setUserDto(null);
		}
		
		return events;
		
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventDescription() {
		return eventDescription;
	}
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	public LocalDate getEventDate() {
		return eventDate;
	}
	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(eventDate, eventDescription, eventId, eventName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventDto other = (EventDto) obj;
		return Objects.equals(eventDate, other.eventDate) && Objects.equals(eventDescription, other.eventDescription)
				&& eventId == other.eventId && Objects.equals(eventName, other.eventName);
	}
	@Override
	public String toString() {
		return "EventDto [eventId=" + eventId + ", eventName=" + eventName + ", eventDescription=" + eventDescription
				+ ", eventDate=" + eventDate + "]";
	}
	

}
