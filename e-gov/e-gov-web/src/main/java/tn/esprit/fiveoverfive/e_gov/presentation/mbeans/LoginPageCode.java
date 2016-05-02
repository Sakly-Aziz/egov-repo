package tn.esprit.fiveoverfive.e_gov.presentation.mbeans;
import java.io.Serializable;


import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name="loginpagecode")
@SessionScoped
public class LoginPageCode implements Serializable {
    private static final long serialVersionUID = -1611162265998907599L;
 
    public String getFacebookUrlAuth() {
        HttpSession session =
        (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        String sessionId = session.getId();
        String appId = "1895322817360760";
        String redirectUrl = "http://localhost:18080/e-gov-web/pages/citizen/citizen.jsf";
        String returnValue = "https://www.facebook.com/dialog/oauth?client_id="
                + appId + "&redirect_uri=" + redirectUrl
                + "&scope=email,user_birthday&state=" + sessionId;
        return returnValue;
    }
 
    public String getUserFromSession() {
        HttpSession session =
        (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        String userName = (String) session.getAttribute("FACEBOOK_USER");
        if (userName != null) {
            return "Hello " + userName;
        }
        else {
            return "";
        }
    }
}