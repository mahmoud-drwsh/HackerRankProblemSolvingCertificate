import java.util.*

fun filledOrders(order: Array<Int>, k: Int): Int {
    // make k modifiable
    var k = k
    // create a PriorityQueue of the orders
    var pQ = PriorityQueue(order.toList())
    // remove orders bigger than k
    while (!pQ.isEmpty() && pQ.peek() > k) pQ.remove()
    // if the PriorityQueue is empty then we can't fulfill any orders
    if (pQ.isEmpty()) return 0
    // a counter for the orders that can be fulfilled
    var count = 0
    /*
    * counting the orders that can be fulfilled by fulfilling
    * orders starting at the largest down to the smallest
    */
    while (!pQ.isEmpty() && (k - pQ.peek() >= 0)) {
        k -= pQ.remove()
        count++
    }
    return count
}