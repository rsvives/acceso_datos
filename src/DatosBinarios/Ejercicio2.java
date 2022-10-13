package DatosBinarios;

import java.io.*;
import java.util.Random;

public class Ejercicio2 {

    private static Random random = new Random();

    public static void main(String[] args) {

        File file = new File("./Archivos/datos.dat");

        try {
            escribirBin(file,10, 5,20);
            leerFichero(file);
            mediaSinArray(file);
            mediaArray(file);
            //System.err.println(mediaBruta(file));
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected static void escribirBin(File file, int cant, int min, int max) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        for (int i = 0; i < cant; i++)
            fileOutputStream.write(random.nextInt(max-min +1)+min);
        fileOutputStream.close();
    }


    //El siguiente método falla
//    protected static int mediaBruta(File file) throws IOException {
//        FileInputStream fileInputStream = new FileInputStream(file);
//
//        int sumatorio = 0;
//        int i = 0;
//
//        for (; i < fileInputStream.available(); i++)
//            sumatorio += fileInputStream.read();
//
//        fileInputStream.close();
//
//        return sumatorio/(i+1);
//    }

    public static void mediaSinArray(File f){
        try{
            FileInputStream fin = new FileInputStream(f);
            int i, cant = 0;
            double  acum = 0,media = 0;
            while((i=fin.read())!=-1){
                acum += i;
                cant ++;
            }
            media = acum/cant;
            System.out.println("La media es " + acum + "/" + cant + "=" + media);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public static void mediaArray (File f) throws IOException {
        FileInputStream fin = new FileInputStream(f);
        byte[] array = fin.readAllBytes();
        double total =0;
        for (int j = 0; j < array.length; j++) {
            total =total+array[j];
        }
        double media = total/array.length;
        System.out.println("La media con array es: " + media);
        fin.close();
    }


    public static void leerFichero (File f) throws  IOException{
        FileInputStream fin = new FileInputStream(f);

        int i;
        while((i=fin.read())!=-1){
            System.out.println(i);
        }

        fin.close();
    }
}
