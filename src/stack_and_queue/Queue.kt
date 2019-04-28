package stack_and_queue

import java.util.*

open class Queue<T>(queueSize: Int = 0) {
    protected var queue: LinkedList<T> = LinkedList()
    protected var front: T? = null
    protected var rear: T? = null
    protected var maxSize: Int = queueSize

    fun isEmpty(): Boolean = queue.isEmpty()
    fun isFull(): Boolean = queue.size == maxSize
    fun size(): Int = queue.size

    fun insert(element: T): Queue<T> {
        print("****** INSERT ******\n")
        print("before: " + this.toString())
        if (!isFull()) {
            queue.add(element)
            front = front ?: queue.peekFirst()
            rear = queue.peekLast()
        }
        print("after: " + this.toString())
        print("${queue.size} top = $front last = $rear\n")
        return this
    }
    fun remove(): T? {
        print("****** REMOVE ******\n")
        print("before: " + this.toString())

        var toReturn: T? = null
        if (!isEmpty()) {
            toReturn = front
            queue.removeFirst()
            front = queue.peekFirst()
        }

        print("after: " + this.toString())
        print("${queue.size} top = $front last = $rear\n")

        return toReturn
    }
    fun peekFirst(): T? = front
    fun peekLast(): T? = rear

    override fun toString(): String {
        return "$queue \n"
    }
}