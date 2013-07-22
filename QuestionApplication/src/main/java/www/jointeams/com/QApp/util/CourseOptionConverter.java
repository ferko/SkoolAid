package www.jointeams.com.QApp.util;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;
import javax.inject.Named;

import www.jointeams.com.QApp.controller.UserRegController;
import www.jointeams.com.QApp.model.CourseOption;

@Named("CourseOptionConverter")
public class CourseOptionConverter implements Converter {
	@Inject
	private UserRegController userReg;

	public Object getAsObject(FacesContext facesContext, UIComponent component,
			String submittedValue) {

		if (submittedValue.trim().equals("") || submittedValue == null) {
			return null;
		} else {
			try {
				for (CourseOption option : userReg.getCourseOptions()) {
					if (option.getOptionId() == Integer
							.parseInt(submittedValue)) {
						return option;
					}
				}
			} catch (NumberFormatException exception) {
				throw new ConverterException(new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Conversion Error",
						"Not a valid player"));
			}
		}
		return null;
	}

	public String getAsString(FacesContext facesContext, UIComponent component,
			Object value) {
		if (value == null || value.equals("")) {
			return "";
		} else {
			return Integer.toString(((CourseOption) value).getOptionId());
		}
	}
}
