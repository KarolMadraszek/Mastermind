package junit4;

import org.example.MainMenu;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

/* Spy and Virtual Input */
import java.io.*;

/* SQL test */
import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MockitoTest {

    @Test
    public void testIO() {
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

  /*  @Test
    public void inputSpyTest () {
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        //System.out.println("Mastermind");
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(printStream).println(captor.capture());
        assertEquals("Mastermind\n Start gry. Wpisz cztery cyfry...", captor.getValue());
    }  */

    @Test
    public void textScannerWithInjectedInput() {
        IntegerAsker asker = Mockito.mock(IntegerAsker.class);
        // to co ma zwrócić scanner
        Mockito.when(asker.ask()).thenReturn(1);
        int result = asker.ask();
        // linijka tesująca
        Assert.assertEquals(result, 1);
    }
}
