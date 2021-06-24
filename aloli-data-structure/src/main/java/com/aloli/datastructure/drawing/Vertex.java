package com.aloli.datastructure.drawing;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
public class Vertex {


    /**
     * 顶点的名称
     */
    private String name;

    /**
     * 此顶点关联的下一个顶点
     */
    private List<Vertex> connVertexs = new ArrayList<>();

    @Override
    public String toString(){
        return name +connVertexs.toArray();
    }
}
