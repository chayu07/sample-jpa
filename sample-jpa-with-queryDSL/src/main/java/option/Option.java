package option;

/**
 * Created by hoons on 2014-10-14.
 */
public abstract class Option<T> {
    public abstract T get();
    public abstract boolean hasValue();
    public abstract boolean hasNotValue();

    public T getOrElse(T alternative) {
        return hasValue() == true ? get() : alternative;
    }
}
