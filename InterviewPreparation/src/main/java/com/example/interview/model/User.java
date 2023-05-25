package com.example.interview.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="USER_TABLE")
public class User {
	@Id
	@GeneratedValue
	private Integer ID;
	private String name;
	private Set<String> email;
	private String mobNo;
	private String address;

}
