package gr.codehub.j101;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    private static final Lorem generator = LoremIpsum.getInstance();

    public static void main(String[] args) {
        System.out.println("Hello world from System.out!");
        logger.info("Hello world from logger!");
        System.out.printf("Signed: %s %s of %s, %s"
                , generator.getFirstNameFemale()
                , generator.getLastName()
                , generator.getCity()
                , generator.getCountry()
        );
    }
}
