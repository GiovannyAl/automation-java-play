package edgaralbarracin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    @Test
    public void testSayHello() {
        String result = Main.sayHello();
        assertEquals("Hello, World!", result);
    }
}
