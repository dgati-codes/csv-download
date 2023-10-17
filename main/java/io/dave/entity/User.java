package io.dave.entity;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "User table", name = "User Schema")
public class User {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Schema(description = "ID which uniquely identifies a User")
	    private Long id;

	    @Column(name = "first_name")
	    @Schema(description = "User's first name")
	    private String firstName;

	    @Column(name = "last_name")
	    @Schema(description = "User's last name")
	    private String lastName;

	    @Column(name = "email")
	    @Schema(description = "User's email")
	    private String email;

	    @Column(name = "phone_number")
	    @Schema(description = "User's phone number")
	    private String phoneNumber;

	    @Column(name = "mobile_phone_number")
	    @Schema(description = "User's mobile phone number")
	    private String mobilePhoneNumber;

	    @Column(name = "user_status")
	    @Schema(description = "User's status")
	    private String userStatus;

	    @Column(name = "created_on")
	    @Schema(description = "Date the user was created")
	    private LocalDateTime createdOn;

	    @Column(name = "updated_on")
	    @Schema(description = "Date the user was last updated")
	    private LocalDateTime updatedOn;

	    @Column(name = "deleted_on")
	    @Schema(description = "Date the user was deleted")
	    private LocalDateTime deletedOn;

	    @Column(name = "username")
	    @Schema(description = "User's username")
	    private String username;

	
    
}
