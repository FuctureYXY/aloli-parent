package com.aloli.datastructure.drawing;

import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * 图
 */
public class Chart {
    /**
     * 顶点的集合
     */
    private Map<String,Vertex> vertexs = new HashMap<>();
    /**
     * 边缘的条数
     */
    private int edges=0;

    /**
     * 添加边缘  两个顶点间
     */
    public void addEdage(Vertex a,Vertex b){
        List<Vertex> aconnVertexs = this.vertexs.get(a.getName()).getConnVertexs();
        List<Vertex> bconnVertexs = this.vertexs.get(b.getName()).getConnVertexs();
        aconnVertexs.add(b);
        bconnVertexs.add(a);
        edges++;

    }

    public void showChart(){
        for(Vertex v:vertexs.values()){
            System.out.println("节点: "+v+"关联顶点"+v.getConnVertexs());
        }
    }





    private List<String>  markList = new ArrayList<>();

    /**
     * 深度优先遍历
     */
    public void dfs(Vertex v){

        if(markList.contains(v.getName())){
            return;
        }
        markList.add(v.getName());
        System.out.println(v.getName());
        for (Vertex connVertex : v.getConnVertexs()) {
            dfs(connVertex);
        }
    }

    public void dfs(String name){
       dfs(this.vertexs.get(name));
       clearMarked();
    }

    public void bfs(String name ){
        bfs(this.vertexs.get(name));
        clearMarked();
    }
    public void bfsWithLayer(String name ){
        bfsWithLayer(this.vertexs.get(name));
        clearMarked();
    }


    private void minPathTo(Vertex v){
        if(!markList.contains(v.getName())){
            throw  new RuntimeException("没有这个路径");
        }




    }


    /**
     * 层次遍历 不需要判断层数
     * @param v
     */
    private void bfs(Vertex v) {
        Queue<Vertex> queue = new ArrayDeque();
        queue.add(v);
        while (!queue.isEmpty()){
            Vertex vertex = queue.poll();
            if(markList.contains(vertex.getName())){
               continue;
            }
            markList.add(vertex.getName());
            System.out.println(vertex.getName());
            for (Vertex connVertex : vertex.getConnVertexs()) {
                queue.add(connVertex);
            }
        }
    }

    /**
     * 广度优先遍历获取层数
     * @param v
     */
    private void bfsWithLayer(Vertex v) {
        ArrayList[] arr = new ArrayList[10];
        Queue<Vertex> queue = new ArrayDeque();
        queue.add(v);
        int layer=0;
        while (!queue.isEmpty()){
            System.out.println("层数"+layer);
            int size = queue.size();
            while(size>0){
                size--;
                Vertex vertex = queue.poll();
                if(markList.contains(vertex.getName())){
                    continue;
                }
                markList.add(vertex.getName());
                System.out.println(vertex.getName());
                if(CollectionUtils.isEmpty(arr[layer])){
                    arr[layer] = new ArrayList();
                }
                arr[layer].add(vertex.getName());

                for (Vertex connVertex : vertex.getConnVertexs()) {
                    queue.add(connVertex);
                }
            }
            layer++;
        }
        System.out.println(arr.toString());
    }

    private void clearMarked(){
        this.markList.clear();
    }

    public Vertex createVertex(String name){
        Vertex v = new Vertex();
        v.setName(name);
        this.vertexs.put(name,v);
        return v;
    }


    public void init(){
        Vertex a = createVertex("a");
        Vertex b = createVertex("b");
        Vertex c = createVertex("c");
        Vertex d = createVertex("d");
        Vertex e = createVertex("e");

        this.addEdage(a,b);
        this.addEdage(a,c);
        this.addEdage(a,d);
        this.addEdage(b,c);
        this.addEdage(c,e);
        this.addEdage(a,e);
    }

    public static void main(String[] args) {
        Chart chart = new Chart();
        chart.init();
        //chart.bfs("a");
        chart.bfsWithLayer("a");
    }


}
