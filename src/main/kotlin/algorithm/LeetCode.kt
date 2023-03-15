package algorithm

import utils.TypeSupport

class LeetCode() {

    fun twoSum(){
        val map = HashMap<Int, Int>()

        val nums: IntArray = intArrayOf(2,7,11,15)
        val target = 9
        println("problem.caseOne nums => ${nums.contentToString()}")
        println("problem.caseOne target => $target")

        for(idx in nums.indices){
            val complement = target - nums[idx]
            if(map.containsKey(complement)){
                println("no1 result => ${intArrayOf(map[complement]!!, idx).contentToString()}")
            }
            map[nums[idx]] = idx
        }

        throw IllegalArgumentException("no two sum solution")
    }

    fun addTwoNums(){
        val typeSupport = TypeSupport()

        val l1 = typeSupport.ListNode(2).apply{
            next = typeSupport.ListNode(4).apply {
                next = typeSupport.ListNode(3)
            }
        }

        val l2 = typeSupport.ListNode(5).apply{
            next = typeSupport.ListNode(6).apply {
                next = typeSupport.ListNode(4)
            }
        }

        var carry = 0
        var p: TypeSupport.ListNode? = l1
        var q: TypeSupport.ListNode? = l2
        val dummyHead: TypeSupport.ListNode = typeSupport.ListNode(0)
        var curr = dummyHead

        while(p != null || q != null){
            val x = p?.`value` ?:0
            val y = q?.`value` ?: 0

            val sum = carry + x + y
            carry = sum / 10
            curr.next = typeSupport.ListNode(sum % 10)
            curr = curr.next!!
            p = p?.next
            q = q?.next
        }

        if(carry > 0){
            curr.next = typeSupport.ListNode(carry)
        }

        var current:TypeSupport.ListNode? = dummyHead.next
        while(current != null){
            print("${current.`value`}")
            current = current.next
        }

    }

    fun lengthOfLongestSubstring(){
        val s = "abcabcbb"
        println("text is => $s")
        var start = 0
        var maxLength = 0

        for (i in s.indices) {
            val c = s[i]

            if (s.substring(start, i).contains(c)) {
                start = s.indexOf(c, start) + 1
            }

            maxLength = maxOf(maxLength, i - start + 1)
        }

        print("maxLength => $maxLength")
    }

    fun medianOfTwoSortedArrays(){
        val firstArray = intArrayOf(1, 3)
        val secondArray = intArrayOf(2, 7)
        val mergedArray = (firstArray + secondArray).sortedArray()

        val midIndex = mergedArray.size / 2
        val median = if (mergedArray.size % 2 == 0) {
            (mergedArray[midIndex - 1] + mergedArray[midIndex]) / 2.0
        } else {
            mergedArray[midIndex].toDouble()
        }

        print(median)

    }

}