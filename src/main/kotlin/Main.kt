import algorithm.LeetCode

fun main(args: Array<String>) {

    if(args.isEmpty()){
        println("input problem numbers")
    } else{
        println("inputted problem number -> ${args[0]}")
        val leetCode = LeetCode()

        val question: String = args[0]

        when(question.toInt()){
            1 -> leetCode.twoSum()
            2 -> leetCode.addTwoNums()
            3 -> leetCode.lengthOfLongestSubstring()
        }
    }

}