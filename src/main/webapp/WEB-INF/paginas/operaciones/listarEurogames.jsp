<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_AR"/>
<section id="eurogames">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class ="card">
                    <div class="card-header">
                        <h4>Listado de Eurogames</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">                       
                            <tr class="text-center">
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Editor</th>
                                <th>Cantidad de jugadores</th>
                                <th >Duración de la partida en minutos</th>
                                <th>Edad mínima recomendada</th>
                                <th>Precio</th>
                                <th>Cantidad</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var = "eurogame" items = "${eurogames}" varStatus="status">
                                <tr class="text-center">
                                    <td >${status.count}</td>
                                    <td >${eurogame.nombre}</td>
                                    <td>${eurogame.editor}</td>
                                    <td>${eurogame.cantidadJugadores}</td>
                                    <td>${eurogame.minutosJuego}</td>
                                    <td>${eurogame.edadMinima}</td>
                                    <td><fmt:formatNumber value="${eurogame.precio}" type="currency"/> </td>
                                    <td>${eurogame.cantidad}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/servletControlador?accion=editar&idEurogame=${eurogame.idEurogame}" class="btn btn-secondary">
                                            <i class="fas fa-wand-magic-sparkles"></i>
                                            Editar
                                        </a>
                                    </td>                                    
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card text-center bg-danger text-white mb-3">
                    <div class="card-body">
                        <h3>Variedad de juegos totales</h3>
                        <h4 class="display-4"><i class="fas fa-dragon"></i> ${totalJuegos}</h4>
                    </div>
                </div>
                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Stock total de juegos</h3>
                        <h4 class="display-4"><i class="fas fa-chess-board"></i> ${stockTotalJuegos}</h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="/WEB-INF/paginas/operaciones/agregarJuego.jsp"/>