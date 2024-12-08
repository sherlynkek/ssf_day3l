package sg.edu.nus.iss.vttp5a_day3l.model;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

// @Data (lombok)
// @AllArgsConstructor (lombok)
// @NoArgsConstructor (lombok)

public class Person {

    // @NotNull(message = "id must be auto generated")
    private String id;

    @NotEmpty (message = "First Name is mandatory")
    @Size (min = 5, max = 60, message = "First Name must be between 5 to 60 characters")
    private String firstName;

    @NotEmpty (message = "Last Name is mandatory")
    @Size (min = 2, max = 60, message = "Last Name must be between 2 to 60 characters")
    private String lastName;

    @Min(value = 1500, message = "Minimum salary starts from 1500")
    @Max(value = 50000, message = "Maximum salary ceiling is 50000")
    private Integer salary;

    @Email(message = "Email input does not conform to email format")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @Past(message = "When were you born?")
    @NotNull(message = "Please set your date of birth")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    // private Date dateOfBirth;
    private LocalDate dateOfBirth;

    @Pattern(regexp = "(8|9)[0-9]{7}", message = "Phone number must start with 8 or 9, followed by 7 digits")
    private String telephone;

    @Digits(fraction = 0, integer = 6, message = "Postal code must be 6 digits!")
    @Min(value = 111111, message = "Postal codes start from 111111")
    @Max(value = 999999, message = "Postal codes cannot exceed 999999")
    private Integer postalCode;

    public Person(String firstName, String lastName, Integer salary, String email, LocalDate dob,
    String telephone, Integer postalCode) {
        // Generates a random unique id
        this.id = UUID.randomUUID().toString();
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.email = email;
        this.dateOfBirth = dob;
        this.telephone = telephone;
        this.postalCode = postalCode;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }
    
}