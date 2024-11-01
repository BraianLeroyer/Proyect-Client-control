<%@taglib uri="jakarta.tags.core" prefix="c" %>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<fmt:setLocale value="es_MX"/>

 <main class="container flex-column gap-9">
   
    <table class="table table-striped text-center">
        <div class="d-flex justify-content-center justify-content-center ">
            <thead class="table-dark">
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Saldo</th>
                    <th>Editar</th>
                </tr>
            </thead>
            <c:forEach items="${clientes}" var="lista">

                <tr>
                    <td>${lista.idCliente}</td>
                    <td>${lista.nombre}  ${lista.apellido}</td>
                    <td><fmt:formatNumber value="${lista.saldo}" type="currency"/> </td>

                    <td>
                        <a href="${pageContext.request.contextPath}/ServletControlador?accion=editar&idCliente=${lista.idCliente}"                                 
                           class="btn btn-secondary">
                            <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-tabler icon-tabler-edit" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round">
                                <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
                                <path d="M7 7h-1a2 2 0 0 0 -2 2v9a2 2 0 0 0 2 2h9a2 2 0 0 0 2 -2v-1"></path>
                                <path d="M20.385 6.585a2.1 2.1 0 0 0 -2.97 -2.97l-8.415 8.385v3h3l8.385 -8.415z"></path>
                                <path d="M16 5l3 3"></path>
                            </svg>
                            Editar
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </div>
    </table>
    
</main>
<section class="container-fluid p-5  text-white text-center row">
        <div class="card text-center bg-success text-white col-sm-4">
            <div class="card-body">
                <h3>Saldo total</h3>
                <h4 class="display-3">
                    <fmt:formatNumber value="${saldoTotal}" type="currency"/>
                </h4>
            </div>
        </div>
        <div class="card text-center bg-danger text-black col-sm-4">
            <div class="card-body">
                <h3>Cantidad de Persona</h3>
                <h4 class="display">
                    <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-tabler icon-tabler-users-group" width="50" height="50" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round">
                        <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
                        <path d="M10 13a2 2 0 1 0 4 0a2 2 0 0 0 -4 0"></path>
                        <path d="M8 21v-1a2 2 0 0 1 2 -2h4a2 2 0 0 1 2 2v1"></path>
                        <path d="M15 5a2 2 0 1 0 4 0a2 2 0 0 0 -4 0"></path>
                        <path d="M17 10h2a2 2 0 0 1 2 2v1"></path>
                        <path d="M5 5a2 2 0 1 0 4 0a2 2 0 0 0 -4 0"></path>
                        <path d="M3 13v-1a2 2 0 0 1 2 -2h2"></path> 
                    </svg>
                    ${totalClientes}
                </h4>
            </div>
        </div>
</section>
<jsp:include page="/WEB-INF/cliente/agregarcliente.jsp"/>
