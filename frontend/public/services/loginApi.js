import apiFetch from "./client.js";
import { CONFIG } from "./config.js";

export async function login(email, password) {
    return apiFetch(CONFIG.API_ENDPOINTS.LOGIN, {
        method: "POST",
        body: JSON.stringify({ email, password })
    });
}
