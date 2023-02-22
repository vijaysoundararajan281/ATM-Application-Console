package ATM;
import java.text.SimpleDateFormat;
import java.util.*;
public class atm {
    public static Scanner sc = new Scanner(System.in);
    public static int[][] amount = new int[2][4];
    public static int balance=0;
    public static String[] state= new String[3];
    public static int[][] arr = { { 11,110,1000 }, {12, 120,20000 },{13,130,10000} };
    public static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy.HH:mm:ss");
    public static void admin(){
        int admin_password=1234;
        System.out.println("Enter admin password : ");
        int e=sc.nextInt();
        if(e==admin_password){
            System.out.println("Select any one : ");
            System.out.println("To Load Amount : 1");
            System.out.println("Check Balance : 2");
            System.out.println("Exit : 3");
            int n1=sc.nextInt();
            if(n1==1){
                System.out.println("Enter the amount :");
                int a=sc.nextInt();
                System.out.println("Enter the denomination value : ");
                System.out.print("2000 :");
                int a1=sc.nextInt();
                if(a1+amount[1][0]<=100){
                    System.out.println("Valid");
                    amount[1][0]+=a1;
                    balance += 2000*a1;
                }
                else{
                    System.out.println("System only accepts "+ (100-amount[1][0])+" notes");
                    admin();
                }
                System.out.println("500 :");
                int a2=sc.nextInt();
                if(a2+amount[1][1]<=100){
                    System.out.println("Valid");
                    amount[1][1]+=a2;
                    balance+=500*a2;
                }
                else{
                    if(a1 !=0 ){
                        amount[1][0]-=a1;
                        balance -= 2000*a1;
                    }
                    System.out.println("System only accepts "+ (100-amount[1][1])+" notes");
                    admin();
                }
                System.out.println("200 :");
                int a3=sc.nextInt();
                if(a3+amount[1][2]<=100){
                    System.out.println("Valid");
                    amount[1][2]+=a3;
                    balance+=200*a3;
                }
                else{
                    if(a1 !=0 ){
                        amount[1][0]-=a1;
                        balance -= 2000*a1;
                    }
                    if(a2 !=0 ){
                        amount[1][1]-=a2;
                        balance -= 500*a2;
                    }
                    System.out.println("System only accepts "+ (100-amount[1][2])+" notes");
                    admin();
                }
                System.out.println("100 :");
                int a4=sc.nextInt();
                if(a4+amount[1][3]<=100){
                    System.out.println("Valid");
                    amount[1][3]+=a4;
                    balance+=100*a4;
                }
                else{
                    if(a1 !=0 ){
                        amount[1][0]-=a1;
                        balance -= 2000*a1;
                    }
                    if(a2 !=0 ){
                        amount[1][1]-=a2;
                        balance -= 500*a2;
                    }
                    if(a3!=0){
                        amount[1][2]-=a3;
                        balance -= 200*a3;
                    }
                    System.out.println("System only accepts "+ (100-amount[1][3])+" notes");
                    admin();
                }
                System.out.println("Amount Loaded Successfully");
                System.out.println("Select any one : ");
                System.out.println("To go to admin : 1");
                System.out.println("To go to main menu : 2");
                int n3 = sc.nextInt();
                if(n3==1){
                    admin();
                }
                else if(n3==2){
                    system();
                }
                
            }
            else if(n1==2){
                System.out.println("The available blance is : "+balance);
                System.out.println("Select any one : ");
                System.out.println("To go to admin : 1");
                System.out.println("To go to main menu : 2");
                int n3 = sc.nextInt();
                if(n3==1){
                    admin();
                }
                else if(n3==2){
                    system();
                }
            }
            else if(n1==3){
                system();
            }
            else{
                System.out.println("Select either 1 or 2 or 3");
            }
        }
        else{
            System.out.println("Wrong password");
            admin();
        }
    }
    public static void user(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your user id: ");
        int id=sc.nextInt();
        int y=0;
        for(int i=0;i<3;i++){
            if(id == arr[i][0]){
                y=1;
                System.out.println("Enter pin : ");
                int pin=sc.nextInt();
                if(pin==arr[i][1]){
                    user1(i);
                }
            }
        }
        if(y==0){
            System.out.println("Enter valid id");
            system();
        }
        
    }
    public static void user1(int i){
        System.out.println("Select any one : ");
        System.out.println("\tBalance check : 1");
        System.out.println("\tCash Withdrawel : 2");
        System.out.println("\tStatement : 3");
        System.out.println("\tDeposit amount : 4");
        System.out.println("\tTransfer Amount : 5");
        System.out.println("\tPin change : 6");
        System.out.println("\tExit : 7");
        int n4 = sc.nextInt();
        if(n4==1){
            check(i);
        }
        if(n4==2){
            withdrawel(i);
        }
        if(n4==3){
             statement(i);
        }
        if(n4==4){
            deposit(i);
        }
        if(n4==5){
            transfer(i);
        }
        if(n4==6){
            pinchange(i);
        }
        if(n4==7){
            system();
        }
    }
    public static void check(int i){
        System.out.println("The available balance is "+arr[i][2]);
        user1(i);
    }
    public static void withdrawel(int i){
        System.out.println("Please enter the amount to be withdrawel:");
        int am=sc.nextInt();
        int amdup=am;
        int amdup2=am;
        if(arr[i][2] < am){
            System.out.println("Transaction cannot takes plce due to insufficiant balance");
            user1(i);
        }
        else if(am > balance){
            System.out.println("Insufficiant funds");
            user1(i);
        }
        else if (am%100 != 0){
             System.out.println("Plese enter value in 100's");
             user1(i);
        }
        else if(arr[i][2] >= am && am<=balance){
            int c=0;
            for(int j=0;j<4 ;j++){
                if(am>=amount[0][j] ){
                    if(amount[1][j] >= am/amount[0][j]){
                        am = am%amount[0][j];
                    }
                }
                if(am == 0){
                    c=1;
                }
            }
            if(c==1){
                for(int j=0;j<4;j++){
                    if(amdup>=amount[0][j]){
                        if(amount[1][j] >= am/amount[j][0]){
                            amdup = am%amount[0][j];
                            amount[1][j]-=am/amount[j][0];
                        }
                    }
                    if(am == 0){
                        c=1;
                    }
                }
            System.out.println("Please collect your cash");
            String timeStamp = df.format(new Date());
            state[i] = state[i]+ '\n'+"Cash withdrawel of "+ amdup2 +" at "+timeStamp;
            arr[i][2]-=amdup2;
            balance-=amdup2;
            System.out.println("Your available balance is " + arr[i][2]);
            user1(i);
            }
            if(c==0){
                System.out.println("We cannot provide cash");
                user1(i);
            }
        }
    }
    public static void statement(int i){
        System.out.println("The statements are as follows :");
        System.out.println(state[i]);
        user1(i);
    }
    public static void deposit(int i){
        System.out.println("Plese enter the amount to be deposited :");
        int amu=sc.nextInt();
        System.out.println("Enter the denomination value : ");
                System.out.print("2000 :");
                int a1=sc.nextInt();
                if(a1+amount[1][0]<=100){
                    System.out.println("Valid");
                    amount[1][0]+=a1;
                    balance += 2000*a1;
                }
                else{
                    System.out.println("System only accepts"+ (100-amount[1][0])+"notes");
                    user1(i);
                }
                System.out.println("500 :");
                int a2=sc.nextInt();
                if(a2+amount[1][1]<=100){
                    System.out.println("Valid");
                    amount[1][1]+=a2;
                    balance+=500*a2;
                }
                else{
                    if(a1 !=0 ){
                        amount[1][0]-=a1;
                        balance -= 2000*a1;
                    }
                    System.out.println("System only accepts"+ (100-amount[1][1])+"notes");
                    user1(i);
                }
                System.out.println("200 :");
                int a3=sc.nextInt();
                if(a3+amount[1][2]<=100){
                    System.out.println("Valid");
                    amount[1][2]+=a3;
                    balance+=200*a3;
                }
                else{
                    if(a1 !=0 ){
                        amount[1][0]-=a1;
                        balance -= 2000*a1;
                    }
                    if(a2 !=0 ){
                        amount[1][1]-=a2;
                        balance -= 500*a2;
                    }
                    System.out.println("System only accepts"+ (100-amount[1][2])+"notes");
                    user1(i);
                }
                System.out.println("100 :");
                int a4=sc.nextInt();
                if(a4+amount[1][3]<=100){
                    System.out.println("Valid");
                    amount[1][3]+=a4;
                    balance+=100*a4;
                }
                else{
                    if(a1 !=0 ){
                        amount[1][0]-=a1;
                        balance -= 2000*a1;
                    }
                    if(a2 !=0 ){
                        amount[1][1]-=a2;
                        balance -= 500*a2;
                    }
                    if(a3!=0){
                        amount[1][2]-=a3;
                        balance -= 200*a3;
                    }
                    System.out.println("System only accepts"+ (100-amount[1][3])+"notes");
                    user1(i);
                }
                arr[i][2]+=amu;
                //balance+=amu;
                System.out.println("Succesfull");
                String timeStamp = df.format(new Date());
                state[i] = state[i]+ '\n'+"Amount deposited of "+ amu +" at "+timeStamp;
                System.out.println("Your available balance is" + arr[i][2]);
                user1(i);
    }
    public static void transfer(int i){
        System.out.println("Please enter the user id to whom you want to transfer:");
        int u=sc.nextInt();
        int v=0;
        for(int k=0;k<arr.length;k++){
            if(u==arr[k][0]){
                v++;
                System.out.println("Please enter the amount to be transferred :");
                int h=sc.nextInt();
                if(arr[i][2] >= h){
                System.out.println("Enter the denomination value : ");
                System.out.print("2000 :");
                int a1=sc.nextInt();
                if(a1+amount[1][0]<=100){
                    System.out.println("Valid");
                    amount[1][0]+=a1;
                    //balance += 2000*a1;
                }
                else{
                    System.out.println("System only accepts"+ (100-amount[0][0])+"notes");
                    user1(i);
                }
                System.out.println("500 :");
                int a2=sc.nextInt();
                if(a2+amount[1][1]<=100){
                    System.out.println("Valid");
                    amount[1][1]+=a2;
                    //balance+=500*a2;
                }
                else{
                    if(a1 !=0 ){
                        amount[1][0]-=a1;
                        //balance -= 2000*a1;
                    }
                    System.out.println("System only accepts"+ (100-amount[1][1])+"notes");
                    user1(i);
                }
                System.out.println("200 :");
                int a3=sc.nextInt();
                if(a3+amount[1][2]<=100){
                    System.out.println("Valid");
                    amount[1][2]+=a3;
                    //balance+=200*a3;
                }
                else{
                    if(a1 !=0 ){
                        amount[1][0]-=a1;
                        //balance -= 2000*a1;
                    }
                    if(a2 !=0 ){
                        amount[1][1]-=a2;
                        //balance -= 500*a2;
                    }
                    System.out.println("System only accepts"+ (100-amount[2][2])+"notes");
                    user1(i);
                }
                System.out.println("100 :");
                int a4=sc.nextInt();
                if(a4+amount[1][3]<=100){
                    System.out.println("Valid");
                    amount[1][3]+=a4;
                    //balance+=100*a4;
                }
                else{
                    if(a1 !=0 ){
                        amount[1][0]-=a1;
                        //balance -= 2000*a1;
                    }
                    if(a2 !=0 ){
                        amount[1][1]-=a2;
                        //balance -= 500*a2;
                    }
                    if(a3!=0){
                        amount[1][2]-=a3;
                        //balance -= 200*a3;
                    }
                    System.out.println("System only accepts"+ (100-amount[3][3])+"notes");
                    user1(i);
                }
                arr[k][2]+=h;
                //balance+=h;
                arr[i][2]-=h;
                System.out.println("Succesfull");
                String timeStamp = df.format(new Date());
                state[i] = state[i]+ '\n'+"Amount transferred of "+ h +" at "+timeStamp + " to "+ arr[k][1];
                System.out.println("Your available balance is" + arr[i][2]);
                user1(i);
                }
                else{
                    System.out.println("You are having insufficiant funds ");
                    user1(i);
                }
            }
        }
        if(v==0){
            System.out.println("Please enter the valid user-id");
            user1(i);
        }
    }
    public static void pinchange(int i ){
        System.out.println("Please enter the old pin:");
        int p=sc.nextInt();
        if(p==arr[i][1]){
            System.out.println("Please enter the new pin:");
            int p1=sc.nextInt();
            System.out.println("Please re-enter the pin:");
            int p2=sc.nextInt();
            if(p1==p2){
                arr[i][1]=p1;
                System.out.println("Pin changed successfully");
                String timeStamp = df.format(new Date());
                state[i] = state[i]+ '\n'+"New pin changed ";
                user();
            }
            else{
                System.out.println("Please renter the pin correctly");
                pinchange(i);
            }
        }
    }
    public static void system(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Select any one : ");
        System.out.println("Admin : 1");
        System.out.println("User : 2");
        int n=sc.nextInt();
        if(n==1){
            admin();
        }
        else if(n==2){
            user();
        }
        else{
            System.out.println("Select either 1 0r 2");
        }

    }
    public static void main(String args[]){
        amount[0][0]=2000;
        amount[0][1]=500;
        amount[0][2]=200;
        amount[0][3]=100;
        system();   
    }
}
