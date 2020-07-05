import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.io.IOException;

public class NumberGame {
    public static void main(String[] args){
        NumberGame numbergame = new NumberGame();
        numbergame.gameController();
    }

    public void gameController(){
        //初期値設定
        Random rand = new Random();
        int answerNum = rand.nextInt(90) + 10;
        int chanceNum = 5;
        String line;
        int userNum = 0;
        
        //入力待ち表示
        System.out.println("数あてゲームを始めます。");
        System.out.println("現在の残りチャンスは" + chanceNum + "回です" );
        System.out.println("数字を入力してください");
        //デバック用答え表示
        //System.out.println(answerNum);

        while(true){
            //入力処理
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                line = br.readLine();
                userNum = Integer.parseInt(line);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            System.out.println(userNum);

            //当たりはずれ処理
            if(userNum-answerNum > 20 || answerNum-userNum > 20){
                System.out.println("数が20以上離れています");
            }
            if(userNum == answerNum){
                System.out.println("当たりです！おめでとうございます！");
                break;
            }else if(userNum > answerNum){
                System.out.println("正解の数字より大きいですね");
                chanceNum--;
            }else if(userNum < answerNum){
                System.out.println("正解の数字より小さいですね");
                chanceNum--;
            }
            
            //チャンス回数処理
            if(chanceNum <= 0){
                System.out.println("残りチャンス数が0になりました。残念ながらゲームは終了です");
                break;
            }
        }

    }
}