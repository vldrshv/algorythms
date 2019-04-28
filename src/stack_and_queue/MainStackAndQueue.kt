package stack_and_queue

fun main(args: Array<String>) {
//    stackTest()
//    queueTest()
    dequeueTest()
}
fun stackTest() {
    var stack: Stack<Int> = Stack(5)
    stack.push(1)
            .push(2)
            .push(1)
            .push(1)
            .push(2)
            .push(3)
    stack.pop()
    stack.pop()
    stack.pop()
    stack.push(7)
    stack.pop()
    stack.pop()
    stack.pop()

}
fun queueTest(){
    var queue: Queue<Int> = Queue(5)
    queue.insert(1)
            .insert(2)
            .insert(3)
            .insert(4)
            .insert(5)
            .insert(6)
    queue.remove()
    queue.insert(6)
    queue.remove()
}
fun dequeueTest() {
    var dequeue: Dequeue<Int> = Dequeue(5)
    dequeue.insertRight(1)
            .insertRight(2)
            .insertRight(5)

    dequeue.removeLeft()
    dequeue.insertRight(6)
    dequeue.removeLeft()
}