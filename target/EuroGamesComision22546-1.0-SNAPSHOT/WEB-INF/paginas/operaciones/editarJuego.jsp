<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://kit.fontawesome.com/382381b436.js" crossorigin="anonymous"></script>
        <title>Editar EuroGames</title>
    </head>
    <body>
        <jsp:include page="../comunes/cabecera.jsp"/>
        <form action="${pageContext.request.contextPath}/servletControlador?accion=modificar&idEurogame=${eurogame.idEurogame}" method="POST" class="was-validated">
            <jsp:include page="../comunes/botonesNavegacionEditar.jsp"/>

            <section id="details" style="background: linear-gradient(0deg, rgba(34,193,195,1) 0%, rgba(3,21,29,0.2922688973050157) 100%);">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Modificar Juego</h4>                                    
                                </div>
                                <div class="card-body">
                                    <div class="form-group"> 
                                        <label for="nombre">Nombre</label>
                                        <input type="text" class="form-control" name="nombre" required="" value="${eurogame.nombre}"> 
                                    </div>
                                    <div class="form-group"> 
                                        <label for="editor">Editor</label>
                                        <input type="text" class="form-control" name="editor" required="" value="${eurogame.editor}">
                                    </div>
                                    <div class="form-group"> 
                                        <label for="cantidadJugadores">Cantidad de jugadores</label>
                                        <input type="text" class="form-control" name="cantidadJugadores" required="" value="${eurogame.cantidadJugadores}">
                                    </div>
                                    <div class="form-group"> 
                                        <label for="minutosJuego">Duración de la partida</label>
                                        <input type="number" class="form-control" name="minutosJuego" required="" value="${eurogame.minutosJuego}">
                                    </div>
                                    <div class="form-group"> 
                                        <label for="edadMinima">Edad mínima recomendada</label>
                                        <input type="number" class="form-control" name="edadMinima" required="" value="${eurogame.edadMinima}">
                                    </div>
                                    <div class="form-group"> 
                                        <label for="precio">Precio</label>
                                        <input type="number" class="form-control" name="precio" required="" value="${eurogame.precio}">
                                    </div>
                                    <div class="form-group"> 
                                        <label for="cantidad">Cantidad</label>
                                        <input type="number" class="form-control" name="cantidad" required="" value="${eurogame.cantidad}">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form>
        <jsp:include page="../comunes/pieDePagina.jsp"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>