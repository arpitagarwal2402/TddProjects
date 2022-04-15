import java.util.*;

public class Calculator
{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.print(Add(input));
    }
    
    static int Add(String numbers) throws Exception {
        //String arr[] = numbers.split("\\D{1,}");
        String delimiter = ",";
        if(numbers.startsWith("//;")){
            delimiter = String.valueOf(numbers.charAt(2));
        }
        
        numbers = numbers.replaceAll("//"+delimiter,"");
        numbers = numbers.replaceAll("\\\\n",delimiter);

        String arr[] = numbers.split(delimiter);
        int sum=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals("")){
                arr[i] = "0";
            }
            if(Integer.parseInt(arr[i])<0){
                List<Integer> negs = new ArrayList();
                negs.add(Integer.parseInt(arr[i]));
                for(int j=i+1;j<arr.length;j++){
                    if(Integer.parseInt(arr[j])<0){
                        negs.add(Integer.parseInt(arr[j]));
                    }
                }
                throw new Exception("negatives not allowed "+negs);
            }
            sum = sum + Integer.parseInt(arr[i]);
        }
        return sum;
    }
}
