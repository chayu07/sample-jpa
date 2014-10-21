package functionalPrograming;

/**
 * Created by hoons on 2014-10-21.
 */
public class ListModule {
    public static interface List<T> {
        public abstract T head();

        public abstract List<T> tail();

        public abstract boolean isEmpty();

        public List<T> filter(Function1<T, Boolean> f);

        public <T2> List<T2> map(Function1<T, T2> f);

        public <T2> T2 foldLeft(T2 seed, Function2<T2, T, T2> f);

        public <T2> T2 foldRight(T2 seed, Function2<T, T2, T2> f);

        public void foreach (Function1Void<T> f);
    }

    public static final class NonEmptyList<T> implements List<T> {
        private final T _head;
        private final List<T> _tail;

        public T head() {
            return _head;
        }

        public List<T> tail() {
            return _tail;
        }

        public boolean isEmpty() {
            return false;
        }

        protected NonEmptyList(T head, List<T> tail) {
            this._head = head;
            this._tail = tail;
        }

        public List<T> filter(Function1<T, Boolean> f) {
            if (f.apply(head())) {
                return list(head(), tail().filter(f));
            } else {
                return tail().filter(f);
            }
        }

        public <T2> List<T2> map(Function1<T, T2> f) {
            return list(f.apply(head()), tail().map(f));
        }

        public <T2> T2 foldLeft(T2 seed, Function2<T2, T, T2> f) {
            return tail().foldLeft(f.apply(seed, head()), f);
        }

        public <T2> T2 foldRight(T2 seed, Function2<T, T2, T2> f) {
            return f.apply(head(), tail().foldRight(seed, f));
        }

        public void foreach(Function1Void<T> f) {
            tail().foreach(f);
            f.apply(head());
        }

        @Override
        public boolean equals(Object other) {
            if (other == null || getClass() != other.getClass())
                return false;
            List<?> that = (List<?>) other;
            return head().equals(that.head()) && tail().equals(that.tail());
        }

        @Override
        public int hashCode() {
            return 37 * (head().hashCode() + tail().hashCode());
        }

        @Override
        public String toString() {
            return "(" + head() + ", " + tail() + ")";
        }
    }

    public static class EmptyListHasNoHead extends RuntimeException {
    }

    public static class EmptyListHasNoTail extends RuntimeException {
    }

    public static final List<? extends Object> EMPTY = new List<Object>() {
        public Object head() {
            throw new EmptyListHasNoHead();
        }

        public List<Object> tail() {
            throw new EmptyListHasNoTail();
        }

        public boolean isEmpty() {
            return true;
        }

        public List<Object> filter(Function1<Object, Boolean> f) {
            return this;
        }

        public <T2> List<T2> map(Function1<Object, T2> f) {
            return emptyList();
        }

        public <T2> T2 foldLeft(T2 seed, Function2<T2, Object, T2> f) {
            return seed;
        }

        public <T2> T2 foldRight(T2 seed, Function2<Object, T2, T2> f) {
            return seed;
        }

        public void foreach(Function1Void<Object> f) {
        }

        @Override
        public String toString() {
            return "()";
        }
    };

    /* 이 코드에 대한 설명은 본문에서 보라. */
    @SuppressWarnings(value = "unchecked")
    public static <T> List<T> emptyList() {
        return (List<T>) EMPTY; // Dangerous!?
    }

    public static <T> List<T> list(T head, List<T> tail) {
        return new NonEmptyList<T>(head, tail);
    }
}