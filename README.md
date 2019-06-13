# songr
This repository cotains a spring application that runs on port 8080 and handles six paths:
/hello
/capitalize/
/reverse
/number
/album
/addNewFileForm

1) The first path prints "Hello World" on the users screen
2) The second path capitalizes any world that is passed after the last forward slash(/)
3) The third path reverses any sentence passed to it.
4) The fourth path gets a number paramater and makes a request to a numbers api and returns a fact about that number (to access this path type "http://localhost:8080/number?number="what ever number you want""
5) The fifth path displays the number of albums currently available in the database, and also contains a link to add a new album to the database
6) The sixth path displays a form that lets users add new albums to the database

HOW TO RUN
1) Fork this repo
2) Make a clone to your local computer
3) Run "gradle bootRun" on your terminal 
4) Go to each of the six paths on your browser


---------------------------------------------------------------------------------------------------------------------------
