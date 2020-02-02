
public class NBody {

    public static double readRadius(final String filename) {

        final In in = new In(filename);
        in.readInt();
        final double radius = in.readDouble();

        return radius;
    }

}