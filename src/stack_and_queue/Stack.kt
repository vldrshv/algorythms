package stack_and_queue

class Stack<T> {
    private var stack: ArrayList<T> = arrayListOf()
    private var maxSize = 0
    private var topElement: T? = null

    constructor(size: Int) {
        maxSize = size
    }

    fun isEmpty(): Boolean = stack.isEmpty()
    fun isFull(): Boolean = stack.size == maxSize

    fun push(element: T): Stack<T> {
        print("****** PUSH ******\n")
        print("before: " + this.toString())
        print("${stack.size} element = $element\n")
        if (!isFull()) {
            stack.add(element)
            topElement = element
            print("${stack.last()} ")
        }
        print("after: " + this.toString())
        print("${stack.size} topElement = $topElement\n")

        return this
    }
    fun pop(): T? {
        print("------ POP ------\n")
        print("before: " + this.toString())
        print("${stack.size} topElement = $topElement\n")
        if (!isEmpty()) {
            stack.removeLast()
            topElement = if (stack.isEmpty()) null else stack.last()
        }
        print("after: " + this.toString())
        print("${stack.size} topElement = $topElement\n")

        return topElement
    }
    fun peek(): T? {
        return topElement
    }
    override fun toString(): String {
        return "$stack\n"
    }

    private fun <T> ArrayList<T>.removeLast() {
        if (size > 0)
            removeAt(size - 1)
    }

}