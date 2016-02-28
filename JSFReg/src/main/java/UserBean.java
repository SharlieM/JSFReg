/**
 * Created by Lena on 2/21/2016.
 */
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.validator.ValidatorException;
import javax.faces.view.facelets.FaceletContext;
import java.util.Date;

@ManagedBean
@SessionScoped
public class UserBean {
    private String firstName;
    private String lastName;
    private String sex;
    private String email;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setServiceLevel(String serviceLevel) {
        this.serviceLevel = serviceLevel;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getLastName() {

        return lastName;
    }

    private String serviceLevel = "medium";
    private Date dob ;

    public String getSex() {
        return sex;
    }

    public String getEmail() {
        return email;
    }

    public String getServiceLevel() {
        return serviceLevel;
    }

    public Date getDob() {
        return dob;
    }

    public String getFirstName() {

        return firstName;
    }
public void validateEmail(FaceletContext context, UIComponent toValidate, Object value)throws ValidatorException {
    String v = (String) value;
    if (v.indexOf("@") == -1) {
        FacesMessage message = new FacesMessage("invalid email address!");
        throw new ValidatorException(message);
    }
}
public String addConfirmedUser(){
        boolean added = true;
        FacesMessage doneMessage = null;
        String outcome = null;
        if(added)
        {
            doneMessage = new FacesMessage("successfully added new user.");
            outcome = "done";
            return outcome;
        }
        //else
        doneMessage = new FacesMessage("faild to add new user.");
        outcome = "register";
        return outcome;
    }

}
