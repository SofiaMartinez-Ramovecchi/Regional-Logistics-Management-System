import { getRemitos }
from "../../services/operarioApi.js";

const table =
    document.getElementById(
        "ordersTable"
    );

async function renderOrders() {

    const orders =
        await getRemitos();

    table.innerHTML = "";

    orders.forEach(order => {

        const row =
            document.createElement("tr");

        row.innerHTML = `
            <td>${order.id}</td>
            <td>${order.sucursal}</td>
            <td>${order.estado}</td>
        `;

        table.appendChild(row);
    });
}

renderOrders();
