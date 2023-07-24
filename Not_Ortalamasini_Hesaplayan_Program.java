import java.util.Scanner;

public class Not_Ortalamasini_Hesaplayan_Program {
    public static void main(String[] args) {
        //Değişkenleri Oluştur
        int mat, fizik, kimya, tarih, muzik, resim;
        //Scanner sınıf tanımla
        Scanner inp = new Scanner(System.in);
        //Matematik verilerini al
        System.out.println("Matematik Notunuzu Giriniz :");
        mat = inp.nextInt();
        //Fizik verilerini al
        System.out.println("Fizik Notunuzu Giriniz :");
        fizik = inp.nextInt();
        //Kimya verilerini al
        System.out.println("Kimya Notunuzu Giriniz :");
        kimya = inp.nextInt();
        //Tarih verilerini al
        System.out.println("Tarih Notunuzu Giriniz :");
        tarih = inp.nextInt();
        //Müzik verilerini al
        System.out.println("Müzik Notunuzu Giriniz :");
        muzik = inp.nextInt();
        //Resim verilerini al
        System.out.println("Resim Notunuzu Giriniz :");
        resim = inp.nextInt();

        int toplam = (mat+fizik+kimya+tarih+muzik+resim);
        double ortalama = ( toplam/6.0 );
        System.out.println("Ortalamanız :" + ortalama);

        boolean durum = ortalama>=60;
        String sonuc = durum ? "Sınıfı Geçtiniz" : "Sınıfta Kaldınız";
        System.out.println(sonuc);
    }
    }