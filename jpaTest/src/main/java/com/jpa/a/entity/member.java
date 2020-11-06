package com.jpa.a.entity;

import java.sql.Date;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.*;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "member")
public class member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;	
	private String name;
	private int age;
	private String address;
	@CreationTimestamp
	private Date createdAt;

	 public member(String name, int age, String address){
	        this.name = name;
	        this.age = age;
	        this.address = address;
	    }
	
}
