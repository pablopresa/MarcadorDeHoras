package com.project.horas.bean;

public class Jornada {
    private String entrada;
    private String salida;
    private String fecha;
    private int suma;
    
    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSalida() {
        return (salida==null) ? "" : (salida);
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String entradaToString(){
        String[] hora  = entrada.split(":");
        return hora[0]+":"+hora[1];
    }
    
    public String salidaToString(){
        if(salida!=null && !salida.isEmpty()){
            String[] hora  = salida.split(":");
            return hora[0]+":"+hora[1];
        }
        else{
            return "";
        }
    }
    
    @Override
    public String toString() {
        return fecha + ": " + entradaToString() + " - " + salidaToString();
    }

   
    
}
