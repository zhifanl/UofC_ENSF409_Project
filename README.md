# UofC_ENSF409_Project ENSF409 Group#10, HYL Discord Group 14.

ENSF 409 final project for the HYL hackathon, made by (ENSF409 Group 10), (HYL Group 14).

Team Members: Taimor Abrar, Tianfan Zhou, Manpreet Singh, Zhifan Li

Our Project is in main branch.

All the java file is in edu/ucalgary/ensf409

# To run Junit: 
1. javac -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar:mysql-connector-java-8.0.23.jar  edu/ucalgary/ensf409/TestMySystem.java
2. java -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar:mysql-connector-java-8.0.23.jar  org.junit.runner.JUnitCore edu.ucalgary.ensf409.TestMySystem

# To Run the program 
1. clone the code
2. javac edu/ucalgary/ensf409/MySystem.java 
3. java edu/ucalgary/ensf409/MySystem inputFileName outputFileName

* main method is in MySystem.java
* How to run this program: 
* execute the main method and GUI window will pop to the user,
* in the window, type the user name as "scm", password as "ensf409", which are the default user name and password that this course uses.
* and type the order request: the format should be similar as this: "mesh chair,1", "executive chair,2", "swing arm lamp,3".
* then click "submit", and the program will execute these request and use the GUI to give you result, also Output.txt file will be generated that have required information on it.
* The GUI may give you error message if the user name is not found, or the password is not correct, or the DBURL is not correct in the SupplyChain java file
* The GUI may give you prompt if you enter a invalid number, also if you enter invalid information for required type or category, it will gives you error message.
* Every time it gives you error prompt, it will terminate itself, and you need to run this again.
* Output.txt file will also give error message if there is any error with your inputs.
* Check Output.txt file every time you finish running the program.

UML Diagram is here: 
https://github.com/zhifanl/UofC_ENSF409_Project/blob/main/UML_Diagram.png
![...](https://github.com/zhifanl/UofC_ENSF409_Project/blob/main/UML_Diagram.png)

# How this project is designed:

We have main method inside the MySystem file and it passes the command line argument as parameter to call method of SupplyChain. SupplyChain will read the input from the input file based on the command line arg you provide. SupplyChain will retrieve the order request in input file, and it will initiate a database connection as localhost for using the Inventory class, the Inventory object will have connection to the database, which will get the information from localhost, for example, which specific category it is looking for. There are 5 categories: Filing, Desk, Furniture, Chair, Lamp.

After getting the information as a LinkedList from a database, it will use its very customized and useful algorithm. It will search if any component of each item is used from the smallest possible amount of items to the largest possible amount of items.(for example, when searching available and cheapest order for CHAIR, it will first find if there is only one item that can satisfy this requirement, then look for 2, 3, and 4)

After having the algorithm bring you back the best choice, the system will process the order, it will write the order you have in the output file that specified in the command line, and it will also update the database. When the system cannot find such possible order, it will first search the possible manufacturer from the database and then give the user the useful information (The Manufacturer names whose ManuIDs match the item that is not found in the database).

One thing that is hard to solve is that, when dealing with multiply orders, sometimes only one or few orders can be processed, not all can be processed since the rest of them is out of stock. So we design to solve this problem by our programming knowledge. We made the system to process as many orders as it could, and also when something is out of stock, and database information will behave the same way too. it will also search for the manufacturer that could produce this type of product, and write it into the output file.

Also, We are employing Junit testing in the project: there are so far 17 test cases that test the algorithm we wrote and check for proper throw of exceptions. And so far the system can pass all the test cases and input-output files with the expected result.

That is how this program is designed, hope you will enjoy it.

