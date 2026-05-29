// Simulación de variables de entorno y rutas de navegación
export const ENV = {
    API_BASE_URL: "/api", // Prefijo que Nginx reconoce para el proxy [3, 4]
};

export const UI_PATHS = {
    LOGIN: "/index.html",
    OPERARIO_PANEL: "/operario/operario.html", // Eliminamos el prefijo "/public" [3]
};

export const API_ENDPOINTS = {
    AUTH_LOGIN: "/login",
    OPERARIO_REMITOS: "/operarios/remitos", // Mantenemos el plural que funcionó en tu curl [3]
};
