public class NBody{
    

    public static double readRadius(String path){
        In in=new In(path);
        int firstItemInFile=in.readInt();
        double secondItemInFile=in.readDouble();
        return secondItemInFile;
    }

    public static Planet[] readPlanets(String path){
        In in=new In(path);
        int firstItemInFile=in.readInt();
        double secondItemInFile=in.readDouble();
        Planet[] p=new Planet[firstItemInFile];//建一个定长的planet数组，不过全是指针
        for(int i=0;i<firstItemInFile;i++){

            double xp=in.readDouble();
            double yp=in.readDouble();
            double xv=in.readDouble();
            double yv=in.readDouble();
            double m=in.readDouble();
            String img=in.readString();

            p[i]=new Planet(xp,yp,xv,yv,m,img);

        }
        return p;
    }
    private static void DrawBack(String path,double rRadius){
        String imageToDraw = path;
        /** Sets up the universe so it goes from 
          * -100, -100 up to 100, 100 */
        StdDraw.setScale((-1.0*rRadius), rRadius);

        /* Clears the drawing window. */
        StdDraw.clear();

        /* Stamps three copies of advice.png in a triangular pattern. */
        StdDraw.picture(0, 0, imageToDraw,2*rRadius,2*rRadius);

        /* Shows the drawing to the screen, and waits 2000 milliseconds. */
        //StdDraw.show();

    }
    public static void main(String[] args) {
        
        StdDraw.enableDoubleBuffering();

        double T=Double.parseDouble(args[0]);
        double dt=Double.parseDouble(args[1]);
        String filename=args[2];
        Planet[] planets=readPlanets(filename);
        double radius=readRadius(filename);
        //画背景
        String path="images/starfield.jpg";

        NBody.DrawBack(path,radius);
        //画全部星球
        for(int i=0;i<planets.length;i++){
            planets[i].draw();
        }
        StdDraw.show();
        Double start_time;//在时间内循环

        for(start_time=0.0;start_time<=T;start_time+=dt){
            double[] xForces=new double[planets.length];
            double[] yForces=new double[planets.length];
            for(int i=0;i<planets.length;i++){
                xForces[i]=planets[i].calcNetForceExertedByX(planets);
                yForces[i]=planets[i].calcNetForceExertedByY(planets);
            }

            for(int i=0;i<planets.length;i++){
                planets[i].update(dt,xForces[i],yForces[i]);
                
            }
            StdDraw.clear();//先清屏
                //画背景
            

            NBody.DrawBack(path,radius);
            //画全部星球
            for(int i=0;i<planets.length;i++){
                planets[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);

            
        }
        StdOut.printf("%d\n", planets.length);
            StdOut.printf("%.2e\n", radius);
            for (int i = 0; i < planets.length; i++) {
                  StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
            }

    }
    
}

/*
javac Planet.java TestPlanetConstructor.java 编译两个，且会链接

java TestPlanetConstructor 会运行TestPlanetConstructor.java的main()

java Planet报错因为没main()

*/