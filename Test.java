import java.util.*;

public class Test {

    public static void main1(String[] args) {
        char c = 0;
        short s = 0;
        float f = 0;
        double d = 0;
        double ret = c * s + f + d;
    }

    public static void main2(String[] args) {
        int i = 5;
        int s = (i++) + (++i) + (i--) + (--i);
        System.out.println(s); // 24
    }

    public static void main3(String[] args) {
        int i = 0;
        int j = 0;
        if ((++i > 0) || (++j > 0)) {
            System.out.println(i + " " + j);
            // 1 0 (只实现 || 前面的部分)
        }
    }
}

class Main {

    static private Main ss=new Main();
    private Stack<Integer> left=new Stack<>(); // 表示左手边的牌
    private Stack<Integer> right=new Stack<>(); // 表示右手边的牌
    public void pokeSort(List list,List list2,List list3){ // list3 表示总的牌数
        list.clear();
        list2.clear();
        for(int i = 0; i < list3.size() / 2; i++) {
            list.add(list3.get(i)); //将前 n 张牌给左手边
        }
        for(int i = list3.size() / 2; i < list3.size(); i++) {
            list2.add(list3.get(i)); //将后 n 张牌给右手边
        }
        left.addAll(list); // 分别入栈
        right.addAll(list2);
        list3.clear();
        while (!left.empty()) { //模拟一次洗牌过程，将结果放入 list3 中
            list3.add(right.pop());
            list3.add(left.pop());
        }

        //从上往下看的顺序序列，符合题目要求存入 list3，作为一次排序的结果
        Collections.reverse(list3);

    }

    public static void main1(String[] args) {

        // 洗牌在生活中十分常见，现在需要写一个程序模拟洗牌的过程。
        // 现在需要洗 2n 张牌，从上到下依次是第 1 张，第 2 张，第 3 张一直到第 2n 张。
        // 首先，我们把这 2n 张牌分成两堆，左手拿着第 1 张到第 n 张（上半堆），右手拿着第 n + 1 张到第 2n 张（下半堆）。
        // 接着就开始洗牌的过程，先放下右手的最后一张牌，再放下左手的最后一张牌，接着放下右手的倒数第二张牌，再放下左手的倒数第二张牌，
        // 直到最后放下左手的第一张牌。接着把牌合并起来就可以了。
        // 例如有 6 张牌，最开始牌的序列是 1, 2, 3, 4, 5, 6。
        // 首先分成两组，左手拿着 1, 2, 3；右手拿着 4, 5, 6。
        // 在洗牌过程中按顺序放下了 6, 3, 5, 2, 4, 1。
        // 把这六张牌再次合成一组牌之后，我们按照从上往下的顺序看这组牌，就变成了序列 1, 4, 2, 5, 3, 6。
        // 现在给出一个原始牌组，请输出这副牌洗牌 k 次之后从上往下的序列。

        // 输入描述:
        // 第一行一个数 T(T ≤ 100)，表示数据组数。
        // 对于每组数据，第一行两个数 n, k(1 ≤ n,k ≤ 100)，
        // 接下来一行有 2n 个数 a1, a2, ..., a2n(1 ≤ ai ≤ 1000000000)。表示原始牌组从上到下的序列.
        // 输出描述:
        // 对于每组数据，输出一行，最终的序列。数字之间用空格隔开，不要在行末输出多余的空格。

        // 示例 1:
        // 输入:
        // 3
        // 3 1
        // 1
        // 2
        // 3
        // 4
        // 5
        // 6
        // 3 2
        // 1
        // 2
        // 3
        // 4
        // 5
        // 6
        // 2 2
        // 1
        // 1
        // 1
        // 1
        // 输出:
        // 1 4 2 5 3 6
        // 1 5 4 3 2 6
        // 1 1 1 1

        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>(); // 存放左手牌
        List<Integer> list2 = new ArrayList<>(); // 存放右手牌
        List<Integer> list3 = new ArrayList<>(); // 存放总牌数
        List <String> result = new ArrayList<>(); // 存储所有组数的结果
        int t = sc.nextInt(); // 组数
        int n = 0, k = 0;
        while(t != 0){
            n=sc.nextInt(); // 左手的牌数(总牌数的一半)
            k=sc.nextInt(); // 洗牌次数
            for(int i = 0; i < 2 * n; i++) {
                list3.add(sc.nextInt());
            }
            while(k != 0) {
                // 洗牌 k 次
                ss.pokeSort(list, list2, list3);
                k--;
            }
            // 存储每组结果
            result.add(list3.toString().replace("[", "").replace("]", "").replace(",", ""));
            t--;
            list3.clear();
        }


        for(String str:result) {
            //打印结果
            System.out.println(str);
        }
    }

    public static void main2(String[] args) {
        // 读入 N 名学生的成绩, 将获得某一给定分数的学生人数输出

        //输入包含若干测试用例,每个测试用例的格式为
        //第 1 行: N
        //第 2 行: N 名学生的成绩, 相邻两数字用一个空格间隔.
        //第 3 行: 给定分数
        //当读到 N = 0 时输入结束.
        // 其中 N 不超过 1000, 成绩分数为(包含) 0 到 100 之间的一个整数.
        //对每个测试用例,将获得给定分数的学生人数输出.

        // 输入:
        // 3
        // 80 60 90
        // 60

        //2
        //85 66
        //0

        //输出：
        //1

        //0

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i]= sc.nextInt();
        }
        int count = 0;
        int score = sc.nextInt();
        for(int j = 0; j < n; j++){
            if(arr[j] == score){
                count++;
            }
        }
        System.out.println(count);
    }
}