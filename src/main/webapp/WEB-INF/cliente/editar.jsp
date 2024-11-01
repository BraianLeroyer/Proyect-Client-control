<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Editar clientes</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">


    </head>
    <body>
        <jsp:include page="../componentes/header.jsp"/>

        <form action="${pageContext.request.contextPath}/ServletControlador?accion=modificar&idCliente=${cliente.idCliente}" method="POST" class="was-validated">
            <section id="detalles">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar Cliente</h4>
                                    <div class="card-body">
                                        <div class="mb-3 mt-3">
                                            <label for="nombre" >Nombre</label>
                                            <input type="text" class="form-control" name="nombre" placeholder="nombre" required value="${cliente.nombre}">
                                            <div class="valid-feedback">Valido</div>
                                            <div class="invalid-feedback">Ingrese su nombre.</div>
                                        </div>
                                        <div class="mb-3 mt-3">
                                            <label for="apellido" >Apellido</label>
                                            <input type="text" class="form-control" name="apellido" placeholder="apellido" required value="${cliente.apellido}"> 
                                            <div class="valid-feedback">Valid.</div>
                                            <div class="invalid-feedback">Ingrese su apellido.</div>
                                        </div>
                                        <div class="mb-3 mt-3">
                                            <label for="email" >Correo Electronico</label>
                                            <input type="text" class="form-control" name="email" placeholder="usuario@gmail.com" required value="${cliente.email}">
                                            <div class="valid-feedback">Valid.</div>
                                            <div class="invalid-feedback">Ingese su correo electronico.</div>
                                        </div>
                                        <div class="mb-3 mt-3">
                                            <label for="telefono" >Telefono</label>
                                            <input type="text" class="form-control" name="telefono" placeholder="+11-1111" required value="${cliente.telefono}">
                                            <div class="valid-feedback">Valid.</div>
                                            <div class="invalid-feedback">Ingrese su telefono.</div>
                                        </div>
                                        <div class="mb-3 mt-3">
                                            <label for="saldo" >Saldo</label>
                                            <input type="number" class="form-control" name="saldo" placeholder="$0.0" required step="any" value="${cliente.saldo}">
                                            <div class="valid-feedback">Valid.</div>
                                            <div class="invalid-feedback">Ingrese su saldo actual.</div>
                                        </div>
                                    </div>
                                    <div class="modal-footer mt-6 px-20 ">
                                        <button class="btn btn-primary" type="submit"> Aceptar</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                </div>
            </section>          

        </form>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>


    </body>
</html>
