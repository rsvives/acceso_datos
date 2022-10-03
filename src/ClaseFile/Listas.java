package ClaseFile;

import java.io.File;
import java.util.Arrays;

public class Listas {
    public static void main(String[] args) {

        File archivo = new File("./archivos");

        listarNombresConList(archivo);
        listarNombresConListFiles(archivo);


    }

    public static void listarNombresConList(File archivo){

        for (String s : archivo.list()) {
            System.out.println(s);
        }
    }

    public static void listarNombresConListFiles(File archivo){
        //System.out.println(Arrays.stream(archivo.listFiles()).toList());

        for(File f : archivo.listFiles()){
            System.out.println(f.getName());
        }
    }
}
