package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;


/**
 * Created by spencerhammersten on 2/7/17.
 */
public class filterTodoByCategory {

    @Test
    public void filterTodoByCategory() throws IOException {
        TodoController todoController = new TodoController();
        Todo[] allTodos = todoController.listTodos(new HashMap<>());
        Todo[] homeworkTodos = todoController.filterTodoByCategory(allTodos, -1, "homework");
        assertEquals("Incorrect number of todos with category homework", 79,homeworkTodos.length);
        Todo[] groceriesTodos = todoController.filterTodoByCategory(allTodos,-1,"groceries");
        assertEquals("Incorrect number of todos with category groceries", 76,groceriesTodos.length);
    }

    @Test
    public void listTodosWithCategoryFilter() throws IOException {
        TodoController todoController = new TodoController();
        Map<String, String[]> queryParams = new HashMap<>();
        queryParams.put("category", new String[] {"homework"});
        Todo[] homeworkTodos = todoController.listTodos(queryParams);
        assertEquals("Incorrect number of todos with category Homework", 79, homeworkTodos.length);
        queryParams.put("category", new String[] {"groceries"});
        Todo[] groceriesTodos = todoController.listTodos(queryParams);
        assertEquals("Incorrect number of todos with category Groceries", 76, groceriesTodos.length);

    }
}