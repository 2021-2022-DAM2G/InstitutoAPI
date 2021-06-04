package org.iesfm.instituto.controllers;

import org.iesfm.instituto.Student;
import org.iesfm.instituto.Title;
import org.iesfm.instituto.services.HighSchool;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TitleController {

    private HighSchool highSchool;

    public TitleController(HighSchool highSchool) {
        this.highSchool = highSchool;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/title")
    public List<Title> getTitles() {
        return highSchool.getTitles();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/title/{id}")
    public Title getTitle(@PathVariable("id") int id) {
        return highSchool.getTitle(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/title/{id}")
    public void deleteTitle(@PathVariable("id") int id) {
        highSchool.deleteTitle(id);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/title", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addTitle(@RequestBody Title title) {
        highSchool.addTitle(title);
    }

}
