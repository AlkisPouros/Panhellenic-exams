
public class Lesson {

	private String lessonName;
	private double coefficient;
	private ScientificField field;
	
	public Lesson(String lessonName, double coefficient, String field) {
		this.lessonName = lessonName;
		this.coefficient = coefficient;
		this.field = new ScientificField(field);
	}
	
}
