package ee.tlu.Kodutoo05.controller;

import ee.tlu.Kodutoo05.model.Todo;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class RestTemplateController {

    // http://localhost:8080/saa-tegevused
    @GetMapping("saa-tegevused")
    public List<Todo> getTodo() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/todos";
        ResponseEntity<Todo[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Todo[].class);

        return  List.of(response.getBody());
    }

    // http://localhost:8080/saa-tegevused/2
    @GetMapping("saa-tegevused/{kasutajaId}")
    public List<Todo> getUserTodo(@PathVariable int kasutajaId) {

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/todos";
        ResponseEntity<Todo[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Todo[].class);

        List<Todo> kasutajaTodod = new ArrayList<>();
        for (Todo t : response.getBody()) {
            if (t.getUserId() == kasutajaId) {
                kasutajaTodod.add(t);
            }
        }
        return kasutajaTodod;
    }
}
