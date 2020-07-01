public class Planet{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static final double g=6.67e-11; //用static final定义常量
    //如果parameter list的名字与类的变量名一致要加this.去区分
    public Planet(double xP,double yP,double xV,double yV,double m,String img){
        xxPos=xP;
        yyPos=yP;
        xxVel=xV;
        yyVel=yV;
        mass=m;
        imgFileName=img;
    }

    //建立一份类的copy，不能直接返回一个指针指向同一个，而要建另外一份有另一套变量
    public Planet(Planet p){
        xxPos=p.xxPos;
        yyPos=p.yyPos;
        xxVel=p.xxVel;
        yyVel=p.yyVel;
        mass=p.mass;
        imgFileName=p.imgFileName;
    }

    public double calcDx(Planet p){
        double distance=p.xxPos-this.xxPos;
        
        return distance;
        
    }

    public double calcDy(Planet p){
        double distance=p.yyPos-this.yyPos;
        return distance;
        
    }
    public double calcDistance(Planet p){
        double distance;
        double dx=this.calcDx(p);
        double dy=this.calcDy(p);
        distance=dx*dx+dy*dy;

        return Math.sqrt(distance);

    }

    public double calcForceExertedBy(Planet p){
        double force=(g*this.mass*p.mass)/(this.calcDistance(p)*this.calcDistance(p));
        return force;
    }

    public double calcForceExertedByX(Planet p){
        double force=calcForceExertedBy(p);
        double dx=calcDx(p);
        double distance=calcDistance(p);
        double fx=force*dx/distance;
        return fx;
    }
    public double calcForceExertedByY(Planet p){
        double force=calcForceExertedBy(p);
        double dy=calcDy(p);
        double distance=calcDistance(p);
        double fy=force*dy/distance;
        return fy;
    }
    //true,false要小写，指针指向同个对象是可以比较的
    public boolean equals(Planet p){
        if(this==p){
            return true;
        }
        else{
            return false;
        }
    }
    public double calcNetForceExertedByX(Planet[] p){
        double net=0.0;
        for(int i=0;i<p.length;i++){
            if(this.equals(p[i])==true){
                continue;
            }
            double fx=calcForceExertedByX(p[i]);
            net+=fx;
        }
        return net;
    }
    

    public double calcNetForceExertedByY(Planet[] p){
        double net=0.0;
        for(int i=0;i<p.length;i++){
            if(this.equals(p[i])==true){
                continue;
            }
            double fy=calcForceExertedByY(p[i]);
            net+=fy;
        }
        return net;
    }
    public void update(double t,double fx,double fy){
        double ax=fx/this.mass;
        double ay=fy/this.mass;
        this.xxVel=this.xxVel+t*ax;
        this.yyVel=this.yyVel+t*ay;
        this.xxPos=this.xxPos+t*this.xxVel;
        this.yyPos=this.yyPos+t*this.yyVel;
           
    }
    public void draw(){
        String imageToDraw="images/"+this.imgFileName;
        StdDraw.picture(this.xxPos,this.yyPos, imageToDraw);

        /* Shows the drawing to the screen, and waits 2000 milliseconds. */
        //StdDraw.show();
    }

    
}

/*
javac Planet.java TestPlanetConstructor.java 编译两个，且会链接

java TestPlanetConstructor 会运行TestPlanetConstructor.java的main()

java Planet报错因为没main()

*/