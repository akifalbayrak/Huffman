public class HuffmanNode implements Comparable<HuffmanNode>{
    public char symbol;
    private double frequency;
    public HuffmanNode left, right;


    public HuffmanNode(char symbol, double frequency) {
        this.symbol = symbol;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }

    public HuffmanNode(double frequency, HuffmanNode left, HuffmanNode right) {
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(HuffmanNode l) {
        if (this.frequency > l.frequency) {
            return 1;
        } else if (this.frequency < l.frequency) {
            return -1;
        } else {
            return 0;
        }
    }

    public String toString() {
        return String.valueOf(this.symbol + " " + this.frequency);
    }

    public char getSymbol() {
        return this.symbol;
    }


    public double getFrequency() {
        return frequency;
    }

    public HuffmanNode getRight() {
      return this.right;
    }

    public HuffmanNode getLeft() {
      return this.left;
    }

}
