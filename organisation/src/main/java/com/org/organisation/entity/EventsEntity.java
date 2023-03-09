package com.org.organisation.entity;

import java.time.LocalDate;
import java.util.Objects;

import com.org.organisation.dto.EventDto;
import com.org.organisation.dto.UserDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="events")
public class EventsEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int eventId;
	private String eventName;
	private String eventDescription;
	
	@Column(name="event_date")
	private LocalDate eventDate;
	
	private int joinees;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id", unique=true)
	private UserEntity users;

	public static EventsEntity dtoToEntity(EventDto eventDto) {
		EventsEntity event = new EventsEntity();
		event.setEventId(eventDto.getEventId());
		event.setEventName(eventDto.getEventName());
		event.setEventDescription(eventDto.getEventDescription());
		event.setEventDate(eventDto.getEventDate());
		UserDto user = eventDto.getUserDto();
		if(user == null) {
			event.setUsers(null);
		}
		return event;
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

	public int getJoinees() {
		return joinees;
	}

	public void setJoinees(int joinees) {
		this.joinees = joinees;
	}

	public UserEntity getUsers() {
		return users;
	}

	public void setUsers(UserEntity users) {
		this.users = users;
	}

	@Override
	public int hashCode() {
		return Objects.hash(eventDate, eventDescription, eventId, eventName, joinees, users);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventsEntity other = (EventsEntity) obj;
		return Objects.equals(eventDate, other.eventDate) && Objects.equals(eventDescription, other.eventDescription)
				&& eventId == other.eventId && Objects.equals(eventName, other.eventName) && joinees == other.joinees
				&& Objects.equals(users, other.users);
	}

	@Override
	public String toString() {
		return "EventsEntity [eventId=" + eventId + ", eventName=" + eventName + ", eventDescription="
				+ eventDescription + ", eventDate=" + eventDate + ", joinees=" + joinees + ", users=" + users + "]";
	}
	
	
	
}
