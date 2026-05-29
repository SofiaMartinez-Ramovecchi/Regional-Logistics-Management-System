import apiFetch from "./client.js";
import { API_ENDPOINTS } from "./config.js";

export async function login(email, password) {
    return apiFetch(API_ENDPOINTS.AUTH_LOGIN, {
        method: "POST",
        body: JSON.stringify({ email, password })
    });
}
