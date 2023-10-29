import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // Basically what fileToList does is it reads the file and creates a list of
        // HuffmanNodes
        // with the frequency of each character in the file.
        // Then it creates a HuffmanTree from the list.
        // And returns the tree.

        // ####### TREE DISPLAYS ITSELF IN THE CONSOLE #######
        HuffmanTree tree = fileToList();
        // ####### TREE DISPLAYS ITSELF IN THE CONSOLE #######
            
        // Encode the source file and write it to the encoded file.
        encode(tree);
        // Decode the encoded file and write it to the decoded file.
        decode(tree);
        LinkedList linkedList = new LinkedList<>();
        linkedList.selectionSort();
        HuffmanNode huffmanNode = new HuffmanNode("3".charAt(0), 0.5);
        HuffmanNode huffmanNode1 = new HuffmanNode("1".charAt(0), 0.2);
        HuffmanNode huffmanNode2 = new HuffmanNode("2".charAt(0), 0.7);

        linkedList.addFront(huffmanNode);
        linkedList.addFront(huffmanNode1);
        linkedList.addFront(huffmanNode2);
        System.out.println(tree.decode("01"));
    }

    public static HuffmanTree fileToList() throws FileNotFoundException {
        File file = new File("homework4-akbas/src/letter.txt");
        Scanner scanner = new Scanner(file);
        LinkedList<HuffmanNode> list = new LinkedList<HuffmanNode>();

        int[] count = new int[256];
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                count[c]++;
            }
        }
        double total = 0;
        for (int i = 0; i < count.length; i++) {
            total += count[i];
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                list.addToEnd(
                        new HuffmanNode((char) i, Math.round((((double) count[i] / total) * 100) * 100.0) / 100.0));
            }
        }
        scanner.close();

        HuffmanTree tree = list.createHuffmanTree();
        tree.exportCodesFromTree(true);
        tree.display();
        return tree;
    }

    public static void encode(HuffmanTree tree) throws IOException {
        File sourceFile = new File("homework4-akbas/src/source.txt");
        FileWriter myWriter = new FileWriter("homework4-akbas/src/encoded.txt");

        Scanner scanner = new Scanner(sourceFile);
        Map<Character, String> codesOfChars = tree.exportCodesFromTree(false);

        while (scanner.hasNextLine()) {
            String encoded = "";
            String line = scanner.nextLine();
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                encoded += codesOfChars.get(c);
            }

            myWriter.write(encoded);
            myWriter.write("\r\n");
        }

        myWriter.close();
        scanner.close();
    }

    public static void decode(HuffmanTree tree) throws IOException {
        File encodedFile = new File("homework4-akbas/src/encoded.txt");
        FileWriter myWriter = new FileWriter("homework4-akbas/src/decoded.txt");

        Scanner scanner = new Scanner(encodedFile);
        Map<String, Character> charsOfCodes = new HashMap<>();
        for (Map.Entry<Character, String> entry : tree.exportCodesFromTree(false).entrySet()) {
            charsOfCodes.put(entry.getValue(), entry.getKey());
        }

        while (scanner.hasNextLine()) {
            String decoded = "";
            String line = scanner.nextLine();
            String code = "";
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                code += c;
                if (charsOfCodes.containsKey(code)) {
                    decoded += charsOfCodes.get(code);
                    code = "";
                }
            }

            myWriter.write(decoded);
            myWriter.write("\r\n");
        }

        myWriter.close();
        scanner.close();

    }

}
