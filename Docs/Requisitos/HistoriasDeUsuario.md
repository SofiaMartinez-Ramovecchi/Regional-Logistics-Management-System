# Historias de Usuario

## Centro Logístico de Distribución Avanzada

Las siguientes historias de usuario fueron organizadas según prioridad técnica y dependencia arquitectónica, comenzando por las funcionalidades fundamentales del sistema y continuando con características complementarias y de visualización.

---

# Historia de Usuario 1 — Autenticación de Usuarios

## Como

usuario del sistema

## Quiero

iniciar sesión mediante credenciales válidas

## Para

acceder a las funcionalidades correspondientes según mi rol y permisos asignados.

### Prioridad

Alta

### Justificación Técnica

La autenticación es la base del sistema, ya que controla acceso y segmentación de funcionalidades para operadores, gerentes, choferes y administradores.

---

# Historia de Usuario 2 — Gestión de Inventario

## Como

operador logístico

## Quiero

registrar, modificar, eliminar y visualizar productos del inventario

## Para

mantener actualizado el stock del centro logístico.

### Prioridad

Alta

### Justificación Técnica

La gestión de inventario representa una funcionalidad central del sistema y permite operar posteriormente pedidos, lotes y rutas.

---

# Historia de Usuario 3 — Localización de Stock

## Como

operador logístico

## Quiero

buscar productos mediante su código universal

## Para

localizar rápidamente su ubicación física dentro del depósito.

### Prioridad

Alta

### Justificación Técnica

La búsqueda eficiente de productos es uno de los principales objetivos del sistema y se encuentra directamente relacionada con el uso de estructuras optimizadas.

---

# Historia de Usuario 4 — Gestión de Pedidos

## Como

operador logístico

## Quiero

crear pedidos, editar pedidos y actualizar estados

## Para

gestionar el flujo operativo de distribución.

### Prioridad

Alta

### Justificación Técnica

Los pedidos representan el núcleo operativo del sistema y conectan inventario, rutas y expedición.

---

# Historia de Usuario 5 — Optimización de Recolección

## Como

operario del depósito

## Quiero

obtener recorridos optimizados para recolectar productos

## Para

minimizar desplazamientos dentro del almacén.

### Prioridad

Alta

### Justificación Técnica

La optimización de recorridos permite aplicar grafos y algoritmos de caminos mínimos para mejorar eficiencia logística.

---

# Historia de Usuario 6 — Control de Inventario Crítico

## Como

operador logístico

## Quiero

visualizar productos con bajo stock

## Para

priorizar tareas de reposición.

### Prioridad

Media

### Justificación Técnica

La detección rápida de productos críticos permite mantener disponibilidad operativa y aplicar estructuras de prioridad.

---

# Historia de Usuario 7 — Línea de Expedición

## Como

operador logístico

## Quiero

administrar pedidos listos para despacho en orden de llegada

## Para

mantener organizada la carga de vehículos de distribución.

### Prioridad

Media

### Justificación Técnica

La expedición representa una etapa clave del flujo logístico y permite implementar estructuras tipo cola.

---

# Historia de Usuario 8 — Trazabilidad de Lotes

## Como

gerente de operaciones

## Quiero

visualizar movimientos y trazabilidad de lotes

## Para

conocer el recorrido y estado de la mercadería dentro del sistema.

### Prioridad

Media

### Justificación Técnica

La trazabilidad permite registrar movimientos históricos y mejorar control operativo.

---

# Historia de Usuario 9 — Reversión de Operaciones

## Como

operador logístico

## Quiero

revertir movimientos recientes del inventario

## Para

corregir errores operativos realizados durante la gestión de mercadería.

### Prioridad

Media

### Justificación Técnica

La reversión de operaciones permite implementar estructuras tipo pila para recuperación de estados recientes.

---

# Historia de Usuario 10 — Gestión de Rutas de Distribución

## Como

operador logístico

## Quiero

registrar y visualizar rutas de distribución

## Para

organizar entregas hacia sucursales.

### Prioridad

Media

### Justificación Técnica

Las rutas complementan el flujo logístico y permiten modelar conexiones entre puntos de distribución.

---

# Historia de Usuario 11 — Visualización de Rutas Asignadas

## Como

chofer de distribución

## Quiero

visualizar las rutas y pedidos asignados

## Para

realizar entregas dentro de los tiempos planificados.

### Prioridad

Baja

### Justificación Técnica

Esta funcionalidad depende previamente de la existencia de pedidos y rutas registradas.

---

# Historia de Usuario 12 — Administración de Usuarios y Sucursales

## Como

administrador del sistema

## Quiero

crear, modificar y eliminar usuarios y sucursales

## Para

gestionar la estructura organizativa del sistema.

### Prioridad

Baja

### Justificación Técnica

La administración complementa la gestión general del sistema, pero no forma parte del núcleo logístico principal.

---

# Historia de Usuario 13 — Visualización Operativa

## Como

gerente de operaciones

## Quiero

visualizar pedidos, rutas y entregas

## Para

supervisar el funcionamiento general del centro logístico.

### Prioridad

Baja

### Justificación Técnica

Esta funcionalidad se orienta principalmente a monitoreo y supervisión.

---

# Historia de Usuario 14 — Gestión de Métricas

## Como

jefe de logística

## Quiero

visualizar métricas operativas

## Para

realizar toma de decisiones basada en indicadores del sistema.

### Prioridad

Baja

### Justificación Técnica

Las métricas dependen de información previamente generada por el resto de módulos del sistema.

