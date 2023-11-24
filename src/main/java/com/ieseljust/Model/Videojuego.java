/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ieseljust.Model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Daniel
 */


@Entity
public class Videojuego implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "nombre_juego")
    private String nombreJuego;
    
    @Column(name = "desarrolladora")
    private String desarrolladora;
    
    @Column(name = "año_salida")
    private int añoSalida;
    
    @Column(name = "numero_ventas")
    private int numeroVentas;

    // Constructor, getters, setters y otros métodos según sea necesario

    public Videojuego() {
        // Constructor por defecto requerido por JPA
    }

    public Videojuego(String nombreJuego, String desarrolladora, int añoSalida, int numeroVentas) {
        this.nombreJuego = nombreJuego;
        this.desarrolladora = desarrolladora;
        this.añoSalida = añoSalida;
        this.numeroVentas = numeroVentas;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreJuego() {
        return nombreJuego;
    }

    public void setNombreJuego(String nombreJuego) {
        this.nombreJuego = nombreJuego;
    }

    public String getDesarrolladora() {
        return desarrolladora;
    }

    public void setDesarrolladora(String desarrolladora) {
        this.desarrolladora = desarrolladora;
    }

    public int getAñoSalida() {
        return añoSalida;
    }

    public void setAñoSalida(int anoSalida) {
        this.añoSalida = anoSalida;
    }

    public int getNumeroVentas() {
        return numeroVentas;
    }

    public void setNumeroVentas(int numeroVentas) {
        this.numeroVentas = numeroVentas;
    }

    @Override
    public String toString() {
        return "ID=" + id + ", Nombre del juego=" + nombreJuego + ", Desarrolladora=" + desarrolladora + ", Año salida=" + añoSalida + ", Numero de ventas=" + numeroVentas + '}';
    }
    
}
