package org.iesfm.instituto.controllers;

import org.iesfm.instituto.Group;
import org.iesfm.instituto.Student;
import org.iesfm.instituto.services.HighSchool;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class GroupController {

    private HighSchool highSchool;

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

    @RequestMapping(method = RequestMethod.POST, path = "/group")
    public void addGroup(@RequestBody Group group) {
        highSchool.addGroup(group);
    }

}
