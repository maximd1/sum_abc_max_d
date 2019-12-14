# sum_abc_max_d
https://www.codewars.com/kata/5a13d36046d843105e000106


You are given a sorted integer array arr. It contains several uniq integers(negative, positive, or zero).

Your task is to find the largest d such that a + b + c = d, where a, b, c, and d are distinct elements of arr. If no such an element d found, return null.

Still not understand the task? Look at the following example ;-)

Example
  For arr = [2,3,5,7,12], the output should be 12. => 12 = 2 + 3 + 7

  For arr = [2,16,64,256,1024], the output should be null. => No such an element d found.

  For arr = [-100,-1,0,7,101], the output should be 0. => 0 = -100 + -1 + 101

Note
  3 < arr.length <= 1000
  -10^8 <= arr[i] <= 10^8
  In order to avoid timeout, be aware of the code's performance ;-)

Happy Coding ^_^
