package learn_data_structure;

import com.google.gson.Gson;
import learn_data_structure.hash.Person;

public class MainApp {


    public static void main(String[] args) {

        Person person = new Person();
        person.setDesc("hello desc");
        Gson gson = new Gson();
        System.out.println(gson.toJson(person));
        System.out.println(gson.fromJson(gson.toJson(person), Person.class));

        Person person1=gson.fromJson(gson.toJson(person), Person.class);
        System.out.println(person1.getDesc());


        person1.getName();

    }
}
