Xayah is a professional gamer, she has won many famous games and she is intending to conquer the newly released NOXA game.

NOXA will give the player **total** number of missions, from mission **0** to mission **total-1**. 
Game play has some conditions represented as 2-dimensional array where the **conditions[i] = [m1, m2]** means to take the mission **m1**, Xayah needs to complete the mission **m2** first.

You can help Xayah determine if she can win the game by completing all the missions. Return **victory** if possible. Otherwise, return **defeat**


Example:  
Input: total = 2, conditions = [[1,0]]  
Output: victory  
Explanation:  
According to the input, there are 2 total missions.  
To take the mission 1, Xayah should have completed mission 0.  
She can win.

Input: total = 2, conditions = [[1,0], [0,1]]  
Output: defeat  
Explanation:  
According to the input, there are 2 total missions.  
To take the mission 1, Xayah should have completed mission 0.  
To take the mission 0, Xayah should have completed mission 1.  
She can not win.  



Constraint:  
1 <= total <= 10000  
0 <= conditions.length <= 5000  
conditions[i].length == 2  
0 <= m1, m2 < total  
All the pairs [m1 ,m2] are **distinct**  

