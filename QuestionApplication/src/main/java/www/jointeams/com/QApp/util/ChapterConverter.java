package www.jointeams.com.QApp.util;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;
import javax.inject.Named;

import www.jointeams.com.QApp.model.Chapter;
import www.jointeams.com.QApp.model.Question;

@Named("ChapterConverter")
public class ChapterConverter implements Converter {
	@Inject
	@Named("newQuestion")
	private Question newQuestion;
	
	@Inject
	@Named("quizChapters")
	private List<Chapter> quizChapters;
	
	public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
        if (submittedValue.trim().equals("") || submittedValue == null) {
            return null;
        } else {
        	try {
                int number = Integer.parseInt(submittedValue);
                List<Chapter> chapters;
                System.out.println(component.getId());
                if(component.getId().equals("chapter"))
                {
                	chapters = newQuestion.getCourse().getChapters();
                }
                else
                {
                	chapters = quizChapters;
                }
                for(Chapter chapter : chapters)
    			{
    				if(chapter.getChapterId() == number)
    				{
    					return chapter;
    				}
    			}
                
            } catch(NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid player"));
            }
        }
        return null;
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(((Chapter) value).getChapterId());
        }
    }
}
