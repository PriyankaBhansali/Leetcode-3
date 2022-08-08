When using DP array - space complexity will be O(m.n) 
but you don't need to check if obstacleGrid[0][0] == 1, dp array will take care of it
to reduce space complexity to O(1), we can use same obstacleGrid but need to take care of few things here

If you start filling column first then start with 0th column and then start row with 1st row or vice versa
-- because once you say, start with 0th column and you see no obstacle you mark it as 1 which means that 
when you now start filling the 1st row next time say, with 0th column index, it will have 1 and so consider it 
as an obstacle and hence mark all the remaining columns in the 1st row as 0.

-- for cases [[1,0]], we check first column (fill column) and see obstacle 1 so we make it to 0, but then when we fill rows, 
we start with column 1. And if it's original value is 0 (no obstacle) then we make it as 1, meaning 1 path possible.
 But we should have it as 0 because the previous column value - column 0, was turned to 0
So for this case we need to check if obstacleGrid[0][0] == 1 and return directly if that's the first case

-- for case -[[0]], we can't start filling first column with i = 1. It has to be i = 0 when filling first column
and i = 1 when fill first row along with if obstacleGrid[0][0] == 1 before filling either of those
