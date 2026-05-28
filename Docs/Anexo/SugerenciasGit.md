🧭 Política de ramas del proyecto
1. Estructura de ramas

El repositorio utiliza la siguiente estrategia de branching:

main
│
└── develop
     │
     ├── feature/ISSUE-ID-descripcion
     ├── bugfix/ISSUE-ID-descripcion
     ├── hotfix/ISSUE-ID-descripcion
2. Tipos de ramas
main
rama estable
solo código listo para entrega
develop
integración de funcionalidades
ambiente de desarrollo principal
feature/
nuevas funcionalidades
asociadas a un issue
bugfix/
corrección de errores
hotfix/
correcciones urgentes en producción
3. Duración de ramas

Las ramas deben ser de corta duración:

ideal: 1 a 3 días
máximo recomendado: 1 semana

Si una rama supera ese tiempo:

debe ser revisada o dividida
evitar ramas “eternas”
4. Naming de ramas

Formato obligatorio:

tipo/ISSUE-ID-descripcion-corta

Ejemplos:

feature/LOG-12-crear-pedido
feature/LOG-15-asignar-vehiculo
bugfix/LOG-22-error-login
5. Relación con issues

Cada rama debe estar asociada a un issue:

debe nacer desde un issue creado previamente
debe referenciarlo en commits y PR

Ejemplo:

Closes #12
6. Uso de ADR por rama (obligatorio en features grandes)

Para funcionalidades relevantes:

Se debe crear un:

ADR específico de la rama

Contenido mínimo:

objetivo de la rama
alcance funcional
estimación de duración
impacto en el sistema
7. Flujo de trabajo
issue → rama → commits chicos → pull request → review → develop → main
📁 2. Reglas de Commits
docs/05-decisiones-adr/COMMIT-RULES.md
💾 Política de commits del proyecto
1. Tamaño de commits

Se deben realizar commits pequeños y atómicos:

máximo recomendado:
1 a 3 archivos modificados
un commit = una intención clara

❌ Incorrecto:

"cambios varios"
"update todo"
2. Principio del commit

Cada commit debe representar:

una sola unidad lógica de cambio

Ejemplos:

agregar endpoint de pedidos
corregir validación de login
agregar entidad vehículo
3. Convención de mensajes

Formato obligatorio:

tipo(alcance): descripción
4. Tipos de commit
feat → nueva funcionalidad
fix → corrección de bug
refactor → refactor de código
docs → documentación
test → tests
chore → tareas internas
5. Ejemplos correctos
feat(pedidos): crear endpoint de creación de pedidos
fix(login): corregir validación de contraseña
docs(requisitos): actualizar historias de usuario
refactor(vehiculos): simplificar servicio de asignación
6. Commits obligatorios por feature

Cada feature debe incluir:

commits incrementales
no commits gigantes

Ejemplo correcto:

1. crear entidad
2. crear repositorio
3. crear endpoint
4. conectar frontend
