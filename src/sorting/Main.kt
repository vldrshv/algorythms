package sorting

fun main(args: Array<String>) {
    val ARR_SIZE = 1_000_000
    var arr: Array<Int> = initArray(ARR_SIZE) { it -> it * -2 }
    //arr.forEach { it -> print("$it ") }
    val toFind: Int = -6
    var valueToCheck: Int = -22

    print("\nsorting.find($toFind).position: ${arr.find(toFind)}")
    print("\nsorting.contains(valueToCheck): ${arr.contains(valueToCheck)}")
    print("\nsorting.binaryFind($toFind).position: ${arr.binaryFind(toFind)}\n")

    var startTime: Long = 0
    var endTime: Long = 0

    startTime = System.currentTimeMillis()
    arr.bubbleSort()
    endTime = System.currentTimeMillis()
    println("sorting.bubbleSort time: ${endTime - startTime} ${arr.isSorted()}")

    arr = initArray(ARR_SIZE) { it -> it * -2 }
    startTime = System.currentTimeMillis()
    arr.selectionSort()
    endTime = System.currentTimeMillis()
    println("sorting.selectionSort time: ${endTime - startTime} ${arr.isSorted()}")


    arr = initArray(ARR_SIZE) { it -> it * -2 }
    startTime = System.currentTimeMillis()
    arr.insertionSort()
    endTime = System.currentTimeMillis()
    println("sorting.insertionSort time: ${endTime - startTime} ${arr.isSorted()}")
}

public fun initArray(size: Int = 0, howInit: (Int) -> Int = { it -> it }): Array<Int> {
    return Array(size, howInit)//{it -> (Random().nextInt() % 1000 * (if(Random().nextBoolean()) 1 else -1))}
}

public fun <T> Array<T>.find(value: T): Int {
    var res = this.indexOf(value)
    return res
}
public fun <T : Number> Array<T>.binaryFind(value: T): Int {
    var left = 0
    var right = this.size - 1
    var middle = 0
    if (!this.isSorted())
        return -2

    while (left <= right) {
        middle = (right + left) / 2
        val tmp = this[middle].toDouble()
        when {
            tmp == value.toDouble() -> return middle
            tmp.compareTo(value.toDouble()) == -1 -> left = middle + 1
            else -> right = middle - 1
        }

    }
    return -1
}

public fun <T : Number> Array<T>.bubbleSort() {
    var noChanges: Boolean = true
    for (i in this.size - 1 downTo 1 step 1) {
        for (j in 0 until i) {
            if (this[j].toDouble() > this[j + 1].toDouble())
                this.apply {
                    swap(j, j + 1)
                    noChanges = false
                }
        }
        if (noChanges)
            return
    }
}
public fun <T : Number> Array<T>.selectionSort() {
    var toSwap: Int = 0
    for (i in 0 until this.size) {
        toSwap = i
        for (j in i+1 until this.size) {
            if (this[toSwap].toDouble() > this[j].toDouble())
                toSwap = j
        }
        swap(i, toSwap)
    }
}
public fun <T : Number> Array<T>.insertionSort() {
    for (i in 1 until this.size) {
        var tmp = this[i]
        var j = i
        while(j > 0 && this[j - 1].toDouble() >= tmp.toDouble()) {
            this[j] = this[j - 1]
            --j
        }
        this[j] = tmp
    }
}

public fun <T> Array<T>.contains(value: T): Boolean {
    return this.find(value) != -1
}
private fun <T> Array<T>.swap(indexFrom: Int, indexTo: Int) {
    val tmp = this[indexFrom]
    this[indexFrom] = this[indexTo]
    this[indexTo] = tmp
}

private fun <T: Number> Array<T>.isSorted(): Boolean {
    for (i in 0 until this.size-1)
        if (this[i].toDouble() > this[i+1].toDouble())
            return false

    return true
}