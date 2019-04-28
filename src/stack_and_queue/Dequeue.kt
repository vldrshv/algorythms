package stack_and_queue

class Dequeue<T> (dequeueSize: Int = 0) : Queue<T>(dequeueSize) {
    fun removeLeft(): T? = remove()
    fun removeRight(): T? {
        print("****** REMOVE ******\n")
        print("before: " + this.toString())

        var toReturn: T? = null
        if (!isEmpty()) {
            toReturn = rear
            queue.removeLast()
            rear = queue.peekLast()
        }

        print("after: " + this.toString())
        print("${queue.size} top = $front last = $rear\n")

        return toReturn
    }
    fun insertLeft(element: T): Dequeue<T> {
        print("****** INSERT_LEFT ******\n")
        print("before: " + this.toString())
        if (!isFull()) {
            queue.add(0, element)
            front = queue.peekFirst()
            rear = rear ?: queue.peekLast()
        }
        print("after: " + this.toString())
        print("${queue.size} top = $front last = $rear\n")
        return this
    }
    fun insertRight(element: T): Dequeue<T> = insert(element) as Dequeue<T>
}