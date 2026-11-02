import java.util.Scanner;
public class smartBank{
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
      String name;
      String beneficiaire;
     int Solde = 250000;
    int CodePinS = 0;
    int CodePin = 2026;
    int newPin;
    int depot;
    int limite = 500000;
    int retrait;
    int limiteR = 150000;
    int FraisRetrait = 500;
    int transfert;
    int fraisT;
    int minT = 1000;
    int maxT = 300000;
    int choix = 0;
  

    // Authentification du client;
    System.out.print("Veuillez entrer votre nom : ");
    name = scanner.nextLine();
    System.out.println("Bonjour " + name + "!");
    System.out.print("Veuillez insérer votre codePIN: ");
    CodePinS = scanner.nextInt();
    if(CodePinS == CodePin){
      System.out.println("Accès autorisé!");
      System.out.println("=================");
      System.out.println("\tSMARTBANK");
      System.out.println("=================\n");
      System.out.println("Bienvenue chez SmartBank\n");
      System.out.println("1. Consulter mon solde");
      System.out.println("2. Effectuer un dépôt");
      System.out.println("3. Effectuer un retrait");
      System.out.println("4. Effectuer un transfert");
      System.out.println("5. Modifier mon PIN");
      System.out.println("6. Quitter\n");
      System.out.print("Votre choix: ");
      choix = scanner.nextInt();
      // OPTIONS DU MENU
      switch(choix){
        // VERIFICATION DU SOLDE
        case 1:
          System.out.println("==================");
          System.out.println("SOLDE DU COMPTE");
          System.out.println("==================\n");
          System.out.printf(" Le solde de votre compte est de %d FCFA.\n",Solde);
          break;
          // DEPOT
        case 2:
          System.out.println("==================");
          System.out.println("\tDEPOT");
          System.out.println("==================");
          System.out.print("Veuillez entrer un montant : ");
          depot = scanner.nextInt();
          while(depot<=0){
            System.out.println("Transaction impossible.");
            System.out.print("Veuillez entrer un nouveau montant : ");
            depot = scanner.nextInt();
          }
          if(depot > limite){
              System.out.printf("Désolé. Le montant maximum que vous pouvez transférer est de %d FCFA.",limite);
              System.out.print("Veuillez entrer un nouveau montant : ");
              depot = scanner.nextInt();
          }else{
            Solde += depot;
            System.out.println("Transaction réussi!");
            System.out.printf("Votre nouveau solde est de %d FCFA.",Solde);
          }
           break;
          case 3:
            // RETRAIT 
            System.out.println("==================");
            System.out.println("\tRETRAIT");
            System.out.println("==================");
            System.out.print("Veuillez entrer un montant : ");
            retrait = scanner.nextInt();
            while(retrait<=0){
            System.out.println("Opération refusée. Le montant doit être supérieur à zéro.");
            System.out.print("Veuillez entrer un nouveau montant : ");
            retrait = scanner.nextInt();
          }
          if(retrait > limiteR){
              System.out.println("Désolé, le montant dépasse la limite de retrait autorisée.");
              System.out.print("Veuillez entrer un nouveau montant : ");
              retrait = scanner.nextInt();
          }else if(retrait>(Solde+FraisRetrait)){
            System.out.println("Opération refusée: votre solde est insuffisant pour couvrir le retrait et les frais.");
          }else{
            Solde -= retrait + FraisRetrait;
            System.out.printf("Transaction réussi! Votre nouveau solde est de %d FCFA.", Solde);
          }
           break;
          case 4:
            scanner.nextLine();
            System.out.printf("Entrez le nom du bénéficiaire : ");
            beneficiaire = scanner.nextLine();
            System.out.printf("Entrez le montant à transférer : ");
            transfert = scanner.nextInt();
            while(transfert<=0 || transfert > Solde){
            System.out.println("Opération refusée.");
            System.out.print("Veuillez entrer un nouveau montant : ");
            retrait = scanner.nextInt();
          }
            if(transfert<1000){
            System.out.printf("Transfert impossible. Le minimum requis est de %d FCFA.",minT);
            System.out.println("Entrez à nouveau  le montant à transférer : ");
          
            }else if(transfert>300000){
              System.out.printf("Transfert impossible. Vous ne pouvez envoyer un montant supérieur à %d FCFA",maxT);
              System.out.println("Entrez à nouveau le montant à transférer : ");
            }else{
              fraisT = transfert * 1/100;
              Solde -= transfert + fraisT;
              System.out.printf("Transfert de %d FCFA effectué avec succès sur le compte de %s.",transfert,beneficiaire);
              System.out.printf("Votre nouveau solde est de %d FCFA.",Solde);
          
            }
             break;
            case 5:
               System.out.printf("Entrez votre ancien Code PIN : ");
               CodePinS = scanner.nextInt();
               if(CodePinS!=CodePin){
                    int tentative = 3;
                      do{
       
                          tentative -=1;
                          if(tentative ==0){
                           System.out.println("Ancien code PIN incorrect. Impossible de modifier votre code.");
                          break;
                          }
                          System.out.println("Code PIN incorrect.");
                         System.out.print(" Il vous reste " +  tentative + " tentatives." + "Veuillez réessayez: ");
                         CodePinS =scanner.nextInt();
                       }
                        while(CodePinS!=CodePin);
                   }else{
                    System.out.print("Entrez votre nouveau Code PIN à 4 chiffres : ");
                    newPin = scanner.nextInt();
                    System.out.print("Confirmez votre nouveau Code PIN à 4 chiffres : ");
                    newPin = scanner.nextInt();
                      CodePin = newPin;
                    System.out.println("Félicitations! Vous venez de modifier votre code PIN.");
                    
                   }
                    break;
                    default:
                      System.out.println("Merci d'aoir utilisé SmartBank!");
                      System.out.println("Nous vous souhaitons une bonne journée.");
                      System.out.println("A bientôt!");
      
}
    }
    else if(CodePinS!=CodePin){
       int tentative = 3;
      do{
       
        tentative -=1;
         if(tentative ==0){
          System.out.println("Accès refusé! Trop de tentatives.");
          break;
        }
        System.out.println("Code PIN incorrect.");
        System.out.print(" Il vous reste " +  tentative + " tentatives." + "Veuillez réessayez: ");
        CodePinS =scanner.nextInt();
      }
      while(CodePinS!=CodePin);
      
    }






    scanner.close();
  }
}
