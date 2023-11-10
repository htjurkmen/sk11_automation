package lecture04;

public class Examples {

    public static void main(String[] args) {
        breakExample();

    }

    private static void arithmeticOperators() {
        int num1 = 100;
        int num2 = 20;

        System.out.println("num1 + num2: " + (num1 + num2)); //120
        System.out.println("num1 - num2: " + (num1 - num2) ); //80
        System.out.println("num1 * num2: " + (num1 * num2)); //2000
        System.out.println("num1 / num2: " + (num1 / num2)); //5
        System.out.println("num1 % num2: " + (num1 % num2)); //0

    }

    private static void assignmentOperators() {
        int num1 = 10;
        int num2 = 20;

        num2 = num1;
        System.out.println("= Output: "+num2); //10
        num2 += num1;
        System.out.println("+= Output: "+num2); //30
        num2 -= num1;
        System.out.println("-= Output: "+num2); //10
        num2 *= num1;
        System.out.println("*= Output: "+num2); //200
        num2 /= num1;
        System.out.println("/= Output: "+num2); //2
        num2 %= num1;
        System.out.println("%= Output: "+num2); //0

    }

    private static void autoIncrementDecrement(){
        int num1=100;
        int num2=200;

        num1++;
        num2--;
        System.out.println("num1++ is: "+num1);
        System.out.println("num2-- is: "+num2);
        System.out.println(num1 + num2++);
        System.out.println(num1 + (++num2));

    }

    private static void logicalOperators(){

        boolean a1 = true;
        boolean b2 = false;
        int c = 10;
        int d = 20;

        System.out.println("b1 && b2: " + (a1&&b2)); //False
        System.out.println("b1 || b2: " + (a1||b2)); //True
        System.out.println("!(b1 && b2): " + !(a1&&b2)); //True
        System.out.println((10>2) && (8>4)); //True
        System.out.println((6<2) || (4>2)); //True
        System.out.println(!(c<d)); //False

    }
    private static void comparisonOperators(){

        System.out.println(2+1 == 2+2); //False
        System.out.println(3+1 == 2+2); //True
        System.out.println(8 > 5); //True
        System.out.println(5 >= 5); //True

    }

    private static void ternaryOperator() {
        int num1, num2;
        num1 = 25;

        num2 = (num1 == 10) ? 100: 200;
        System.out.println( "num2: "+num2); //200

        num2 = (num1 == 25) ? 100: 200;
        System.out.println( "num2: "+num2); //100
    }

    private static void ifStatement() {

        int num=70;

        if( num < 100 ) {
            System.out.println("number is less than 100");
        }
    }

    private static void nestedIfStatement() {
        int num=70;

        if( num < 100 ) {
            System.out.println("number is less than 100");
            if (num > 50) {
                System.out.println("number is greater than 50");
            }
        }
    }

    private static void ifElseExample(){
        int num=120;

        if( num < 50 ){
            System.out.println("num is less than 50");
        }
        else {
            System.out.println("num is greater than or equal 50");
        }
    }

    private static void ifElseIfExample() {

        int num=1234;

        if(num <100 && num>=1) {
            System.out.println("Its a two digit number");
        }
        else if(num <1000 && num>=100) {
            System.out.println("Its a three digit number");
        }
        else if(num <10000 && num>=1000) {
            System.out.println("Its a four digit number");
        }
        else {
            System.out.println("number is not between 1 & 99999");
        }
    }

    private static void switchCase(){
        int i=2;

        switch(i)
        {
            case 1:
                System.out.println("Case1 ");
                break;
            case 2:
                System.out.println("Case2 ");
                break;
            case 3:
                System.out.println("Case3 ");
                break;
            default:
                System.out.println("Default ");
        }


    }

    private static void exampleLoop(){

        for(int i=10; i >=1; i--) {
            System.out.println("The value of i is: "+i);
        }
    }

    private static void forLoopExample(){
        int arr[]={2,11,45,9};

        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }

    }

    private static void whileExample() {

        int i=10;

        while(i>1){
            System.out.println(i);
            i--;
        }

    }

    private static void whileArrayExample(){
        int arr[]={2,11,45,9};
        int i=0;

        while(i<4){
            System.out.println(arr[i]);
            i++;
        }
    }

    private static void dowWhileExample(){
        int i=10;

        do {
            System.out.println(i);
            i--;
        }while(i>1);
    }

    private static void doWhileArrayExample(){
        int arr[]={2,11,45,9}; //i starts with 0 as array index starts with 0
        int i=0;

        do {
            System.out.println(arr[i]);
            i++;
        } while(i<4);
    }

    private static void continueExample(){
        for (int j=0; j<=6; j++)
        {
            if (j==4)
            {
                continue;
            }
            System.out.print(j+" ");
        }
    }

    private static void breakExample(){

        int var;
        for (var =100; var>=10; var --)
        {
            System.out.println("For Loop 1 var: "+var);
            for (int i =100; i>=10; i --){
                System.out.println("For Loop 2 var: "+i);
                if (i==99)
                {
                    break;
                }
            }
            if (var==99)
            {
                break;
            }
        }
        System.out.println("Out of for-loop");

    }

}
