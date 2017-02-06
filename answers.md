1. What is the purpose of .gitignore?


    Tells git which files to not accept commits to modify.
    
2. Explain what a _Route_ is.


    Code telling the server how to respond to a request.
    
3.  What is the purpose of umm3601.server class?
    What is the purpose of the umm3601.user.userController class? 
    Explain what happens when a user accesses each of the following URLs
    
    
    a. To set up routes, redirects, and server behavior
    b. UserController is a class used to store and operate on a list of users.
    c. users: redirected to users.html
        api/users: given what appears to be json packaged with the gson library with all of the users
        api/users?age=25: given the same list except with only users of age=25 
        api/users/588935f5de613130e931ffd5: given a length 1 list with the user whose ID is 588935f5de613130e931ffd5
    
4.  What happens when the user accesses the page "kittens"? Modify the server code so accessing the page "kittens" results in the text "Meow". 
    Describe what you did and how it worked.
    
    
    a. 404 Error
    b. Added a line in Server.java defining a route for /kittens to return the string "Meow"
    
5.  What are the contents of the public folder?
    What is the purpose of each of the HTML files there?
    
    
    a. Client files, including resources such as images, stylesheet(s), javascript, and html files
    b. index.html is the first one to be loaded if you don't request anything specific,
        the others are the ones loaded if you do request something specific.
    
6.  Describe what happens when you filter users by age in the client? (sic)
    What is read from the web page, and what request is sent to the server?
    What is received, and how/where is it displayed?
    
    
    a. It sends a query to the server to filter them
    b. Nothing, url with a query is sent to the server
    c. A list of users filtered by age in raw json, displayed right on the page
    
7.  Where is the client-side JavaScript defined? 
    Name the file(s) in which it is used.
    
    
    a. src/main/resources/public/javascript/users.js
    b. users.html, index.html references a nonexistent .js file