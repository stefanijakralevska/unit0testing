package com.internship.services;

import com.internship.model.Subject;

import java.util.List;

/**
 * Created by hnastevska on 7/18/2017.
 */
public interface SubjectService {
    void save(Subject subject);

    void delete(Long id);

    void edit(Subject subject);

    List<Subject> listAll();

    Subject findSubjectById(Long id);
}
