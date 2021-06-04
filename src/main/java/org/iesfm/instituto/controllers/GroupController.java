package org.iesfm.instituto.controllers;

import org.iesfm.instituto.Group;
import org.iesfm.instituto.Student;
import org.iesfm.instituto.services.HighSchool;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupController {

    private HighSchool highSchool;

    public GroupController(HighSchool highSchool) {
        this.highSchool = highSchool;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/group")
    public List<Group> getGroups() {
        return highSchool.getGroups();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/group/{id}")
    public Group getGroup(@PathVariable("id") int id) {
        return highSchool.getGroup(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/group/{id}")
    public void deleteGroup(@PathVariable("id") int id) {
        highSchool.deleteGroup(id);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/group", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addGroup(@RequestBody Group group) {
        highSchool.addGroup(group);
    }

}
