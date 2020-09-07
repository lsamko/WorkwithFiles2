import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //class work
        String goods = "Snikers, Mars, Coca-cola, Twix, Sprite";
        String price = "25, 25, 15, 20, 15";
        String n = "100, 110, 200, 95, 225";
        String del = ";";
        File file1 = new File("Report.xlsx");
        saveReportToCSV(file1, del, goods, price, n);
        System.out.println("Done!");

        //Work 2
        File file = new File("file.txt");
        String text = loadStringFromFile(file);
        System.out.println(text);
    }

    public static void saveReportToCSV(File file, String del, String g, String p, String n){
        String [] goods = g.split(",");
        String [] price = p.split(",");
        String [] num = n.split(",");

        try(PrintWriter pw1 = new PrintWriter(file)){
            for (int i = 0; i < goods.length ; i++) {
                pw1.println(goods[i] + del  + price [i] + del + num[i]);
            }
        } catch (IOException e1){
            System.out.println(e1);
        }
    }

    public static String loadStringFromFile(File file){
        String result = "";
        try(Scanner sc = new Scanner(file)){
            for(; sc.hasNextLine();){
                result += sc.nextLine() + System.lineSeparator();
            }
        } catch (IOException e){
            System.out.println(e);
        }

        return result;
    }
}
