
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleTests {

    static final Logger log = LoggerFactory.getLogger(SimpleTests.class);


    @ParameterizedTest
    @CsvSource({"4,6,3", "-4,7,5", "2,6,3"})
    public void myTest(int a, int b, int c) {
        log.info("\t\t\tStart test!");

        int s_result = Main.square(a, b, c);
        double triangleSquare = Main.square(a, b, c);

        Assertions.assertTrue(triangleSquare > 0);
        assertEquals(triangleSquare, s_result);
        System.out.println(s_result);

        log.info("\t\t\tFinish test!");



    }


}
