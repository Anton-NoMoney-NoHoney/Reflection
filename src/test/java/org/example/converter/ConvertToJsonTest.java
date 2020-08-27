package org.example.converter;


import org.example.dto.Human;
import org.example.dto.RobotDestroyer;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

public class ConvertToJsonTest {
    private ConvertToJson convertToJson =new ConvertToJson();

    @Test
    public void shouldReturnStringWhenConvertNormalObjectClass() {
        //GIVEN
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = "25/08/2020";
        LocalDate localDate = LocalDate.parse(date, formatter);
        Human human= new Human( "Vasya",  "Noname", "java", localDate);
        //WHEN
        String json= convertToJson.toJson(human);
        //THEN
        assertEquals("{\"firstName\":\"Vasya\",\"lastName\":\"Noname\",\"birthDate\":\"25-08-2020\",\"fun\":\"java\"}",json) ;
    }


    @Test
    public void shouldReturnStringWhenConvertLocalDataNoAnnotation() {
        //GIVEN
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = "25/08/2020";
        LocalDate localDate = LocalDate.parse(date, formatter);
        RobotDestroyer destroyer= new RobotDestroyer( "231sdfsdf", "killall", 1l,localDate,localDate);
        //WHEN
        String json= convertToJson.toJson(destroyer);
        //THEN
        assertEquals("{\"number\":\"231sdfsdf\",\"model\":\"killall\",\"dateFrag\":\"2020-08-25\",\"dateRelease\":\"25-серп.-20\",\"killcam\":\"1\"}",json) ;
    }

    @Test
    public void shouldReturnStringWhenConvertObjectWithNullClassField() {
        //GIVEN

        RobotDestroyer destroyer= new RobotDestroyer( null, "killall", null,null,null);
        //WHEN
        String json= convertToJson.toJson(destroyer);
        //THEN
        assertEquals("{\"model\":\"killall\"}",json) ;
    }

}
