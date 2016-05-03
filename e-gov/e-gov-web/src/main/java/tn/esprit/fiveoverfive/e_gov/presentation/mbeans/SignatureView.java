package tn.esprit.fiveoverfive.e_gov.presentation.mbeans;

import javax.annotation.ManagedBean;

@ManagedBean
public class SignatureView {
	private String value;
	 
    public String getValue() {
        return value;
    }
 
    public void setValue(String value) {
        this.value = value;
    }

}
