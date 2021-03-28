# UofC_ENSF409_Project ENSF409 Group#10, HYL Discord Group 14.

ENSF 409 final project for the HYL hackathon, made by (ENSF409 Group 10), (HYL Group 14).

Team Members: Taimor Abrar, Tianfan Zhou, Manpreet Singh, Zhifan Li

Our Project is in main branch.

UML Diagram is here: 
https://github.com/zhifanl/UofC_ENSF409_Project/blob/main/uml.png
![...](https://github.com/zhifanl/UofC_ENSF409_Project/blob/main/uml.png)

# How this project is designed:

We have main method inside the MySystem file and it passes the command line argument as parameter to call method of SupplyChain. SupplyChain will read the input from the input file based on the command line arg you provide. SupplyChain will retrieve the order request in input file, and it will initiate a database connection as localhost for using the Inventory class, the Inventory object will have connection to the database, which will get the information from localhost, for example, which specific category it is looking for. There are 5 categories: Filing, Desk, Furniture, Chair, Lamp.

After getting the information as a LinkedList from a database, it will use its very customized and useful algorithm. It will search if every component is not used from the smallest possible amount of items to the largest possible amount of items.(for example, when searching available and cheapest order for CHAIR, it will first find if there is only one item that can satisfy this requirement, then look for 2, 3, and 4)

After having the algorithm bring you back the best choice, the system will process the order, it will write the order you have in the output file that specified in the command line, and it will also update the database. When the system cannot find such possible order, it will first search the possible manufacturer from the database and then give the user the useful information (The Manufacturer names whose ManuIDs match the item that is not found in the database).

One thing that is hard to solve is that, when dealing with multiply orders, sometimes only one or few orders can be processed, not all can be processed since the rest of them is out of stock. So we design to solve this problem by our programming knowledge. We made the system to process as many orders as it could, and also when something is out of stock, and database information will behave the same way too. it will also search for the manufacturer that could produce this type of product, and write it into the output file.

Also, We are employing Junit testing in the project: there are so far 17 test cases that test the algorithm we wrote and check for proper throw of exceptions. And so far the system can pass all the test cases and input-output files with the expected result.

That is how this program is designed, hope you will enjoy it.

