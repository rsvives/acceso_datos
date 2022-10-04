package ClaseFile;

import java.io.File;

public class Renombrar {
    public static void main(String[] args) {
        String ruta = "./archivos";
        File archivos = new File(ruta);
//        renombrarArchivos(archivos);
        renombrarArchivos2(archivos);
    }
    public static void renombrarArchivos(File archivo){
        File[] files = archivo.listFiles();
        for(File file : files){
            String nombreArchivo = file.getName();
            String nombreNuevo= "";
            boolean hayEspacio = false;
            for (int i = 0; i < nombreArchivo.length(); i++) {
                char caracter = nombreArchivo.charAt(i);
                if(Character.compare(caracter, ' ')==0){
                    nombreNuevo=nombreNuevo + "_";
                    hayEspacio=true;
                }else{
                    nombreNuevo = nombreNuevo + caracter;
                }
            }
            if(hayEspacio==true){
                String ruta = file.getParent();
                File file2 = new File(ruta+"/"+nombreNuevo);

                file.renameTo(file2);
            }
        }
    }
    public static void renombrarArchivos2(File file){
        File[] ficheros = file.listFiles();

        for (File f: ficheros){
            String nuevoNombre = f.getName().replace(" ", "_");
            File f2 = new File(f.getParent()+"/" + nuevoNombre);

            f.renameTo(f2);

        }

    }
}
