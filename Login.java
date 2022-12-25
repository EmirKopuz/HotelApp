public class Login extends DbConnection {

    static String stuff_username;
    ManagementManager manager=new ManagementManager();     //nesneler oluşturduk
    CustomerManager customerManager=new CustomerManager();
    StuffManager stuffManager =new StuffManager();


    static String customer_uniqueId;   //başka classlarda nesne oluşturmaya gerek kalmadan kullanmak için
    static int customer_id;
    public void customerLogin(){   //müşteri girişi
        getCustomers();
        while(true) {
        System.out.print("Müşteri kodunu giriniz : ");
        customer_uniqueId=scanner.next();

        for(int i=0;i<customers.size();i++){
            //customer dizisi boyunda döndürüp ıd kontrolu yapıp girilen bilgilari karşılaştırmak
            if(customer_uniqueId.equals(customers.get(i).getCustomer_uniqueID()) ){
                System.out.println("Giriş Başarılı..\n");
                System.out.println("Hoş geldin "+ customers.get(i).getCustomer_name());
                customer_id=i;
                customerManager.customerMenu();// customerManager adından bir nesne var bu nesneyi kullanarak müşteri menüşüne yönlendiriyoruz
            }

        }
        }
    }

   public void stuffLogin(){     // personel girişi
        getStuff();    //databaseden personelleri aldık
        while(true) {
            System.out.print("Personel kullanıcı adınızı giriniz : ");
            stuff_username = scanner.next();
            System.out.print("Personel şifrenizi giriniz : ");
            String stuff_password = scanner.next();
            //personale ait giriş bilgilarini aldık

            for (int i = 0; i < stuffs.size(); i++) {
                    //müşteride olduğu gibi burdada kontrol edip giriş sağlamak
                if (stuff_username.equals(stuffs.get(i).getStuff_username()) && stuff_password.equals(stuffs.get(i).getStuff_password())) {
                    System.out.println("Giriş Başarılı\n");
                    System.out.println("Hoş geldiniz " + stuffs.get(i).getStuff_name());

                    updateTime("entrytime", stuff_username);  //personelimizin giriş saatini databaseye aktardık
                    stuffManager.stuffRedirect(i); //stuffManager adından bir nesne var bu nesneyi kullanarak müşteri menüşüne yönlendiriyoruzm
                }

            }

        }
    }
    public void managementLogin(){  
        getManagers();  // databasemizden yöneticileri aldık
        while (true) {
            System.out.print("Yönetici kullanıcı adınızı giriniz : ");
            String manager_username = scanner.next();
            System.out.print("Yönetici şifrenizi giriniz : ");
            String manager_password = scanner.next();     //yöneticinin giriş bilgilerinin alınması
            for (Management management : managers) {
            
                if (manager_username.equals(management.getManager_username()) && manager_password.equals(management.getManager_password())) {  
                   //yöneticinin giriş bilgilerinin doğruluk karşılaştırması
                    System.out.println("\nGiriş Başarılı\n");
                    System.out.println("Hoş geldiniz " + management.getManager_name());
                    
                    manager.managerMenu(); //manager adından bir nesne var bu nesneyi kullanarak müşteri menüşüne yönlendiriyoruz

                }

            }

        }

    }


}
