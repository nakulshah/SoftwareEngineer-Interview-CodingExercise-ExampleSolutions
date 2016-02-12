Q] Which problem does this software solve?
A] This software can solve the Ruby Quiz Problem#234 (http://rubyquiz.strd6.com/quizzes/234-random-points-within-a-circle)

Q] Why was Ruby Quiz Problem#234 chosen?
A] (1) It is 'technically' the latest problem on http://rubyquiz.strd6.com
(2) It is one of the few problems which does not have a solution posted
(3) The HR clearly mentioned the following DONT's
    a. Don't make it a science project
    b. Don't make it a trick question
    Problem#234 satisfied this criteria

Q] What criteria was used to certify the solution as acceptable?
A] All the tests in com.groupon.quiz.nakul.shah.ruby.Problem_234_GenerateRandomPointsTest must pass
(1) The points should be scattered among all the four quadrants of a circle
(2) No point must lie outside of the perimeter of the circle
(3) The position of the points should be equally distributed among the circle area

Q] This could all be accomplished by a single static function. Why was such a big application written?
A] One Word: Expandability 
Elaborate: It is not just about solving this particular problem. It is about laying the framework for solving many more to come.
Example: (1) This framework can be leveraged to get random points in other shapes (squares, etc.)
(2) This framework can also be utilized to solve Ruby Quiz Problem#233 (http://rubyquiz.strd6.com/quizzes/233-geometric-intersections)

- Nakul Shah
nakulshah@gmail.com
773.537.8757