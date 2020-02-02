public class Body {
    final static double G = 6.67 * Math.pow(10,-11);
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public double[] allBodys;
   
    public Body(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    
    }
    
    public Body(Body b) {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    public double calcDistance(Body b) {
        double deltaX = xxPos - b.xxPos;
        double deltaY = yyPos - b.yyPos;
        double deltaR = Math.sqrt(Math.pow(deltaX,2)+ Math.pow(deltaY,2));
        return deltaR;
    }

    public double calcForceExertedBy(Body b) {
        double rSquared = Math.pow(calcDistance(b),2);
        double bodyForce = (G * (mass*b.mass))/rSquared;
        return bodyForce;
    }

    public double calcForceExertedByX(Body b) {
        double r = calcDistance(b);
        double totalForce = calcForceExertedBy(b);
        double xForce = totalForce *((b.xxPos - xxPos))/r;
        return xForce;
    }

    public double calcForceExertedByY(Body b) {
        double r = calcDistance(b);
        double totalForce = calcForceExertedBy(b);
        double yForce = totalForce *((b.yyPos - yyPos))/r;
        return yForce;
    }

    public double calcNetForceExertedByX(Body[] allBodys) {
        double netXForce=0;
        for (Body oneBody:allBodys) {
            if (this.equals(oneBody)) {
                continue;
            }
            netXForce += calcForceExertedByX(oneBody);
        }
        return netXForce;
    }
    public double calcNetForceExertedByY(Body[] allBodys) {
        double netYForce=0;
        for (Body oneBody:allBodys) {
            if (this.equals(oneBody)) {
                continue;
            }
            netYForce += calcForceExertedByY(oneBody);
        }
        return netYForce;
    }

    public void update(double time, double fX, double fY) {
        double ax = fX / this.mass;
        double ay = fY / this.mass;
        this.xxVel += ax * time;
        this.yyVel += ay * time;
        this.xxPos += this.xxVel * time;
        this.yyPos += this.yyVel * time;
    }
}

