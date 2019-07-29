package com.internship.controllers;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.google.gson.Gson;
import com.internship.model.Subject;
import com.internship.services.impl.SubjectServiceImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class MainControllerTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private List<Subject> subjects;
    @Mock
    private SubjectServiceImpl subjectService;
    @InjectMocks
    private MainController controller;
    private MockMvc mockMvc; // Mock MVC offers a powerful way to quickly test MVC controllers without needing to start a full HTTP server.
    private Long subjectId = 1L;
    private Gson gson;
    private Subject subject;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        subject = new Subject()
            .withId(subjectId)
            .withMentor("John Doe")
            .withName("Math");

        gson = new Gson();
        subjects = new ArrayList<>();
        subjects.add(subject);
    }

    @Test
    public void testSaveSubject() throws Exception {

        String json = gson.toJson(subject);

        mockMvc.perform(post("/demo/saveSubject")
            .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
            .content(json))
            .andExpect(status().isOk());

    }


    @Test
    public void testGetMentorForSpecificSubject() throws Exception {

        when(subjectService.listAll()).thenReturn(subjects);
        when(subjectService.findSubjectById(eq(subjectId))).thenReturn(subject);

        mockMvc.perform(get("/demo/subject/{name}", subject.getName())
            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(status().isOk())
            .andExpect(content().contentType("text/plain;charset=UTF-8"))
            .andExpect(content().string("John Doe"));

        verify(subjectService, times(1)).listAll();

    }

    @Test
    public void testGetAllSubjectsByMentor() throws Exception {

        when(subjectService.listAll()).thenReturn(subjects);

        mockMvc.perform(get("/demo/subjectsBy/{mentor}", subject.getMentor())
            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(content().json(gson.toJson(subjects)));

        verify(subjectService, times(1)).listAll();

    }


}
