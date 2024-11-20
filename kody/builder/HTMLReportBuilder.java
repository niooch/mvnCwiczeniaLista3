package eu.jpereira.trainings.designpatterns.creational.builder;

import eu.jpereira.trainings.designpatterns.creational.builder.model.ReportBuilder;
import eu.jpereira.trainings.designpatterns.creational.builder.model.Customer;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SoldItem;
import java.util.List;
import eu.jpereira.trainings.designpatterns.creational.builder.model.Report;

public class HTMLReportBuilder implements ReportBuilder{
    private HTMLReportBody reportBody;

    public HTMLReportBuilder() {
        this.reportBody = new HTMLReportBody();
    }

    @Override
    public void buildHeader(Customer customer) {
        reportBody.putContent("<span class=\"customerName\">");
        reportBody.putContent(customer.getName());
        reportBody.putContent("</span><span class=\"customerPhone\">");
        reportBody.putContent(customer.getPhone());
        reportBody.putContent("</span>");
    }
    public void buildBody(List<SoldItem> items){
        reportBody.putContent("<items>");
        for (SoldItem item : items) {
            reportBody.putContent("<item><name>");
            reportBody.putContent(item.getName());
            reportBody.putContent("</name><quantity>");
            reportBody.putContent(item.getQuantity());
            reportBody.putContent("</quantity><price>");
            reportBody.putContent(item.getUnitPrice());
            reportBody.putContent("</price></item>");
        }
        reportBody.putContent("</items>");
    }

    @Override
    public Report getReport() {
        Report report = new Report();
        report.setReportBody(reportBody);
        return report;
    }


}
