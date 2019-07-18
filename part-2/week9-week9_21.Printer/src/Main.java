import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
        Printer printer = new Printer("src/textfile.txt");
    
        printer.printLinesWhichContain("Väinämöinen");
        System.out.println("-----");
        printer.printLinesWhichContain("Frank Zappa");
        System.out.println("-----");
        printer.printLinesWhichContain("vanha");
        System.out.println("-----");
    }
}
