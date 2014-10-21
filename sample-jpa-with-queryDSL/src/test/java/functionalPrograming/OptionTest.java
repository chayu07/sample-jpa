package functionalPrograming; /**
 * Created by hoons on 2014-10-14.
 */
import java.util.*;

import org.junit.*;
import static org.junit.Assert.*;

public class OptionTest {
    private List<Option<String>> names = null;
    @Before
    public void setup() {
        names = new ArrayList<Option<String>>();
        names.add(new Some<String>("Dean"));
        names.add(new None<String>());
        names.add(new Some<String>("Wampler"));
    }
    @Test
    public void getOrElseUsesValueForSomeAndAlternativeForNone() {
        String[] expected = { "Dean", "Unknown!", "Wampler"};
        System.out.println("*** Using getOrElse:");
        for (int i = 0; i < names.size(); i++) {
            Option<String> name = names.get(i);
            String value = name.getOrElse("Unknown!");
            System.out.println(name + ": " + value);
            assertEquals(expected[i], value);
        }
    }
}
