import java.util.Scanner;

public class MainPage {

    public static void showLoginChoice(){
        Scanner scanner=new Scanner(System.in);
        Login login = new Login();
        int giris;
        String kontrol="1";
        System.out.println("Giriş Yap\n********************************");
        while (kontrol.equals("1")){
            System.out.println("1-Müşteri girişi \n2-Personel Girişi\n3-Yönetim Girişi\n4-Çıkış\n**********");
            System.out.print("Seçiminiz : ");

            giris = scanner.nextInt();

            if(giris==1){
                kontrol="";

                login.customerLogin();

            } else if (giris==2) {
                kontrol="";
                login.stuffLogin();


            }else if(giris==3){
                kontrol="";
                login.managementLogin();
            }else if(giris==4){

                kontrol="0";


            }else{
                System.out.println("Hatalı giriş yaptınız !!\n****************");
            }


        }
    }
}
