package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.IOException;

import static hexlet.code.Differ.generate;

@Command(name = "gendiff",
        mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public final class App implements Runnable {

    @Option(names = {"-f", "--format"}, defaultValue = "stylish", description = "output format [default: stylish]")
    private String format;

    @Parameters(paramLabel = "filepath1", description = "path to first file")
    private String filePath1;
    @Parameters(paramLabel = "filepath2", description = "path to second file")
    private String filePath2;

    @Override
    public void run() {
        try {
            System.out.println(generate(filePath1, filePath2, format));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new CommandLine(new App()).execute(args);
    }
}
