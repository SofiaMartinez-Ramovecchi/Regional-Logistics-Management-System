# Regional-Logistics-Management-System
Sistema de gestión de procesos de logística para gerentes regionales de supermercados

Este proyecto utiliza una arquitectura de microservicios contenedorizados con Docker, empleando Nginx como proxy inverso para comunicar un frontend de archivos estáticos con un backend en Spring Boot

🚀 Inicio Rápido
Para poner en marcha el sistema completo (Frontend, Backend y Nginx), asegúrate de tener instalado Docker y Docker Compose. Solo necesitas seguir estos dos pasos:
### 1 Clonar el repositorio:

### 2 Levantar los contenedores: Ejecuta el siguiente comando en la raíz del proyecto para construir las imágenes y desplegar los servicios:
docker compose up --build

## 🛠️ Cómo probar las rutas
Una vez que los contenedores estén corriendo, el sistema estará disponible en http://localhost:3000 . La comunicación se realiza a través de un proxy que redirige las peticiones con el prefijo /api/ directamente al backend

## 1. Verificar el Frontend
Abre tu navegador en:
Login: http://localhost:3000/
Prueba con el primer usuario mock: operario@logistica.com
contraseña: 1234 (por cierto, no vayas a usar esa contraseña vos)
Panel de Operario: http://localhost:3000/operario/operario.html (es al que te redirige) 

##📂 Estructura del Proyecto
/public: Contiene los archivos estáticos (HTML, CSS, JS) servidos por Nginx

/nginx: Configuración de default.conf que maneja el proxy inverso hacia el backend

/services (en JS): Lógica de comunicación con el servidor mediante apiFetch y la constante API_URL = "/api"

Backend (Spring Boot): Escucha internamente en el puerto 8080 y procesa las peticiones de autenticación y gestión de remitos


