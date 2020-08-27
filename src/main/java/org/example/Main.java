package org.example;

import org.example.converter.ConvertToJson;
import org.example.dto.Human;
import org.example.dto.RobotDestroyer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args)  {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = "25/08/2020";
        LocalDate localDate = LocalDate.parse(date, formatter);

        Human human= new Human( "Vasya",  "Noname", "java", localDate);
        RobotDestroyer destroyer= new RobotDestroyer( "231sdfsdf", "killall", 1l,LocalDate.now(),localDate);

        ConvertToJson convertToJson =new ConvertToJson();

        System.out.println(convertToJson.toJson(human));
        System.out.println(convertToJson.toJson(destroyer));


    }

}
