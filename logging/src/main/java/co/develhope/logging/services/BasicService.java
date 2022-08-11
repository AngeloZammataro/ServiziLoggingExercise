package co.develhope.logging.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class BasicService {

    Logger logger = LoggerFactory.getLogger(BasicService.class);


    //takes the 2 numeric env values,
    //then logs and returns the power (exponent) of the 2 values
    public String calculateEXP(int customEnvs1, int customEnvs2){
        try {
            //logs when starting the calculation
            logger.info("Starting EXP - envValue1: " + customEnvs1 + " envValue2: " + customEnvs2);

            double exp1 = Math.getExponent(customEnvs1);
            double exp2 = Math.getExponent(customEnvs2);
            return "Exponent of Value1 = 2 is: " + exp1 + " - Exponent of Value2 = 8 is:  " + exp2;
        }finally {
            //logs when when finishing the calculation
            logger.info("Ending EXP");
        }
    }
}