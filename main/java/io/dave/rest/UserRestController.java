package io.dave.rest;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import io.dave.exception.UserException;
import io.dave.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserRestController {

	@Autowired
	private UserServiceImpl userService;
	
	String datePattern = "dd_MM_yyyy_HH:mm:ss";
	 @GetMapping("/users-csv")
	    public ResponseEntity<StreamingResponseBody> downloadUsersCsv(HttpServletResponse response) {
	        response.setContentType("text/csv");
	        String fileName = "users_" + new SimpleDateFormat(datePattern).format(new Date()) + ".csv";
	        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);

	        StreamingResponseBody responseBody = outputStream -> {
	            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream))) {
	                writer.write("ID,First Name,Last Name,Email,Phone Number,Mobile Phone Number,User Status," +
	                        "Created On,Updated On,Deleted On,Username");
	                writer.newLine();

	                userService.getAllUsers().forEach(user -> {
	                    try {
	                        writer.write(String.join(",", 
	                        		String.valueOf(user.getId()),
	                                user.getFirstName(),
	                                user.getLastName(), 
	                                user.getEmail(),
	                                user.getPhoneNumber(), 
	                                user.getMobilePhoneNumber(), 
	                                user.getUserStatus(),
	                                String.valueOf(user.getCreatedOn()), 
	                                String.valueOf(user.getUpdatedOn()),
	                                String.valueOf(user.getDeletedOn()), 
	                                user.getUsername()));
	                        writer.newLine();
	                    } catch (IOException e) {
	                        log.error("=== Error writing CSV data to output Stream ==={}", e);
	                        throw new UserException("Error writing CSV data for users");
	                    }
	                });
	            } catch (Exception e) {
	                log.error("==== Error writing CSV data for users==={}", e);
	                throw new UserException("Error writing CSV data for users");
	            }
	        };
	        return ResponseEntity.ok().body(responseBody);
	    }
}
