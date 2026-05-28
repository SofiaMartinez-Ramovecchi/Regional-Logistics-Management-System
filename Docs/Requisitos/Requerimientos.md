📦 REQUISITOS FUNCIONALES
RF-01 — Gestión de pedidos (Operador)

Como operador del sistema de logística
debo poder crear, editar, actualizar estados y eliminar pedidos
para operar el flujo logístico de distribución desde el centro de distribución hacia sucursales.

RF-02 — Asignación de vehículos (Operador)

Como operador del sistema de logística
debo poder asignar vehículos de la flota de distribución a pedidos o lotes de pedidos
para optimizar la consolidación de carga y la planificación de rutas de distribución.

RF-03 — Autenticación de usuarios

Como usuario del sistema
debo poder iniciar sesión mediante credenciales válidas
para acceder a las funcionalidades del sistema según mi rol y permisos asignados.

RF-04 — Visualización operativa de logística (Gerente)

Como gerente de operaciones logísticas
debo poder visualizar remitos de despacho, rutas de distribución, entregas y pedidos
para supervisar el flujo operativo del centro de distribución y la distribución hacia sucursales.

RF-05 — Gestión de métricas (Jefe de logística)

Como jefe de logística
debo poder visualizar métricas operativas del sistema
para la toma de decisiones basada en indicadores de desempeño logístico (KPIs).

RF-06 — Visualización de rutas de entrega (Chofer)

Como chofer de distribución
debo poder visualizar las rutas asignadas y sus pedidos asociados
para ejecutar las entregas a sucursales dentro de los tiempos planificados.

RF-07 — Administración de usuarios y sucursales

Como administrador del sistema
debo poder crear, modificar y eliminar usuarios y sucursales
para gestionar la estructura organizativa del sistema logístico y sus roles operativos.

RF-08 — Trazabilidad de lotes logísticos

Como gerente de operaciones logísticas
debo poder visualizar y consultar lotes logísticos
para trazar el recorrido completo del producto desde el centro de distribución hasta la sucursal destino.

RF-09 — Gestión de remitos

Como gerente de operaciones logísticas
debo poder visualizar los remitos de ingreso y egreso de mercadería
para controlar la trazabilidad documental de los movimientos del centro de distribución.

RF-10 — Gestión de rutas de distribución

Como operador del sistema de logística
debo poder generar, visualizar y administrar rutas de distribución
para consolidar entregas por zona geográfica y optimizar los recorridos de los vehículos.

RF-11 — Visualización de stock

Como operador y gerente de logística
debo poder visualizar el stock disponible en el centro de distribución por categoría (secos, refrigerados, tóxicos)
para garantizar disponibilidad operativa de productos.

⚙️ REQUISITOS NO FUNCIONALES
RNF-01 — Arquitectura del sistema

El sistema deberá estar compuesto por una arquitectura cliente-servidor
utilizando un frontend web, un backend API y una base de datos relacional
para garantizar separación de responsabilidades y escalabilidad.

RNF-02 — Rendimiento del sistema

El sistema deberá responder a las solicitudes API en un tiempo menor a 300 ms en operaciones de consulta
para garantizar eficiencia operativa en entornos logísticos.

RNF-03 — Seguridad de acceso

El sistema deberá implementar autenticación basada en roles (RBAC)
para garantizar el acceso controlado a las funcionalidades según el tipo de usuario (administrador, gerente, operador, chofer, jefe).

RNF-04 — Persistencia de datos

El sistema deberá garantizar la persistencia consistente de datos en la base de datos relacional
para asegurar la integridad de información de pedidos, remitos, rutas y stock.

RNF-05 — Escalabilidad

El sistema deberá permitir el incremento progresivo de sucursales, usuarios, pedidos y vehículos
sin degradación significativa del rendimiento.

RNF-06 — Contenerización del sistema

El sistema deberá ser desplegable mediante contenedores Docker
para asegurar portabilidad entre entornos de desarrollo, testing y producción.

RNF-07 — Trazabilidad de operaciones

El sistema deberá registrar los movimientos de pedidos, remitos y rutas
para permitir auditoría y seguimiento de procesos logísticos.

RNF-08 — Integridad de datos

El sistema deberá garantizar consistencia en las operaciones de actualización de estado de pedidos y stock
para evitar discrepancias entre el centro de distribución y las sucursales.