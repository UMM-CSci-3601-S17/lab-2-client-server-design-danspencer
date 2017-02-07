package umm3601.todo;

import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class getTodoByID {

    @Test
    public void getStokesClayton() throws IOException {
        TodoController TodoController = new TodoController();
        Todo Todo = TodoController.getTodoByID("58895985164faefd0ad32fd0");
        assertEquals("Incorrect body", "Nostrud sint dolore occaecat nisi do Lorem nulla consequat magna esse. Eu enim exercitation Lorem elit eiusmod est.", Todo.body);
    }

    @Test
    public void getBoltonMonroe() throws IOException {
        TodoController TodoController = new TodoController();
        Todo Todo = TodoController.getTodoByID("5889598502d8a80d0ee55da5");
        assertEquals("Incorrect body", "Consectetur id quis esse est dolore duis non nulla commodo dolor. Anim aliquip pariatur tempor dolor.", Todo.body);
    }
}