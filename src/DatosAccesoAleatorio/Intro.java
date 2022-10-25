package DatosAccesoAleatorio;

import java.io.*;

public class Intro {
    public static void main(String[] args) throws IOException {
        File f = new File("./archivos/random_access/raf1.dat");
        RandomAccessFile raf = new RandomAccessFile( f,"rw");
//        RandomAccessFile rafTexto = new RandomAccessFile("./archivos/random_access/raf2.txt","rw");
        insertarDatos(raf,"primer dato", 30);
        insertarDatos(raf,"segundo dato", 30);
        insertarDatos(raf,"tercer dato", 30);
        leerDatos(raf,3,30);
        raf.close();
    }

    public static void insertarDatosFAIL(RandomAccessFile raf, String datos, long longitud) throws IOException {

        //Este método no funciona 😢

        int contador=0;
        if(raf.length()==0){
            raf.writeChars(datos);
            contador=1;
        }else{
            raf.seek(contador*longitud);
            raf.writeChars(datos);
            contador++;
        }
    }

    public static void leerDatosFAIL(RandomAccessFile raf, long registro, long longitud) throws IOException {
        //Este método no funciona 😢
        long posicion = (registro) * longitud;
        raf.seek(posicion);

        StringBuilder datos = new StringBuilder();
        try {
            while (posicion <= posicion + 30) {
                raf.seek(posicion);
                datos.append(raf.readChar());
                posicion++;
            }
        } catch (EOFException eof) {
            System.err.println("End of File");
        } finally {
            System.out.println(datos.toString());
        }
    }

    public static void leerDatos(RandomAccessFile raf, long order, long size) throws IOException {
        long position = order*size-size;
        raf.seek(position);
        StringBuilder dato;
        dato = new StringBuilder();
        for (int i=0;i<size/2;i++){
            dato.append(raf.readChar());
        }
        System.out.println(dato.toString());
    }
    public static void insertarDatos (RandomAccessFile raf, String datos, Integer longitud) throws IOException {
        StringBuffer stringBuffer = new StringBuffer(datos);
        stringBuffer.setLength(longitud/2);
        raf.seek(raf.length());
        long posicion;
        posicion =  raf.getFilePointer();
        System.out.println("Posicion ini: " + posicion);
        raf.writeChars(stringBuffer.toString());
        posicion = raf.getFilePointer();
        System.out.println("Posicion fin: " + posicion);

    }

}
