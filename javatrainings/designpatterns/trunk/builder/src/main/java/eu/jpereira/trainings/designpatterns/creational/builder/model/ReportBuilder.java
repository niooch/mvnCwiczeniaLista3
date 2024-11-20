package eu.jpereira.trainings.designpatterns.creational.builder.model;
import java.util.List;
public interface ReportBuilder {
    public void buildHeader(Customer customer);
    public void buildBody(List<SoldItem> items);
    public Report getReport();
}
