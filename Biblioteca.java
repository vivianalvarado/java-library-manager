import java.util.ArrayList;
import java.util.Scanner;

// Clase que define el objeto "Libro" (POO)
class Libro {
    String titulo;
    String autor;
    boolean disponible;

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true;
    }

    @Override
    public String toString() {
        String estado = disponible ? "✅ Disponible" : "❌ Prestado";
        return String.format("📘 %s | Autor: %s | %s", titulo, autor, estado);
    }
}

// Clase Principal
public class Biblioteca {
    // ArrayList para guardar libros en memoria RAM (Estructura de Datos)
    static ArrayList<Libro> inventario = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Datos de prueba iniciales
        inventario.add(new Libro("Cien Años de Soledad", "García Márquez"));
        inventario.add(new Libro("Clean Code", "Robert C. Martin"));
        inventario.add(new Libro("Inteligencia Artificial", "Stuart Russell"));

        while (true) {
            mostrarMenu();
            try {
                int opcion = Integer.parseInt(scanner.nextLine());
                if (opcion == 1) listarLibros();
                else if (opcion == 2) registrarLibro();
                else if (opcion == 3) {
                    System.out.println("👋 ¡Cerrando sistema!");
                    break;
                } else {
                    System.out.println("⚠️ Opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Error: Debes ingresar un número.");
            }
        }
    }

    static void mostrarMenu() {
        System.out.println("\n=== 🏛️ GESTOR DE BIBLIOTECA (JAVA SE) ===");
        System.out.println("1. Listar Libros");
        System.out.println("2. Registrar Nuevo Libro");
        System.out.println("3. Salir");
        System.out.print("👉 Seleccione una opción: ");
    }

    static void listarLibros() {
        System.out.println("\n--- 📚 Inventario Actual ---");
        if (inventario.isEmpty()) {
            System.out.println("(Vacío)");
        } else {
            // Uso de bucle for-each (Java Moderno)
            for (Libro libro : inventario) {
                System.out.println(libro);
            }
        }
    }

    static void registrarLibro() {
        System.out.println("\n--- ✍️ Nuevo Registro ---");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        inventario.add(new Libro(titulo, autor));
        System.out.println("✅ ¡Libro registrado exitosamente!");
    }
}