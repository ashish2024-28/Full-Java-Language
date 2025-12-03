/* Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */

    // 1.Approach Algrothim :- T.C = O(n^2) => find n elements through looping
    //   S.C = O(1) => space required does not depend on the size of the input array, so only constant space is used.

    //2. Two-pass Hash Table Approach :- T.C = O(n) => we traverse the array twice, once to build the hash table and once to find the complement.  
    //  S.C = O(n) => space required depends on the size of the input array, as we store each element in the hash table.

    // 3. One-pass Hash Table Approach :- T.C = O(n) => we traverse the array once, checking for complements in the hash table.
    //  S.C = O(n) => space required depends on the size of the input array, as we store each element in the hash table.