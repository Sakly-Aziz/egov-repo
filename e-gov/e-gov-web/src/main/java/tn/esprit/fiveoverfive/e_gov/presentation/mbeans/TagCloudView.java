package tn.esprit.fiveoverfive.e_gov.presentation.mbeans;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.tagcloud.DefaultTagCloudItem;
import org.primefaces.model.tagcloud.DefaultTagCloudModel;
import org.primefaces.model.tagcloud.TagCloudItem;
import org.primefaces.model.tagcloud.TagCloudModel;
 
@ManagedBean
public class TagCloudView {
     
    private TagCloudModel model;
     
    @PostConstruct
    public void init() {
        model = new DefaultTagCloudModel();
        model.addTag(new DefaultTagCloudItem("Cars", 1));
        model.addTag(new DefaultTagCloudItem("Cases", "#", 3));
        model.addTag(new DefaultTagCloudItem("Cin", 2));
        model.addTag(new DefaultTagCloudItem("Works", "#", 5));
        model.addTag(new DefaultTagCloudItem("Birth", 4));
        model.addTag(new DefaultTagCloudItem("University", "#", 2));
        model.addTag(new DefaultTagCloudItem("Health", 5));
        model.addTag(new DefaultTagCloudItem("B3",  3));
        model.addTag(new DefaultTagCloudItem("Transport", "#", 4));
       
    }
 
    public TagCloudModel getModel() {
        return model;
    }
     
    public void onSelect(SelectEvent event) {
        TagCloudItem item = (TagCloudItem) event.getObject();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Selected", item.getLabel());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}