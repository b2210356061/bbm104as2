// An interface which is exactly like java.util.function::BiConsumer, but accepts functions
// which throw BankruptException
@FunctionalInterface
public interface ThrowingBiConsumer<T, U> {
    void apply(T t, U u) throws BankruptException;
}
