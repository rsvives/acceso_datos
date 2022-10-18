package Excepciones;

public class ExcepcionesThrow {
    public static void main(String[] args) {
        diaDeLaSemana(1);
        diaDeLaSemana(2);
        diaDeLaSemana(12);
        diaDeLaSemana(6);

    }
    public static void diaDeLaSemana(int i){
        try{
            if(i == 1){
                throw new Exception("Hoy es lunes");
            } else if (i == 2) {
                throw new Exception("Hoy es martes");
            }else if (i == 3) {
                throw new Exception("Hoy es miercoles");
            }else if (i == 4) {
                throw new Exception("Hoy es jueves");
            }else if (i == 5) {
                throw new Exception("Hoy es viernes");
            }else if (i == 6) {
                throw new Exception("Hoy es sabado");
            }else if (i == 7) {
                throw new Exception("Hoy es domingo");
            }else
                throw new Exception("No se que dia es");
        }catch(Exception e){
            System.err.println(e);
        }
    }
}
