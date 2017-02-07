package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;


/**
 * Created by spencerhammersten on 2/7/17.
 */
public class filterTodoByStatus {

    @Test
    public void filterTodoByStatus() throws IOException {
        TodoController todoController = new TodoController();
        Todo[] allTodos = todoController.listTodos(new HashMap<>());
        Todo[] trueTodos = todoController.filterTodoByStatus(allTodos, -1, true);
        assertEquals("Incorrect number of todos with Status true", 143,trueTodos.length);
        Todo[] falseTodos = todoController.filterTodoByStatus(allTodos,-1,false);
        assertEquals("Incorrect number of todos with Status false", 157,falseTodos.length);
    }

    @Test
    public void listTodosWithStatusFilter() throws IOException {
        TodoController todoController = new TodoController();
        Map<String, String[]> queryParams = new HashMap<>();
        queryParams.put("status", new String[] {"true"});
        Todo[] trueTodos = todoController.listTodos(queryParams);
        assertEquals("Incorrect number of todos with Status true", 143, trueTodos.length);
        queryParams.put("status", new String[] {"false"});
        Todo[] falseTodos = todoController.listTodos(queryParams);
        assertEquals("Incorrect number of todos with Status False", 157, falseTodos.length);

    }
}