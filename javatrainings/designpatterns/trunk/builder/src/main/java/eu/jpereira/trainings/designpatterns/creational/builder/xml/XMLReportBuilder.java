package eu.jpereira.trainings.designpatterns.creational.builder.xml;
import eu.jpereira.trainings.designpatterns.creational.builder.model.Customer;
import eu.jpereira.trainings.designpatterns.creational.builder.model.ReportBuilder;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SoldItem;
import java.util.Iterator;
import java.util.List;
import eu.jpereira.trainings.designpatterns.creational.builder.model.Report;


public class XMLReportBuilder implements ReportBuilder{
    private XMLReportBody reportBody;

    public XMLReportBuilder() {
        this.reportBody = new XMLReportBody();
    }

    @Override
    public void buildHeader(Customer customer) {
        reportBody.putContent("<sale><customer><name>");
        reportBody.putContent(customer.getName());
        reportBody.putContent("</name><phone>");
        reportBody.putContent(customer.getPhone());
        reportBody.putContent("</phone></customer>");
    }
    @Override
    public void buildBody(List<SoldItem> items) {
        reportBody.putContent("<items>");
        Iterator<SoldItem> it = items.iterator();
			while ( it.hasNext() ) {
				SoldItem soldEntry= it.next();
				reportBody.putContent("<item><name>");
				reportBody.putContent(soldEntry.getName());
				reportBody.putContent("</name><quantity>");
				reportBody.putContent(soldEntry.getQuantity());
				reportBody.putContent("</quantity><price>");
				reportBody.putContent(soldEntry.getUnitPrice());
				reportBody.putContent("</price></item>");
            }
        reportBody.putContent("</items></sale>");
    }
    @Override
    public Report getReport() {
        Report report = new Report();
        report.setReportBody(reportBody);
        return report;
    }
}
