<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
    
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link rel="stylesheet" href="css/stilos.css"/>
    </head>
    <body class="vh-100 position-relative">
        <jsp:include page="WEB-INF/componentes/header.jsp"/>
        <main class="container text-xl-center">
            <h2>Clientes en procesos</h2>
            <a class="link-primary link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover" href="${pageContext.request.contextPath}/ServletControlador?accion=cliente">Lista de clientes</a>

       </main>
            <jsp:include page="WEB-INF/componentes/footer.jsp"/>

    </body>
</html>
