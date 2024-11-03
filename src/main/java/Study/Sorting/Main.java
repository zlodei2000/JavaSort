package Study.Sorting;

import java.util.ArrayList;
import java.util.Scanner;


import static Study.Sorting.ListUtils.*;

public class Main {

    private static ArrayList<sortAlgInterface> algList;
    final static int numAlgs = 2;

    private static void InitAlgorithms(){
        // массив указателей на методы сортировки, пока что просто 2 алгоритма
        algList = new ArrayList<>(numAlgs);
        algList.add(new sortAlgBubbleSort(5));
        algList.add(new sortAlgMergeSort(10));
    }
    private static void printAlgorithmsAvailable(){
        System.out.println("Available Algorithms:");
        for(int i = 0; i < algList.size(); i++){
            System.out.printf("%d %s\n", i, algList.get(i).getAlgName());
        }
    }

    public static void main(String[] args) {

        // сделаем 1 сканер - это удобно, если например надо будет переделать, чтоб ввод был не из консоли, а как-то иначе
        Scanner in = new Scanner(System.in);

        int numElements = inputIntMinMax(1,10, in, "Enter number of elements (1 - 10):");
        System.out.printf("List length: %d\n",numElements);
        System.out.println("Enter elements to sort");
        ArrayList<Integer> listSource = inputList(numElements,in);

        InitAlgorithms();
        printAlgorithmsAvailable();
        int algChoice = inputIntMinMax(0,numAlgs-1, in, String.format("Choose algorithm (%d - %d):",0,numAlgs-1));

        System.out.printf("Algorithm to use: %d\nSource list:",algChoice);
        printList(listSource);

        try {
            ArrayList<Integer> listSorted = (algList.get(algChoice)).sortAlgFunc(listSource);
            System.out.print("Sorted list:");
            printList(listSorted);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.out.println("Trying all other algorithms:");
                for (int i = 0; i < algList.size(); i++) {
                    if (i != algChoice) {
                        try {
                            ArrayList<Integer> listSorted = (algList.get(i)).sortAlgFunc(listSource);
                            System.out.printf("Sorted list by %s:",algList.get(i).getAlgName());
                            printList(listSorted);
                            break;
                        } catch (IllegalArgumentException ex) {
                            System.out.println(e.getMessage());
                        }
                    }
            }
        }
        in.close();

        System.out.println("CustomArrayList test add");
        CustomArrayList<String> lst1 = new CustomArrayList<>();
        lst1.add("hello");
        lst1.add("world");
        for(int i = 0; i < 17; i++) {
            lst1.add(String.valueOf(i));
        }

        for(int i = 0; i < lst1.size(); i++){
           System.out.println(lst1.get(i));
        }

        System.out.println("Test remove");

        lst1.remove(0);
        for(int i = 0; i < lst1.size(); i++){
            System.out.println(lst1.get(i));
        }

    }
}
