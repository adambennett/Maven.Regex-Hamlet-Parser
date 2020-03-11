import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.*;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    public static void main(String[] args) {
        HamletParser hp = new HamletParser();
        hp.loadFile();
        hp.getHamletData();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        String regex = "Hamlet";
        String replace = "Leon";
        Pattern pat = Pattern.compile(regex);
        Matcher match = pat.matcher(hamletData);
        String toRet = match.replaceAll(replace);

        regex = "HAMLET";
        replace = "LEON";
        pat = Pattern.compile(regex);
        match = pat.matcher(toRet);
        toRet = match.replaceAll(replace);

        regex = "Horatio";
        replace = "Tariq";
        pat = Pattern.compile(regex);
        match = pat.matcher(toRet);
        toRet = match.replaceAll(replace);

        regex = "HORATIO";
        replace = "TARIQ";
        pat = Pattern.compile(regex);
        match = pat.matcher(toRet);
        toRet = match.replaceAll(replace);
        System.out.println(toRet);
        hamletData = toRet;
        return hamletData;
    }

}
