package com.internship.services;


import com.internship.model.Student;

/**
 * Created by hnastevska on 7/18/2017.
 */

public interface StudentService {
  void save(Student student);
  void delete(Long id);
  void edit(Student student);


}
