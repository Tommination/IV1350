package view;

import controller.Controller;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.ldap.Control;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ViewTest {
    private View instanceToTest;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;

    @BeforeEach
    void setUp() {
        Controller contr = new Controller();
        instanceToTest = new View(contr);

        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);
    }

    @AfterEach
    void tearDown() {
        instanceToTest = null;
        printoutBuffer = null;

        System.setOut(originalSysOut);

    }

    @Test
    void testRunFakeExecution() {
        instanceToTest.runFakeExecution();
        String printout = printoutBuffer.toString();
        String expectedOutput = "started";
        assertTrue(printout.contains(expectedOutput), "UI did not not start correctly");

    }
}