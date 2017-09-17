package com.algorithm.other;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Ethan on 2017/8/31.
 */
public class Dijkstra {
    static int MAX=10000;
    static String[] path; //保存start到其它边路径的字符串
    //static LinkedList<Integer> list = new LinkedList<>();
    public static void main(String[] args) {

        //邻接矩阵
        /*int[][] weight = {
                {0,3,2000,7,MAX},
                {3,0,4,2,MAX},
                {MAX,4,0,5,4},
                {7,2,5,0,6},
                {MAX,MAX,4,6,0}
    };*/
        int[][] weight = {
            {0,9,4},
            {9,0,4},
            {4,4,0}};
        int[][] backup = weight.clone();
        int i;
        int start=0;
        int[] shortPath = Dijsktra(weight,start);
        for(i = 0;i < shortPath.length;i++)
        {
            System.out.println("从"+start+"出发到"+i+"的最短距离为："+shortPath[i]);
        }
        /*double[] dis = distance(backup,1);
        Arrays.sort(dis);
        for(i=0;i<2;i++) {
            dis[dis.length-1-i] /= 2;
        }
        double sum = 0d;
        for(i=0;i<dis.length;i++) {
            sum += dis[i];
        }
        System.out.printf("%.1f",sum);
        System.out.println();
        */
    }

    //接受一个有向图的权重矩阵，和一个起点编号start（从0编号，顶点存在数组中）
    //返回一个int[] 数组，表示从start到它的最短路径长度
    public static int[] Dijsktra(int[][] weight,int start){

        int n = weight.length;
        //存放从start到其他各点的最短路径
        int[] shortPath = new int[n];
        //存放从start到其他各点的最短路径的字符串表示
        path=new String[n];
        for(int i=0;i<n;i++)
        {
            path[i] = start + "-->" + i;
        }
        //标记当前该顶点的最短路径是否已经求出,1表示已求出
        int[] visited = new int[n];

        shortPath[start] = 0;
        visited[start] = 1;
        for(int count = 1;count <= n - 1;count++)
        {
            //选出一个距离初始顶点start最近的未标记顶点
            int k = -1;
            int dmin = Integer.MAX_VALUE;
            for(int i = 0;i < n;i++)
            {
                if(visited[i] == 0 && weight[start][i] < dmin)
                {
                    dmin = weight[start][i];
                    k = i;
                }
            }
            //将新选出的顶点标记为已求出最短路径，且到start的最短路径就是dmin
            shortPath[k] = dmin;
            visited[k] = 1;
            //以k为中间点，修正从start到未访问各点的距离
            for(int i = 0;i < n;i++)
            {
                if(visited[i] == 0 && weight[start][k] + weight[k][i] < weight[start][i])
                {
                    weight[start][i] = weight[start][k] + weight[k][i];
                    path[i]=path[k]+"-->"+i;
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            System.out.println("从"+start+"出发到"+i+"的最短路径为："+path[i]);
        }
        System.out.println("=====================================");
        return shortPath;
    }

    //返回顶点start到顶点i的路径中，每条边的长度数组
    public static double[] distance(int[][] backup,int idx){
        //System.out.println(path[i]);
        String[] point = path[idx].split("-->");
        double[] distance = new double[point.length-1];
        int i;
        for(i=0;i<point.length-1;i++) {
            distance[i] = backup[Integer.valueOf(point[i])][Integer.valueOf(point[i+1])];
        }
        return distance;
    }
}
