package com.org.organisation.entity;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name= "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private long id; 
	
	@Column(name = "first_name")
	@NotNull(message = "employee.firstname.absent")
	private String FirstName;
	@Column(name = "last_name")
	@NotNull(message = "employee.firstname.absent")
	private String LastName;

	@Column(name = "email_id")
	@NotNull
	private String EmailId;
	
	@OneToMany(cascade= CascadeType.MERGE)
	private List<EventsEntity> eventsAttended;
	

	public List<EventsEntity> getEventsAttended() {
		return eventsAttended;
	}
	public void setEventsAttended(List<EventsEntity> eventsAttended) {
		this.eventsAttended = eventsAttended;
	}
	public Employee() {
		//before creating parameterised constructor create a default constructor.
		
	}
	public Employee(String firstName, String lastName, String emailId) {
		super();
		FirstName = firstName;
		LastName = lastName;
		EmailId = emailId;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", FirstName=" + FirstName + ", LastName=" + LastName + ", EmailId=" + EmailId
				+ ", eventsAttended=" + eventsAttended + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(EmailId, FirstName, LastName, eventsAttended, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(EmailId, other.EmailId) && Objects.equals(FirstName, other.FirstName)
				&& Objects.equals(LastName, other.LastName) && Objects.equals(eventsAttended, other.eventsAttended)
				&& id == other.id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmailId() {
		return EmailId;
	}

	public void setEmailId(String emailId) {
		EmailId = emailId;
	}
	
}
