<div class="modal fade" id="agregarClienteModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header text-white">
                <h5 class="modal-title"> Agregar Cliente</h5>
                <button class="btn btn-danger" data-bs-dismiss="modal">
                    <span>cerrar</span>
                </button>
            </div>
            <form action="${pageContext.request.contextPath}/ServletControlador?accion=insertar" method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="mb-3 mt-3">
                        <label for="nombre" >Nombre</label>
                        <input type="text" class="form-control" name="nombre" placeholder="nombre" required>
                        <div class="valid-feedback">Valido</div>
                        <div class="invalid-feedback">Ingrese su nombre.</div>
                    </div>
                    <div class="mb-3 mt-3">
                        <label for="apellido" >Apellido</label>
                        <input type="text" class="form-control" name="apellido" placeholder="apellido" required>
                        <div class="valid-feedback">Valid.</div>
                        <div class="invalid-feedback">Ingrese su apellido.</div>
                    </div>
                    <div class="mb-3 mt-3">
                        <label for="email" >Correo Electronico</label>
                        <input type="text" class="form-control" name="email" placeholder="usuario@gmail.com" required>
                        <div class="valid-feedback">Valid.</div>
                        <div class="invalid-feedback">Ingese su correo electronico.</div>
                    </div>
                    <div class="mb-3 mt-3">
                        <label for="telefono" >Telefono</label>
                        <input type="text" class="form-control" name="telefono" placeholder="+11-1111" required>
                        <div class="valid-feedback">Valid.</div>
                        <div class="invalid-feedback">Ingrese su telefono.</div>
                    </div>
                    <div class="mb-3 mt-3">
                        <label for="saldo" >Saldo</label>
                        <input type="number" class="form-control" name="saldo" placeholder="$0.0" step="any" required>
                        <div class="valid-feedback">Valid.</div>
                        <div class="invalid-feedback">Ingrese su saldo actual.</div>
                    </div>
                </div>
                <div class="modal-footer mb-5 ">
                    <button class="btn btn-primary" type="submit"> Aceptar</button>
                </div>
            </form>
        </div>
    </div>
</div>
                
 <style>
   .modal-header{
     background-color: #2C3E50;   
   }
 </style>