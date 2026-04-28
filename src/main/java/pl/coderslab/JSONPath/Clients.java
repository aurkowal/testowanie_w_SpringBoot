package pl.coderslab.JSONPath;
import org.apache.commons.io.IOUtils;
import java.util.List;
import com.jayway.jsonpath.JsonPath;



public class Clients {
    public static void main(String[] args) throws Exception{
        String json = IOUtils.toString(JSONPathExample.class.getResourceAsStream("/data/clients.json"));
        List<String> names = JsonPath.read(json, "$.clients[?(@.country=='USA')].name");

        System.out.println("Osoby, mieszkające w USA: ");
        for (String name : names) {
            System.out.println(name);
        }
    }
}
