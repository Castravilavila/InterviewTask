# InterviewTask
This is a  program that will parse a csv file, filter the records and paste the valid records to a db and the invalid ones to another csv file

* HOW TO INSTALL AND CONFIGURE

Clone the project and just run the "Main" class because it's all configured

* OPERATING INSTRUCTIONS

The project has a class for every role

1) "ReadCsv" class has the role of parsing the csv file and storing it in an ArrayList of string arrays, also it can filter the records and store them in corresponding "validRecords" and "invalidRecords" variables.

2) "WriteToCsv" class has the role of writing a List of string arrays to a csv file.

3) "DataBaseCSV" class has the role of creating a table in a db if it does not exist, delete all the content if it has
   any and inserting a list of string arrays to it.
   
4) "Log" class has the role of logging the csv results to a log file

5) "DefVariables" class contains all the static links to csv's and db

* KNOWN BUGS

1) The Program can add data only to tables with 10 columns

2) The program is slow

3) The title of table in db will always be the strings from first array in the argument list
