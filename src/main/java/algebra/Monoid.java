package algebra;

import java.util.function.BinaryOperator;

public interface Monoid<E> {

    E identity();
    BinaryOperator<E> operator();
}
