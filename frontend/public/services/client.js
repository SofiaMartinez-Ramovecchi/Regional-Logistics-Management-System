const API_URL = "/api/";

export default async function apiFetch(
    endpoint,
    options = {}
) {

    const response = await fetch(
        API_URL + endpoint,
        {
            headers: {
                "Content-Type":
                    "application/json"
            },

            ...options
        }
    );

    return await response.json();
}
