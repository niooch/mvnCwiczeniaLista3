package eu.jpereira.trainings.designpatterns.creational.abstractfactory;

import eu.jpereira.trainings.designpatterns.creational.abstractfactory.factory.JSONReportElementFactory;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.factory.XMLReportElementFactory;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.factory.ReportElementFactory;
import java.util.HashMap;
import java.util.Map;


public class FactoryProvider {

    private static Map<String, ReportElementFactory> factories = new HashMap<>();

    static {
        // Register default factories
        factories.put("JSON", new JSONReportElementFactory());
        factories.put("XML", new XMLReportElementFactory());
    }

    public static ReportElementFactory getFactory(String reportType) {
        ReportElementFactory factory = factories.get(reportType.toUpperCase());
        if (factory == null) {
            throw new IllegalArgumentException("Unknown report type: " + reportType);
        }
        return factory;
    }

    public static void registerFactory(String reportType, ReportElementFactory factory) {
        factories.put(reportType.toUpperCase(), factory);
    }
}
