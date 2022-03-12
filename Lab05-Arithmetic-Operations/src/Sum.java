import java.util.ArrayList;
import java.util.List;

public class Sum extends Node {

    List<Node> args = new ArrayList<>();

    Sum(){}

    Sum(Node n1, Node n2){
        args.add(n1);
        args.add(n2);
    }


    Sum add(Node n){
        args.add(n);
        return this;
    }

    Sum add(double c){
        args.add(new Constant(c));
        return this;
    }

    Sum add(double c, Node n) {
        Node mul = new Prod(c,n);
        args.add(mul);
        return this;
    }

    @Override
    double evaluate() {
        double result =0;
        for (Node n : args){
            result += n.evaluate();
        }
        //oblicz sumę wartości zwróconych przez wywołanie evaluate skłądników sumy
        return sign*result;
    }

    int getArgumentsCount(){return args.size();}

    @Override
    Node diff(Variable var) {
        Sum r = new Sum();
        for(Node n : args){
            if(!n.diff(var).isZero()) {
                r.add(n.diff(var));
            }
            if(n instanceof Sum){
                for(Node m : ((Sum) n).args){

                }
            }
            //System.out.println(n.diff(var));
            //System.out.println(n.diff(var).getClass());
            //System.out.println(n.diff(var).isZero());
            //System.out.println(n.diff(var).evaluate());
        }
        return r.simplify();
    }

    @Override
    boolean isZero() {
        return args.isEmpty();
    }

    @Override
    public Node simplify() {
        Sum temp = new Sum();
        for (Node n : args) {
            //System.out.println("---");
            //System.out.println(n);

            //System.out.println(n.getClass());
            Node r = n.simplify();
            //System.out.println(r);
            if (r.getClass() == Constant.class && r.evaluate() == 0){
                return new Constant(0);
            }
            else if (r.getClass() == Constant.class && r.evaluate() == 1){
                continue;
            }
            temp.add(r);
        }
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
        if(sign<0)b.append("-(");

        for(int i = 0; i < args.size(); i++){
            if(i != 0) {
                if (args.get(i).sign < 0) b.append(" + (");
                else {
                    b.append(" + ");
                }
            }

            b.append(args.get(i).toString());


            if(args.get(i).sign < 0)b.append(") ");

        }

        //zaimplementuj

        if(sign<0)b.append(")");
        return b.toString();
    }



}
