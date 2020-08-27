package org.example.converter;

import org.example.annotation.CustomDateFormat;
import org.example.annotation.JsonValue;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;


public class ConvertToJson {

    public String toJson(Object o)  {

        HashMap<String,String> json=new HashMap<>();
        for(Field field : o.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                if (field.get(o) != null) {
                    JsonValue jsonValue = field.getAnnotation(JsonValue.class);
                    CustomDateFormat customDateFormat = field.getAnnotation(CustomDateFormat.class);
                    if (jsonValue != null) {
                        if (jsonValue.name() != null) {
                            json.put(jsonValue.name(), field.get(o).toString());
                        } else {
                            json.put(field.getName(), field.get(o).toString());
                        }
                    } else if (customDateFormat != null) {
                        if (customDateFormat.format() != null) {
                            LocalDate localDate = (LocalDate) field.get(o);
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(customDateFormat.format());
                            json.put(field.getName(), localDate.format(formatter));
                        } else {
                            json.put(field.getName(), field.get(o).toString());
                        }
                    } else {
                        json.put(field.getName(), field.get(o).toString());
                    }
                }
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }

        return String.valueOf(new JSONObject(json));
    }

}
