import kotlin.math.max

fun longestSubarray(arr: Array<Int>): Int {
    if (arr.size in 0..1) return 1;

    var max = Int.MIN_VALUE

    for ((index, i) in arr.withIndex()) {
        val longest = Math.max(findSubArray(arr, index, i - 1), findSubArray(arr, index, i))
        max = Math.max(max, longest)
    }

    return max
}

fun findSubArray(arr: Array<Int>, index: Int, lowerBound: Int, length: Int = 0): Int {
    if (index > arr.lastIndex || arr[index] - lowerBound !in 0..1) return length
    return findSubArray(arr, index + 1, lowerBound, length + 1)
}
