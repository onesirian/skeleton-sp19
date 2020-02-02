
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

    public static void main(String[] args) {
        
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radiusUniverse = NBody.readRadius(filename);
        Body[] Planets = NBody.readBodies(filename);

        

    }
}