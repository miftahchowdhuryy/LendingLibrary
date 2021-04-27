# LendingLibrary

I did a project about a Library Management where Customer can borrow a book or dvd from the library. I followed the Object Oriented Programming like Inheritance, Abstraction, Polymorphism and Encapsulation in the project. I have also used Java Collections Framework in my project.

If I tell you a little bit about my project structure, I made three packages which are models, ui, and utilities. In my model package I have all the functionality classes like Book, Customer, Loan. In ui package I have my main class also the ui class which has method like printMaterial, printCustomerHeader. In my utilities class I have my enum like GenderType and LoanStatus.

Now let me give you a brief detail of my projects. In my models package I have Customer class which is basically a blueprint of each customer object. It has states like customer id, title, first name, last name etc.  I made my instance variable as private so that other classes can not access it. However, I have provided getter and setter method if any classes want to access it. I also have a behavior such as mailingName() which print out the first name and last name of each customer. I have used StringBuilder classes here since StringBuilder class is mutable unlike String.  I have also overridden the toString() method of my Object class to print a nice output for each customer object instead of the object reference. 

Then, I have a material class which is an abstract class. I tried to follow the design pattern which tells us to always program on the interface. So there are two classes which inherited Material class which are Book and DVD. They both have the common states like id, title, branch a. It also have a common behavior such as lend(), which basically check if any book has been lended to any customer, if it has already been landed to any customer then it will basically throw a User Define Exception LoanAlreadyExistsException.

I have a class name CustomerRecords which basically add Customer in a HashSet. I have a method name addCustomer() which check if the customer is already exist if its exist then it will throw a user define Exception CusomterAlreadyExistsException, otherwise it will add the customer in a hash set. I used set data structures here to store customer because as we know that set do not allow duplicate unlike other data structures like List. 

I also have a loan class which has states like loan id, customer and book reference variable, start date, due date, return date and status. For date I used GregorianCalender and Date class of Java util package. I have a constructor in this class which basically create a loan based on loan id, customer, and book. It also initialize startDate, due date and status as Current. 

There is also a MaterialCatalgorInterface which has abstract method such as addMaterial, findMaterial. I created an interface to make it more robust. For example, in first pace of my project I stored all the materials in memory. However, later on the project I stored data in a database. So both classes implemented addMaterial and findMaterial different way. So basically I have twos implementation of this interface. One is MaterialCatalogMemoryVersion which store materials in a hash map. I used hash map here since it stores data in a key and value pair also the key is unique in hash map. So this class has a method addMaterial which add material in a hash map. There is also another method fineMaterial which find material by title. If it does not find  any title then it throws a user define exception MaterialNotFoundException.
And the other implementation was a MaterialCatalogDatabaseVersion which stores data in a database. In this class I basically connected to a derby database following the jdbc concept. 
