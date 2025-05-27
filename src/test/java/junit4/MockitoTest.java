package junit4;

import org.example.InputReader;
import org.example.IntegerAsker;
import org.example.MainMenu;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

/* Spy and Virtual Input */
import java.io.*;

/* SQL test */
import java.util.Scanner;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;



public class MockitoTest {
    // Mockito implementation
    @Test
    public void testIO() {  // input-output test
        // Spy stdout
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream spyOut = spy(new PrintStream(outContent));
        System.setOut(spyOut);

        // Replace stdin
        String input = "Hello\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Test logic
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line = reader.readLine();
            System.out.println("Echo: " + line);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Verify and assert
        verify(spyOut).println("Echo: Hello");
    }

    @Test
    public void inputSpyTest() {  // general input-output Mastermind test
        String simulatedInput = "1234\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        PrintStream mockOut = mock(PrintStream.class);
        System.setOut(mockOut);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mastermind");
        System.out.println("Start gry. Wpisz cztery cyfry...");
        String input = scanner.nextLine();
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockOut, times(2)).println(captor.capture());
        assertEquals("Mastermind", captor.getAllValues().get(0));
        assertEquals("Start gry. Wpisz cztery cyfry...", captor.getAllValues().get(1));
    }

// 7890 - solution
// 1234 - rrrr
// 5678 - rryy
// 9087 - yyyy
// 8709 - yygg
// 2709 - rygg
// 7890 - gggg
@Test
public void gameStateTest(){
    PrintStream mockOut = mock(PrintStream.class);
    InputReader mockIn = mock(InputReader.class);
    MainMenu mainMenu = new MainMenu(mockIn, mockOut);
    mainMenu.start();
    ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
    verify(mockOut, times(2)).println(captor.capture());
    System.out.println("Mastermind");
    System.out.println("Start gry. Wpisz cztery cyfry...");
}

 /*   @Test
    public void textScannerWithInjectedInput() {
        IntegerAsker asker = Mockito.mock(IntegerAsker.class);
        // to co ma zwrócić scanner
        Mockito.when(asker.ask()).thenReturn(1);
        int result = asker.ask();
        // linijka tesująca
        Assert.assertEquals(result, 1);
    } */

    @Test
    public void testAskReturnsParsedInt() { // testing IntegerAsker class
        InputReader mockReader = mock(InputReader.class);
        when(mockReader.readLine()).thenReturn("42");
        IntegerAsker asker = new IntegerAsker(mockReader);
        int result = asker.ask();
        assertEquals(42, result);
    }
}
