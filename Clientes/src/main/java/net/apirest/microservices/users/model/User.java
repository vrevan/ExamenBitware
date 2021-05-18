
package net.apirest.microservices.users.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * Model class of controller
 * @author Victor Camacho
 *
 */
@Document(collection = "users")
@JsonPropertyOrder({"userId", "name"})
public class User implements Serializable{

	private static final long serialVersionUID = -7788619177798333712L;

    @Id
    private String userId;
      
    private String name;
    private String Apellido;
    private String Nombre_Usuario;
    private String Contraseña;

    public String getNombre_Usuario() {
        return Nombre_Usuario;
    }

    public void setNombre_Usuario(String Nombre_Usuario) {
        this.Nombre_Usuario = Nombre_Usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public String getCorreo_Electronico() {
        return Correo_Electronico;
    }

    public void setCorreo_Electronico(String Correo_Electronico) {
        this.Correo_Electronico = Correo_Electronico;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public double getEstatura() {
        return Estatura;
    }

    public void setEstatura(double Estatura) {
        this.Estatura = Estatura;
    }

    public double getPeso() {
        return Peso;
    }

    public void setPeso(double Peso) {
        this.Peso = Peso;
    }

    public double getIMC() {
        return IMC;
    }

    public void setIMC(double IMC) {
        this.IMC = IMC;
    }

    public double getGEB() {
        return GEB;
    }

    public void setGEB(double GEB) {
        this.GEB = GEB;
    }

    public double getETA() {
        return ETA;
    }

    public void setETA(double ETA) {
        this.ETA = ETA;
    }

    public String getFecha_Creacion() {
        return Fecha_Creacion;
    }

    public void setFecha_Creacion(String Fecha_Creacion) {
        this.Fecha_Creacion = Fecha_Creacion;
    }

    public String getFecha_Actualizacion() {
        return Fecha_Actualizacion;
    }

    public void setFecha_Actualizacion(String Fecha_Actualizacion) {
        this.Fecha_Actualizacion = Fecha_Actualizacion;
    }
    private String Correo_Electronico;
    private int Edad;
    private double Estatura;
    private double Peso;
    private double IMC;
    private double GEB;
    private double ETA;
    private String Fecha_Creacion;
    private String Fecha_Actualizacion;

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }
    
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}   
}
