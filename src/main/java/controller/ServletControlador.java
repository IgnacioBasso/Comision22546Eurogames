package controller;

import data.EurogameDAO;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Eurogame;

@WebServlet("/servletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String accionJava = req.getParameter("accion");
        if (accionJava != null) {
            switch (accionJava) {
                case "editar": {
                    try {
                        editarJuego(req, res);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ServletControlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case "eliminar": {
                    try {
                        eliminarJuego(req, res);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ServletControlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                default: {
                    try {
                        accionDefault(req, res);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ServletControlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            }
        } else {
            try {
                accionDefault(req, res);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ServletControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String accionJava = req.getParameter("accion");
        if (accionJava != null) {
            switch (accionJava) {
                case "insertar": {
                    try {
                        insertarJuego(req, res);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ServletControlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                case "modificar": {
                    try {
                        modificarJuego(req, res);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ServletControlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                default: {
                    try {
                        accionDefault(req, res);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ServletControlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

            }
        } else {
            try {
                accionDefault(req, res);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ServletControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private Integer calcularStockTotal(List<Eurogame> eurogames) {
        Integer cantidad = 0;
        for (int i = 0; i < eurogames.size(); i++) {
            cantidad += eurogames.get(i).getCantidad();
        }
        return cantidad;
    }

    private void accionDefault(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException, ClassNotFoundException {
        List<Eurogame> eurogames = null;
        try {
            eurogames = new EurogameDAO().seleccionar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        eurogames.forEach(System.out::println);

        HttpSession sesion = req.getSession();

        sesion.setAttribute("eurogames", eurogames);
        sesion.setAttribute("totalJuegos", eurogames.size());
        sesion.setAttribute("stockTotalJuegos", calcularStockTotal(eurogames));
        res.sendRedirect("eurogames.jsp");
    }

    private void insertarJuego(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, ClassNotFoundException {

        String nombre = req.getParameter("nombre");
        String editor = req.getParameter("editor");
        String cantidadJugadores = req.getParameter("cantidadJugadores");
        int minutosJuego = 0, edadMinima = 0, cantidad = 0;
        double precio = 0;

        String minutosJuegoString = req.getParameter("minutosJuego");
        if (minutosJuegoString != null && !minutosJuegoString.equals("")) {
            minutosJuego = Integer.parseInt(minutosJuegoString);
        }
        String edadMinimaString = req.getParameter("edadMinima");
        if (edadMinimaString != null && !edadMinimaString.equals("")) {
            edadMinima = Integer.parseInt(edadMinimaString);
        }
        String precioString = req.getParameter("precio");
        if (precioString != null && !precioString.equals("")) {
            precio = Double.parseDouble(precioString);
        }
        String cantidadString = req.getParameter("cantidad");
        if (cantidadString != null && !cantidadString.equals("")) {
            cantidad = Integer.parseInt(cantidadString);
        }

        Eurogame eurogame = new Eurogame(nombre, editor, cantidadJugadores, minutosJuego, edadMinima, precio, cantidad);

        int regMod = new EurogameDAO().insertar(eurogame);

        System.out.println("Registros guardados: " + regMod);

        accionDefault(req, res);
    }

    private void editarJuego(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException, ClassNotFoundException {
        int idEurogame = 0;
        String idJuegoString = req.getParameter("idEurogame");
        if (idJuegoString != null && !idJuegoString.equals("")) {
            idEurogame = Integer.parseInt(idJuegoString);
        }

        Eurogame eurogame = new EurogameDAO().seleccionarPorID(idEurogame);

        req.setAttribute("eurogame", eurogame);
        String jspEditar = "/WEB-INF/paginas/operaciones/editarJuego.jsp";
        req.getRequestDispatcher(jspEditar).forward(req, res);

    }

    private void modificarJuego(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException, ClassNotFoundException {

        int idEurogame = 0;
        String idJuegoString = req.getParameter("idEurogame");
        if (idJuegoString != null && !idJuegoString.equals("")) {
            idEurogame = Integer.parseInt(idJuegoString);
        }

        String nombre = req.getParameter("nombre");
        String editor = req.getParameter("editor");
        String cantidadJugadores = req.getParameter("cantidadJugadores");
        int minutosJuego = 0, edadMinima = 0, cantidad = 0;
        double precio = 0;

        String minutosJuegoString = req.getParameter("minutosJuego");
        if (minutosJuegoString != null && !minutosJuegoString.equals("")) {
            minutosJuego = Integer.parseInt(minutosJuegoString);
        }
        String edadMinimaString = req.getParameter("edadMinima");
        if (edadMinimaString != null && !edadMinimaString.equals("")) {
            edadMinima = Integer.parseInt(edadMinimaString);
        }
        String precioString = req.getParameter("precio");
        if (precioString != null && !precioString.equals("")) {
            precio = Double.parseDouble(precioString);
        }
        String cantidadString = req.getParameter("cantidad");
        if (cantidadString != null && !cantidadString.equals("")) {
            cantidad = Integer.parseInt(cantidadString);
        }

        Eurogame eurogame = new Eurogame(idEurogame, nombre, editor, cantidadJugadores, minutosJuego, edadMinima, precio, cantidad);

        int regMod = new EurogameDAO().actualizar(eurogame);

        System.out.println("Registros actualizados: " + regMod);

        accionDefault(req, res);
    }

    public void eliminarJuego(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, ClassNotFoundException {

        int idEurogame = 0;
        String idJuegoString = req.getParameter("idEurogame");
        if (idJuegoString != null && !idJuegoString.equals("")) {
            idEurogame = Integer.parseInt(idJuegoString);
        }
        int regBorrador = new EurogameDAO().eliminar(idEurogame);

        System.out.println("Registros eliminados: " + regBorrador);

        accionDefault(req, res);
    }

}
