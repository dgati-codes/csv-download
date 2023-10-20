# Suppliers CSV Download Functionality

This functionality allows users to download supplier data in CSV format from the Spring Boot application. It leverages Spring Web MVC and Spring Data JPA to retrieve and convert supplier data into CSV format for download.

## Table of Contents
- [Purpose](#purpose)
- [Usage](#usage)
- [Configuration](#configuration)
- [Customization](#customization)
- [Using BufferedWriter](#using-bufferedwriter)

## Purpose

The purpose of this functionality is to provide a convenient way for users to download supplier data in CSV format. This can be useful for various purposes, such as data analysis or exporting data for other applications.

## Usage

### Downloading CSV

To download supplier data in CSV format, make a GET request to the `/suppliers/suppliers-csv` endpoint. The CSV file will be automatically downloaded.

Example:
```bash
curl -OJ http://localhost:8080/suppliers/suppliers-csv
## Configuration

The CSV download functionality is configured in the Spring Boot application using the `SuppliersController` class. The configuration includes setting up the endpoint for CSV download and configuring the CSV generation logic.

### Endpoint Configuration

The CSV download endpoint is defined in the `SuppliersController` class using the `@GetMapping` annotation. The endpoint URL is `/suppliers/suppliers-csv`.

### CSV Generation Logic

The CSV generation logic uses a `BufferedWriter` to write CSV data to the response. The data is retrieved from the database using the `SupplierService` and converted to CSV format.

### Customization

To customize the CSV download functionality, you can modify the following components:

- **CSV Formatting:** Customize the CSV formatting, header, and column ordering in the `downloadSuppliersCsv` method of `SuppliersController`.

### Using BufferedWriter

`BufferedWriter` is used to efficiently write the CSV data directly to the HTTP response. This ensures that the CSV content is streamed without buffering the entire content in memory, making it suitable for handling potentially large datasets and providing optimal memory usage and responsiveness.

The CSV data is written to the response line by line, enhancing performance and allowing the seamless download of the CSV file, even for substantial amounts of data.
