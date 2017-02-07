package umm3601.todo;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.text.ParseException;
import java.util.Comparator;

public class Todo {

    public Todo(){}
    public Todo(final Todo other)
    {
        _id = other._id;
        owner = other.owner;
        status = other.status;
        body = other.body;
        category = other.category;
    }

    String _id;
    String owner;
    boolean status;
    String body;
    String category;

    public static class TodoComparator implements Comparator<Todo>
    {
        public static final int
                ORDER_BY_ID        = 1,
                ORDER_BY_OWNER     = 2,
                ORDER_BY_STATUS    = 3,
                ORDER_BY_BODY      = 4,
                ORDER_BY_CATEGORY  = 5;

        private int orderBy;

        public TodoComparator(int ORDER_BY)
        {
            orderBy = ORDER_BY;
        }

        public TodoComparator(String ORDER_BY)
        {
            orderBy = parseOrder(ORDER_BY);
        }

        public static int parseOrder(String token)
        {
            token = token.toLowerCase();
            switch (token)
            {
                case "id":
                    return ORDER_BY_ID;
                case "owner":
                    return ORDER_BY_OWNER;
                case "status":
                    return ORDER_BY_STATUS;
                case "body":
                    return ORDER_BY_BODY;
                case "category":
                    return ORDER_BY_CATEGORY;
            }
            throw new RuntimeException("Parse Order not understood token=" + token);
        }

        /**
         * Compare a todo with another based on how this comparator was told to order by
         * @param a First Todo
         * @param b Second Todo to compare against
         * @return result of comparison of a and b
         */
        public int compare(Todo a, Todo b)
        {
            switch (orderBy)
            {
                case ORDER_BY_ID:
                    return a._id.compareTo(b._id);
                case ORDER_BY_OWNER:
                    return a.owner.compareTo(b.owner);
                case ORDER_BY_STATUS:
                    return Boolean.compare(a.status, b.status);
                case ORDER_BY_BODY:
                    return a.body.compareTo(b.body);
                case ORDER_BY_CATEGORY:
                    return a.category.compareTo(b.category);
                default:
                    throw new RuntimeException("Requested to compare Todos without telling how. ORDER_BY=" + orderBy);
            }
        }
    }
}