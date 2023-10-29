# Huffman Coding Implementation

This Java program demonstrates the implementation of Huffman coding, a widely used algorithm for lossless data compression. Huffman coding is used to encode and decode text files efficiently by assigning shorter codes to more frequent characters.

## Overview

The program includes the following functionality:

1. **File to Huffman Tree:** 
   - The program reads a text file ("letter.txt") and analyzes its content to create a list of HuffmanNodes.
   - It calculates the frequency of each character in the file and constructs a HuffmanTree based on these frequencies.

2. **Encoding:**
   - The program encodes another text file ("source.txt") using the Huffman Tree created in the previous step.
   - It generates a new file ("encoded.txt") containing the encoded data.

3. **Decoding:**
   - The program decodes the encoded file ("encoded.txt") using the same Huffman Tree.
   - It produces a decoded output file ("decoded.txt") that should match the original content of "source.txt".

## How to Use

1. **Prerequisites:**
   - Ensure you have Java installed on your system.
   
2. **Compile and Run:**
   - Compile the Java code by running `javac Main.java` in your command line.
   - Run the program by executing `java Main`.

3. **Output:**
   - The program will display the Huffman Tree in the console, which provides a visual representation of the tree's structure.

4. **Generated Files:**
   - Three output files will be created in the "homework4-akbas/src" directory:
     - `encoded.txt`: The encoded version of the "source.txt" file.
     - `decoded.txt`: The decoded version of the "encoded.txt" file.
     - `encoded-huffman-codes.txt`: A text file that contains the Huffman codes used for encoding.

## Customization

- You can replace the input files ("letter.txt" and "source.txt") with your own text files for encoding and decoding.
- The program automatically calculates and assigns Huffman codes to each character based on their frequencies in the source file.

## Example

You can try the program with your own text files to see how Huffman coding works for data compression and decompression.

**Note:** Ensure that you have the necessary input files in the "homework4-akbas/src" directory, and the program will generate the output files there as well.

## Author

This Java program was created by [Your Name]. If you have any questions or feedback, feel free to contact me at [your@email.com].

Enjoy using Huffman coding for efficient data compression!
