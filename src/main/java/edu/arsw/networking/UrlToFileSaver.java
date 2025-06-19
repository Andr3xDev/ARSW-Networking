package edu.arsw.networking;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class UrlToFileSaver{

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Por favor, ingrese una dirección URL completa:");
            String urlString = scanner.nextLine();
            
            fetchAndSaveUrl(urlString, "resultado.html");
        }
    }

    public static void fetchAndSaveUrl(String urlString, String filePath) {
        try {
            URL siteUrl = new URL(urlString);
            
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(siteUrl.openStream()));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

                System.out.println("Leyendo datos de " + siteUrl + "...");
                String inputLine;
                while ((inputLine = reader.readLine()) != null) {
                    writer.write(inputLine);
                    writer.newLine();
                }
                System.out.println("Guardado exitosamente en '" + filePath + "'");

            } catch (IOException e) {
                System.err.println("Error de I/O: " + e.getMessage());
            }
        } catch (MalformedURLException e) {
            System.err.println("URL inválida: " + e.getMessage());
        }
    }
}
