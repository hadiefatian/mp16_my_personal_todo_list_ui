package at.refugeescode.mp16_my_personal_todo_list_ui.controller;

import at.refugeescode.mp16_my_personal_todo_list_ui.model.ToDo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ToDoController {

    @Value("${todo.url}")
    private String todoUrl;

    private RestTemplate restTemplate;

    public ToDoController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<ToDo> showAll() {
        ToDo[] toDos = restTemplate.getForObject(todoUrl, ToDo[].class);
        return Arrays.asList(toDos);
    }

    public void addNewToDo(ToDo toDo) {
        restTemplate.postForObject(todoUrl, toDo, ToDo.class);
    }

    private void print(Object toDo) {
        System.out.println(toDo);
    }

    public void done(String id) {
        String url = todoUrl + "/" + id + "/done";
        restTemplate.put(url, ToDo.class);
    }

    public void removeToDo(String id) {
        String url = todoUrl + "/" + id;
        restTemplate.delete(url, ToDo.class);
    }

}

