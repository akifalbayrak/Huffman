import java.sql.RowId;
import java.util.HashMap;
import java.util.Map;

public class HuffmanTree {
    public HuffmanNode root;

    // Constructor
    public HuffmanTree(HuffmanNode root) {
        this.root = root;
    }

    public void display() {
        display(root, 0);
    }

    private void display(HuffmanNode root, int level) {
        if (root == null)
            return;
        display(root.getRight(), level + 1);
        for (int i = 0; i < level; i++)
            System.out.print("\t");
        System.out.println(root.getSymbol() + " " + String.format("%.1f", root.getFrequency()));
        display(root.getLeft(), level + 1);
    }

    public void swapLargeSmall() {
        if (root == null) {
            System.out.println("tree is empty");
        }
        HuffmanNode largeVal = root;
        HuffmanNode minVal = root;
        while (largeVal.right != null) {
            largeVal = largeVal.right;
        }
        while (minVal.left != null) {
            minVal = minVal.left;
        }
        char temp = largeVal.symbol;
        largeVal.symbol = minVal.symbol;
        minVal.symbol = temp;
    }

    public LinkedList findLeaves() {
        return findLeaves(root, new LinkedList<>());

    }

    public LinkedList findLeaves(HuffmanNode root, LinkedList linkedList) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                linkedList.addFront(root);
            } else {
                findLeaves(root.left, linkedList);
                findLeaves(root.right, linkedList);
            }
        }

        return linkedList;
    }

    public String getCodeLetter(String letter, HuffmanNode current, String code) {

        if (current != null) {
            if (current.left == null && current.right == null && letter.equals(current.symbol)) {
                code = "";
            }
            if (letter.equals(code)) {
                return code;
            }
            getCodeLetter(letter, current.left, code + "0");
            getCodeLetter(letter, current.right, code + "1");

        }
        return code;
    }

    public String decode(String code) {
        String answer = "";
        HuffmanNode iterator = root;
        String[] arr = code.split("");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(0)) {
                iterator = iterator.left;
            } else {
                iterator = iterator.right;
            }
            if (iterator.left == null && iterator.right == null) {
                answer += iterator.symbol;
                iterator = root;
            }
        }
        return answer;
    }

    public Map<Character, String> exportCodesFromTree(Boolean willDisplay) {
        Map<Character, String> codes = new HashMap<>();
        exportCodesFromTree(root, "", codes);
        if (willDisplay) {
            System.out.println("Codes:");
            for (Map.Entry<Character, String> entry : codes.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
        return codes;
    }

    private void exportCodesFromTree(HuffmanNode root, String code, Map<Character, String> codes) {
        if (root == null)
            return;
        if (root.getLeft() == null && root.getRight() == null) {
            codes.put(root.getSymbol(), code);
            return;
        }

        exportCodesFromTree(root.getLeft(), code + "0", codes);
        exportCodesFromTree(root.getRight(), code + "1", codes);
    }

}
