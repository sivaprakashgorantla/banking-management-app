package com.siva.banking.dto;

import java.util.Set;

public class AccountTypeDTO {
	private Long id;

	private String typeName;
	// Getters and Setters

	public AccountTypeDTO() {
	}
	

	public AccountTypeDTO(Long id, String typeName) {
		super();
		this.id = id;
		this.typeName = typeName;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	@Override
	public String toString() {
		return "AccountTypeDTO [id=" + id + ", typeName=" + typeName + "]";
	}


}