import org.junit.*;

import java.util.regex.*;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        String[] splice = hamletText.split(" ");
        for (int i = 0; i < splice.length; i++) {
            if (splice[i].equals("Hamlet")) {
                System.out.println(i);
            }
            Assert.assertFalse(splice[i].equals("Hamlet"));
        }
    }

    @Test
    public void testChangeHoratioToTariq() {
        String[] splice = hamletText.split(" ");
        for (int i = 0; i < splice.length; i++) {
            if (splice[i].equals("Horatio")) {
                System.out.println(i);
            }
            Assert.assertFalse(splice[i].equals("Horatio"));
        }
    }

    @Test
    public void testFindHoratio() {
        String patternString = "HORATIO";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(hamletText);
        Assert.assertFalse(matcher.find());
    }

    @Test
    public void testFindHamlet() {
        String patternString = "HAMLET";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(hamletText);
        Assert.assertFalse(matcher.find());
    }
}