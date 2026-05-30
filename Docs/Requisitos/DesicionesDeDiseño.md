# Decisiones Técnicas — Centro Logístico de Distribución Avanzada

## Introducción

Para el desarrollo del sistema se tomó la decisión de utilizar distintas estructuras de datos y algoritmos según la necesidad específica de cada funcionalidad del centro logístico.
El objetivo principal fue optimizar las operaciones críticas del sistema, reducir complejidad temporal y mantener una arquitectura modular y clara.

Cada decisión técnica fue seleccionada considerando eficiencia, facilidad de mantenimiento y relación directa con los requerimientos planteados en el trabajo práctico.

---

# 1. Localización de Stock

Cada producto del sistema posee un código universal único y una ubicación física dentro del depósito compuesta por:

* Pasillo
* Estantería
* Sección

Para evitar recorridos lineales sobre todas las estanterías, se decidió utilizar un Árbol AVL indexado por código universal de producto.

## Justificación Técnica

El Árbol AVL mantiene balanceada su estructura automáticamente, permitiendo operaciones de búsqueda, inserción y eliminación en complejidad:

O(log n)

Esto permite localizar rápidamente un producto dentro del depósito sin necesidad de recorrer manualmente todas las posiciones existentes.

## Ejemplo de funcionamiento

Al buscar un producto mediante su código:

```text
buscarProducto("A123")
```

el sistema devuelve directamente:

```text
Pasillo 7
Estantería 99
Sección B
```

sin realizar búsquedas lineales.

---

# 2. Optimización de Recolección

Para representar la interconexión de los pasillos y sectores del depósito se decidió utilizar una estructura de Grafos.

## Modelo utilizado

* Nodos: sectores o pasillos del depósito.
* Aristas: conexiones entre sectores.
* Peso: distancia o costo de recorrido.

## Algoritmo seleccionado

Se utilizará el algoritmo de Dijkstra para calcular caminos mínimos entre sectores del almacén.

## Justificación Técnica

El objetivo es minimizar el recorrido realizado por los operarios al recolectar productos de distintos pedidos.

El flujo será:

1. Buscar productos mediante AVL.
2. Obtener sus ubicaciones físicas.
3. Calcular el recorrido óptimo utilizando grafos.

Esto reduce desplazamientos innecesarios dentro del depósito y mejora eficiencia operativa.

---

# 3. Control de Inventario Crítico

Para identificar rápidamente productos con bajo stock se decidió utilizar una estructura Priority Queue implementada mediante Min Heap.

## Criterio de organización

Los productos se ordenan según su cantidad disponible en stock.

El elemento con menor existencia queda siempre en la parte superior de la estructura.

## Justificación Técnica

Esto permite obtener rápidamente los productos críticos para reposición mediante operaciones eficientes:

```text
top()
```

Complejidad aproximada:

O(log n)

De esta manera el sistema puede priorizar automáticamente productos con riesgo de agotamiento.

---

# 4. Línea de Expedición

Los pedidos listos para despacho se administrarán mediante una Cola (Queue).

## Justificación Técnica

La lógica logística requiere respetar el orden de llegada de los pedidos.

Por esta razón se implementa el criterio:

FIFO (First In, First Out)

El primer pedido en ingresar a la línea de expedición será el primero en cargarse al vehículo de reparto.

## Operaciones principales

```text
enqueue(pedido)
dequeue()
```

Esto representa correctamente el comportamiento real de una fila de despacho.

---

# 5. Trazabilidad y Reversión de Movimientos

Para registrar movimientos recientes de mercadería y permitir revertir operaciones erróneas se decidió utilizar una Pila (Stack).

## Justificación Técnica

La estructura Stack funciona bajo el criterio:

LIFO (Last In, First Out)

Esto permite implementar una funcionalidad similar a “deshacer” (undo), donde la última operación realizada es la primera en revertirse.

## Ejemplo

```text
push(movimiento)
```

Si ocurre un error:

```text
pop()
revertirMovimiento()
```

Esto facilita la recuperación ante errores operativos dentro del inventario.

---

# 6. Unicidad de Productos

Para garantizar que no existan productos duplicados en el sistema se utilizará un HashMap complementario.

## Justificación Técnica

El HashMap permite verificar existencia de productos mediante acceso promedio:

O(1)

Esto mejora validaciones y evita duplicados durante altas de inventario.

---

# 7. Robustez y Validaciones

El sistema incluirá validaciones para controlar errores y casos límite.

## Casos contemplados

* IDs duplicados.
* Productos inexistentes.
* Rutas inválidas.
* Stock negativo.
* Pedidos vacíos.
* Intentos de revertir movimientos inexistentes.

Estas validaciones buscan mantener integridad y estabilidad del sistema.

---

# 8. Casos de Prueba

Se desarrollarán pruebas funcionales para validar el comportamiento correcto de cada estructura y operación principal.

## Ejemplos

* Inserción de productos.
* Búsqueda de stock.
* Eliminación de elementos.
* Cálculo de rutas.
* Reversión de movimientos.
* Control de productos críticos.

Las pruebas podrán realizarse mediante:

* Interfaces del sistema.
* Métodos main de prueba.
* Casos documentados.

---

# 9. Modularidad y Organización

El proyecto será desarrollado utilizando una arquitectura modular para facilitar mantenimiento y legibilidad.

## Organización propuesta

```text
models/
tda/
avl/
graphs/
heap/
queue/
stack/
services/
controllers/
```

## Objetivos

* Separación de responsabilidades.
* Código reutilizable.
* Mayor claridad estructural.
* Facilidad de mantenimiento.

También se utilizarán nombres descriptivos y comentarios para explicar lógica compleja cuando sea necesario.

---

# Conclusión

Las decisiones técnicas tomadas buscan relacionar directamente cada necesidad del sistema con la estructura de datos más adecuada para resolverla eficientemente.

El proyecto prioriza:

* eficiencia temporal,
* organización modular,
* trazabilidad,
* robustez,
* y correcta utilización de tipos de datos abstractos.

De esta manera el sistema logra representar de forma realista y eficiente la operatoria de un centro logístico de distribución avanzada.

