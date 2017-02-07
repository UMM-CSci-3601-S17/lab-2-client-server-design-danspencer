package umm3601.todo;

        import org.junit.Test;

        import java.io.IOException;
        import java.util.HashMap;
        import java.util.Map;

        import static junit.framework.TestCase.assertEquals;


/**
 * Created by spencerhammersten on 2/7/17.
 */
public class filterTodoByOwner {

    @Test
    public void filterTodoByOwner() throws IOException {
        TodoController todoController = new TodoController();
        Todo[] allTodos = todoController.listTodos(new HashMap<>());
        Todo[] frysTodos = todoController.filterTodoByOwner(allTodos, -1, "Fry");
        assertEquals("Incorrect number of todos with owner Fry", 61,frysTodos.length);
        Todo[] robertasTodos = todoController.filterTodoByOwner(allTodos,-1,"Roberta");
        assertEquals("Incorrect number of todos with owner Roberta", 46,robertasTodos.length);
    }

    @Test
    public void listTodosWithOwnerFilter() throws IOException {
        TodoController todoController = new TodoController();
        Map<String, String[]> queryParams = new HashMap<>();
        queryParams.put("owner", new String[] {"Fry"});
        Todo[] frysTodos = todoController.listTodos(queryParams);
        assertEquals("Incorrect number of todos with owner Fry", 61, frysTodos.length);
        queryParams.put("owner", new String[] {"Roberta"});
        Todo[] RobertasTodos = todoController.listTodos(queryParams);
        assertEquals("Incorrect number of todos with owner Roberta", 46, RobertasTodos.length);

    }
}
