package com.internship.services.impl;

import com.internship.model.Subject;
import com.internship.repository.SubjectRepository;
import com.internship.services.SubjectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {


    private SubjectRepository subjectRepository;

    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public void save(Subject subject) {
        subjectRepository.save(subject);
    }

    @Override
    public List<Subject> listAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject findSubjectById(Long id) {
        return subjectRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public void edit(Subject subject) {
        Subject foundSubject = subjectRepository.findById(subject.getId()).get();
        foundSubject.setMentor(subject.getMentor());
        foundSubject.setName(subject.getName());
    }

}
