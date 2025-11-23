package com.hospital.authentication_service.Entity;

import com.hospital.authentication_service.enums.ETenantStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tenant")
public class Tenant extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(mappedBy="tenant")
	private User user;
	
	private String name;
	
	@Column(name="tenant_code", nullable=false, unique=true)
	private String tenantcode;
	
	@Enumerated(EnumType.STRING)
	@Column(unique=true)
	private ETenantStatus status;

}
