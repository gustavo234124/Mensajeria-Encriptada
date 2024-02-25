package encriptaciones;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345); // Puerto del servidor
            System.out.println("Servidor esperando conexiones...");

            while (true) {
                Socket socket = serverSocket.accept(); // Aceptar conexión de un cliente
                System.out.println("Cliente conectado desde: " + socket.getInetAddress().getHostAddress());

                // Establecer flujo de entrada y salida con el cliente
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                // Leer texto y tipo de encriptación desde el cliente
                String text = reader.readLine();
                String encryptionType = reader.readLine();

                // Realizar encriptación según el tipo seleccionado
                String encryptedText = "";
                if ("César".equals(encryptionType)) {
                    encryptedText = encryptCesar(text, 3); // Usar un desplazamiento de 3 para el cifrado César
                } else if ("AES".equals(encryptionType)) {
                    encryptedText = encryptAES(text, "claveAES"); // Usar una clave fija para AES (en una aplicación real, la clave debería ser segura y compartida entre el cliente y el servidor)
                } else if ("DES".equals(encryptionType)) {
                    encryptedText = encryptDES(text, "claveDES"); // Usar una clave fija para DES (en una aplicación real, la clave debería ser segura y compartida entre el cliente y el servidor)
                }

                // Enviar texto encriptado al cliente
                writer.println("Texto Encriptado: " + encryptedText);
                socket.close(); // Cerrar conexión con el cliente
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Funciones de encriptación

    private static String encryptCesar(String text, int shift) {
        // Implementación del cifrado César
        // ...
        return text;
    }

    private static String encryptAES(String text, String key) {
        // Implementación de la encriptación AES
        // ...
        return text;
    }

    private static String encryptDES(String text, String key) {
        // Implementación de la encriptación DES
        // ...
        return text;
    }
}
