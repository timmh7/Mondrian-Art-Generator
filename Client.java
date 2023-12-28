// Run this client class to generate random art w/ a 
// style similar to the famous artist Piet Mondrian!

// The art generated creates random regions with varying colors.
// Preference for the canvas size is determined by the user, and
// the user can choose to generate a basic or "complex" version.
// The basic version will automatically incorporate random colors.
// The complex version will generate location based colors.

import java.awt.*;
import java.util.*;

public class Client {
    // Method 1: main
    //  Run to prompt creation of Modrian art!
    public static void main(String[] args) throws Exception {
        Scanner console = new Scanner(System.in);
        System.out.println("Welcome to the CSE 123 Mondrian Art Generator!");

        int choice = 0;
        while (choice != 1 && choice != 2) {
            System.out.print("Enter 1 for a basic Mondrian or 2 for a complex Mondrian: ");
            choice = console.nextInt();
        }
        System.out.print("Enter image width (>= 300px): ");
        int width = console.nextInt();
        System.out.print("Enter image height (>= 300px): ");
        int height = console.nextInt();

        Mondrian mond = new Mondrian();
        Picture pic = new Picture(width, height);
        Color[][] pixels = pic.getPixels();

        if (choice == 1) {
            mond.paintBasicMondrian(pixels);
        } else {    // choice == 2
            mond.paintComplexMondrian(pixels);
        }
        
        pic.setPixels(pixels);
        pic.save(choice == 1 ? "basic.png" : "complex.png");
        pic.show();
        System.out.println("Enjoy your artwork!");
    }
}

