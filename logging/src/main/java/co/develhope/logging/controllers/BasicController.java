package co.develhope.logging.controllers;

import co.develhope.logging.services.BasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @Autowired
    private Environment environment;

    @Value("${customEnvs.n1}")
    int envValue1;

    @Value("${customEnvs.n2}")
    int envValue2;

    @Autowired
    BasicService basicService;
    Logger logger = LoggerFactory.getLogger(BasicController.class);

    //  "/" returns just a welcome message and logs it
    @GetMapping("/")
    public void sayWelcome(){
        logger.info("Welcome inTo my App");
    }

    // map "/exp" return calculateEXP on basic service
    @GetMapping("/exp")
    public String exp(){
        logger.info("Start EXP");
        return basicService.calculateEXP(envValue1,envValue2);
    }

    //throws a new custom error that will be logged
    @GetMapping("/get-errors")
    public void getError(){
        Error error = new Error("This is a Custom Error");//logga tutti gli errori
        logger.error("This is an ERROR logging",error);
    }
}
