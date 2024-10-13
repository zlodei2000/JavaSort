package Study.Sorting;

import java.util.ArrayList;
import java.util.Scanner;


import static Study.Sorting.ListUtils.*;

public class Main {
    // интерфейс, который будет использоваться для создания указателей на функции сортировки
    private interface sortAlg {
        ArrayList<Integer> sortAlgFunc(ArrayList<Integer> listSource, int maxListSize);
    }

    // вспомогательный класс - просто название алгоритма, ссылка на метод и ограничение
    private static class Algorithm {
            public String AlgName;
            public sortAlg AlgImpl;
            public int maxListSize;
            public Algorithm(String AlgName, sortAlg AlgImpl, int maxListSize) {
                this.AlgName = AlgName;
                this.AlgImpl = AlgImpl;
                this.maxListSize = maxListSize;
            }
    }
    private static ArrayList<Algorithm> algList;
    final static int numAlgs = 2;

    private static void InitAlgorithms(){
        // массив указателей на методы сортировки, пока что просто 2 алгоритма
        algList = new ArrayList<>(numAlgs);
        algList.add(new Algorithm("Bubble sort",SortingAlgs::sortListBubbleSort,100 ));
        algList.add(new Algorithm("Merge sort",SortingAlgs::sortListMergeSort,100 ));
    }
    private static void printAlgorithmsAvailable(){
        System.out.println("Available Algorithms:");
        for(int i = 0; i < algList.size(); i++){
            System.out.printf("%d %s\n", i, algList.get(i).AlgName);
        }
    }

    public static void main(String[] args) {

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

        ArrayList<Integer> listSorted = (algList.get(algChoice)).AlgImpl.sortAlgFunc(listSource, (algList.get(algChoice)).maxListSize);


        System.out.print("Sorted list:");
        printList(listSorted);

        in.close();
    }
}
