package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private int id;
    private String title;
    private String[] instructorName;
    private String[] requirement;
    private LocalDate startDate;
}
