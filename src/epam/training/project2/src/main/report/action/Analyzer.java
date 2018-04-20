package report.action;

@FunctionalInterface
public interface Analyzer<T> {
    String analyze(T object);
}
