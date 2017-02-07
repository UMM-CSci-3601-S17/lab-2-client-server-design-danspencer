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
        long limit = -1;
        //This is where we define how filters happen and which ones exist based on parameters passed (queryParams)


        if(queryParams.containsKey("limit")) {
            try {
                limit = Integer.parseInt(queryParams.get("limit")[0]);
            }
            catch(NumberFormatException nfe)
            {
                nfe.printStackTrace();
            }
        }

        if(queryParams.containsKey("owner"))
        {
            String owner = queryParams.get("owner")[0];
            filteredTodos = filterTodoByOwner(filteredTodos, limit, owner);
        }

        if(queryParams.containsKey("contains"))
        {
            String text = queryParams.get("contains")[0];
            filteredTodos = filterTodoByBodyContains(filteredTodos, limit, text);
        }

        // Filter by options if specified

        /*if(queryParams.containsKey("id")) {
            String id = queryParams.get("id")[0];
            Todo a = getTodoByID(id);
            if (a == null)
                filteredTodos = new Todo[0]; //Return an array with no todos
            else
                filteredTodos = new Todo[]{a};//Return an array with the todo found
        }*/


        return filteredTodos;
    }

    // Filter todos
    public Todo[] filterTodoByOwner(Todo[] filteredTodos, long limit, String owner) {
        if(limit < 0) //If limit is a sentinel (invalid) value then there is no limit
            return Arrays.stream(filteredTodos).filter(x -> x.owner.equals(owner)).toArray(Todo[]::new);
        else
            return Arrays.stream(filteredTodos).filter(x -> x.owner.equals(owner)).limit(limit).toArray(Todo[]::new);
    }

    public Todo[] filterTodoByBodyContains(Todo[] filteredTodos, long limit, String text) {
        if(limit < 0) //If limit is a sentinel (invalid) value then there is no limit
            return Arrays.stream(filteredTodos).filter(x -> x.body.contains(text)).toArray(Todo[]::new);
        else
            return Arrays.stream(filteredTodos).filter(x -> x.body.contains(text)).limit(limit).toArray(Todo[]::new);
    }

    // Get a single todo
    public Todo getTodoByID(String id) {
        return Arrays.stream(todos).filter(x -> x._id.equals(id)).findFirst().orElse(null);
    }
}
