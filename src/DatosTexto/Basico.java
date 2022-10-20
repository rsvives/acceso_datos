package DatosTexto;

import java.io.*;

public class Basico {

    public static void main(String[] args) throws IOException {
        File f = new File("./archivos/adios.txt");
//        System.out.println(leerSinBuffer(f));
//        leerSinBuffer(f);
        leerConBuffer(f);
        escribir(f, "¿Quién ganará?",true);
        leerConBuffer(f);
    }
    public static void leerSinBuffer(File f) throws IOException {
        FileReader freader = new FileReader(f);
//        StringBuilder sb = new StringBuilder() ;

        int i;
        while((i=freader.read())!=-1){
//            sb.append((char)i);
            System.out.println((char)i);
        }
//        return sb.toString();
        freader.close();
    }
    public static void leerConBuffer(File f ) throws IOException {
        FileReader freader = new FileReader(f);
        BufferedReader bufferedReader = new BufferedReader(freader);

        String linea;
        while((linea=bufferedReader.readLine())!=null){
            System.out.println(linea);
        }
        freader.close();
        bufferedReader.close();
    }

    public static void escribir(File f, String texto, Boolean append) throws IOException {
        FileWriter  fwriter = new FileWriter(f,append);

        fwriter.write(texto);
        fwriter.close();

    }

    public static void escribirConBuffer(File f,String texto, Boolean append) throws IOException {
        FileWriter fwriter = new FileWriter(f,append);
        BufferedWriter bufferedWriter = new BufferedWriter(fwriter);

        bufferedWriter.write(texto);
        bufferedWriter.newLine();

        bufferedWriter.close();
        fwriter.close();
    }


}
