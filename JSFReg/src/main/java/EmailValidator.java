import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Created by lena.manukyan on 5/2/2016.
 */
@ManagedBean(name = "emailValidator")
@SessionScoped
public class EmailValidator implements Validator {

    protected static final String VALUE_HOLDER_ATTR_NAME = "value";
    protected static final String PROCESS_VALIDATION_HOLDER_ATTR_NAME = "process";
    protected static final String VALIDATION_MESSAGE_HOLDER_ATTR_NAME = "message";
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException
    {
        Object value = uiComponent.getAttributes().get(VALUE_HOLDER_ATTR_NAME);

        if(processValidation(uiComponent)){
            if(value instanceof String)
            {
                if(!((String) value).matches("[A-Za-z0-9]+@[A-Za-z0-9]+\\.[a-z]+"));
                throwValidatorException((String) uiComponent.getAttributes().get(VALIDATION_MESSAGE_HOLDER_ATTR_NAME));

                return;
            }
            else throwValidatorException((String) uiComponent.getAttributes().get(VALIDATION_MESSAGE_HOLDER_ATTR_NAME));
        }
    }

    //checks if appropriate attribute of uiComponent is true
    // (in this case checks if the appropriate button is pressed to start validation)
    protected boolean processValidation(UIComponent uiComponent){
        Object process = uiComponent.getAttributes().get(PROCESS_VALIDATION_HOLDER_ATTR_NAME);

        if(process instanceof  String)
        {
            return Boolean.valueOf(process.toString());
        }
        return (Boolean) process;
    }
    protected void throwValidatorException(String validationMessage) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, validationMessage, validationMessage);
        facesContext.addMessage(null, msg);
        throw new ValidatorException(msg);
    }

    //getters
    public String getValueHolderAttrName(){
        return  VALUE_HOLDER_ATTR_NAME;
    }
    public String getProcessValidationHolderAttrName(){
        return  PROCESS_VALIDATION_HOLDER_ATTR_NAME;
    }

    public String getValidationMessageHolderAttrName(){
        return VALIDATION_MESSAGE_HOLDER_ATTR_NAME;
    }
}
