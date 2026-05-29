import { ENV } from "./config.js";

export default async function apiFetch(endpoint, options = {}) {
    const url = `${ENV.API_BASE_URL}${endpoint}`;
    
    const defaultOptions = {
        headers: { "Content-Type": "application/json" },
        ...options
    };

    const response = await fetch(url, defaultOptions);
    
    // Manejo de errores básico para evitar el error de "Unexpected token <" [3, 6]
    if (!response.ok) {
        const errorData = await response.json().catch(() => ({}));
        throw new Error(errorData.message || "Error en la petición");
    }

    return response.json();
}
