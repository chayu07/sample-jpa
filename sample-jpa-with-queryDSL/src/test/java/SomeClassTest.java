/**
 * Created by hoons on 2014-10-14.
 */

import option.None;
import option.Option;
import option.Some;
import option.SomeClass;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class SomeClassTest {

    private SomeClass someClass;
    @Before
    public void setup() {
        someClass = new SomeClass();
    }

    @Test(expected = Exception.class)
    public void 인자가_널이라_예외가_발생한다() throws Exception {
        //given
        Option<String> someParameter = new None<String>();

        //when
        someClass.someMethod(someParameter);
    }

    @Test
    public void 인자가_정상이면_예외가_발생하지_않는다() throws Exception {
        //given
        Option<String> someParameter = new Some<String>("Victor");

        //when
        someClass.someMethod(someParameter);
    }

    @Test
    public void 인자가_정상이면_전달받은_인자를_반환한다() throws Exception {
        //given
        Option<String> someParameter = new Some<String>("Victor");

        //when
        String name = someClass.someMethod(someParameter);

        //then
        assertEquals("인자를 반환하지 않았다.", "Victor", name);
    }
}
