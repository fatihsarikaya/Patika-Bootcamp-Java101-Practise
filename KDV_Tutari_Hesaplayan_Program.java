import java.util.Scanner;

public class KDV_Tutari_Hesaplayan_Program {
    public static void main(String[] args) {
       double paradegeri, kdvsizfiyat, kdvlifiyat,kdvorani, kdvtutari;
        Scanner input = new Scanner(System.in);

        System.out.println("Para Değerini Giriniz :");
        paradegeri = input.nextDouble();
        
        kdvorani = (paradegeri>0) && (paradegeri <=1000) ? 0.20 : 0.08;
        System.out.println("Kdv Oranı :" +kdvorani);
        kdvsizfiyat = paradegeri;
        System.out.println("KDV'siz Fiyat :" + kdvsizfiyat);
        kdvlifiyat = ((paradegeri*kdvorani)+paradegeri);
        System.out.println("KDV'li Fiyat :" + kdvlifiyat);
        kdvtutari = (paradegeri*kdvorani);
        System.out.println("KDV Tutarı :" +kdvtutari);
    }
}