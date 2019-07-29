package com.internship.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;

@Entity
@Wither
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Subject {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String mentor;

}
