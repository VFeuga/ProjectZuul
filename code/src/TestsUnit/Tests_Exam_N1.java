package TestsUnit;
/**
 * @author loic
 */
import model.rooms.Exam;

public class Tests_Exam_N1 {
	
	public static void main(String[] args) {
		Exam e = new Exam("Examen POO2",null);
		e.showQCM();
		e.takeExam();
	}

}
