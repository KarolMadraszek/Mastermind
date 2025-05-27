package org.example;

// created with SO and ChatGPT
public class IntegerAsker {
    //private final Scanner scanner;
    private final InputReader inputReader;

    public IntegerAsker (InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public int ask() {
        return Integer.parseInt(inputReader.readLine());
    }
}
