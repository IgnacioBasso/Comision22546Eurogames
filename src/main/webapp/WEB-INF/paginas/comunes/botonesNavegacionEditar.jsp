<section id="actions" class="py-4 bg-info">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <a href="index.jsp" class="btn btn-light btn-block">
                    <i class="fas fa-arrow-left"></i>
                    Regresar a inicio
                    <i class="fas fa-gamepad"></i>
                </a>
            </div>
            <div class="col-md-3">
                <button type="submit" class="btn btn-success btn-block"> 
                    <i class="fas fa-check"></i>
                    Guardar Modificación
                    <i class="fas fa-wand-magic-sparkles"></i>
                </button>   
            </div>
            <div class="col-md-3">
                <a href="${pageContext.request.contextPath}/servletControlador?accion=eliminar&idEurogame=${eurogame.idEurogame}" class="btn btn-danger btn-block">
                    <i class="fas fa-trash"></i>
                    Eliminar Juego
                    <i class="fas fa-dragon"></i>
                </a>  

            </div>
        </div>
    </div>

</section>

