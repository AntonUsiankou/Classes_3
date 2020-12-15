package by.gsu.epamlab;

public class ToByn {
    public static String toByn(int kopecks) {
        int kops = kopecks % 100;
        return kopecks / 100 + "." + kops / 10 + kops % 10;
    }
}
