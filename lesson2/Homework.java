package ru.geekbrains.java_2.homework.lesson2;

public class Homework {

    public static void SumElofArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr.length != 4 || arr[i].length != 4) {
                    System.out.println("Invalid array size!\n");
                    throw new MyArraySizeException();
                }
                try {
                    Integer.parseInt(arr[i][j]);
                    sum+=Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    System.out.printf("The sum of the array elements up to the wrong cell: %s\n", sum);
                    System.out.printf("Incorrect data in the cell: [%s][%s]\n\n",(i+1),(j+1));
                    throw new MyArrayDataException();
                }
            }
        }
        System.out.printf("Sum of all array elements: %s\n", sum);

    }

    public static void main(String[] args) {

        String[][] arr1 = new String[][] {{"1", "1", "1", "1"}, {"2", "2", "2", "2"}, {"3", "3", "3", "3"}};
        String[][] arr2 = new String[][] {{"1", "1", "1", "1"}, {"2", "2", "2", "2"}, {"3", "3", "3", "3"}, {"4", "4", "4"}};
        String[][] arr3 = new String[][] {{"1", "1", "1", "1"}, {"2", "2", "2", "2"}, {"3", "3", "3", "3"}, {"a", "4", "4", "4"}};
        String[][] arr4 = new String[][] {{"1", "1", "1", "1"}, {"2", "2", "2", "2"}, {"3", "3", "3", "3"}, {"4", "4", "4", "4"}};

        try {
            SumElofArray(arr1);
        } catch (MyArraySizeException e) {
        } catch (MyArrayDataException e) {
            }
        try {
            SumElofArray(arr2);
        } catch (MyArraySizeException e) {
        } catch (MyArrayDataException e) {
        }
        try {
            SumElofArray(arr3);
        } catch (MyArraySizeException e) {
        } catch (MyArrayDataException e) {
        }
        try {
            SumElofArray(arr4);
        } catch (MyArraySizeException e) {
        } catch (MyArrayDataException e) {
        }
    }

}
