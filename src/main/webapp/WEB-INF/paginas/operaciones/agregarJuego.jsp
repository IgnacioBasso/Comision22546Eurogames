<div class="modal fade" id="agregarJuegoModal" tabindex="-1" aria-labelledby="agregarJuegoModal" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Juego</h5>
                <button type="button" class="btn-close" data-dismiss="modal" aria-label="close"></button>
            </div>
            <form action="${pageContext.request.contextPath}/servletControlador?accion=insertar" method="POST" class="was-validated">
                <div class="modal-body"> 
                    <div class="form-group"> 
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombre" required/>
                    </div>
                    <div class="form-group"> 
                        <label for="editor">Editor</label>
                        <input type="text" class="form-control" name="editor"required/>
                    </div>
                    <div class="form-group"> 
                        <label for="cantidadJugadores">Cantidad de jugadores</label>
                        <input type="text" class="form-control" name="cantidadJugadores"required/>
                    </div>
                    <div class="form-group"> 
                        <label for="minutosJuego">Duración de la partida</label>
                        <input type="number" class="form-control" name="minutosJuego"required/>
                    </div>
                    <div class="form-group"> 
                        <label for="edadMinima">Edad mínima recomendada</label>
                        <input type="number" class="form-control" name="edadMinima"required/>
                    </div>
                    <div class="form-group"> 
                        <label for="precio">Precio</label>
                        <input type="number" class="form-control" name="precio"required/>
                    </div>
                    <div class="form-group"> 
                        <label for="cantidad">Cantidad</label>
                        <input type="number" class="form-control" name="cantidad"required/>
                    </div>
                </div>
                <div class="modal-footer"> 
                    <button class="btn btn-primary" type="submit">
                        Guardar
                    </button>
                </div>

            </form>
        </div>
    </div>
</div>