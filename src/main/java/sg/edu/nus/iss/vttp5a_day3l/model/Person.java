package sg.edu.nus.iss.vttp5a_day3l.model;

import java.util.Date;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

// @Data (lombok)
// @AllArgsConstructor (lombok)
// @NoArgsConstructor (lombok)

public class Person {
    
    @NotNull(message = "id must be auto-generated")
    private String id;

    @NotEmpty(message = "First Name is mandatory")
    @Size(min = 5, max = 60, message = "First Name must be between 5 to 60 characters")
    private String firstName;

    @NotEmpty(message = "Last Name is mandatory")
    @Size(min = 2, max = 60, message = "Last Name must be between 2 to 60 characters")
    private String lastName;

    @Min(value = 1500, message = "Minimum salary starts from 1500")
    @Max(value = 50000, message = "Maximum salary starts from 50000")
    private Integer salary;

    @Email(message = "Email input does not conform to email format")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @Past(message = "Date of Birth must be a past date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    public Person(String firstName, String lastName, String email, Integer salary, Date dob) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.salary = salary;
        this.dob = dob;
    }

    public Person() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
    

}
