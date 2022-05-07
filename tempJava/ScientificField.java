import java.util.ArrayList;
import java.util.HashMap;

public class ScientificField {
	
	private String name;
	private int noLesson;
	private HashMap<String, Lesson> allLessonsperScientificField = new HashMap<String, Lesson>();
	
	public ScientificField(String name, int noLesson) {
		this.name = name;
		this.noLesson = noLesson;
	}
	
	public ScientificField(String name) {
		this.name = name;
	}
	
	public void setLesson(String name, Lesson lesson) {
		this.allLessonsperScientificField.put(name, lesson);
	}
}
