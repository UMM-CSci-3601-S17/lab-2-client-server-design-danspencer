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

        // Filter by options if specified
        /*if(queryParams.containsKey("id")) {
            String id = queryParams.get("id")[0];
            Todo a = getTodoByID(id);
            if(a == null)
                filteredTodos = new Todo[0]; //Return an array with no todos
            else
                filteredTodos = new Todo[]{a};//Return an array with the todo found
        }*/

        return filteredTodos;
    }

    // Filter todos
    /*public Todo[] filterTodoByID(Todo[] filteredTodos, String id) {
        return Arrays.stream(filteredTodos).filter(x -> x._id.equals(id)).toArray(Todo[]::new);
    }*/

    // Get a single todo
    public Todo getTodoByID(String id) {
        return Arrays.stream(todos).filter(x -> x._id.equals(id)).findFirst().orElse(null);
    }
}
