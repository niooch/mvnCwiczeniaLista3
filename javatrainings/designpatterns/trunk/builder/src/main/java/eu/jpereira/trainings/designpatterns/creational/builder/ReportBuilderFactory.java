package eu.jpereira.trainings.designpatterns.creational.builder;

import eu.jpereira.trainings.designpatterns.creational.builder.json.JSONReportBuilder;
import eu.jpereira.trainings.designpatterns.creational.builder.xml.XMLReportBuilder;
import eu.jpereira.trainings.designpatterns.creational.builder.model.ReportBuilder;


public class ReportBuilderFactory {
    public static ReportBuilder createReportBuilder(String type){
        switch(type.toUpperCase()){
            case "HTML":
                return new HTMLReportBuilder();
            case "XML":
                return new XMLReportBuilder();
            case "JSON":
                return new JSONReportBuilder();
            default:
                throw new IllegalArgumentException("Report type not supported: " + type);
        }
    }
}
