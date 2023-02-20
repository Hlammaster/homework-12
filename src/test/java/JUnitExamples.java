import org.junit.jupiter.api.*;

public class JUnitExamples {
    @BeforeAll
    static void beforeAll() {
        System.out.println("    Here is blaTest()");
    }
    @BeforeEach
      void beforeEach() {
        System.out.println("        Oh FUCK()");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Pizza Time()");
    }
    @AfterEach
    void afterEach() {
        System.out.println("no pizza()");
    }
    @Test
    void firstTest() {
        System.out.println("Here is firstTest()");
    }
    @Test
    void secondTest() {
        System.out.println("Here is blablaTest()");
    }

}
