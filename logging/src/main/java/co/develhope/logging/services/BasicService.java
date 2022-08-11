package co.develhope.logging.services;

import co.develhope.logging.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class BasicService {

    Logger logger = LoggerFactory.getLogger(BasicService.class);

    public String doGreeting(int numberOfGreetings){
        try {
            logger.info("Starting Greeting - Number of greetings: " + numberOfGreetings +
                    " User: " + new User("Angelo","Zammataro","Palermo"));
            //[...]
            return "Greetings";
        }finally {
            logger.info("Ending Greeting");
        }
    }


    //takes the 2 numeric env values,
    //then logs and returns the power (exponent) of the 2 values
    public String calculateEXP(int customEnvs1, int customEnvs2){
        try {
            //logs when starting the calculation
            logger.info("Starting EXP - envValue1: " + customEnvs1 + " envValue2: " + customEnvs2);

            double exp1 = Math.getExponent(customEnvs1);
            double exp2 = Math.getExponent(customEnvs2);
            return "Exponent of Value1 = 2 is: " + String.valueOf(exp1) + " - Exponent of Value2 = 8 is:  " + String.valueOf(exp2);
        }finally {
            //logs when when finishing the calculation
            logger.info("Ending EXP");
        }
    }
}