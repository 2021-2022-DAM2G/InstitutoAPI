package org.iesfm.instituto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HighSchoolController {

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String index() {
        return "Instituto Federica Montseny";
    }
}
