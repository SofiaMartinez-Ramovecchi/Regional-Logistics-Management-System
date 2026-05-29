import { getRemitos } from "../../services/operarioApi.js";

const table = document.getElementById("ordersTable");

async function renderOrders() {
    // Feedback visual mientras carga
    table.innerHTML = "<tr><td colspan='4' class='text-center'>Cargando remitos...</td></tr>";

    try {
        const orders = await getRemitos();

        // Limpiamos la tabla antes de renderizar
        table.innerHTML = "";

        // Validamos que 'orders' sea una lista válida
        if (!orders || orders.length === 0) {
            table.innerHTML = "<tr><td colspan='4' class='text-center'>No hay remitos disponibles.</td></tr>";
            return;
        }

        orders.forEach(order => {
            const row = document.createElement("tr");

            row.innerHTML = `
                <td>${order.id}</td>
                <td>${order.sucursal}</td>
                <td>
                    <span class="badge ${order.estado === 'Pendiente' ? 'bg-warning text-dark' : 'bg-info'}">
                        ${order.estado}
                    </span>
                </td>
                <td>
                    <button class="btn btn-sm btn-outline-primary" onclick="alert('Funcionalidad pendiente: Cambiar estado del remito ${order.id}')">
                        Gestionar
                    </button>
                </td>
            `;

            table.appendChild(row);
        });
    } catch (error) {
        console.error("Error al renderizar órdenes:", error);
        table.innerHTML = "<tr><td colspan='4' class='text-center text-danger'>Error al conectar con el servidor.</td></tr>";
    }
}

// Inicializamos la carga
renderOrders();
