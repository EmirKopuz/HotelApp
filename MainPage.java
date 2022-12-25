import java.util.Scanner;

public class MainPage {

    public static void showLoginChoice(){      //giriş seçenekerini göstermek için 
        Scanner scanner=new Scanner(System.in); //scanner oluşturdk
        Login login = new Login();   //login nesnesi oluşturduk
        int giris;
        String kontrol="1";
        System.out.println("Giriş Yap\n********************************");
        while (kontrol.equals("1")){
            System.out.println("1-Müşteri girişi \n2-Personel Girişi\n3-Yönetim Girişi\n4-Çıkış\n**********");
            System.out.print("Seçiminiz : ");

            giris = scanner.nextInt();   // giriş seceneğini alıp else if kullanarak doğru giriş ekranına gönderme

            if(giris==1){
                kontrol="";

                login.customerLogin(); //login classımızdan müşteri giriş ekranı 

            } else if (giris==2) {
                kontrol="";
                login.stuffLogin(); //login classımızdan personel giriş ekranı 


            }else if(giris==3){
                kontrol="";
                login.managementLogin();  //login classımızdan yönetici giriş ekranı 
            }else if(giris==4){

                kontrol="0";  //while döngüsünü kırmak için


            }else{
                System.out.println("Hatalı giriş yaptınız !!\n****************"); // hatali giriş ihtimali
            }


        }
    }
}
