/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nacho
 */
public class Eurogame {
    
    private int idEurogame;
    private String nombre;
    private String editor;
    private String cantidadJugadores;
    private int minutosJuego;
    private int edadMinima;
    private double precio;
    private int cantidad;

    public Eurogame(int idEurogame, String nombre, String editor, String cantidadJugadores, int minutosJuego, int edadMinima, double precio, int cantidad) {
        this.idEurogame = idEurogame;
        this.nombre = nombre;
        this.editor = editor;
        this.cantidadJugadores = cantidadJugadores;
        this.minutosJuego = minutosJuego;
        this.edadMinima = edadMinima;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Eurogame(String nombre, String editor, String cantidadJugadores, int minutosJuego, int edadMinima, double precio, int cantidad) {
        this.nombre = nombre;
        this.editor = editor;
        this.cantidadJugadores = cantidadJugadores;
        this.minutosJuego = minutosJuego;
        this.edadMinima = edadMinima;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    
    public Eurogame(){
        
    }

    public int getIdEurogame() {
        return idEurogame;
    }

    public void setIdEurogame(int idEurogame) {
        this.idEurogame = idEurogame;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getCantidadJugadores() {
        return cantidadJugadores;
    }

    public void setCantidadJugadores(String cantidadJugadores) {
        this.cantidadJugadores = cantidadJugadores;
    }

    public int getMinutosJuego() {
        return minutosJuego;
    }

    public void setMinutosJuego(int minutosJuego) {
        this.minutosJuego = minutosJuego;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    @Override
    public String toString(){
        return "Eurogame{" + "nombre = " + nombre + ", editor = " + editor + ", cantidad de jugadores = " + cantidadJugadores + ", minutos de juego = " 
                + minutosJuego + ", edad mínima recomendada = " + edadMinima + ", precio = " + precio + ", cantidad = " + cantidad;
    }

    
}
