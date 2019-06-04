package com.geepi.provider1;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author liaoyong
 * @date 2019/05/30
 * @since JDK 1.8
 */
@RestController
public class HelloController {



    @RequestMapping(value = "/search/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Person searchPerson(@PathVariable Integer id) {
        Person person = new Person();
        person.setId(id);
        person.setName("geepi");
        return person;
    }
}
