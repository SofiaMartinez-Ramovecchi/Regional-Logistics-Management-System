import { CONFIG } from "./config.js";

export default async function apiFetch(endpoint, options = {}) {
    // Construcción dinámica de la URL
    const url = `${CONFIG.API_PREFIX}${endpoint}`;
    return fetch(url, {
        headers: { "Content-Type": "application/json" },
        ...options
    }).then(res => res.json());
}