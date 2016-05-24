/*
 * Ejercicio Tortugas Ninjas orientado a objetos
 */
package superninjas;

import java.util.ArrayList;
import utilidades.*;

/**
 *
 * @author mfontana
 */
public class SuperNinjas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Arraylist para guardar las tortugas
        ArrayList<Tortuga> tortugas = new ArrayList<>();
        // Creamos las 4 tortugas y las añadimos al ArrayList
        Tortuga t = new Tortuga("Leonardo");
        tortugas.add(t);
        t = new Tortuga("Michelangelo");
        tortugas.add(t);
        t = new Tortuga("Raphael");
        tortugas.add(t);
        t = new Tortuga("Donatello");
        tortugas.add(t);
        int opcion;
        int malos = 0, inocentes = 0;
        do {
            menu();
            opcion = EntradaDatos.pedirEntero("Escoge una opción:");
            switch (opcion) {
                case 1:
                    malos = registrarDato("Introduce el nº de malos");
                    System.out.println("Nº de malos registrado.");
                    break;
                case 2:
                    inocentes = registrarDato("Introduce el nº de inocentes");
                    System.out.println("Nº de inocentes registrado.");
                    break;
                case 3:
                    registrarRealizacion(tortugas);
                    break;
                case 4:
                    incidencia(malos, inocentes);
                    break;
                case 5:
                    equilibrio(malos, inocentes);
                    break;
                case 6:
                    mejorarRealizacion(tortugas);
                    break;
                case 7:
                    ranking(tortugas);
                    break;
                case 8:
                    System.out.println("Cowadunga!");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }

        } while (opcion != 8);
    }

    public static void ranking(ArrayList<Tortuga> tortugas) {
        // Método de la bubuja
        // variable que me indica si ha habido algún intercambio
        boolean intercambio;
        do {
            intercambio = false;
            // Voy comparando cada tortuga con la siguiente
            for (int i = 0; i < tortugas.size() - 1; i++) {
                if (tortugas.get(i).getRealizacion() < tortugas.get(i + 1).getRealizacion()) {
                    // Si están desordenados (de mayor a menor) los intercambio
//                    intercambio(tortugas.get(i), tortugas.get(i+1));
                    Tortuga aux = tortugas.get(i);
                    tortugas.set(i, tortugas.get(i + 1));
                    tortugas.set(i + 1, aux);
                    intercambio = true;
                }
            }

        } while (intercambio);
        // Una vez ordenado sacamos datos por pantalla
        System.out.println("Ranking de las tortugas");
        for (Tortuga t : tortugas) {
            System.out.println(t.getNombre()+ " - "+ t.getRealizacion());
        }
    }

    public static void intercambio(Tortuga uno, Tortuga dos) {
        // Guardo en una variable auxiliar los datos de la tortuga uno
        Tortuga aux = new Tortuga(uno.getNombre());
        aux.setRealizacion(uno.getRealizacion());
        aux.setRegistrado(uno.isRegistrado());
        // Pongo los datos de la tortuga dos en la tortuga uno
        uno.setNombre(dos.getNombre());
        uno.setRealizacion(dos.getRealizacion());
        uno.setRegistrado(dos.isRegistrado());
        // Pongo los datos de la tortuga uno en la tortuga dos (guardados en aux)
        dos.setNombre(aux.getNombre());
        dos.setRealizacion(aux.getRealizacion());
        dos.setRegistrado(aux.isRegistrado());
    }

    public static void mejorarRealizacion(ArrayList<Tortuga> tortugas) {
        String nombre = EntradaDatos.pedirCadena("Introduce el nombre de la tortuga:");
        boolean encontrado = false;
        // Buscamos la tortuga
        for (Tortuga t : tortugas) {
            if (t.getNombre().equalsIgnoreCase(nombre)) {
                encontrado = true;
                // Si se ha registrado podemos mejorar realización
                if (t.isRegistrado()) {
                    // Si la tortuga ya tiene el máximo no se puede mejorar
                    if (t.getRealizacion() == 10) {
                        System.out.println("Esta tortuga ya tiene la realización máxima.");
                    } else {
                        double mejora;
                        // Control de errores (mejora entre 0 y 10)
                        do {
                            mejora = EntradaDatos.pedirDouble("Introduce la mejora:");
                            if (mejora <= 0 || mejora > 10) {
                                System.out.println("La mejora tiene que ser >0 y <10");
                            }
                        } while (mejora <= 0 || mejora > 10);
                        double total = mejora + t.getRealizacion();
                        // Comprobamos si hemos pasado el máximo de realización
                        if (total > 10) {
                            // Si se pasa dejamos la realización al máximo (10)
                            t.setRealizacion(10);
                            System.out.println("Tu realización ha superado el máximo.");
                            System.out.println("La hemos dejado en un 10. No puede haber más.");
                        } else {
                            t.setRealizacion(total);
                            System.out.println("Mejora registrada.");
                            System.out.println("Tu realización ahora es: " + t.getRealizacion());
                        }
                    }
                } else {
                    System.out.println("Esta tortuga todavía no ha registrado una realización.");
                }
            }
        }
        // Si encontrado es false es que no hay ninguna tortuga con el nombre introducido x usuario
        if (!encontrado) {
            System.out.println("No existe ninguna tortuga con ese nombre.");
        }
    }

    public static void equilibrio(int m, int i) {
        if (m == i) {
            System.out.println("Equilibrio Neutro");
        } else if (m > i) {
            System.out.println("Equilibrio Negativo");
        } else {
            System.out.println("Equilibrio Positivo");
        }
    }

    public static void incidencia(int malos, int inocentes) {
        // Comprobamos que el denominador no sea cero
        if (inocentes == 0) {
            System.out.println("No se han salvado inocentes. El grado de incidencia no se puede calcular.");
        } else {
            double incidencia = (double) malos / inocentes;
            System.out.println("El grado de incidencia es: " + incidencia);
        }
    }

    public static void registrarRealizacion(ArrayList<Tortuga> tortugas) {
        // Pedimos el nombre de la tortuga
        String nombre = EntradaDatos.pedirCadena("Introduce el nombre de la tortuga:");
        // Variable para saber si el nombre de la tortuga existe
        boolean encontrado = false;
        // Recorro el array de Tortuga comprobando si existe tortuga con nombre
        for (Tortuga t : tortugas) { // for (int i = 0 ; i < tortugas.size(); i++)
            // Comparamos el nombre de la tortuga con el nombre introducido x usuario
            if (t.getNombre().equalsIgnoreCase(nombre)) {
                // Nombre válido de tortuga
                encontrado = true;
                // Comprobamos si ya se había registrado
                if (t.isRegistrado()) { // Igual que t.isRegistrado() == true
                    System.out.println("Ya habías registrado la realización.");
                } else {
                    double realizacion;
                    do {
                        realizacion = EntradaDatos.pedirDouble("Introduce la realización:");
                        if (realizacion < 0 || realizacion > 10) {
                            System.out.println("La realización debe estar entre 0 y 10.");
                        }
                    } while (realizacion < 0 || realizacion > 10);
                    // guardamos la realización el la tortuga
                    t.setRealizacion(realizacion);
                    // Y marcamos la tortuga como registrada
                    t.setRegistrado(true);
                    System.out.println("Realización registrada en " + t.getNombre());
                }
            }
        }
        if (!encontrado) {  // Esto es lo mismo que encontrado == false
            System.out.println("Nombre de tortuga incorrecto.");
        }
    }

    public static int registrarDato(String msg) {
        int dato;
        do {
            dato = EntradaDatos.pedirEntero(msg);
            if (dato < 0) {
                System.out.println("No puede ser un nº negativo!!");
            }
        } while (dato < 0);
        return dato;
    }

    public static void menu() {
        System.out.println("1. Registrar malos");
        System.out.println("2. Registrar inocentes");
        System.out.println("3. Registrar realización");
        System.out.println("4. Grado de incidencia");
        System.out.println("5. Equilibrio");
        System.out.println("6. Mejorar realización");
        System.out.println("7. Ranking de realización");
        System.out.println("8. Salir");
    }

}
