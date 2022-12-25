
import java.time.LocalDateTime;
import java.util.Scanner;

public class CustomerManager extends DbConnection {

    //CustomerManager sınıfı db connectiona kalıtımladık



    public void customerMenu() {
        MainPage mainPage = new MainPage(); //mainPage nesnemizi oluşturma
        int giris;
        String kontrol = "1";  // while döngüsü için kontrol değişkeni tanımladım
        System.out.println("Yapmak istediğiniz işlemi giriniz.\n********************************");
        while (kontrol.equals("1")) {  //kontrol 1 olduğunda while döngüsünün dönmesi için kontrol ettim
            System.out.println("1-Sipariş Ver \n2-Sipariş Durumu Görüntüle\n3-Hizmet iste\n4-Gece Kulübüne gir\n5-Çıkış Yap\n***************");
            System.out.print("Seçiminiz : ");

            giris = scanner.nextInt();
                //Menudeki hangi işlemi yapacağına dair scannerla int değeri aldım ve daha sonra bunu if else ile kontrol ettim
            if (giris == 1) {                       
                kontrol = "";  // while döngüsünden çıkarmak için kontrol değişkenini boş yaptım
                foodDisplaying();   //yemek listesini gösterme
                foodChoosing();     // yemek seçimi
            } else if (giris == 2) {
                getCustomers();  //veritabanında müşterikre ulaştık
                                
                kontrol = "";
                getOrders(customers.get(Login.customer_id).getCustomer_roomnumber());  //siparişlerden ilgili müşterimizin siparişleri
                customerMenu();
            } else if (giris==3) {        // hizmet seçeneğini seçerse
                System.out.println("1-Oda Temizliği\n2-Teknik Destek\n3-Müşteri menüsüne geri dön\n");
                int secim;
                System.out.print("Seçiminiz : ");
                secim= scanner.nextByte();

                if(secim==1){
                    kontrol = "";

                    System.out.println("Hangi saatler arasında Oda temizliği istersiniz (00:00 şeklinde giriniz) Başlangıç Zamanı:");
                    String saat= scanner.next(); // baslama saatini aldık müşterimizden
                    System.out.println("Hangi saatler arasında Oda temizliği istersiniz (00:00 şeklinde giriniz) Bitiş Zamanı:");
                    String saat1=scanner.next();  // bitmesini istedği saat
                    String time=saat+"-"+saat1; //iki saati aralık seklinde alıp time değişkenine atadık
                    housekeepingAdding(time); // veri tabanına saat bilgimizi ekledik
                    System.out.println("Talebiniz alınmıştır.");
                    customerMenu();
                }
                else if (secim==2) {

                    System.out.print("İletmek istediğiniz mesajınızı giriniz: ");
                    scanner.nextLine();  // cümle şeklinde müşterimizden sorunun ne olduğunu aldık
                    String supportMessage=scanner.nextLine();

                    String time= String.valueOf(LocalDateTime.now());
                    technicalSupportAdding(supportMessage,time.substring(0,19));
                    // databasemize sorunun ne olduğunu aldık

                    System.out.println("Talebiniz alınmıştır.");
                }
                else if (secim==3){
                    kontrol = "";
                }

            }
            else if(giris==4){
                getCustomers();
                int age=customers.get(Login.customer_id).getCustomer_age(); // müşterimiizn yaş bilgisini aldık
                if(age<18){
                    kontrol = "";
                    System.out.println("Yaşınız 18 yaşından küçük olduğu için giriş reddedildi");
                }
                else if(age>=18){
                    kontrol = "";
                    System.out.println("Giriş kabul edildi"); // 18 yaşında büyük mü küçük mü olduğu kontrolunu yaptık
                    System.out.println("İçecek siparişi vermek ister misiniz?\n1)Evet\n2)Hayır");
                    
                    int icecek=scanner.nextInt();
                    if(icecek==1){

                        foodDisplaying("içecek"); //override ettiğimiz yemek me
                        //override ettiğimiz yemek menüsünde sadece içeçekleri gösterdik
                        foodChoosing();//ve seçim aldık
                    }
                    else if (icecek==2) {
                        System.out.println("İyi eğlenceler...");

                    }

                }
            }
            else if (giris==5) {
                mainPage.showLoginChoice(); //çıkış yapmak isterse uygulamamızın kullanıcı giriş sayfasına yönlendirme
            }else {
                System.out.println("Hatalı giriş yaptınız !!\n****************"); // hatalı giriş ihtimaline karşı
            }


        }
    }


    public void foodDisplaying() {
        getFoods();
        System.out.println("No    Ürün Adı                    Ürün Ücreti       Ürün Kalorisi      Ürün Kategorisi");
        for (int i=0;i< foods.size();i++) {
               // foods arrayimizin büyüklüğü boyunca dönüp yemeklerin id isim bilgilarini yazdırdık
            System.out.print(foods.get(i).getFood_id() + " ");
            System.out.print(foods.get(i).getFood_name());
            for (int j = foods.get(i).getFood_name().length(); j < 34; j++) {                       // yemek listesinin daha güzel gözükmesi için bu döngüye aldık
                System.out.print(" ");
            }
            System.out.print(foods.get(i).getFood_price() + "               "); 
            System.out.print(foods.get(i).getFood_calories() + "                 ");
            System.out.println(foods.get(i).getFood_category());


        }
    }
    // sadece içecekleri göstermesi için
    public void foodDisplaying(String category) {       // sadece gece kulubunde verilecek siparişler için override ettik 
        getFoods(); //  yemekleri databaseden aldık
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

    public void foodChoosing() {   //
        getCustomers();
        System.out.print("Lütfen seçmek istediğiniz ürünün numarasını giriniz: ");
        int yemeksecim = scanner.nextInt();

        int ordersRoomnumber ;
        System.out.print("Lütfen kaç porsiyon istediğiniz giriniz: ");
        int porsiyon = scanner.nextInt();
        System.out.println();
        ordersRoomnumber=customers.get(Login.customer_id).getCustomer_roomnumber();  //siparişin gideceği oda numarası
        //  orderAdding(yemeksecim, ordersRoomnumber, porsiyon,foods.get(yemeksecim-1).getFood_name());
        orderAdding(yemeksecim, ordersRoomnumber, porsiyon); //sipariş ekleme
        System.out.println("Siparişiniz alınmıştır.");
        customerMenu(); //müsteri ana sayfasına yönlendirmek
    }


}
