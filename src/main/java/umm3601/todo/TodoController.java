package umm3601.todo;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public class TodoController {

    private Todo todos[];

    public TodoController() throws IOException {
        Gson gson = new Gson();
        FileReader reader = new FileReader("src/main/data/todos.json");
        todos = gson.fromJson(reader, Todo[].class);
    }

    // List users
    public Todo[] listTodos(Map<String, String[]> queryParams) {
        Todo[] filteredTodos = todos;

        //This is where we define how filters happen and which ones exist based on parameters passed (queryParams)

        // Filter age if defined
        /*if(queryParams.containsKey("age")) {
            int age = Integer.parseInt(queryParams.get("age")[0]);
            filteredUsers = filterUsersByAge(filteredUsers, age);
        }*/

        return filteredTodos;
    }

    // Filter todos
    /*public Todo[] filterUsersByAge(Todo[] filteredUsers, int age) {
        return Arrays.stream(filteredUsers).filter(x -> x.age == age).toArray(Todo[]::new);
    }*/

    // Get a single todo
    public Todo getTodoByID(String id) {
        return Arrays.stream(todos).filter(x -> x._id.equals(id)).findFirst().orElse(null);
    }
}
