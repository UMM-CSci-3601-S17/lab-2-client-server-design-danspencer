package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;


/**
 * Created by spencerhammersten on 2/7/17.
 */
public class filterTodoByBodyContains {

    @Test
    public void filterTodoByBodyContains() throws IOException {
        TodoController todoController = new TodoController();
        Todo[] allTodos = todoController.listTodos(new HashMap<>());
        Todo[] LoremTodos = todoController.filterTodoByBodyContains(allTodos, -1, "Lorem");
        assertEquals("Incorrect number of todos with BodyContains Lorem", 83,LoremTodos.length);
        Todo[] ipsumTodos = todoController.filterTodoByBodyContains(allTodos,-1,"ipsum");
        assertEquals("Incorrect number of todos with BodyContains ipsum", 59,ipsumTodos.length);
    }

    @Test
    public void listTodosWithBodyContainsFilter() throws IOException {
        TodoController todoController = new TodoController();
        Map<String, String[]> queryParams = new HashMap<>();
        queryParams.put("BodyContains", new String[] {"Lorem"});
        Todo[] LoremTodos = todoController.listTodos(queryParams);
        assertEquals("Incorrect number of todos with BodyContains Lorem", 83, LoremTodos.length);
        queryParams.put("BodyContains", new String[] {"ipsum"});
        Todo[] ipsumTodos = todoController.listTodos(queryParams);
        assertEquals("Incorrect number of todos with BodyContains Ipsum", 59, ipsumTodos.length);

    }
}