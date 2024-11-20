package eu.jpereira.trainings.designpatterns.creational.builder.json;
import eu.jpereira.trainings.designpatterns.creational.builder.model.Report;
import eu.jpereira.trainings.designpatterns.creational.builder.model.ReportBuilder;
import eu.jpereira.trainings.designpatterns.creational.builder.model.Customer;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SoldItem;
import java.util.List;
import java.util.Iterator;
public class JSONReportBuilder extends Report implements ReportBuilder {

    private JSONReportBody report;

    public JSONReportBuilder() {
        this.report = new JSONReportBody();
    }

    @Override
    public void buildHeader(Customer customer) {
        report.addContent("sale:{customer:{");
        report.addContent("name:\"" + customer.getName() + "\",");
        report.addContent("phone:\"" + customer.getPhone()+"\"}");

    }

    @Override
    public void buildBody(List<SoldItem> items) {
        report.addContent(",items:[");
        //przejscie po wszystkich itemach
        Iterator<SoldItem> it = items.iterator();
        while(it.hasNext()){
            SoldItem item = it.next();
            report.addContent("{");
            report.addContent("name:\"" + item.getName() + "\",");
            report.addContent("quantity:\"" + item.getQuantity() + "\",");
            report.addContent("price:\"" + item.getUnitPrice() + "\"");
            report.addContent("}");
            if(it.hasNext()){
                report.addContent(",");
            }
        }
        report.addContent("]}");

    }

    @Override
    public Report getReport() {
        Report report = new Report();
        report.setReportBody(this.report);
        return report;
    }

}
