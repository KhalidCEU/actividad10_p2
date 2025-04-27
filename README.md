## Árboles

**Ejercicio 93**

> Defina los términos árbol y árbol binario, y explique aplicaciones de ambas estructuras

**Arbol**: Estructura jerarquica **no lineal** compuesta por **nodos** (raíz, hijos y hojas) que organiza datos de forma recursiva, donde cada nodo tiene **un padre** (excepto la raíz) y **cero o más hijos**

**Arbol binario**: Tipo de arbol donde cada nodo tiene como maximo dos hijos (izquierdo y derecho), utilizado en busquedas **ordenadas** (BST), **compresión** (Huffman) y **algoritmos jerarquicos**

**Ejercicio 94**

> Simule la inserción en un árbol binario de los siguientes elementos: 2, 1, 3, 8, 5, 2

Suponiendo que es un arbol no ordenado :

```
            2       <- Se convierte en la raíz
          /   \
         1     3    <- Insertamos en subarbol derecho de la raíz (sin criterio de orden)
              / \
             2   8  <- Insertamos en subarbol derecho de 3
                /
               5    <- Insertamos en primer espacio libre
```

#### Ejercicio 95

> Explique qué reglas se siguen para borrar un elemento de un árbol binario

En un arbol binario de busqueda, para el **eliminado** de un elemento, pueden haber **3 casos**:
- El nodo es una **hoja** (ningun nodo hijo) -> se elimina directamente
- El nodo tiene **1 solo hijo** -> se **reemplaza por su hijo**
- El nodo tiene **2 hijos** -> se **reemplaza por** _(una de estas 2 opciones)_
    - El nodo con el **valor minimo** en su **subarbol derecho**
    - El nodo con el **valor maximo** en su **subarbol izquierdo**.


**Ejercicio 96**

> Sea el [siguiente código](/code/BinaryTree.java) que implementa un árbol binario (la
mayor parte del código ha sido tomado de http://cslibrary.stanford.edu/110/BinaryTrees.html#java)

> Se pide
> 1. Mostrar el resultado del siguiente método y dibujar cómo está estructurado el árbol:

```
static void mostrarFuncionamientoArbolesBinarios() {
    BinaryTree bt = new BinaryTree();
    bt.insert(2);
    bt.insert(1);
    bt.insert(3);
    bt.insert(8);
    bt.insert(5);
    bt.insert(2);
    System.out.println(bt);
    bt.printPostorder();
}
```

**R:** El programa nos da el siguiente **output**

```
 1  2  2  3  5  8
2 1 5 8 3 2
```

La primera línea `1 2 2 3 5 8` muestra el recorrido sin orden.
La segunda línea `2 1 5 8 3 2` muestra el recorrido despues de ordenarlo.

El árbol binario quedaría estructurado de la siguiente manera:

```
       2
      / \
     1   3
        / \
       2   8
          /
         5
```

Explicacion : `1 2 2 3 5 8` indica lo siguiente:
- Visita nodo  **1** (**subarbol izquierdo** de la raíz) su padre es **2**
- Ahora visita el **2** (raíz del arbol)
- Visita el **segundo 2** (hijo izquierdo de **3**)
- Visita el **nodo 5** (hijo izquierdo de **8**)
- Finalmente, se visita el nodo **8** (hijo derecho de **3**)

<br>

> 2. El análisis de complejidad temporal asintótico de cada uno de los métodos públicos que aparecen en el ejercicio

Métodos

- `lookup`
- `insert`
- `maxDepth`
- `minValue`
- `toString`
- `equals`
- `sameTree`
- `printPostorder`

**Ejercicio 97**

> Explique qué es un árbol rojo-negro y qué propiedades debe satisfacer


**Ejercicio 98**

> Explique mediante ejemplos cómo se realiza la inserción de un elemento en un árbol rojo-negro

**Ejercicio 99**

> Explique cómo se realiza el borrado de un nudo rojo en árbol rojo-negro

**Ejercicio 100**

> Explique qué es un set y cómo puede implementarse mediante un árbol binario

Un **set** es una estructura que almacena elementos **únicos sin orden definido** (aunque se pueden ordenar).

Para implementarlo con un árbol binario:

- Cada nodo tiene un valor **unico**
- Operaciones:
    - Insertar: Añadimos el elemento en la posicion correcta según su valor (**izquierda = menor, derecha = mayor**), manteniendo el orden
    - Buscar: **Recorremos** el árbol **comparando valores** hasta encontrar el elemento o llegar a un nodo nulo
    - Eliminar: Lo mismo que explicamos en el [ejercicio 95](#ejercicio-95)

**Ejercicio 101**

> Explique qué es un map y cómo puede implementarse mediante un árbol binario

Un **map** es una estructura que almacena **pares clave-valor** (como por ejemplo en un objeto **JSON**)

- Operaciones:
    - Insertar: Añadimos el elemento en la posicion correcta según el **valor** de la clave.
    - Buscar: **Recorremos** el árbol **comparando claves**.
    - Eliminar:

**Ejercicio 103**

> Explique cómo implementaría un árbol en que cada nodo puede tener más de dos hijos

Para implementar un arbol en el que cada nodo podría tener mas de 2 hijos, crearía **nodos** que tendrían
un **ArrayList** (necesitamos algo **dinamico**) con **referencias hacia todos sus hijos**.

Si eliminaramos por ejemplo este nodo, y tiene un nodo padre, tendríamos que:

- Eliminarlo de los nodos hijos de su nodo padre
- Hacer que todos los hijos de este nodo que eliminamos, se añadan a las referencias del nodo padre del nodo que queremos eliminar.

o si queremos que se **preserve la jerarquía** (= que los nodos "nietos" no se conviertan en "hijos")

reasignaríamos los **hijos del nodo eliminado** a **otro nodo especifico** (no necesariamente al padre del eliminado), dependiendo de la logica del árbol.


**Ejercicio 104**

> Averigüe cómo JDOM estructuraría en forma de árbol el siguiente fragmento de HTML

```
<TABLE>
    <TBODY>
        <TR>
            <TD>Shady Grove</TD>
            <TD>Aeolian</TD>
        </TR>
        <TR>
            <TD>Over the River, Charlie</TD>
            <TD>Dorian</TD>
        </TR>
    </TBODY>
</TABLE>
```

La estructuraría de la siguiente manera:

```
                TABLE
                  |
                TBODY
                  |
          ------------------
          |                 |
          |                 |
         TR                 TR
        /  \               /  \
       /    \             /    \
      TD    TD           TD     TD
    Shady..  Aeolian    Over..   Dorian
```