
public class NBody {

    public static double readRadius(final String filename) {

        final In in = new In(filename);
        in.readInt();
        final double radius = in.readDouble();

        return radius;
    }

    public static Body[] readBodies(String filename) {
        In in = new In(filename);
        int planetCount = in.readInt();
        in.readDouble();
        Body[] Planets = new Body[planetCount];
        int i = 0;
        while (i < planetCount) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            Planets[i++] = new Body(xP, yP, xV, yV, m, img);
        }
        return Planets;
    }

    
}