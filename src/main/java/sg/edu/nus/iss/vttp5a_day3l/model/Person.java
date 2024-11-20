package sg.edu.nus.iss.vttp5a_day3l.model;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    @NotEmpty(message = "First name is mandatory")
    @Size(min = 5, max = 60, message = "First name miust be between 5 to 60 characters")
    private String firstName;

    @NotEmpty(message = "Last name is mandatory")
    @Size(min = 2, max = 60, message = "Last name miust be between 2 to 60 characters")
    private String lastName;

    @Min(value = 1500, message = "Minimum salary starts from 1500")
    @Max(value = 50000, message = "Msximum salary ceiling is 50000")
    private int salary;

    @Email(message = "Email input does not conform to email format")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @Past(message = "birth date must be a past date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    @Pattern(regexp = "(8|9)[0-9]{7}", message = "Phone number must start with 8 or 9 followed by 7 digits")
    private String telephone;

    @Min(value = 111111, message = "Postal Code is too small, must be greater than 111111")
    @Max(value = 999999, message = "POstal code cannot exceed 999999")
    @Digits(fraction = 0, integer = 6, message = "Postal code must be 6 digits")
    private int postalCode;

    public Person(){

    }

    public Person(String firstName, String lastName, int salary, String email, Date dob, String telephone, int postalCode) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.email = email;
        this.dob = dob;
        this.telephone = telephone;
        this.postalCode = postalCode;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return "firstName: " + firstName + ", lastName: " + lastName + ", Salary: " + salary 
        + ", Email: " + email + ", Date of Birth: " + formatter.format(dob) + ", Telephone: " + telephone + ", Postal Code: " + postalCode;
    }
}
