package report;

import report.action.Analyzer;

import java.util.List;

public class ReportBuilder {
    StringBuilder report = new StringBuilder();

    public <T> ReportBuilder report(List<T> list, Analyzer<T> analyzer){
        for (T elem : list) {
            report(elem, analyzer);
        }
        return this;
    }

    public<T> ReportBuilder report(T object, Analyzer<T> analyzer){
        report.append(object)
                .append("------->")
                .append(analyzer.analyze(object))
                .append(System.getProperty("line.separator"));

        return this;
    }


    public String generateReport(){
        String generatedReport = new String(report);
        report = new StringBuilder();
        return generatedReport;
    }
}
