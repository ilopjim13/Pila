/**
 * Función genérica que invierte la lista que se le ha dado retornando la lista invertida
 * @param pila :Pila pila que va a invertir
 * @return List<T> lista invertida de cualquier tipo
 */
fun <T> reverse(pila: Pila<T>) :List<T> {
    val nuevaLista = Pila(mutableListOf<T>())
    val listaCopia = pila
    val iterator = pila.pila.listIterator()

    if (pila.isEmpty()) {
        while (iterator.hasNext()) {
            listaCopia.top()?.let { nuevaLista.push(it) }
            listaCopia.pop()
        }
    }

    return nuevaLista.pila
}


fun main() {

    val numbers = Pila(mutableListOf("one", "two", "three", "four"))
    val numbersRev:List<String> = reverse(numbers)
    if (!listOf("four", "three", "two", "one").equals(numbersRev))
        println("Error")
    else
        println("Correcto")

    println(numbersRev)

    //Realiza la misma prueba, pero con listas de otros tipos de datos...
    //por ejemplo una lista que combine valores numéricos Int, Float y Double

    val numbers2 = Pila(mutableListOf(1, 2.0f, 3.9878, 4))
    val numbersRev2:List<Number> = reverse(numbers2)
    if (!listOf(4, 3.9878, 2.0f, 1).equals(numbersRev2))
        println("Error")
    else
        println("Correcto")

    println(numbersRev2)

    //Otra con una lista de cualquier data class que te inventes.

    //Comprueba también si podemos hacerlo con una lista de tipos de datos distintos...
    //por ejemplo con una lista que contenga tipos de datos String, Int, Float, Usuario("Pepe", 30), Boolean...
    //¿Por qué es posible usarla si parece que la lista contiene tipos de datos diferentes?

    val numbers3 = Pila(mutableListOf("one", 2, 3f, 4.243, Usuario("Pepe", 30), true))
    val numbersRev3:List<Any> = reverse(numbers3)
    if (!listOf(true,Usuario("Pepe", 30),4.243,3f,2,"one").equals(numbersRev3))
        println("Error")
    else
        println("Correcto")

    println(numbersRev3)

}