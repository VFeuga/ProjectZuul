package controler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.sun.org.apache.bcel.internal.generic.LLOAD;

import model.Item;
import model.rooms.Lecture;
import model.LectureItem;
import model.Student;
import model.Tablets;

public class Controler {
	private HashMap<String,Lecture> listLecture;
	private ArrayList<Item> listItem;
	private Student student;
	private Game game;

	public Controler(){
		listLecture = new HashMap<String,Lecture>();
		listItem = new ArrayList<>();
		initLecture();
		initItem();
	}


	public void initItem(){

		model.Book b = new model.Book("Objects first", this);

		LectureItem li = new LectureItem(this, listLecture.get("T"));
		Tablets t = new Tablets(this);
		listItem.add(b);
		listItem.add(li);
		listItem.add(t);
	}


	public void initLecture(){
		Lecture l = new Lecture("A fake description","Cours de POO2");
		Lecture l2 = new Lecture("A fake description2","TD de POO2");
		Lecture l3 = new Lecture("A fake description3","TD de AA");
		Lecture lec = new Lecture("Description","Current lesson");
		Lecture lec2 = new Lecture("Description2","Current lesson");

		listLecture.put("POO0",l);
		listLecture.put("POO1",l2);
		listLecture.put("AA",l3);
		listLecture.put("T",lec);
		listLecture.put("T2",lec2);

	}

	public void setStudent(Student student){
		this.student = student;
	}

	public Student getStudent(){
		return this.student;
	}

	public Item getItem(int i){
		return listItem.get(i);
	}

	public void followAllPOOLecture(){

		Iterator<String> i = listLecture.keySet().iterator();
		String chaine;

		while(i.hasNext()){
			chaine = i.next();
			if(chaine.contains("POO")){
				student.followLecture(listLecture.get(chaine));
			}
		}

	}

	public Lecture getRandomLecture(){

		int max  =listLecture.size(); int min = 0;
		//min et max inclu
		int rand = min + (int)(Math.random() * ((max - min) + 1));


		return listLecture.get(rand);
	}

	//Test ok
	public Lecture getRandomLectureThanStudentDontKnow(){
		int rand = 0;
		String chaine = null;
		do{
			int max  =listLecture.size() -1; int min = 0;
			//min et max inclu
			rand = min + (int)(Math.random() * ((max - min) + 1));



			Iterator<String> i = listLecture.keySet().iterator();
			if(i.hasNext())
				{
				chaine =i.next();


				}


			if(chaine != null)
				while(i.hasNext() && student.know(listLecture.get(chaine)) && rand >= 0){
					rand--;
					chaine = i.next();
				}

		}while(student.know(listLecture.get(chaine)));


		return listLecture.get(chaine);
	}

	//Test OK
	public Lecture getRandomLectureThanStudentKnow(){
		int rand = 0;
		String chaine = null;
		do{
			int max  =listLecture.size() -1; int min = 0;
			//min et max inclu
			rand = min + (int)(Math.random() * ((max - min) + 1));			 

			Iterator<String> i = listLecture.keySet().iterator();


			while(i.hasNext() && rand >= 0){
				rand--;
				chaine = i.next();

			}


		}while(!student.know(listLecture.get(chaine)));


		return listLecture.get(chaine);
	}

	public Game getGame(){
		return game;
	}
	
	public void printListLecture(){

		Iterator<String> i = listLecture.keySet().iterator();
		
		while(i.hasNext()){
			System.out.println(listLecture.get(i.next()));
		}
	}


}
