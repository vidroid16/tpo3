package tests;

import org.junit.jupiter.api.Test;
import utils.EmailReciver;

public class MailTest {
    @Test
    public void testMail(){
        EmailReciver.readEmail();
    }
}
