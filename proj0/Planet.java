public class Planet {
    public double xxPos, yyPos;
    public double xxVel, yyVel;
    public double mass;
    public String imgFileName;
    static final double G = 6.67e-11;

    public Planet (double xP, double yP, double xV,
                   double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Planet (Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance (Planet rocinante) {
        double xDistance = Math.abs(rocinante.xxPos - xxPos);
        double yDistance = Math.abs(rocinante.yyPos - yyPos);
        return Math.sqrt(Math.pow(xDistance, 2)+Math.pow(yDistance, 2));
    }
    /*
    *   计算作用在这个Planet上的Force
    */
    public double calcForceExertedBy (Planet rocinante) {
        return G*mass*rocinante.mass/Math.pow(calcDistance(rocinante),2);
    }

    public double calcForceExertedByX (Planet rocinante) {
        double F = calcForceExertedBy(rocinante);
        double r = calcDistance(rocinante);

        return F*(rocinante.xxPos-xxPos)/r;
    }
    public double calcForceExertedByY (Planet rocinante) {
        double F = calcForceExertedBy(rocinante);
        double r = calcDistance(rocinante);

        return F*(rocinante.yyPos-yyPos)/r;
    }
    public double calcNetForceExertedByX (Planet[] allPlanets) {
        double xForce = 0;
        for (Planet temp: allPlanets) {
            if (!this.equals(temp))
                xForce += calcForceExertedByX(temp);
        }
        return xForce;
    }
    public double calcNetForceExertedByY (Planet[] allPlanets) {
        double yForce = 0;
        for (Planet temp: allPlanets) {
            if (!this.equals(temp))
                yForce += calcForceExertedByY(temp);
        }
        return yForce;
    }
    public void update (double dt, double fX, double fY) {
        xxVel = xxVel + dt * (fX/mass);
        yyVel = yyVel + dt * (fY/mass);
        xxPos = xxPos + dt * xxVel;
        yyPos = yyPos + dt * yyVel;
    }
}

