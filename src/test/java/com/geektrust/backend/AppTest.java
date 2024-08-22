package com.geektrust.backend;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("App Test")
class AppTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void Application_Test_forInput1() throws Exception{
        // Arrange
        // Act   
        // Assert
        String[] args = {"sample_input/input1.txt"};

        // Call the main method
        App.main(args);

        // Capture the output
        String expectedOutput = "ARRIVAL TRAIN_A ENGINE NDL NDL GHY NJP NGP\n" +
        "ARRIVAL TRAIN_B ENGINE NJP GHY AGA BPL PTA\n" +
        "DEPARTURE TRAIN_AB ENGINE ENGINE GHY GHY NJP NJP PTA NDL NDL AGA BPL NGP";

        assertEquals(expectedOutput.trim(), outputStreamCaptor.toString().trim());
        
    }

    //@Test
   // public void Application_test_forInput2() throws Exception{
    //    String[] args = {"sample_input/input2.txt"};
    //    App.main(args);
    //    String expectedOutput = "ARRIVAL TRAIN_A ENGINE HYB NGP ITJ\n" +
    //                        "ARRIVAL TRAIN_B ENGINE NJP PTA\n" +
     //                       "DEPARTURE TRAIN_AB ENGINE ENGINE NJP PTA ITJ NGP";

   // assertEquals(expectedOutput.trim(), outputStreamCaptor.toString().trim());
   // }
    
    @Test
    public void testMain_withInvalidInput() {
        // Prepare the command line arguments with an invalid file path
        String[] args = {"sample_input/non_existing_file.txt"};

        // Call the main method
        App.main(args);

        // Capture the output
        String expectedOutput = "Invalid input. Please ensure the input file contains data for both Train A and Train B.";

        assertEquals(expectedOutput.trim(), outputStreamCaptor.toString().trim());
    }

    @BeforeEach
    public void tearDown() {
        System.setOut(standardOut);
    }

}
