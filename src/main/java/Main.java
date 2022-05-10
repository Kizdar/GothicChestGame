import GeneratorLosu.LosowanieNagrody;
import GeneratorLosu.LosowanieSzyfru;
import Skrzynia.Skrzynia;
import User.User;

import java.util.Scanner;

public class Main {





        public static void main(String[] args) {
            User user = new User();
            user.setLiczbaProb(5);
            user.setWynik(0);
            System.out.println("Witam w nowej grze:");
            System.out.println("Celem jest otwarcie skrzyni w której jest nagroda,\nw skrzyni znajduja sie pieniadze lub wytrych" +
                    "\nZasady:\nPosiadasz 5 wytrychow\nZamek jest sześcio segmentowy\nMozesz otworzyc skrzynie wpisujać lewo lub prawo" +
                    "jesli wpiszesz prawidłowo dostaniesz\nkomunikat ok jesli nie to łamie ci sie wytrych i zaczynasz gre od nowa\nTo tyle. Powodzenia!" );


            boolean petla = true;
            while (petla) {
                user = Gra(user);
                if(user.getLiczbaProb()==0){
                    System.out.println("Koniec gry, nie masz juz wytrychów");
                    break;
                }
                System.out.println("Posiadasz: "+user.getWynik()+" punktów i "+user.getLiczbaProb()+" wytrychów");
            }


        }
        public static Skrzynia getSkrzyniaObject () {
            Skrzynia skrzynia1 =new Skrzynia();
            LosowanieSzyfru los =new LosowanieSzyfru();
            LosowanieNagrody nagroda = new LosowanieNagrody();
            skrzynia1.setProba1(los.losowanie());
            skrzynia1.setProba2(los.losowanie());
            skrzynia1.setProba3(los.losowanie());
            skrzynia1.setProba4(los.losowanie());
            skrzynia1.setProba5(los.losowanie());
            skrzynia1.setProba6(los.losowanie());
            skrzynia1.setNagroda(nagroda.nagroda());
            return skrzynia1;
        }

        public static User Gra(User user) {
            String nagroda = "";
            String inputUser = "";
            Scanner input = new Scanner(System.in);
            Skrzynia skrzynia = getSkrzyniaObject();
            int warunek = user.getLiczbaProb();

            for (int i = 0; i < warunek; i++) {
                System.out.print("pierwszy segment:");
                inputUser = input.nextLine().trim().toLowerCase();
                if (skrzynia.getProba1().equals(inputUser)) {
                    System.out.println(" OK");
                } else {
                    System.out.println(blad(user));;
                    continue;}
                System.out.print("drugi segment:");
                inputUser = input.nextLine().trim().toLowerCase();
                if (skrzynia.getProba2().equals(inputUser)) {
                    System.out.println(" OK");
                }  else {
                    System.out.println(blad(user));;
                    continue;}
                System.out.print("trzeci segment:");
                inputUser = input.nextLine().trim().toLowerCase();
                if (skrzynia.getProba3().equals(inputUser)) {
                    System.out.println(" OK");
                }  else {
                    System.out.println(blad(user));;
                    continue;}
                System.out.print("czwarty segment:");
                inputUser = input.nextLine().trim().toLowerCase();
                if (skrzynia.getProba4().equals(inputUser)) {
                    System.out.println(" OK");
                }  else {
                    System.out.println(blad(user));;
                    continue;}
                System.out.print("piąty segment:");
                inputUser = input.nextLine().trim().toLowerCase();
                if (skrzynia.getProba5().equals(inputUser)) {
                    System.out.println(" OK");
                }  else {
                    System.out.println(blad(user));;
                    continue;}
                System.out.print("szusty segment:");
                inputUser = input.nextLine().trim().toLowerCase();



                if (skrzynia.getProba6().equals(inputUser)) {
                    nagroda = String.valueOf(skrzynia.getNagroda() + " punktów");
                    if (skrzynia.getNagroda() == -1) {
                        nagroda = "1 wytrych";
                    }
                    System.out.println("Brawo otworzyłeś skrzynie!!!\nZnajduje sie tam: " + nagroda );
                    if(skrzynia.getNagroda()==-1) {user.setLiczbaProb(user.getLiczbaProb()-i+1);}
                    else {
                        user.setWynik(skrzynia.getNagroda());
                    }
                    break;
                } else {
                    System.out.println(blad(user));;
                    continue;}

            }
            return user;
        }
        public static String blad(User user){
            user.setLiczbaProb(user.getLiczbaProb()-1);
            return "Błąd    Zostało ci "+user.getLiczbaProb()+" Prób";
        }

    }
