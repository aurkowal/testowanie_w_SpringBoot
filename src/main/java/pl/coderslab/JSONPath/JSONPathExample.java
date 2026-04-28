package pl.coderslab.JSONPath;

import com.jayway.jsonpath.JsonPath;
import org.apache.commons.io.IOUtils;

import java.util.List;

public class JSONPathExample {

    public static void main(String[] args) throws Exception {
        // Odczytanie zawartości pliku JSON
        String json = IOUtils.toString(JSONPathExample.class.getResourceAsStream("/data/books.json"));

        // Użycie JsonPath do wyodrębnienia tytułów książek, które kosztują mniej niż 15 jednostek waluty
        List<String> titles = JsonPath.read(json, "$.books[?(@.price < 15)].title");

        // Wyświetlenie tytułów
        System.out.println("Tytuły książek, które kosztują mniej niż 15 jednostek waluty:");
        for (String title : titles) {
            System.out.println(title);
        }
    }
}