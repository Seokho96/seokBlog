package com.jpa.a.entity;


import javax.persistence.*;



import lombok.Data;
import lombok.*;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;
	
	@NonNull
	@Column(name = "user_id", nullable = false, updatable = false)
	private String userId;
	 
	@NonNull
	@Column(name = "password", nullable = false, updatable = true)
	private String password;
	
	@Column(name = "name", nullable = true, updatable = true)
	private String name;  
	
	@Column(name = "authority", nullable = false, updatable = true)
	private String authority;
	
	@Column(name = "enabled", nullable = false, updatable = true)
	private int enabled;

	
	public member( String userId, String password, String name, String authority, int enabled) {
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.authority = authority;
		this.enabled =  enabled;
	}
	
}
