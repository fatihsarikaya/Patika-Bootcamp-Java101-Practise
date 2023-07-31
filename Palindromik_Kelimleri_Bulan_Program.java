import java.util.Scanner;

public class Palindromik_Kelimleri_Bulan_Program {
    public static String isPalindrome(String str)
    {
        String reverse = "";

        for(int i = str.length()-1 ; i >=0; i--){
            reverse += str.charAt(i);
        }
        if(str.equals(reverse)){
            return "Palindromik Kelime.";
        }
        else
            return "Palindromik Kelime değil.";
    }

    public static void main(String[] args) {
        String value;
        Scanner input = new Scanner(System.in);
        System.out.println("Kelime giriniz: ");
        value = input.nextLine();
        System.out.println("-------------------");
        System.out.println(isPalindrome(value));

    }

}