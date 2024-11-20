package eu.jpereira.trainings.designpatterns.creational.factorymethod;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;




public class ReportFactory{
    private static Map<String, Supplier<Report>> registeredReports = new HashMap<>();

    static {
        registeredReports.put("JSON", JSONReport::new);
        registeredReports.put("HTML", HTMLReport::new);
        registeredReports.put("PDF", PDFReport::new);
        registeredReports.put("XML", XMLReport::new);
    }

    public static Report createReport(String type){
        Supplier<Report> reportSupplier = registeredReports.get(type);
        if(reportSupplier != null){
            return reportSupplier.get();
        }
        return null;
    }
}
