package encriptaciones;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345); // Conectar al servidor en localhost y puerto 12345

            // Establecer flujo de entrada y salida con el servidor
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Leer texto y tipo de encriptación desde el usuario
            System.out.print("Ingrese el texto a encriptar: ");
            String text = reader.readLine();
            System.out.print("Seleccione el tipo de encriptación (César/AES/DES): ");
            String encryptionType = reader.readLine();

            // Enviar texto y tipo de encriptación al servidor
            writer.println(text);
            writer.println(encryptionType);

            // Recibir y mostrar el texto encriptado desde el servidor
            String encryptedText = serverReader.readLine();
            System.out.println("Texto encriptado recibido del servidor: " + encryptedText);

            socket.close(); // Cerrar conexión con el servidor
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
