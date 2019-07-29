package com.internship.services.impl;

import com.internship.model.Student;
import com.internship.repository.StudentRepository;
import com.internship.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hnastevska on 7/18/2017.
 */
@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void edit(Student student) {
        Student foundStudent = studentRepository.getOne(student.getId());
        foundStudent.setName(student.getName());
        foundStudent.setStudentCode(student.getStudentCode());
        foundStudent.setSurname(student.getSurname());
        foundStudent.setSubjects(student.getSubjects());

    }
}
