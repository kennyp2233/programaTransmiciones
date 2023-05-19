import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class Prueba {
    private static Map<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        // Agregar usuarios y contraseñas válidos al mapa de usuarios
        users.put("usuario1", hashPassword("pass1"));
        users.put("usuario2", hashPassword("contraseña2"));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Usuario: ");
        String username = scanner.nextLine();
        System.out.print("Contraseña: ");
        String password = scanner.nextLine();

        if (authenticate(username, password)) {
            String hwid = getHWID();
            System.out.println("Inicio de sesión exitoso.");
            System.out.println("HWID: " + hwid);
            // Aquí puedes continuar con la lógica de tu programa después de autenticar correctamente al usuario.
        } else {
            System.out.println("Inicio de sesión fallido. Usuario o contraseña incorrectos.");
        }

        scanner.close();
    }

    private static boolean authenticate(String username, String password) {
        if (users.containsKey(username)) {
            String hashedPassword = users.get(username);
            String inputHashedPassword = hashPassword(password);
            return hashedPassword.equals(inputHashedPassword);
        }
        return false;
    }

    private static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getHWID() {
        String hwid = System.getProperty("os.version") +
                      System.getProperty("os.name") +
                      System.getProperty("os.arch") +
                      System.getProperty("user.name");
        return hashPassword(hwid);
    }
}