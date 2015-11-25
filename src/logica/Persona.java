/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.sql.Date;

/**
 *
 * @author gabriel
 */
public class Persona {
    	private float altura;
	private String apellido;
	private long cuit;
	private String direccion_particular;
	private Date fecha_nacimiento;
	private boolean fuma;
	private String localidad_particular;
	private String nombre;
	private int DNI;
        private int nro;
	private String ocupacion;
	private float peso;
	private String provincia_particular;
	private String sexo;
	private long tel_particular;
	private float tension_arterial;
	private String tipo_DNI;
	private boolean zurdo;
	private String tipo_familiar;
        private String estadoCivil;

    public String getTipo_familiar() {
        return tipo_familiar;
    }

    public void setTipo_familiar(String tipo_familiar) {
        this.tipo_familiar = tipo_familiar;
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

	public Persona(){

	}

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

	public float get_altura(){
		return altura;
	}

	public String get_apellido(){
		return apellido;
	}

	public long get_cuit(){
          return cuit;
	}

	public String get_dR_Calle(){
		return direccion_particular;
	}

	public String get_dR_Localidad(){
		return localidad_particular;
	}

	public int get_dR_Nro(){
		return nro ;
	}

	public String get_dR_Provincia(){
		return "";
	}

	public Date get_fechanac(){
		return fecha_nacimiento;
	}

	public boolean get_fuma(){
		return false;
	}

	public boolean get_incapacitado(){
		return false;
	}

	public String get_nombre(){
		return nombre;
	}

	public float get_peso(){
		return peso;
	}

	public String get_sexo(){
		return "";
	}

	public long get_telefono_particualr(){
		return tel_particular;
	}

	public float get_tencion_arterial(){
		return tension_arterial;
	}

	public String get_tipo_familiar(){
		return "";
	}

	public boolean get_zurdo(){
		return false;
	}

	/**
	 * 
	 * @param altura
	 */
	public void set_altura(float altura){

	}

	/**
	 * 
	 * @param apellido
	 */
	public void set_apellido(String apellido){
             this.apellido=apellido;
	}

	/**
	 * 
	 * @param cuit
	 */
	public void set_cuit(long cuit){
           this.cuit=cuit;
	}

	/**
	 * 
	 * @param calle
	 */
	public void set_dR_Calle(String calle){
         this.direccion_particular=calle;
	}

	/**
	 * 
	 * @param localidad
	 */
	public void set_dR_Localidad(String localidad){

	}

	/**
	 * 
	 * @param nro
	 */
	public void set_dR_Nro(int nro){
          nro=nro;
	}

	/**
	 * 
	 * @param provincia
	 */
	public void set_dR_Provincia(String provincia){

	}

	/**
	 * 
	 * @param fecha_nac
	 */
	public void set_fechanac(Date fecha_nac){
         fecha_nacimiento=  fecha_nac;       
	}

	/**
	 * 
	 * @param fumar
	 */
	public void set_fuma(boolean fumar){

	}

	/**
	 * 
	 * @param incapacidad
	 */
	public void set_incapacitado(boolean incapacidad){

	}

	/**
	 * 
	 * @param nombre
	 */
	public void set_nombre(String nombre){
        this.nombre=nombre;
	}

	/**
	 * 
	 * @param peso
	 */
	public void set_peso(float peso){

	}

	/**
	 * 
	 * @param sexo
	 */
	public void set_sexo(String sexo){

	}

	/**
	 * 
	 * @param telefono
	 */
	public void set_telefono_particualr(long telefono){
              tel_particular=telefono;
	}

	/**
	 * 
	 * @param tension_arterial
	 */
	public void set_tencion_arterial(float tension_arterial){

	}

	/**
	 * 
	 * @param tipo_familiar
	 */
	public void set_tipo_familiar(String tipo_familiar){

	}

	/**
	 * 
	 * @param zurdo
	 */
	public void set_zurdo(boolean zurdo){

	}

}
