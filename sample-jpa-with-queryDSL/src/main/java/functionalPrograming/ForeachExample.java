package functionalPrograming;

import static functionalPrograming.ListModule.*;
/**
 * Created by hoons on 2014-10-21.
 */
public class ForeachExample {
    public static void main(String[] p) {

        String args[] = {"1","2","3","4","5"};
        argsToList(args).foreach(new Function1Void<String>() {
            public void apply(String arg) {
                System.out.println("You entered: "+arg);
            }
        });
    }
    private static List<String> argsToList(String[] args) {
        List<String> result = emptyList();
        for (String arg: args) {
            result = list(arg, result);
        }
        return result;
    }
}