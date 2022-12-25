
import java.time.LocalDateTime;
import java.util.Scanner;

public class CustomerManager extends DbConnection {




    public void customerMenu() {
        MainPage mainPage = new MainPage();
        int giris;
        String kontrol = "1";
        System.out.println("Yapmak istediğiniz işlemi giriniz.\n********************************");
        while (kontrol.equals("1")) {
            System.out.println("1-Sipariş Ver \n2-Sipariş Durumu Görüntüle\n3-Hizmet iste\n4-Gece Kulübüne gir\n5-Çıkış Yap\n***************");
            System.out.print("Seçiminiz : ");

            giris = scanner.nextInt();

            if (giris == 1) {
                kontrol = "";
                foodDisplaying();
                foodChoosing();
            } else if (giris == 2) {
                getCustomers();

                kontrol = "";
                getOrders(customers.get(Login.customer_id).getCustomer_roomnumber());
                customerMenu();
            } else if (giris==3) {
                System.out.println("1-Oda Temizliği\n2-Teknik Destek\n3-Müşteri menüsüne geri dön\n");
                int secim;

                secim= scanner.nextByte();

                if(secim==1){
                    kontrol = "";

                    System.out.println("Hangi saatler arasında Oda temizliği istersiniz (00:00 şeklinde giriniz) Başlangıç Zamanı:");
                    String saat= scanner.next(); // bu saat veritabanına gönderilecek
                    System.out.println("Hangi saatler arasında Oda temizliği istersiniz (00:00 şeklinde giriniz) Bitiş Zamanı:");
                    String saat1=scanner.next();
                    String time=saat+"-"+saat1;
                    housekeepingAdding(time);
                    System.out.println("Talebiniz alınmıştır.");
                    customerMenu();
                }
                else if (secim==2) {

                    System.out.print("İletmek istediğiniz mesajınızı giriniz: ");
                    scanner.nextLine();
                    String supportMessage=scanner.nextLine();

                    String time= String.valueOf(LocalDateTime.now());
                    technicalSupportAdding(supportMessage,time.substring(0,19));

                    System.out.println("Talebiniz alınmıştır.");
                }
                else if (secim==3){
                    kontrol = "";
                }

            }
            else if(giris==4){
                getCustomers();
                int age=customers.get(Login.customer_id).getCustomer_age();
                if(age<18){
                    kontrol = "";
                    System.out.println("Yaşınız 18 yaşından küçük olduğu için giriş reddedildi");
                }
                else if(age>=18){
                    kontrol = "";
                    System.out.println("Giriş kabul edildi");
                    System.out.println("İçecek siparişi vermek ister misiniz?\n1)Evet\n2)Hayır");

                    int icecek=scanner.nextInt();
                    if(icecek==1){

                        foodDisplaying("içecek");
                        // 2 defa menü gösteriyor ve seçim al
                        foodChoosing();
                    }
                    else if (icecek==2) {
                        System.out.println("İyi eğlenceler...");

                    }

                }
            }
            else if (giris==5) {
                mainPage.showLoginChoice();
            }else {
                System.out.println("Hatalı giriş yaptınız !!\n****************");
            }


        }
    }


    public void foodDisplaying() {
        getFoods();
        System.out.println("No    Ürün Adı                    Ürün Ücreti       Ürün Kalorisi      Ürün Kategorisi");
        for (int i=0;i< foods.size();i++) {

            System.out.print(foods.get(i).getFood_id() + " ");
            System.out.print(foods.get(i).getFood_name());
            for (int j = foods.get(i).getFood_name().length(); j < 34; j++) {
                System.out.print(" ");
            }
            System.out.print(foods.get(i).getFood_price() + "               ");
            System.out.print(foods.get(i).getFood_calories() + "                 ");
            System.out.println(foods.get(i).getFood_category());


        }
    }
    // sadece içecekleri göstermesi için
    public void foodDisplaying(String category) {
        getFoods();
        System.out.println("No    Ürün Adı                    Ürün Ücreti       Ürün Kalorisi      Ürün Kategorisi");
        for (int i=0;i< foods.size();i++) {
            if (foods.get(i).getFood_category().equalsIgnoreCase(category)){
                System.out.print(foods.get(i).getFood_id() + " ");
                System.out.print(foods.get(i).getFood_name());
                for (int j = foods.get(i).getFood_name().length(); j < 34; j++) {
                    System.out.print(" ");
                }
                System.out.print(foods.get(i).getFood_price() + "               ");
                System.out.print(foods.get(i).getFood_calories() + "                 ");
                System.out.println(foods.get(i).getFood_category());

            }

        }
    }

    public void foodChoosing() {
        getCustomers();
        System.out.print("Lütfen seçmek istediğiniz ürünün numarasını giriniz: ");
        int yemeksecim = scanner.nextInt();

        int ordersRoomnumber ;
        System.out.print("Lütfen kaç porsiyon istediğiniz giriniz: ");
        int porsiyon = scanner.nextInt();
        System.out.println();
        ordersRoomnumber=customers.get(Login.customer_id).getCustomer_roomnumber();
        //  orderAdding(yemeksecim, ordersRoomnumber, porsiyon,foods.get(yemeksecim-1).getFood_name());
        orderAdding(yemeksecim, ordersRoomnumber, porsiyon);
        System.out.println("Siparişiniz alınmıştır.");
        customerMenu();
    }


}
