package org.iesfm.instituto.controllers;

import org.iesfm.instituto.Enrollment;
import org.iesfm.instituto.services.HighSchool;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnrollmentController {

    private HighSchool highSchool;

    public EnrollmentController(HighSchool highSchool) {
        this.highSchool = highSchool;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/enrollment")
    public List<Enrollment> getEnrollments() {
        return highSchool.getEnrollments();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/enrollment/{id}")
    public Enrollment getEnrollment(@PathVariable("id") Integer id) {
        return highSchool.getEnrollment(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/enrollment/{id}")
    public void deleteEnrollment(@PathVariable("id") Integer id) {
        highSchool.deleteEnrollment(id);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/enrollment", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addEnrollment(@RequestBody Enrollment enrollment) {
        highSchool.addEnrollment(enrollment);
    }
}
