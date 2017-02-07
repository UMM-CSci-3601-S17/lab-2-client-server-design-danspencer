/**
 * We use this to make sure we're not trying to do stuff with the
 * elements on the page before the page is even loaded.
 *
 * The use of window.onload is slightly controversial these days, so
 * feel free to google around and replace this with a more
 * up-to-date solution if you think that would be interesting.
 */
window.onload = function() {
    console.log("The page is loaded now!");

    var element = document.getElementById('getTodos');
    element.addEventListener("click", getTodos, true);

    element = document.getElementById('getTodoByID');
    element.addEventListener("click", getTodoByID, true);

    document.getElementById('owner_name_enabled').checked = false;
    document.getElementById('body_contains_enabled').checked = false;
    document.getElementById('category_enabled').checked = false;
    document.getElementById('status_enabled').checked = false;
    document.getElementById('order_enabled').checked = false;
    document.getElementById('limit_enabled').checked = false;

    document.getElementById('owner_name_enabled').addEventListener("change", refreshTodoListForms);
    document.getElementById('body_contains_enabled').addEventListener("change", refreshTodoListForms);
    document.getElementById('category_enabled').addEventListener("change", refreshTodoListForms);
    document.getElementById('status_enabled').addEventListener("change", refreshTodoListForms);
    document.getElementById('order_enabled').addEventListener("change", refreshTodoListForms);
    document.getElementById('limit_enabled').addEventListener("change", refreshTodoListForms);

    refreshTodoListForms();
};

/**
 * Refresh the TodoList UI disabled status to reflect
 * the status of the checkboxes
 */
var refreshTodoListForms = function() {
    document.getElementById('todo_filter_owner_name').disabled      = !document.getElementById('owner_name_enabled').checked;
    document.getElementById('todo_filter_body_contains').disabled   = !document.getElementById('body_contains_enabled').checked;
    document.getElementById('todo_filter_category').disabled        = !document.getElementById('category_enabled').checked;
    document.getElementById('todo_filter_status').disabled          = !document.getElementById('status_enabled').checked;
    document.getElementById('todo_ordering').disabled               = !document.getElementById('order_enabled').checked;
    document.getElementById('todo_filter_limit').disabled           = !document.getElementById('limit_enabled').checked;
};

var createGetParameters = function() {
    var prefix = "?";
    var params = "";

    /**
     * Construct params string by the value of the elements of which are enabled
     */

    if (document.getElementById('owner_name_enabled').checked)
    {
        params += prefix + "owner=" + document.getElementById('todo_filter_owner_name').value;
        prefix = "&";
    }
    if(document.getElementById('body_contains_enabled').checked)
    {
        params += prefix + "contains=" + document.getElementById('todo_filter_body_contains').value;
        prefix = "&";
    }
    if(document.getElementById('category_enabled').checked)
    {
        params += prefix + "category=" + document.getElementById('todo_filter_category').value;
        prefix = "&";
    }
    if(document.getElementById('status_enabled').checked)
    {
        params += prefix + "status=" + document.getElementById('todo_filter_status').value;
        prefix = "&";
    }
    if(document.getElementById('order_enabled').checked)
    {
        params += prefix + "orderBy=" + document.getElementById('todo_ordering').value;
        prefix = "&";
    }
    if(document.getElementById('limit_enabled').checked)
    {
        params += prefix + "limit=" + document.getElementById('todo_filter_limit').value;
        prefix = "&";
    }
    return params;
}

/**
 * Function to get all the todos!
 */
var getTodos = function() {

    var parameters = createGetParameters();

    var HttpThingy = new HttpClient();
    HttpThingy.get("/api/todos" + parameters, function(returned_json){
        document.getElementById('jsonDump').innerHTML = returned_json;
    });
};

/**
 * Function to get one of the todos!
 */
var getTodoByID = function() {
    var id = document.getElementById('todo_getby_id').value;

    var HttpThingy = new HttpClient();
    HttpThingy.get("/api/todos/" + id, function(returned_json){
        document.getElementById('jsonDump').innerHTML = returned_json;
    });
};


/**
 * Wrapper to make generating http requests easier. Should maybe be moved
 * somewhere else in the future!.
 *
 * Based on: http://stackoverflow.com/a/22076667
 * Now with more comments!
 */
function HttpClient() {
    // We'll take a URL string, and a callback function.
    this.get = function(aUrl, aCallback){
        var anHttpRequest = new XMLHttpRequest();

        // Set a callback to be called when the ready state of our request changes.
        anHttpRequest.onreadystatechange = function(){

            /**
             * Only call our 'aCallback' function if the ready state is 'DONE' and
             * the request status is 200 ('OK')
             *
             * See https://httpstatuses.com/ for HTTP status codes
             * See https://developer.mozilla.org/en-US/docs/Web/API/XMLHttpRequest/readyState
             *  for XMLHttpRequest ready state documentation.
             *
             */
            if (anHttpRequest.readyState == 4 && anHttpRequest.status == 200)
                aCallback(anHttpRequest.responseText);
        };

        anHttpRequest.open("GET", aUrl, true);
        anHttpRequest.send(null);
    }
}