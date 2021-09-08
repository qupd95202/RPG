/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animal1;

/**
 *
 * @author mickytsai
 */
import java.util.ArrayList;
import java.util.Scanner;
public class AnimalArray {

    public static void main (String[] args){
        ArrayList<Animal> list = new ArrayList<>();
        AnimalArray.newAnimal(list);
        AnimalArray.newAnimal(list);
        AnimalArray.newAnimal(list);
        AnimalArray.printAnimal(list);
        AnimalArray.filterWeight(list);
        
    }
    
    //      可以依照指定姓名查找動物(只會有一個)
    //      可以依照指定字母開頭找出相同字母開頭姓名的動物(會有多個)
    //      可以依照體重的大小(min~max)篩選動物
    //      可以依照動物的種類篩選動物
    public static void serchAnimal (ArrayList<Animal> list){
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        for(int i = 0; i < list.size(); i++){
            if(n.equals(list.get(i).getName())){
                System.out.println("在第" + i + 1 + "位置");
                break;
            }
        System.out.println("沒找到");    
        }   
    }
    public static void findAnimal (ArrayList<Animal> list) {
        Scanner sc = new Scanner(System.in);
        String[] arr = new String[2];
        int count = 0;
        for(int i = 0; i < list.size(); i++){
            arr[i] = list.get(i).getName();
            count++;
            if(count == arr.length){
                arr = doubleArr(arr);
            }
        }
        String s = sc.next();
        char n = s.charAt(0);
        for(int i = 0; i < count; i++){
            if(n == arr[i].charAt(0) ){
                System.out.println(arr[i]);
            }
        }
        
    }
    public static void filterWeight (ArrayList<Animal> list){
        Scanner sc = new Scanner(System.in);
        int min = sc.nextInt();
        int max = sc.nextInt();
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getWeight() > min && list.get(i).getWeight() < max){
                System.out.println(list.get(i).getName());
            }
        }
        
        
    }
   
    
    
    
    //    請撰寫一個類別為 AnimalArray 並實現以下功能
    //    可以新增一個動物(於尾端)
    //    可以插入一個動物(於指定位置)
    //    可以刪除一個動物(指定位置)
    //    可以依照動物的姓名排序動物(String compare)
    //    可以依照動物的體重排序動物
    //    可以按當前array中的順序印出所有動物
    public static void newAnimal (ArrayList<Animal> list){
        Scanner sc = new Scanner(System.in);
        Animal animal = new Animal(sc.next(),sc.nextInt());
        list.add(animal);
        
        }
    public static void addAnimal (ArrayList<Animal> list){
        Scanner sc = new Scanner(System.in);
        Animal animal = new Animal(sc.next(),sc.nextInt());
        int index = sc.nextInt();
        list.add(index, animal);
        
    }
    public static void removeAnimal (ArrayList<Animal> list){
        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();
        list.remove(index);
        
    }
    public static void sortName (ArrayList<Animal> list){
        for(int i = 0; i < list.size() - 1; i++){
            for(int k = 0; k < list.size() - 1 - i; k++){
                String n1 = list.get(k).getName();
                String n2 = list.get(k + 1).getName();
                if (n1.compareTo(n2) > 0){
                    swap(list, k, k + 1);
                }
            } 
        }
        
    }
    public static void sortWeight (ArrayList<Animal> list){
        for(int i = 0; i < list.size() - 1; i++){
            for(int k = 0; k < list.size() - 1 - i; k++){
                float w1 = list.get(k).getWeight(); 
                float w2 = list.get(k + 1).getWeight();
                
                if(w1 > w2){
                    swap(list, k, k + 1);
                }
            }
        }
    }
    public static void printAnimal (ArrayList<Animal> list){
        for(int i = 0; i < list.size(); i++){
            Animal a = list.get(i);
            System.out.println(a.getName() + " " + a.getWeight());
        }
    }
    
    public static void swap (ArrayList<Animal> list, int index1, int index2){
        Animal tmp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, tmp);
    }
    public static String[] doubleArr (String[] arr){
        String[] newarr = new String[arr.length * 2];
        for(int i = 0; i < arr.length; i++){
            newarr[i] = arr[i];
        }
        return newarr;
    }
    
    
    
    
}

