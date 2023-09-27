package fr.fms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Pattern regExp = Pattern.compile("[0-9]+");
    public static void main(String[] args) {
       display(scanner);
    }
    public static ArrayList<Integer> getList (int nb){
        ArrayList<Integer> list = new ArrayList<>();
        int a =0;
        do {
            if (nb % 2 == 0) {
                list.add(nb/2);
                nb = nb/2;

            } else {
                list.add(nb* 3 + 1);
                nb =nb* 3 + 1;
            }
            if(nb==1)
                a=nb;
        }while (a!=1);
    return list;
    }
    public static void display(Scanner scanner){
        ArrayList<Integer> listOfNumbers;
        ArrayList<Integer> flightList = new ArrayList<Integer>();
        System.out.println("Bonjour souhaitez vous voir la conjecture Tchèque O/N?");
        String str = scanner.next();
        while(str.equalsIgnoreCase("oui") || str.equalsIgnoreCase("o")){
        System.out.println("Veuillez saisir un nombre entier positif : ");
        int nb = 0;
        if (scanner.hasNext(regExp)) {
            nb = scanner.nextInt();
            listOfNumbers = getList(nb);
            System.out.println("La liste des nombres successifs est : " + listOfNumbers);
            System.out.println("Le temps de vol du nombre " + nb + " est " + listOfNumbers.size());
            for (int i = 0; i < listOfNumbers.size(); i++) {
                if (listOfNumbers.get(i) <= nb) {
                    flightList.add(i+1);
                }
            }
            System.out.println(flightList.get(0));
            flightList.clear();
            Collections.sort(listOfNumbers);
            System.out.println("La valeur maximale de la suite est : " + listOfNumbers.get(listOfNumbers.size() - 1));
        }
        else {
            System.out.println("J'ai demandé un nombre entier positif");
        }
            System.out.println("Voulez vous saisir un nouveau nombre ?");
            str = scanner.next();
        };
        System.out.println("au revoir");
        scanner.close();
    }
}
