package option;

/**
 * Created by hoons on 2014-10-14.
 */
public final class None<T> extends Option<T> {

    public static class NoneHasNoValue extends RuntimeException {
    }

    public None() {
    }

    public boolean hasValue() {
        return false;
    }

    @Override
    public boolean hasNotValue() {
        return true;
    }

    public T get() {
        throw new NoneHasNoValue();
    }

    @Override
    public String toString() {
        return "None";
    }

    @Override
    public boolean equals(Object other) {
        return (other == null || other.getClass() != None.class) ? false :
                true;
    }

    @Override
    public int hashCode() {
        return -1;
    }
}
