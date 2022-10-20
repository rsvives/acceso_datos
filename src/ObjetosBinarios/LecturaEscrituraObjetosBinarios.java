package ObjetosBinarios;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class LecturaEscrituraObjetosBinarios {

    public static void main(String[] args) {
        File f = new File("./archivos/personas.dat");
        Persona persona1 = new Persona("Juan",23);

        HashMap<String, Integer> personas = new HashMap<>();
        personas.put("Ana",19);
        personas.put("Luis",22);
        personas.put("Alicia",24);
        personas.put("Juan",20);
        personas.put("Sofía",19);

        ArrayList<Persona> personasArray= crearMultiplesPersonas(personas);

        try{
            escribirPersona(f,personasArray);
            ArrayList<Persona> personasLeidas =leerPersona(f);
            for (Persona p : personasLeidas){
//                System.out.println(p.toString());
                System.out.printf("Nombre: %s, edad: %d \n", p.getNombre(),p.getEdad());
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void escribirPersona(File f, Persona persona) throws IOException {
        FileOutputStream fout = new FileOutputStream(f);
        ObjectOutputStream objout = new ObjectOutputStream(fout);
        objout.writeObject(persona);
        objout.close();
        fout.close();
    }
    public static void escribirPersona(File f, ArrayList<Persona> personas) throws IOException {
        FileOutputStream fout = new FileOutputStream(f);
        ObjectOutputStream objout = new ObjectOutputStream(fout);

        for(Persona p: personas){
            objout.writeObject(p);
        }
        objout.close();
        fout.close();
    }


    public static ArrayList<Persona> leerPersona(File f) throws IOException, ClassNotFoundException {
        ArrayList<Persona> personas = new ArrayList<>();
        FileInputStream fin = new FileInputStream(f);
        ObjectInputStream objin = new ObjectInputStream(fin);

        try{
            while(true){
                personas.add((Persona) objin.readObject());
            }
        }catch (EOFException eof){
            System.out.println("fin de archivo");
        }
        objin.close();
        fin.close();
        return personas;
    }

    public static ArrayList<Persona> crearMultiplesPersonas(HashMap<String, Integer> hmap){
        Persona persona;
        ArrayList<Persona> personasArray = new ArrayList<>();
        for(String nombre : hmap.keySet()){
            persona = new Persona(nombre,hmap.get(nombre));
            personasArray.add(persona);
        }
        return personasArray;
    }
}
