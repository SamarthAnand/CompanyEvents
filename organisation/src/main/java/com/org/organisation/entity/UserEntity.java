package com.org.organisation.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	
	@Column(name ="username",nullable = false,unique=true)
	private String userName;
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public UserEntity(Long id, String name, String password, String emailId, List<RoleEntity> roles,String userName) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.emailId = emailId;
		this.roles = roles;
		this.userName = userName;
	}

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(name ="password", nullable = false)
	private String password;
	@Column(name="email_id", nullable = false, unique= true)
	private String emailId;
	
	@ManyToMany(fetch= FetchType.EAGER ,cascade = CascadeType.ALL)
	@JoinTable(
			name="users_role",
			joinColumns= {@JoinColumn(name="USER_ID", referencedColumnName="id")},
			inverseJoinColumns= {@JoinColumn(name="ROLE_ID", referencedColumnName="id")}
			)
	private List<RoleEntity> roles = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public List<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}

	@Override
	public int hashCode() {
		return Objects.hash(emailId, id, name, password, roles);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEntity other = (UserEntity) obj;
		return Objects.equals(emailId, other.emailId) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(roles, other.roles)&& Objects.equals(userName, other.userName);
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", name=" + name + ", password=" + password + ", emailId=" + emailId
				+ ", roles=" + roles +",userName=" + userName + "]";
	}
	
	
}
