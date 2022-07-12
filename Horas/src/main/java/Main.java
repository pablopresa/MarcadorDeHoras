
import com.project.horas.controller.HorasController;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

    HorasController controller = new HorasController();
//        List<List<String>> pruebas = new ArrayList<>();
//        List<String> horas = new ArrayList<>();
//        horas.add("10:00:00");
//        horas.add("18:00:00");
//        horas.add("08:00:00");
//        pruebas.add(horas);
//        horas=new ArrayList<>();
//        horas.add("9:37:33");
//        horas.add("17:39:22");
//        horas.add("08:01:49");
//        pruebas.add(horas);
//        horas=new ArrayList<>();
//        horas.add("3:40:33");
//        horas.add("5:40:35");
//        horas.add("02:00:02");
//        pruebas.add(horas);
//        horas=new ArrayList<>();
//        horas.add("9:29:11");
//        horas.add("19:39:22");
//        horas.add("10:10:11");
//        pruebas.add(horas);
//        horas=new ArrayList<>();
//        horas.add("8:07:33");
//        horas.add("11:07:22");
//        horas.add("02:59:49");
//        pruebas.add(horas);
//
//        for (List<String> array : pruebas) {
//            String horaDesde = array.get(0);
//            String horaHasta = array.get(1);
//            String resultadoEsperado = array.get(2);
//            String resultado = controller.restarHoras(horaDesde, horaHasta);
//            System.out.println(horaDesde + " - " + horaHasta);
//            System.out.println("Esperado " + resultadoEsperado);
//            System.out.println("Obtenido " + resultado);
//            System.out.println((resultadoEsperado.equals(resultado)) ? "CORRECTO" : "INCORRECTO");
//        }

        controller.iniciarAplicacion();
    }
}
