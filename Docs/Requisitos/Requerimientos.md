# Requisitos Funcionales, No Funcionales y Glosario

## Centro Logístico de Distribución Avanzada

# 1. Introducción

El presente documento describe los requisitos funcionales y no funcionales del sistema “Centro Logístico de Distribución Avanzada”.

La redacción de los requisitos se realizó siguiendo criterios de claridad y especificidad recomendados por IEEE, utilizando descripciones concretas, verificables y orientadas al comportamiento esperado del sistema.

El objetivo principal del sistema es gestionar el almacenamiento, localización, trazabilidad y despacho de mercadería dentro de un centro logístico, utilizando estructuras de datos optimizadas para mejorar eficiencia operativa y rendimiento.

---

# 2. Requisitos Funcionales

## RF-01 — Registro de Productos

El sistema deberá permitir registrar productos utilizando un código universal único, almacenando información de nombre, categoría, stock y ubicación física dentro del depósito.

---

## RF-02 — Localización de Stock

El sistema deberá permitir localizar productos dentro del depósito mediante su código universal sin realizar recorridos lineales sobre las estanterías.

La búsqueda deberá devolver:

* Pasillo
* Estantería
* Sección

correspondientes a la ubicación física del producto.

---

## RF-03 — Gestión de Inventario

El sistema deberá permitir modificar, actualizar y eliminar productos del inventario manteniendo consistencia entre stock y movimientos realizados.

---

## RF-04 — Control de Inventario Crítico

El sistema deberá permitir identificar rápidamente productos con menor cantidad disponible para priorizar su reposición.

El sistema deberá mantener los productos organizados según nivel de stock.

---

## RF-05 — Gestión de Pedidos

El sistema deberá permitir crear, visualizar, actualizar y despachar pedidos asociados a productos almacenados en el centro logístico.

---

## RF-06 — Optimización de Recolección

El sistema deberá calcular recorridos óptimos dentro del depósito considerando la interconexión entre pasillos y sectores para minimizar desplazamientos de los operarios.

---

## RF-07 — Gestión de Rutas de Distribución

El sistema deberá permitir registrar y visualizar rutas de distribución entre el centro logístico y las sucursales de destino.

---

## RF-08 — Línea de Expedición

El sistema deberá administrar los pedidos listos para despacho respetando el orden de ingreso a la línea de expedición.

---

## RF-09 — Registro de Movimientos

El sistema deberá registrar los movimientos realizados sobre productos y pedidos para mantener trazabilidad operativa.

---

## RF-10 — Reversión de Operaciones

El sistema deberá permitir revertir movimientos recientes del inventario ante errores operativos.

---

## RF-11 — Validación de Integridad

El sistema deberá impedir operaciones inválidas tales como:

* productos duplicados,
* stock negativo,
* pedidos vacíos,
* búsquedas inexistentes,
* rutas inválidas.

---

# 3. Requisitos No Funcionales

## RNF-01 — Eficiencia

El sistema deberá utilizar estructuras de datos optimizadas para minimizar la complejidad temporal de las operaciones críticas.

---

## RNF-02 — Rendimiento

Las operaciones de búsqueda de productos y consulta de stock deberán ejecutarse en tiempos reducidos aun con grandes volúmenes de información.

---

## RNF-03 — Robustez

El sistema deberá manejar errores de entrada y casos límite sin provocar fallos en la ejecución.

---

## RNF-04 — Persistencia de Datos

El sistema deberá mantener persistencia de la información relacionada con productos, pedidos, rutas y movimientos logísticos.

---

## RNF-05 — Integridad de Datos

El sistema deberá garantizar consistencia entre las operaciones realizadas y el estado actual del inventario.

---

## RNF-06 — Modularidad

El sistema deberá desarrollarse utilizando una arquitectura modular basada en separación de responsabilidades.

---

## RNF-07 — Escalabilidad

El sistema deberá permitir incorporar nuevos productos, pedidos y rutas sin degradación significativa del rendimiento.

---

## RNF-08 — Legibilidad

El código deberá utilizar nombres descriptivos, comentarios explicativos y organización clara de clases e interfaces.

---

## RNF-09 — Mantenibilidad

La estructura del sistema deberá facilitar futuras modificaciones y ampliaciones funcionales.

---

## RNF-10 — Casos de Prueba

El sistema deberá incluir pruebas funcionales que validen el correcto comportamiento de las operaciones principales y estructuras utilizadas.

---
# Glosario Actualizado

| Término                  | Definición                                                                                                   |
| ------------------------ | ------------------------------------------------------------------------------------------------------------ |
| AVL                      | Árbol binario auto-balanceado utilizado para búsquedas eficientes.                                           |
| Código Universal         | Identificador único asociado a cada producto del sistema.                                                    |
| Cola (Queue)             | Estructura FIFO donde el primer elemento en ingresar es el primero en salir.                                 |
| Complejidad Temporal     | Medida del costo computacional de una operación según cantidad de datos.                                     |
| Dijkstra                 | Algoritmo utilizado para calcular caminos mínimos dentro de un grafo.                                        |
| Estantería               | Estructura física del depósito donde se almacenan productos.                                                 |
| FIFO                     | Modelo “First In, First Out” utilizado por colas.                                                            |
| Grafo                    | Estructura compuesta por nodos y conexiones utilizada para representar recorridos.                           |
| Heap                     | Estructura utilizada para mantener elementos ordenados según prioridad.                                      |
| Interfaz                 | Componente visual o lógico mediante el cual el usuario interactúa con el sistema.                            |
| Inventario               | Conjunto total de productos almacenados en el centro logístico.                                              |
| Inventario Crítico       | Conjunto de productos con bajo nivel de stock que requieren reposición inmediata.                            |
| LIFO                     | Modelo “Last In, First Out” utilizado por pilas.                                                             |
| Línea de Expedición      | Área o proceso donde los pedidos esperan para ser cargados en vehículos de distribución.                     |
| Lote                     | Conjunto de productos agrupados bajo un mismo identificador para facilitar trazabilidad y control logístico. |
| Mercadería               | Productos o bienes almacenados y distribuidos dentro del sistema logístico.                                  |
| Min Heap                 | Tipo de heap donde el elemento con menor valor tiene mayor prioridad de acceso.                              |
| Nodo                     | Elemento individual dentro de una estructura de datos.                                                       |
| Operario                 | Usuario encargado de realizar tareas de almacenamiento, recolección y despacho dentro del depósito.          |
| Pasillo                  | Sector físico de circulación dentro del depósito.                                                            |
| Pedido                   | Solicitud de productos destinada a una sucursal o punto de entrega.                                          |
| Priority Queue           | Cola de prioridad utilizada para acceder rápidamente a elementos críticos.                                   |
| Producto                 | Mercadería almacenada y gestionada por el sistema logístico.                                                 |
| Recolección              | Proceso de búsqueda y retiro de productos dentro del depósito para preparar pedidos.                         |
| Remito                   | Documento que registra movimientos de ingreso o egreso de mercadería.                                        |
| Reposición               | Proceso de reabastecimiento de productos con bajo stock.                                                     |
| Ruta                     | Recorrido utilizado para distribución o recolección de productos.                                            |
| Sección                  | Subdivisión interna de una estantería o área del depósito.                                                   |
| Stack                    | DynamicStack utilizada para registrar y revertir operaciones recientes.                                              |
| Stock                    | Cantidad disponible de un producto dentro del depósito.                                                      |
| Sucursal                 | Punto de destino al cual se envían pedidos desde el centro logístico.                                        |
| TDA                      | Tipo de Dato Abstracto utilizado para modelar estructuras de datos.                                          |
| Trazabilidad             | Capacidad de registrar y consultar movimientos de mercadería.                                                |
| Ubicación Física         | Posición específica de un producto dentro del depósito, compuesta por pasillo, estantería y sección.         |
| Vehículo de Distribución | Medio utilizado para transportar pedidos hacia sucursales o destinos finales.                                |

