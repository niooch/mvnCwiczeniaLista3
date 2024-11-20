package eu.jpereira.trainings.designpatterns.creational.builder.json;
import eu.jpereira.trainings.designpatterns.creational.builder.model.Report;
import eu.jpereira.trainings.designpatterns.creational.builder.model.ReportBuilder;
import eu.jpereira.trainings.designpatterns.creational.builder.model.Customer;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SoldItem;
import java.util.List;
import java.util.Iterator;
public class JSONReportBuilder extends Report implements ReportBuilder {

    private JSONReportBody reportBody;

    public JSONReportBuilder() {
        this.reportBody = new JSONReportBody();
    }

    @Override
    public void buildHeader(Customer customer) {
        reportBody.addContent("sale:{customer:{");
        reportBody.addContent("name:\"");
        reportBody.addContent(customer.getName());
        reportBody.addContent("\",phone:\"");
        reportBody.addContent(customer.getPhone());
        reportBody.addContent("\"}");

    }

    @Override
    public void buildBody(List<SoldItem> items) {
        reportBody.addContent(",items:[");
        Iterator<SoldItem> it = items.iterator();
        while (it.hasNext()) {
            SoldItem item = it.next();
            reportBody.addContent("{name:\"");
            reportBody.addContent(item.getName());
            reportBody.addContent("\",quantity:");
            reportBody.addContent(String.valueOf(item.getQuantity()));
            reportBody.addContent(",price:");
            reportBody.addContent(String.valueOf(item.getUnitPrice()));
            reportBody.addContent("}");
            if (it.hasNext()) {
                reportBody.addContent(",");
            }
        }
        reportBody.addContent("]}");
    }

    @Override
    public Report getReport() {
        Report report = new Report();
        report.setReportBody(this.reportBody);
        return report;
    }

}
