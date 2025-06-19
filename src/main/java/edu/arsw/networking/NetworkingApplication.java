package edu.arsw.networking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;


@SpringBootApplication
public class NetworkingApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetworkingApplication.class, args);

        Scanner scanner = new Scanner (System.in);

        System.out.println("Select exersice:");
        System.out.println("1 : URL values");
        System.out.println("* : exit");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                URLReader urlReader = new URLReader();
                urlReader.printAll();
            case 2:
                new UrlToFileSaver();
            default:
                break;
        }
	}

}
