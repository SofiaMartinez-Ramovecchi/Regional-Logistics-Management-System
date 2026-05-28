const form = document.getElementById("loginForm");

form.addEventListener("submit", (e) => {

    e.preventDefault();

    const role =
        document.getElementById("role").value;

    if(role === "operario") {

        window.location.href =
            "/operario/operario.html";
    }
});
