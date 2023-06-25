// Задание:
// 1. Организовать вводи и хранение данных пользователей. ФИО возраст и пол
// 2. вывод в формате Фамилия И.О. возраст пол
// 3. добавить возможность выхода или вывода списка отсортированного по возрасту!)
// 4. *реализовать сортировку по возрасту с использованием индексов
// 5. *реализовать сортировку по возрасту и полу с использованием индексов

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class task4 {
    public static void main(String[] args) {
        ArrayList<String> alistFamilyName = new ArrayList<>();
        ArrayList<String> alistName = new ArrayList<>();
        ArrayList<String> alistMiddleName = new ArrayList<>();
        ArrayList<Integer> alistAge = new ArrayList<>();
        ArrayList<String> alistGender = new ArrayList<>();
        String[] data = new String[3];
        String[] fio = new String[3];
        
        // 1. Организовать вводи и хранение данных пользователей. ФИО возраст и пол
        String answer = new String("");
        Scanner reader = new Scanner(System.in); 
        while (!answer.equals("q")){
            System.out.println("Введите ФИО, возраст и пол через запятую или q для выхода: ");
            answer = reader.nextLine().toString();
            if (answer.equals("q")) break;
            data = answer.split(",");
            fio = data[0].split(" ");
            alistFamilyName.add(fio[0]);
            alistName.add(fio[1]);
            alistMiddleName.add(fio[2]);
            alistAge.add(Integer.parseInt(data[1].trim()));
            alistGender.add(data[2].trim());
        }

        // 2. вывод в формате Фамилия И.О. возраст пол
        for (int i = 0; i < alistFamilyName.size(); i++) {
            System.out.printf("Пользователь %s: %s %s. %s. возраст: %s лет, пол: %s", i+1, 
            alistFamilyName.get(i), alistName.get(i).substring(0, 1), 
            alistMiddleName.get(i).substring(0, 1), 
            alistAge.get(i), alistGender.get(i));
            System.out.println();
        }

        // 3. добавить возможность выхода или вывода списка отсортированного по возрасту!)
        System.out.println();
        System.out.println("Отсортировать пользователей по возрасту? yes/no ");
        String otvet = new String("");
        otvet = reader.nextLine().toString();
        ArrayList age = (ArrayList)alistAge.clone();
        Collections.sort(age);

        if (otvet.equals("yes")){
            System.out.println("Сортировка пользователей по возрасту:");
            for (int i = 0; i < age.size(); i++) {
                for (int j = 0; j < alistAge.size(); j++) {
                    if (alistAge.get(j).equals(age.get(i))) {
                        System.out.printf("Пользователь %s: %s %s. %s. возраст: %s лет, пол: %s", i+1, 
                        alistFamilyName.get(j), alistName.get(j).substring(0, 1), 
                        alistMiddleName.get(j).substring(0, 1), 
                        alistAge.get(j), alistGender.get(j));
                        System.out.println();
                    }
                }
            }
        }
        else{
            System.out.println("Вы отказались от сортировки");
            return;
        } 
        reader.close();

        // 4. *реализовать сортировку по возрасту с использованием индексов
        System.out.println();
        System.out.println("Сортировка по возрасту с использованием индексов:");
        Integer[] indexAge = new Integer[alistAge.size()];
        for (int i = 0; i < indexAge.length; i++) {
            indexAge[i] = i;
        }

        int temp = 0;
        for (int i = 0; i < indexAge.length; i++) {
            for (int j = 0; j < indexAge.length-1-i; j++) {
                if (alistAge.get(indexAge[j]) > alistAge.get(indexAge[j+1])){
                    temp = indexAge[j];
                    indexAge[j] = indexAge[j+1];
                    indexAge[j+1] =temp;
                }
            }            
        }
        for (int i = 0; i < indexAge.length; i++) {
            System.out.printf("Пользователь %s: %s %s. %s. возраст: %s лет, пол: %s", i+1, 
                        alistFamilyName.get(indexAge[i]), alistName.get(indexAge[i]).substring(0, 1), 
                        alistMiddleName.get(indexAge[i]).substring(0, 1), 
                        alistAge.get(indexAge[i]), alistGender.get(indexAge[i]));
            System.out.println();            
        }

        // 5. *реализовать сортировку по возрасту и полу с использованием индексов
        System.out.println();
        System.out.println("Сортировка по возрасту и полу с использованием индексов:");
        ArrayList<Integer> indexAgeGender = new ArrayList<>();
        temp = 0;
        for (int i = 0; i < indexAge.length; i++) {
            if (alistGender.get(indexAge[i]).equals("муж")){
                indexAgeGender.add(temp, indexAge[i]);
                temp++;
            }
            else indexAgeGender.add(indexAge[i]);
        }

        for (int i = 0; i < indexAgeGender.size(); i++) {
            System.out.printf("Пользователь %s: %s %s. %s. возраст: %s лет, пол: %s", i+1, 
                        alistFamilyName.get(indexAgeGender.get(i)), alistName.get(indexAgeGender.get(i)).substring(0, 1), 
                        alistMiddleName.get(indexAgeGender.get(i)).substring(0, 1), 
                        alistAge.get(indexAgeGender.get(i)), alistGender.get(indexAgeGender.get(i)));
            System.out.println();  
        }            
    }
}
