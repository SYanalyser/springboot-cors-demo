package com.dreamidea;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author stillChina
 *
 */
@RestController
@RequestMapping("accuracy")
public class AccuracyController {

    @RequestMapping(method = RequestMethod.GET)
    @CrossOrigin(origins = "localhost:3000")
    String getAccuracy(){
        return "jack";
    }
}
