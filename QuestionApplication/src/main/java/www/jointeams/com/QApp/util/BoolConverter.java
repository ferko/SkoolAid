package www.jointeams.com.QApp.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;


@Named("BoolConverter")
public class BoolConverter implements Converter {
	
	public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
        if (submittedValue.trim().equals("") || submittedValue == null) {
            return null;
        } else if(submittedValue.equalsIgnoreCase("true"))
        {
        	return true;
        }
        else if(submittedValue.equalsIgnoreCase("false"))
        {
        	return false;
        }
        return null;
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            return ((Boolean) value).toString();
        }
    }
}
