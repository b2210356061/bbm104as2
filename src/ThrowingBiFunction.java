/**
 * An interface which is exactly like java.util.function.BiFunction, but accepts
 * functions which throw BankruptException
 */
@FunctionalInterface
public interface ThrowingBiFunction<T, U, R> {
    R apply(T t, U u) throws BankruptException;
}
