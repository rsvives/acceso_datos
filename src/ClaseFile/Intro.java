package ClaseFile;

import java.io.File;

public class Intro {
    public static void main(String[] args){
        System.out.println("Clase File");
        String ruta = "./archivos";
        File miCarpeta = new File(ruta);
        System.out.println("miCarpeta existe: " +miCarpeta.exists());
        System.out.println(miCarpeta.isDirectory());
        System.out.println(miCarpeta.isFile());

        File miFichero = new File(ruta+"/afa formacion.txt");
        System.out.println("miFichero existe: " + miFichero.exists());
        System.out.println(miFichero.isDirectory());
        System.out.println(miFichero.isFile());

    }
}
