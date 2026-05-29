import apiFetch from "./client.js";
import { CONFIG } from "./config.js";

export async function getRemitos() {
    // Accedes a través de CONFIG.API_ENDPOINTS
    return apiFetch(CONFIG.API_ENDPOINTS.REMITOS);
}