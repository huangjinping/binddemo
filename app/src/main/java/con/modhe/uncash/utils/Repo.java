package con.modhe.uncash.utils;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * author Created by harrishuang on 2020-09-10.
 * email : huangjinping1000@163.com
 */
public class Repo implements Serializable {

    /**
     * id : 132935648
     * node_id : MDEwOlJlcG9zaXRvcnkxMzI5MzU2NDg=
     * name : boysenberry-repo-1
     * full_name : octocat/boysenberry-repo-1
     * private : false
     */

    private int id;
    private String node_id;
    private String name;
    private String full_name;
    @SerializedName("private")
    private boolean privateX;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNode_id() {
        return node_id;
    }

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public boolean isPrivateX() {
        return privateX;
    }

    public void setPrivateX(boolean privateX) {
        this.privateX = privateX;
    }

    @Override
    public String toString() {
        return "Repo{" +
                "id=" + id +
                ", node_id='" + node_id + '\'' +
                ", name='" + name + '\'' +
                ", full_name='" + full_name + '\'' +
                ", privateX=" + privateX +
                '}';
    }
}

