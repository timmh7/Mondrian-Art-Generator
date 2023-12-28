// This class generates art similar to the artist Piet Mondrian.
// The art generated creates random regions with varying colors.
// Preference for the canvas size is determined by the user, and
// the user can choose to generate a basic or complex version.
// Basic has random colors, whilst complex has location based colors.

import java.util.*;
import java.awt.*;

public class Mondrian {
    // Method 1: paintBasicMondrian 
    //  Generates a basic version of Mondrian art, with randomized colors. 
    // Parameters:
    //  Color[] pixels - colors of the art's pixels
    // Returns:
    // Exceptions: 
    public void paintBasicMondrian(Color[][] pixels) {
        paintBasicMondrian(pixels, 0, 0, pixels.length, pixels[0].length, new Random());
    }   
    
    // Method 2: paintBasicMondrian 
    //  Generates a basic version of Mondrian art, with randomized colors. 
    // Parameters:
    // Color[] pixels - colors of the art's pixels
    //  int lengthStart - the "width" pixel at which one region of the art starts being drawn
    //  int heightStart - the "height" pixel at which one region of the art starts being drawn
    //  int lengthEnd - the "width" pixel at which one region of the art ends
    //  int heightEnd - the "height" pixel at which one region of the art ends 
    //  Random rand - random used to generate random values 
    // Returns:
    // Exceptions: 
    private void paintBasicMondrian(Color[][] pixels, int lengthStart, 
                                    int heightStart, int lengthEnd, int heightEnd, Random rand) {
        int canvasLength = pixels.length;
        int canvasHeight = pixels[0].length; 
        
        int regionLength = lengthEnd - lengthStart;
        int regionHeight = heightEnd - heightStart;

        if (regionHeight >= canvasHeight/4 && regionLength >= canvasLength/4){ // RECURSIVE CASE 1
            // Region greater/equal to 1/4 height & 1/4 width of canvas, split 4 smaller regions
            int splitLength = rand.nextInt(regionLength) + lengthStart;
            int splitHeight = rand.nextInt(regionHeight) + heightStart;
            // Recursion splitting 4 regions:
            paintBasicMondrian(pixels, lengthStart, heightStart, splitLength, splitHeight, rand); 
            paintBasicMondrian(pixels, splitLength, heightStart, lengthEnd, splitHeight, rand); 
            paintBasicMondrian(pixels, lengthStart, splitHeight, splitLength, heightEnd, rand); 
            paintBasicMondrian(pixels, splitLength, splitHeight, lengthEnd, heightEnd, rand); 
        } else if (regionHeight >= canvasHeight/4) { // RECURSIVE CASE 2
            // Region greater/equal to 1/4 height of canvas, split 2 smaller regions horizontally 
            int splitHeight = rand.nextInt(regionHeight) + heightStart;
            // Recursion splitting 2 smaller regions, horizontally:
            paintBasicMondrian(pixels, lengthStart, heightStart, lengthEnd, splitHeight, rand); 
            paintBasicMondrian(pixels, lengthStart, splitHeight, lengthEnd, heightEnd, rand); 
        } else if (regionLength >= canvasLength/4) { // RECURSIVE CASE 3
            // Region greater/equal to 1/4 width of canvas, split 2 smaller regions vertically
            int splitLength = rand.nextInt(regionLength) + lengthStart;
            // Recursion splitting 2 smaller regions, vertically:
            paintBasicMondrian(pixels, lengthStart, heightStart, splitLength, heightEnd, rand); 
            paintBasicMondrian(pixels, splitLength, heightStart, lengthEnd, heightEnd, rand); 
        } else { // BASE CASE 
            // Region smaller than 1/4 width & 1/4 height of canvas, fill w/ random color 
            Color[] colorOptions = {Color.RED, Color.YELLOW, Color.CYAN, Color.WHITE};
            Color chosenColor = colorOptions[rand.nextInt(colorOptions.length)];

            // +1 and -1 to start/end values create 1-pixel black border
            for (int i = lengthStart + 1; i < lengthEnd - 1; i++) {
                for (int j = heightStart + 1; j < heightEnd - 1; j++) {
                    pixels[i][j] = chosenColor;
                }
            }
        }
    }      

    // Method 3: paintComplexMondrian
    //  Generates a "complex" version of Mondrian art, with location based colors.
    // Parameters:
    //  Color[] pixels - colors of the art's pixels
    // Returns:
    // Exceptions: 
    public void paintComplexMondrian(Color[][] pixels) {
        paintComplexMondrian(pixels, 0, 0, pixels.length, pixels[0].length, new Random());
    }

    // Method 4: paintComplexMondrian
    //  Generates a "complex" version of Mondrian art, with location based colors.
    // Parameters:
    //  Color[] pixels - colors of the art's pixels
    //  int lengthStart - the "width" pixel at which one region of the art starts being drawn
    //  int heightStart - the "height" pixel at which one region of the art starts being drawn
    //  int lengthEnd - the "width" pixel at which one region of the art ends
    //  int heightEnd - the "height" pixel at which one region of the art ends 
    //  Random rand - random used to generate random values 
    // Returns:
    // Exceptions: 
    private void paintComplexMondrian(Color[][] pixels, int lengthStart, 
                                      int heightStart, int lengthEnd, int heightEnd, Random rand) {
        int canvasLength = pixels.length;
        int canvasHeight = pixels[0].length; 
        
        int regionLength = lengthEnd - lengthStart;
        int regionHeight = heightEnd - heightStart;

        if (regionHeight >= canvasHeight/4 && regionLength >= canvasLength/4){ // RECURSIVE CASE 1
            // Region greater/equal to 1/4 height & 1/4 width of canvas, split 4 smaller regions
            int splitLength = rand.nextInt(regionLength) + lengthStart;
            int splitHeight = rand.nextInt(regionHeight) + heightStart;
            // Recursion splitting 4 regions:
            paintComplexMondrian(pixels, lengthStart, heightStart, splitLength, splitHeight, rand);
            paintComplexMondrian(pixels, splitLength, heightStart, lengthEnd, splitHeight, rand); 
            paintComplexMondrian(pixels, lengthStart, splitHeight, splitLength, heightEnd, rand); 
            paintComplexMondrian(pixels, splitLength, splitHeight, lengthEnd, heightEnd, rand); 
        } else if (regionHeight >= canvasHeight/4) { // RECURSIVE CASE 2
            // Region greater/equal to 1/4 height of canvas, split 2 smaller regions horizontally 
            int splitHeight = rand.nextInt(regionHeight) + heightStart;
            // Recursion splitting 2 smaller regions, horizontally:
            paintComplexMondrian(pixels, lengthStart, heightStart, lengthEnd, splitHeight, rand); 
            paintComplexMondrian(pixels, lengthStart, splitHeight, lengthEnd, heightEnd, rand); 
        } else if (regionLength >= canvasLength/4) { // RECURSIVE CASE 3
            // Region greater/equal to 1/4 width of canvas, split 2 smaller regions vertically
            int splitLength = rand.nextInt(regionLength) + lengthStart;
            // Recursion splitting 2 smaller regions, vertically:
            paintComplexMondrian(pixels, lengthStart, heightStart, splitLength, heightEnd, rand); 
            paintComplexMondrian(pixels, splitLength, heightStart, lengthEnd, heightEnd, rand); 
        } else { // BASE CASE 
            // Region smaller than 1/4 width & 1/4 height of canvas, fill w/ locaiton's color 
            Color chosenColor = locationBasedColor(lengthStart, heightStart,
                                                   canvasLength, canvasHeight, rand);
            // +1 and -1 to start/end values create 1-pixel black border
            for (int i = lengthStart + 1; i < lengthEnd - 1; i++) {
                for (int j = heightStart + 1; j < heightEnd - 1; j++) {
                    pixels[i][j] = chosenColor;
                }
            }
        }
    }

    // Method 5: locationBasedColor
    //  Assigns a given color, based on where a region starts, in relation to the art canvas. 
    // Parameters:
    //  int lengthStart - the "width" pixel at which one region of the art starts being drawn
    //  int heightStart - the "height" pixel at which one region of the art starts being drawn
    //  int canvasLength - the width of the overall canvas
    //  int canvasHeight - the height of the overall canvas
    //  Random rand - random used to generate random values 
    // Returns:
    //  Returns a color, depending on which quadrant of the art a region starts.
    //  Top-left quadrant color likely to be orange, top-right quadrant color likely to be green.
    //  Bottom-left quadrant color likely blue, bottom-right quadrant color likely red. 
    // Exceptions: 
    private Color locationBasedColor(int lengthStart, int heightStart, 
                                    int canvasLength, int canvasHeight, Random rand) {
        // Calculates center of the canvas
        int centerLength = canvasLength / 2;
        int centerHeight = canvasHeight / 2;

        // Assigns color based on where region starts
        if (lengthStart < centerLength && heightStart < centerHeight) {
            // Top-left region becomes random color, likely to be orange
            return new Color(200 + rand.nextInt(55), 155 + rand.nextInt(100), rand.nextInt(100));
        } else if (lengthStart >= centerLength && heightStart < centerHeight) {
            // Bottom-left region becomes random color, likely to be blue
            return new Color(rand.nextInt(115), rand.nextInt(115), 155 + rand.nextInt(100));
        } else if (lengthStart < centerLength && heightStart >= centerHeight) {
            // Top-right region becomes random color, likely to be green
            return new Color(rand.nextInt(150), 155 + rand.nextInt(100), rand.nextInt(150));
        } else {
            // Bottom-right region becomes random color, likely to be red
            return new Color(155 + rand.nextInt(100), rand.nextInt(115), rand.nextInt(115));
        }
    }
}