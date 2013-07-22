package www.jointeams.com.QApp.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import www.jointeams.com.QApp.controller.QuizController;
import www.jointeams.com.QApp.model.MultipleChoice;
import www.jointeams.com.QApp.model.Option;

@Named("OptionConverter")
public class OptionConverter implements Converter {
	@Inject
	private QuizController quiz;
	
	public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
        
		if (submittedValue.trim().equals("") || submittedValue == null) {
            return null;
        } else {
			for(MultipleChoice question : quiz.getQuestions())
			{
				for(Option option : question.getOptions())
				if(option.getOptionId() == Integer.parseInt(submittedValue))
				{
					return option;
				}
			}
        }
        return null;
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            return Integer.toString(((Option) value).getOptionId());
        }
    }
}
