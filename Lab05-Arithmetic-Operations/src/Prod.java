import java.util.ArrayList;
import java.util.List;

public class Prod extends Node {
    List<Node> args = new ArrayList<>();

    Prod(){}

    Prod(Node n1){
        args.add(n1);
    }
    Prod(double c){
        args.add(new Constant(c));

        //wywołaj konstruktor jednoargumentowy przekazując new Constant(c)
    }

    Prod(Node n1, Node n2){
        args.add(n1);
        args.add(n2);
    }
    Prod(double c, Node n){
        args.add(new Constant(c));
        args.add(n);
        //wywołaj konstruktor dwuargumentowy
    }



    Prod mul(Node n){
        args.add(n);
        return this;
    }

    Prod mul(double c){
        args.add(new Constant(c));
        return this;
    }


    @Override
    double evaluate() {
        double result =1;
        // oblicz iloczyn czynników wołąjąc ich metodę evaluate
        for (Node n : args){
            result *= n.evaluate();
        }
        return sign*result;
    }
    int getArgumentsCount(){return args.size();}

    Node diff(Variable var){
        Sum r = new Sum();
        for(int i=0; i < args.size(); i++){
            Prod m = new Prod();
            for(int j = 0; j < args.size(); j++) {
                Node f = args.get(j);
                if (j == i) m.mul(f.diff(var));
                else m.mul(f);
            }
            if(!m.isZero()) {
                r.add(m);
            }
        }
        return r.simplify();
    }

    @Override
    boolean isZero() {
        for(Node n : args){
            if (n.isZero()){
                return true;
            }
        }
        return false;
        //return this.toString().contains("0");
    }

    @Override
    Node simplify() {
        Prod temp = new Prod();
        //List<Node> temps = new ArrayList<>();

         for (Node n : args) {
            //System.out.print("Prod:");
            //System.out.println(n);
            //System.out.println(n.getClass());
            Node r = n.simplify();
            if (r.getClass() == Constant.class && r.evaluate() == 0){
                return new Constant(0);
            }
            if (r.getClass() == Constant.class && r.evaluate() == 1){
                continue;
            }
            //System.out.print("r:");
            //System.out.println(r);
            //System.out.println(r.getClass());


            temp.mul(r);

            //System.out.println(temp.toString());
        }
         //Node result = temp.simplify();

        //temp2.mul(temp);
        if (temp.args.size() == 0){
            return new Constant(0);
        }
        else if (temp.args.size() > 1){
            return temp;
        }
        else{
            return temp.args.get(0);
        }
    }

    public String toString(){
        StringBuilder b =  new StringBuilder();
        if(sign<0)b.append("-");

        for(int i = 0; i < args.size(); i++){

            if(args.get(i).sign<0)b.append("(");
            b.append(args.get(i).toString());
            if(args.get(i).sign<0)b.append(")");
            if(i + 1 != args.size())b.append("*");

        }

        // ...
        //zaimplementuj
        return b.toString();
    }


}