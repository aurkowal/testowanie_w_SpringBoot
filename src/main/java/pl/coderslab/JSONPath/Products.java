package pl.coderslab.JSONPath;

import com.jayway.jsonpath.JsonPath;
import org.apache.commons.io.IOUtils;

import java.util.List;

public class Products {
    public static void main(String[] args) throws Exception {
        String json = IOUtils.toString(JSONPathExample.class.getResourceAsStream("/data/products.json"));
        List<String> products = JsonPath.read(json, "$.products[?(@.category == 'Electronics' && @.price > 500)].name");

        System.out.println("Produkty z kategorii Elektronika i cenie powyzej 500: ");
        for (String product : products) {
            System.out.println(product);
        }

    }
}
