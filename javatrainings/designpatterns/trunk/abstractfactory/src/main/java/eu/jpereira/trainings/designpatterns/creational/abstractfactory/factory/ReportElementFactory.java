package eu.jpereira.trainings.designpatterns.creational.abstractfactory.factory;

import eu.jpereira.trainings.designpatterns.creational.abstractfactory.ReportBody;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.ReportFooter;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.ReportHeader;

public interface ReportElementFactory {
    public ReportBody createReportBody();
    public ReportHeader createHeader();
    public ReportFooter createFooter();
}
