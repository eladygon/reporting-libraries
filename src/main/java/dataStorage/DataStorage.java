package dataStorage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  class DataStorage {
public static String[] dataInputCity = {"Wroclaw","Poznan","Krakow","Warszawa","Gdansk"};
//list of person in company
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

//salary brutto
public static Map<Integer, Double>listOfEarninigs =  new HashMap<Integer, Double>() {{
	
	put(1,4500.00);
	put(1,5500.00);
	put(1,6500.00);
	put(1,7500.00);
	put(1,8500.00);
	put(1,9500.00);
	put(1,10500.00);
	put(1,11500.00);
	
}};





}

