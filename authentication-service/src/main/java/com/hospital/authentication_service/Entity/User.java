package com.hospital.authentication_service.Entity;

import java.util.Set;

import com.hospital.authentication_service.enums.EUserStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name="tenant_id", referencedColumnName="id")
	private Tenant tenant;
	
	@ManyToMany
	@JoinTable(
			name="user_role",
			joinColumns=@JoinColumn(name="user_id"),
			inverseJoinColumns=@JoinColumn(name="role_id")
	)
	private Set<Role> roles;
	
	@Column(nullable=false, unique=true)
	private String username;
	
	@Column(nullable=false, unique=true)
	private String email;
	
	@Column(nullable=false)
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(unique=true)
	private EUserStatus status;

}
