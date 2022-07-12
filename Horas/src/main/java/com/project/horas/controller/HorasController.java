package com.project.horas.controller;

import com.project.horas.bean.Jornada;
import com.project.horas.view.CalcularSueldo;
import com.project.horas.view.Inicio;
import com.project.horas.view.PanelJornadaActual;
import com.project.horas.view.PanelVerHoras;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class HorasController {

    private static final String NOMBRE_USUARIO = "ppresa";
    private static final int HORAS_POR_JORNADA = 8;

    private int mesActual = 0;
    private int anioActual = 0;
    private String mesActualString = "";
    private double horasExtra = 0;

    public int getMesActual() {
        return mesActual;
    }

    public int getAnioActual() {
        return anioActual;
    }

    public String getMesActualString() {
        return mesActualString;
    }

    public double getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(double horasExtra) {
        this.horasExtra = horasExtra;
    }

    public Jornada getJornada(String fecha) throws Exception {
        Connection con = getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select entrada, salida, fecha from horas where fecha = '" + fecha + "' and usuario = '" + NOMBRE_USUARIO + "';");
        Jornada jornada = new Jornada();
        while (rs.next()) {
            jornada.setEntrada(rs.getString(1));
            jornada.setSalida(rs.getString(2));
            jornada.setFecha(rs.getString(3));
        }
        con.close();
        return jornada;
    }

    public List<String> getJornadasMesString() {
        String mesConCero = (mesActual >= 10) ? mesActual + "" : "0" + mesActual;
        String qMes = (mesActual != 0) ? " and fecha like '" + anioActual + "-" + mesConCero + "-%'" : "";
        String query = "select entrada, salida, fecha from horas where usuario = '" + NOMBRE_USUARIO + "'" + qMes + " order by fecha desc;";
        List<String> jornadas = new ArrayList<>();
        double balanceTotal = 0;
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Jornada jornada = new Jornada();
                jornada.setEntrada(rs.getString(1));
                jornada.setSalida(rs.getString(2));
                jornada.setFecha(rs.getString(3));
                double balanceDia = darHorasExtra(jornada.getEntrada(), jornada.getSalida(), jornada.getFecha());
                jornadas.add(jornada.toString() + " , Balance del dia: " + balanceDia);
                balanceTotal += balanceDia;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        jornadas.add("   ");
        jornadas.add("BALANCE TOTAL DE HORAS: " + balanceTotal);
        horasExtra = balanceTotal;
        return jornadas;
    }

    public List<Jornada> getJornadasMes() {
        String mesConCero = (mesActual >= 10) ? mesActual + "" : "0" + mesActual;
        String qMes = (mesActual != 0) ? " and fecha like '" + anioActual + "-" + mesConCero + "-%'" : "";
        String query = "select entrada, salida, fecha from horas where usuario = '" + NOMBRE_USUARIO + "'" + qMes + " order by fecha desc;";
        List<Jornada> jornadas = new ArrayList<>();
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Jornada jornada = new Jornada();
                jornada.setEntrada(rs.getString(1));
                jornada.setSalida(rs.getString(2));
                jornada.setFecha(rs.getString(3));
                double balanceDia = darHorasExtra(jornada.getEntrada(), jornada.getSalida(), jornada.getFecha());
                jornadas.add(jornada);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jornadas;
    }

    public List<Jornada> getJornadasMesActual() {
        mesActual = Calendar.getInstance().get(Calendar.MONTH) + 1;
        mesActualString = mapeoNumeroMes();
        anioActual = Calendar.getInstance().get(Calendar.YEAR);
        return getJornadasMes();
    }

    public List<String> getJornadasMesActualString() {
        mesActual = Calendar.getInstance().get(Calendar.MONTH) + 1;
        mesActualString = mapeoNumeroMes();
        anioActual = Calendar.getInstance().get(Calendar.YEAR);
        return getJornadasMesString();
    }

    public List<Jornada> getAllJornadas() {
        List<Jornada> jornadas = new ArrayList<>();
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select entrada, salida, fecha from horas where usuario = '" + NOMBRE_USUARIO + "' ");
            while (rs.next()) {
                Jornada jornada = new Jornada();
                jornada.setEntrada(rs.getString(1));
                jornada.setSalida(rs.getString(2));
                jornada.setFecha(rs.getString(3));
                jornadas.add(jornada);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jornadas;
    }

    public void iniciarJornada(Inicio inicio, PanelVerHoras panel, CalcularSueldo sueldo) {
        if (inicio != null) {
            inicio.setVisible(false);
            inicio.dispose();
        }
        if (panel != null) {
            panel.setVisible(false);
            panel.dispose();
        }

        if (sueldo != null) {
            sueldo.setVisible(false);
            sueldo.dispose();
        }

        PanelJornadaActual jornadaActual = new PanelJornadaActual(this);
        jornadaActual.setVisible(true);
        jornadaActual.setLocation(800, 300);

        try {

            Connection con = getConnection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("insert into horas(entrada, fecha, usuario) values('" + getHoraActual() + "', '" + getFechaActual() + "','" + NOMBRE_USUARIO + "'); ");
            Jornada jornada = getJornada(getFechaActual());
            jornadaActual.setTiempoTranscurrido(getTiempoTranscurrido(jornada.getEntrada()));
            jornadaActual.setHoraEntrada(jornada.getEntrada());
        } catch (Exception e) {
            try {

                Jornada jornada = getJornada(getFechaActual());
                jornadaActual.setTiempoTranscurrido(getTiempoTranscurrido(jornada.getEntrada()));
                jornadaActual.setHoraEntrada(jornada.getEntrada());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void terminarJornada(PanelJornadaActual inicio) {
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("update horas set salida = '" + getHoraActual() + "' where fecha='" + getFechaActual() + "' and usuario = '" + NOMBRE_USUARIO + "' ");

        } catch (Exception e) {

        }
        if (inicio != null) {
            inicio.setVisible(false);
            inicio.dispose();
        }
    }

    private String getFechaActual() {
        Calendar fechaActualCal = Calendar.getInstance();
        int mes = fechaActualCal.get(Calendar.MONTH) + 1;
        int dia = fechaActualCal.get(Calendar.DAY_OF_MONTH);
        int anio = fechaActualCal.get(Calendar.YEAR);
        return darFechaAnioMesDia(anio, mes, dia);
    }

    private String getHoraActual() {
        Calendar fechaActualCal = Calendar.getInstance();
        int horas = fechaActualCal.get(Calendar.HOUR_OF_DAY);
        int minutos = fechaActualCal.get(Calendar.MINUTE);
        int segundos = fechaActualCal.get(Calendar.SECOND);
        return darHoraHorasMinutos(horas, minutos, segundos);

    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://168.138.133.144:3306/encuentra", "root", "@200SRL");
    }

    public void mostrarPanelHoras(Inicio inicio) {
        if (inicio != null) {
            inicio.setVisible(false);
            inicio.dispose();
        }
        PanelVerHoras panelHoras = new PanelVerHoras(this);
        panelHoras.setVisible(true);
        panelHoras.setLocation(800, 300);
        panelHoras.setListHoras(getJornadasMesActualString());
        panelHoras.setMesLabel();
    }

    public void verHoras(Inicio inicio, PanelJornadaActual jornadaActual, CalcularSueldo sueldo) {
        if (inicio != null) {
            inicio.setVisible(false);
            inicio.dispose();
        }
        if (jornadaActual != null) {
            jornadaActual.setVisible(false);
            jornadaActual.dispose();
        }
        if (sueldo != null) {
            sueldo.setVisible(false);
            sueldo.dispose();
        }
        PanelVerHoras panel = new PanelVerHoras(this);
        panel.setLocation(800, 300);
        panel.setVisible(true);
        panel.setListHoras(getJornadasMesActualString());
        panel.setMesLabel();
    }

    public void iniciarAplicacion() {
        try {
            Jornada jornada = getJornada(getFechaActual());
            if (jornada == null || jornada.getEntrada() == null || jornada.getEntrada().isEmpty()) {
                Inicio inicio = new Inicio(this);
                inicio.setVisible(true);
                inicio.setLocation(800, 300);
            } else {
                iniciarJornada(null, null, null);
            }
        } catch (Exception e) {

        }
    }

    private String getTiempoTranscurrido(String horaEntrada) {

        return restarHoras(horaEntrada, getHoraActual());

    }

    public String restarHoras(String tiempoDesde, String tiempoHasta) {

        String[] tiempoDesdeSplit = tiempoDesde.split(":");
        String[] tiempoHastaSplit = tiempoHasta.split(":");

        Integer horasDesde = Integer.parseInt(tiempoDesdeSplit[0]);
        Integer minutosDesde = Integer.parseInt(tiempoDesdeSplit[1]);
        Integer segundosDesde = Integer.parseInt(tiempoDesdeSplit[2]);

        Integer horasHasta = Integer.parseInt(tiempoHastaSplit[0]);
        Integer minutosHasta = Integer.parseInt(tiempoHastaSplit[1]);
        Integer segundosHasta = Integer.parseInt(tiempoHastaSplit[2]);

        int horasTotal = 0;
        int minutosTotal = 0;
        int segundosTotal = 0;

        if (segundosHasta != segundosDesde || minutosHasta != minutosDesde || horasHasta != horasDesde) {

            if (horasHasta >= horasDesde) {
                horasTotal = horasHasta - horasDesde;
            }

            if (minutosHasta >= minutosDesde) {
                minutosTotal = minutosHasta - minutosDesde;
            } else {
                minutosTotal = 60 - minutosDesde + minutosHasta;
                horasTotal--;
            }

            if (segundosHasta >= segundosDesde) {
                segundosTotal = segundosHasta - segundosDesde;
            } else {
                segundosTotal = 60 - segundosDesde + segundosHasta;
                minutosTotal--;
            }
            
            if(minutosTotal<0){
                horasTotal--;
                minutosTotal += 60;
            }

        }

        return darHoraHorasMinutos(horasTotal, minutosTotal, segundosTotal);

    }

    private String darFechaAnioMesDia(int anio, int mes, int dia) {
        String sMes = (mes >= 10) ? mes + "" : "0" + mes;
        String sDia = (dia >= 10) ? dia + "" : "0" + dia;
        return anio + "-" + sMes + "-" + sDia;
    }

    private String darHoraHorasMinutos(int horas, int minutos, int segundos) {
        String sHoras = (horas >= 10) ? horas + "" : "0" + horas;
        String sMinutos = (minutos >= 10) ? minutos + "" : "0" + minutos;
        String sSegundos = (segundos >= 10) ? segundos + "" : "0" + segundos;
        return sHoras + ":" + sMinutos + ":" + sSegundos;
    }

    private double darHorasExtra(String tiempoDesde, String tiempoHasta, String fecha) {

        if (tiempoHasta == null || tiempoHasta.isEmpty()) {
            String horaConSegundos = darHoraHorasMinutos(Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND));
            String[] horaConSegundosSplit = horaConSegundos.split(":");
            tiempoHasta = horaConSegundosSplit[0] + ":" + horaConSegundosSplit[1];
        }
        String[] tiempoDesdeSplit = tiempoDesde.split(":");
        String[] tiempoHastaSplit = tiempoHasta.split(":");

        Integer horasDesde = Integer.parseInt(tiempoDesdeSplit[0]);
        Integer minutosDesde = Integer.parseInt(tiempoDesdeSplit[1]);

        Integer horasHasta = Integer.parseInt(tiempoHastaSplit[0]);
        Integer minutosHasta = Integer.parseInt(tiempoHastaSplit[1]);

        double horasTotal = 0;
        int minutosTotal = 0;

        if (minutosHasta > minutosDesde) {
            minutosTotal = minutosHasta - minutosDesde;
            horasTotal = horasHasta - horasDesde;
        } else {
            minutosTotal = minutosHasta - minutosDesde + 60;
            horasTotal = horasHasta - horasDesde - 1;
        }
        if (minutosTotal == 60) {
            minutosTotal = 0;
        }
        
        if(NOMBRE_USUARIO.equals("balcaide")){
            
        }
        else{
            horasTotal = horasTotal - HORAS_POR_JORNADA;
        }
        

        if (minutosTotal >= 15 && minutosTotal < 30) {
            horasTotal += 0.25;
        }
        if (minutosTotal >= 30 && minutosTotal < 45) {
            horasTotal += 0.5;
        }
        if (minutosTotal >= 45) {
            horasTotal += 0.75;
        }

        return horasTotal;
    }

    public void salir(Inicio inicio, PanelVerHoras verHoras, PanelJornadaActual jornadaActual, CalcularSueldo sueldo) {
        if (inicio != null) {
            inicio.dispose();
            inicio.dispatchEvent(new WindowEvent(inicio, WindowEvent.WINDOW_CLOSING));
        }
        if (verHoras != null) {
            verHoras.dispose();
            verHoras.dispatchEvent(new WindowEvent(verHoras, WindowEvent.WINDOW_CLOSING));
        }
        if (jornadaActual != null) {
            jornadaActual.dispose();
            jornadaActual.dispatchEvent(new WindowEvent(jornadaActual, WindowEvent.WINDOW_CLOSING));

        }
        if (sueldo != null) {
            sueldo.dispose();
            sueldo.dispatchEvent(new WindowEvent(sueldo, WindowEvent.WINDOW_CLOSING));
        }
    }

    public void mesSiguiente(PanelVerHoras panelHoras) {
        if (mesActual == 12) {
            mesActual = 1;
            anioActual++;
        } else {
            mesActual++;
        }
        mesActualString = mapeoNumeroMes();
        panelHoras.setListHoras(getJornadasMesString());
        panelHoras.setMesLabel();
    }

    public void mesAnterior(PanelVerHoras panelHoras) {
        if (mesActual == 1) {
            mesActual = 12;
            anioActual--;
        } else {
            mesActual--;
        }
        mesActualString = mapeoNumeroMes();
        panelHoras.setListHoras(getJornadasMesString());
        panelHoras.setMesLabel();
    }

    public String mapeoNumeroMes() {
        switch (mesActual) {
            case 1:
                return "Enero";
            case 2:
                return "Febrero";
            case 3:
                return "Marzo";
            case 4:
                return "Abril";
            case 5:
                return "Mayo";
            case 6:
                return "Junio";
            case 7:
                return "Julio";
            case 8:
                return "Agosto";
            case 9:
                return "Setiembre";
            case 10:
                return "Octubre";
            case 11:
                return "Noviembre";
            case 12:
                return "Diciembre";
            default:
                return "";
        }
    }

    public void vistaCalcularSueldo(PanelVerHoras panel) {
        if (panel != null) {
            panel.setVisible(false);
            panel.dispose();
        }
        CalcularSueldo sueldo = new CalcularSueldo(this);
        sueldo.setVisible(true);
        sueldo.setLocation(800, 300);

    }

    public void calcularSueldo(String sSueldoBase, String sHorasExtra, CalcularSueldo panel) {

        DecimalFormat numberFormat = new DecimalFormat("#.00");

        double sueldoBase = Double.parseDouble(sSueldoBase);
        double pagoHorasExtra = 0;
        int iHorasExtra = 0;
        if(sHorasExtra!=null && !sHorasExtra.isEmpty() && !sHorasExtra.equals("0")){
            try{
                iHorasExtra = Integer.parseInt(sHorasExtra);
            }
            catch(Exception e){
                
            }
        }
        
        if (iHorasExtra > 0) {
            pagoHorasExtra = (sueldoBase / 120) * iHorasExtra;
            sueldoBase += pagoHorasExtra;
        }
        double bps = sueldoBase * (15.0 / 100);
        double frl = sueldoBase * (1.0 / 1000);
        double snis = sueldoBase * (3.0 / 100);
        double snisad = sueldoBase * (1.5 / 100);

        double sueldoBaseIrpf = sueldoBase - bps - frl - snis - snisad;
        
        int franja0 = 36148;
        int franja1 = 51640;
        int franja2 = 77460;
        int franja3 = 154920;
        int franja4 = 258200;
        int franja5 = 387300;

        double descuentoPrimero = 10.0 / 100;
        double descuentoSegundo = 15.0 / 100;
        double descuentoTercero = 24.0 / 100;
        double descuentoCuarto = 25.0 / 100;
        double descuentoQuinto = 27.0 / 100;

        double irpf = 0;

        if (sueldoBaseIrpf > franja0 && sueldoBaseIrpf < franja1) {
            irpf = (sueldoBaseIrpf - franja0) * descuentoPrimero;
        }
        if (sueldoBaseIrpf > franja1 && sueldoBaseIrpf < franja2) {
            irpf = ((franja1 - franja0) * descuentoPrimero) + ((sueldoBaseIrpf - franja1) * descuentoSegundo);
        }
        if (sueldoBaseIrpf > franja2 && sueldoBaseIrpf < franja3) {
            irpf = ((franja1 - franja0) * descuentoPrimero) + ((franja2 - franja1) * descuentoSegundo) + ((sueldoBaseIrpf - franja2) * descuentoTercero);
        }
        if (sueldoBaseIrpf > franja3 && sueldoBaseIrpf < franja4) {
            irpf = ((franja1 - franja0) * descuentoPrimero) + ((franja2 - franja1) * descuentoSegundo) + ((franja3 - franja2) * descuentoTercero) + ((sueldoBaseIrpf - franja3) * descuentoCuarto);
        }
        if (sueldoBaseIrpf > franja4 && sueldoBaseIrpf < franja5) {
            irpf = ((franja1 - franja0) * descuentoPrimero) + ((franja2 - franja1) * descuentoSegundo) + ((franja3 - franja2) * descuentoTercero) + ((franja4 - franja3) * descuentoCuarto) + ((sueldoBaseIrpf - franja4) * descuentoQuinto);
        }

        double deducciones = bps + frl + snis + snisad + irpf;
        double sueldoLiquido = sueldoBase - deducciones;

        List<String> impresiones = new ArrayList<>();

        impresiones.add("\r\n Totales");
        impresiones.add("\r\n Sueldo Base: " + numberFormat.format(sueldoBase));
        if (iHorasExtra > 0) {
            impresiones.add("\r\n Horas Extra (" + iHorasExtra + ") :" + numberFormat.format(pagoHorasExtra));
        }

        impresiones.add("\r\n BPS: " + numberFormat.format(bps));
        impresiones.add("\r\n FRL: " + numberFormat.format(frl));
        impresiones.add("\r\n SNIS: " + numberFormat.format(snis));
        impresiones.add("\r\n SNISAD: " + numberFormat.format(snisad));
        impresiones.add("\r\n IRPF: " + numberFormat.format(irpf));
        impresiones.add("\r\n");
        impresiones.add("\r\n Total deducciones:");
        impresiones.add("\r\n");
        impresiones.add("\r\n " + numberFormat.format(deducciones));
        impresiones.add("\r\n");
        impresiones.add("\r\n Sueldo Liquido: ");
        impresiones.add("\r\n");
        impresiones.add("\r\n " + numberFormat.format(sueldoLiquido));

        panel.imprimir(impresiones);

    }

    public void exportarXls() {
        List<Jornada> jornadas = getJornadasMesActual();
        String pathHorasBase = "C:/Program Files/200/Encuentra/horas/HorasVacias-DenisElias.xlsx";
        String pathNuevo = "C:/Program Files/200/Encuentra/horas" + mesActualString + anioActual + ".xlsx";
        File horasVacias = new File(pathHorasBase);
        
    }
}
