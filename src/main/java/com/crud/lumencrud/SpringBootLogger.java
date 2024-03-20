package com.crud.lumencrud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootLogger {
    Logger logger = LoggerFactory.getLogger(SpringBootLogger.class);

    @RequestMapping("/")
    public String home(){
        logger.trace("Logging test");
        return "hello Raj";
    }
}
