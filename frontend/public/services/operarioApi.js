import apiFetch
from "./client.js";

export async function getRemitos() {

    return apiFetch("/operario/remitos");
}
