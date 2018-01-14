import java.util.*;
import java.io.*;

public class generator {
	static List<String> studyGood=new ArrayList<>();
	static List<String> studyBad=new ArrayList<>();
	static List<String> sportGood=new ArrayList<>();
	static List<String> sportBad=new ArrayList<>();
	static List<String> moralGood=new ArrayList<>();
	static List<String> moralBad=new ArrayList<>();
	
	static void readFile(String fileName, List<String> listName){
		File file = new File(fileName);
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str = null;
            while((str = br.readLine())!=null){
                listName.add(str);
            }
            br.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
	}
	
	static void buildList() {
		readFile("studyGood",studyGood);	
		readFile("studyBad",studyBad);
		readFile("moralGood",moralGood);
		readFile("moralBad",moralBad);
		readFile("sportGood",sportGood);
		readFile("sportBad",sportBad);
	}
	
	static String ramdomPick(List<String> listName) {
		Random random = new Random();
		String pick = listName.get(random.nextInt(listName.size()));
		return pick;
	}
	
	static void choose() {
		String study = null;
		String moral = null;
		String sport = null;
		String total = null;
		Scanner sc=new Scanner(System.in);
		String str=null;
		System.out.println("1代表好,0代表差");
		System.out.println("第一位数字为学习成绩,第二位数字为思想品德,第三位数字为体育");
		System.out.println("请输入学生情况:");
		str=sc.nextLine();	
		String[] str_1 = str.split("");
		int[] str_i = new int[str_1.length];
		for(int i=0;i<str_1.length;i++){
			str_i[i]=Integer.parseInt(str_1[i]);
			}
		if (str_i[0] == 0) {
			study = ramdomPick(studyBad);
		}
		if (str_i[0] == 1) {
			study = ramdomPick(studyGood);
		}
		if (str_i[1] == 0) {
			moral = ramdomPick(moralBad);
		}
		if (str_i[1] == 1) {
			moral = ramdomPick(moralGood);
		}
		if (str_i[2] == 0) {
			sport = ramdomPick(sportBad);
		}
		if (str_i[2] == 1) {
			sport = ramdomPick(sportGood);
		}
		total = study + moral + sport;
		System.out.println(total);
	}
	

	public static void main(String[] args) {
		buildList();
		choose();
	}

}
