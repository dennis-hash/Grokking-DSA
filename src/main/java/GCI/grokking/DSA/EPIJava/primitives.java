package GCI.grokking.DSA.EPIJava;

public class primitives {
    public static short CountBits(int  x){
        short numBits = 0;
        while(x != 0){
            numBits += (x & 1);
            x >>>=1;
        }
        return numBits;
    }
    public static void main(String[] args){
        Short result = CountBits(5);
        System.out.println(result);

    }
}
