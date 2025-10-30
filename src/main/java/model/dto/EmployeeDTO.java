package model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDTO {
    private String id;
    private String name;
    private String nic;
    private String dob;
    private String position;
    private double salary;
    private String contactNumber;
    private String address;
    private String joinedDate;
    private String status;

}
