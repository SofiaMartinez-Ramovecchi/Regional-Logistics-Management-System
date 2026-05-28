const orders = [

    {
        id: 1001,
        sucursal: "Carrefour Avellaneda",
        estado: "Pendiente",
        vehiculo: "Camión 12"
    },

    {
        id: 1002,
        sucursal: "Carrefour Quilmes",
        estado: "En preparación",
        vehiculo: "Camión 5"
    }
];

const table =
    document.getElementById("ordersTable");

function renderOrders() {

    table.innerHTML = "";

    orders.forEach(order => {

        const row =
            document.createElement("tr");

        row.innerHTML = `
            <td>${order.id}</td>
            <td>${order.sucursal}</td>
            <td>${order.estado}</td>
            <td>${order.vehiculo}</td>

            <td>

                <button
                    class="btn btn-success btn-sm"
                    onclick="changeStatus(${order.id})">

                    Cambiar Estado

                </button>

            </td>
        `;

        table.appendChild(row);
    });
}

function changeStatus(id) {

    const order =
        orders.find(o => o.id === id);

    if(order.estado === "Pendiente") {

        order.estado = "En preparación";
    }
    else if(order.estado === "En preparación") {

        order.estado = "Despachado";
    }
    else {

        order.estado = "Entregado";
    }

    renderOrders();
}

renderOrders();
