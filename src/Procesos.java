import javax.swing.JOptionPane;

public class Procesos {

    static String[] nombres;
    static double[] pesos;
    static double[] alturas;
    static double[] imcs;
    static int[] telefonos;

    public static void iniciar() {
        System.out.println("¡Hola!");
        obtenerDatos();
        calcularIMC();
        imprimirDatos();
    }

    public static void obtenerDatos() {
        int cantidadUsuarios = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese una cantidad de usuarios: "));
        nombres = new String[cantidadUsuarios];
        pesos = new double[cantidadUsuarios];
        alturas = new double[cantidadUsuarios];
        telefonos = new int[cantidadUsuarios];

        for (int i = 0; i < cantidadUsuarios; i++) {
            nombres[i] = JOptionPane.showInputDialog(null, "Ingresar nombre del usuario " + (i + 1) + ": ");
            pesos[i] = Double.parseDouble(JOptionPane.showInputDialog(null, nombres[i] + " ingrese un peso en kg: "));
            alturas[i] = Double.parseDouble(JOptionPane.showInputDialog(null, nombres[i] + " ingrese un altura en metros: "));
            telefonos[i] = Integer.parseInt(JOptionPane.showInputDialog(null, nombres[i] + " ingrese un número de teléfono: "));
        }
    }

    public static void calcularIMC() {
        imcs = new double[pesos.length];
        for (int i = 0; i < pesos.length; i++) {
            double imc = pesos[i] / (alturas[i] * alturas[i]);
            imcs[i] = imc;
        }
    }

    public static void imprimirDatos() {
        for (int i = 0; i < imcs.length; i++) {
            double imc = imcs[i];
            String estado = "";
            if (imc < 18.0) {
                estado = "Anorexia";
            } else if (imc >= 18.0 && imc < 20.0) {
                estado = "Delgadez";
            } else if (imc >= 20.0 && imc < 27.0) {
                estado = "Normalidad";
            } else if (imc >= 27.0 && imc < 30.0) {
                estado = "Obesidad (grado 1)";
            } else if (imc >= 30.0 && imc < 35.0) {
                estado = "Obesidad (grado 2)";
            } else if (imc >= 35.0 && imc < 40.0) {
                estado = "Obesidad (grado 3)";
            } else if (imc >= 40.0) {
                estado = "Obesidad mórbida";
            }
            System.out.println("\nUsuario: " + (i + 1) + "\nNombre: " + nombres[i] + "\nTeléfono: " + telefonos[i] + "\nEstado: " + estado);
        }
    }
}
