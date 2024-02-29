/**
 * Clase genérica pila que contiene una pila que se puede apilar o desapilar elementos de cualquier tipo
 * @property pila :MutableList<T> lista genérica de cualquier tipo que recibe
 * @property capacidad :Int capacidad de la pila, si no recibe ninguna sera de -1
 */
class Pila<T>(val pila: MutableList<T>, private var capacidad:Int = -1) {

    init {
        require(this.pila.size <= capacidad || capacidad == -1) {"El numero de la capacidad debe coincidir con el tamaño de la lista"}
    }

    /**
     * Devuelve el elemento en la cabeza de la pila o null si no hay ningun elemento
     * @return tos :T? elemento de la pila o nulo
     */
    fun top(): T?{
        val iterador = pila.listIterator()
        var tos: T? = try{
            iterador.next()
        } catch (e: Exception){
            null
        }
        while (iterador.hasNext()) {
            tos = iterador.next()
        }

        return tos
    }

    /**
     * Aplia o inserta un elemento a la cabeza de la pila si hay capacidad
     * @param t :T elemento que se va a apilar
     */
    fun push(t:T) {
        if(pila.size < capacidad || capacidad == -1) pila.add(t)
    }

    /**
     * Elimina o desapila el elemento a la cabeza de la pila
     */
    fun pop() {
        pila.remove(top())
    }

    /**
     * Comprueba si la pila está vacía (o su tamaño es 0) o si está llena (si existe un tamaño máximo)
     * @return Boolean retorna true o false dependiendo si está vacia, llena o ninguna de las dos
     */
    fun isEmpty():Boolean {
        return if (top() != null || capacidad == 0) true
        else if (pila.size == capacidad || capacidad == -1) true
        else false
    }

}
