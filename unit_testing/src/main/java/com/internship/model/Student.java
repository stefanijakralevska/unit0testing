package com.internship.model;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Wither
public class Student {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private String studentCode;
    private ArrayList<Subject> subjects;

}
