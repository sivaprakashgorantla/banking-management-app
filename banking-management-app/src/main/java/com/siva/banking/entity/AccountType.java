package com.siva.banking.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class AccountType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long id;

    private String typeName;

    // Getters and Setters

    public AccountType() {}

    public AccountType(String typeName) {
        this.typeName = typeName;
    }
    
    public AccountType(Long id, String typeName) {
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

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

	@Override
	public String toString() {
		return "AccountType [id=" + id + ", typeName=" + typeName + "]";
	}

}
