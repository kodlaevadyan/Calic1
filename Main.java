import java.util.Scanner;

public class Main {
    private static String[]Roman={"I","II","III","IV","V","VI","VII","VIII","IX","X"};
    private static String[]Roman10={"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC","C"};
    public static void main(String[] args)throws Exception{
        Scanner sc=new Scanner(System.in);
        System.out.println(calc(sc.nextLine()));
    }

    private static int getRoman(String input){
        for (int i = 0; i < Roman.length; i++) {
            if(Roman[i].equals(input))
                return i+1;
        }
        return-1;
    }
    private static String getRoman(int input)throws Exception {
        if (input<=0){
            throw new Exception();
        }
        String ret=Roman10[input/10];
        if(input%10!=0){
            ret=ret+Roman[input%10-1];
        }
        return ret;
    }
    public static String calc(String input) throws Exception{
        String[]s=input.trim().split(" ");
        if (s.length!=3){
            throw new Exception();
        }
        if(s[1].length()!=1){
            throw new Exception();
        }
        boolean Arabian=false;
        int num1=getRoman(s[0]);
        if(num1<0){
            Arabian=true;
            num1=Integer.parseInt(s[0]);
        }

        int num2= Arabian?Integer.parseInt(s[2]):getRoman(s[2]);
        if (num2<=0&&!Arabian){
            throw new Exception();
        }
        if(num1<1||num1>10||num2<1||num2>10){
            throw new Exception();
        }
        int result=-1;
        switch(s[1].charAt(0)){
            case '+':
                result=num1+num2;
                break;
            case '-':
                result=num1-num2;
                break;
            case '*':
                result=num1*num2;
                break;
            case '/':
                result=num1/num2;
                break;
            default:throw new Exception();
        }
        if(Arabian)return Integer.toString(result);
        else return getRoman(result);

    }
}