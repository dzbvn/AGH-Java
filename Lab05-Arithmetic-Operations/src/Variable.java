public class Variable extends Node {
    String name;
    Double value;
    Variable(String name){
        this.name = name;
    }
    void setValue(double d){
        value = d;
    }


    @Override
    double evaluate() {
        if(value != null) {
            return sign * value;
        }
        else{
            return 0.0;
        }
    }

    @Override
    Node diff(Variable var){
        if(var.name.equals(name))return new Constant(sign);
        else return new Constant(0);
    }

    @Override
    boolean isZero() {
        if(value != null && this.value == 0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    Node simplify() {

        return this;
    }

    @Override
    public String toString() {
        String sgn=sign<0?"-":"";
        return sgn+name;
    }

}
