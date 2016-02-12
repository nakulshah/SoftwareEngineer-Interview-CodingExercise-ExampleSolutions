This project is a solution for: Backend_Java_Quiz_20140127

To use the project:
1. if you find a jar file named com.schrodinger.quiz.s3-1.0-SNAPSHOT.jar in \com.schrodinger.quiz.s3\target
--> then step 2 is optional
2. build the program, this will create a jar file named com.schrodinger.quiz.s3-1.0-SNAPSHOT.jar in \com.schrodinger.quiz.s3\target
3. run the program by giving the following command
java -jar com.schrodinger.quiz.s3-1.0-SNAPSHOT.jar -ProteinsFile="<protein file address>" -DrugsFile="<drugs file address>"
e.g. java -jar com.schrodinger.quiz.s3-1.0-SNAPSHOT.jar -ProteinsFile="C:\\proteins.txt" -DrugsFile="C:\\drugs.txt"
4. the results () summary will be shown in the begening, this will be followed by detailed pairing of 

Q] This solution could all be accomplished by a single static function. Why was such a big application written?
A] One Word: Expandability 
Elaborate: It is not just about solving this particular problem. It is about laying the framework for solving many more 
to come.
Example: (1) We can use dependency injection and have a more speedy calculation by trading off some accuracy

Q] What criteria was used to certify the solution as acceptable?
A] Development was started after the test shah.nakul.com.schrodinger.quiz.s3.BAMaximizerTest was written
A sample test set of Proteins {TPHE39A, ZO-1, ACC2} and Drugs {Lipitor, Actos, Zosyn} were taken and run against the program. For the test to pass, the program was required to compute the expected output (total BA of 20.00) 


Note: The class shah.nakul.com.schrodinger.quiz.s3.thirdparty.HungarianAlgorithm was taken from https://raw.github.com/mudspike/sokoban-searcher/master/src/HungarianAlgorithm.java. 
Modifications were then made in the class to support decimal values

- Nakul Shah
773.537.8757
nakulshah@gmail.com


