package com.amirkost.aop.aspectj.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Amir Kost on 28/09/2015.
 */
@Controller
@RequestMapping("/api")
public class AopController {

    private Logger logger = LoggerFactory.getLogger(AopController.class);

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String sayHello() {
        logger.info("saying hello!");
        return "hello";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    @ResponseBody
    public void throwError() {
        logger.warn("about to throw an error!");
        throw new RuntimeException("A runtime error was thrown");
    }
}
