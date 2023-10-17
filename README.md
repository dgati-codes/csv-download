User CSV Download Functionality
This functionality allows users to download user data in CSV format from the Spring Boot application. It leverages Spring Web MVC and Spring Data JPA to retrieve and convert user data into CSV format for download.

Table of Contents
Purpose
Usage
Downloading CSV
Configuration
Customization
Using StreamingResponseBody
Purpose
The purpose of this functionality is to provide a convenient way for users to download user data in CSV format. This can be useful for various purposes, such as data analysis or exporting data for other applications.

Usage
Downloading CSV
To download user data in CSV format, make a GET request to the /user/users-csv endpoint. The CSV file will be automatically downloaded.

Example:
curl -OJ http://localhost:8080/user/users-csv

Configuration
The CSV download functionality is configured in the Spring Boot application using the UserRestController class. The configuration includes setting up the endpoint for CSV download and configuring the CSV generation logic.

Endpoint Configuration
The CSV download endpoint is defined in the UserRestController class using the @GetMapping annotation. The endpoint URL is /user/users-csv.

CSV Generation Logic
The CSV generation logic uses a StreamingResponseBody to stream CSV data to the response. The data is retrieved from the database using the UserService and converted to CSV format.

Customization
To customize the CSV download functionality, you can modify the following components:

CSV Formatting: Customize the CSV formatting, header, and column ordering in the downloadUsersCsv method of UserRestController.
Using StreamingResponseBody
StreamingResponseBody is employed to efficiently stream large amounts of data, such as CSV content, directly to the HTTP response without buffering the entire content in memory. This is essential for handling potentially large datasets, ensuring optimal memory usage and responsiveness.

The CSV data is streamed in chunks as it is generated, enhancing the performance and allowing seamless download of the CSV file even for substantial amounts of data
