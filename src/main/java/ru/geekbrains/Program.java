package ru.geekbrains;
import ru.geekbrains.exceptions.*;

public class Program {

    public static final String arraySizeIncorrentMessage = "Массив не 4*4";

    public static void main(String[] args) {
        String[][] array1 =  {
            { "1", "2", "3", "4"},
            {"234", "3242", "232", "234"},
            {"1", "0", "22", "8999"},
                {"23", "33", "222", "33"}
        };

        try {
            System.out.println(calculate(array1));
        }
        catch (MyArrayDataException | MyArraySizeException e) {
            System.out.println(e.getMessage());
        }



    }

    public static int calculate(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (array.length<4) {
            throw new MyArraySizeException(arraySizeIncorrentMessage);
        }
        for (int i=0;i<array.length;i++) {
            if(array[i].length<4) {
                throw new MyArraySizeException(arraySizeIncorrentMessage);
            }

                for (int j=0;j<array.length;j++) {
                    try {
                        sum+=Integer.parseInt(array[i][j]);
                    }
                    catch (NumberFormatException e) {
                        throw new MyArrayDataException(String.format("Not int in [%d][%d]",i,j));
                    }
                }
            }
        return sum;
    }

}
