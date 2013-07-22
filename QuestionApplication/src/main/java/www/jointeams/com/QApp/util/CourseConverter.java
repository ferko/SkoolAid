package www.jointeams.com.QApp.util;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import www.jointeams.com.QApp.model.Course;

@Named("CourseConverter")
public class CourseConverter implements Converter {
	@Inject
	@Named("courseByOption")
	private List<Course> courses;
	
	public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
        
		if (submittedValue.trim().equals("") || submittedValue == null) {
            return null;
        } else {
			for(Course course : courses)
			{
				if(course.getCourseId().compareTo(submittedValue) == 0)
				{
					return course;
				}
			}
        }
        return null;
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            return ((Course) value).getCourseId();
        }
    }
}
