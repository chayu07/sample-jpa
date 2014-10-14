package option;

/**
 * Created by hoons on 2014-10-14.
 */
public class SomeClass {

    private Option<String> option;
//    option 반영 전
//    public void someMethod(String someParameter) throws Exception {
//        if(someParameter == null) throw new Exception();
//
//        return someParameter
//    }

    public String someMethod(Option<String> someParameter) throws Exception {
        if(someParameter.hasNotValue()) throw new Exception();

        return someParameter.get();
    }
}
