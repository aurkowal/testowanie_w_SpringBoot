package pl.coderslab.JSONPath;

import com.jayway.jsonpath.JsonPath;
import org.apache.commons.io.IOUtils;

import java.util.List;

public class Students {
    public static void main(String[] args) throws Exception {
        String json = IOUtils.toString(JSONPathExample.class.getResourceAsStream("/data/students.json"));
        String name = JsonPath.read(json, "$.student.firstName");
        String surname = JsonPath.read(json, "$.student.lastName");
        System.out.println("Imię i nazwisko studenta: " + name + " " + surname);
        Double avg = JsonPath.read(json, "$.student.averageGrade");
        System.out.println("średnia ocen: " + avg);
        List<String> subjects = JsonPath.read(json, "$.student.subjects[*]");
        System.out.println("Przedmioty studenta: ");
        for (String s : subjects) {
            System.out.println(s);
        }
        String fathersName = JsonPath.read(json, "$.student.parents.father.firstName");
        String fathersSurname = JsonPath.read(json, "$.student.parents.father.lastName");
        System.out.println("Imię i nazwisko ojca: " + fathersName + " " + fathersSurname);
        String mothersName = JsonPath.read(json, "$.student.parents.mother.firstName");
        String mothersSurname = JsonPath.read(json, "$.student.parents.mother.lastName");
        System.out.println("Imię i nazwisko matki: " + mothersName + " " + mothersSurname);
    }
}
