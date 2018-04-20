package report.analysis;

@FunctionalInterface
public interface ObjectAnalyzer<T> {
    String analyze(T object);
}
