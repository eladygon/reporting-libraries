package dataStorage;
import java.util.ArrayList;
import java.util.List;

public  class DataStorage {
public static String[] dataInputCity = {"Wroclaw","Poznan","Krakow","Warszawa","Gdansk"};
public static  List<Person> listOfPerson = new ArrayList<Person>(){{
			
			  add(new Person(1,"Zofia","Nowak",11,"Test developer","Wroclaw",'f'));
			  add(new Person(2,"Malgorzata","Kowal",40,"Test developer","Wroclaw",'f'));
			  add(new Person(3,"Aleksander","Cybulski",25,"Test manager","Wroclaw",'m'));
			  add(new Person(4,"Justyna","Nizynska",25,"Java developer","Wroclaw",'f'));
			  add(new Person(5,"Tomasz","Sakuta",28,"Java senior developer","Wroclaw",'m'));
			  add(new Person(6,"Olga","Krzeminiska",42,"Senior consultant","Poznan",'f'));
			  add(new Person(7,"Krzysztof","Dudek",23,"Java developer","Poznan",'m'));
			  add(new Person(8,"Karolina","Jezyna",21,"Junior test developer","Poznan",'f'));
			
}};




}

