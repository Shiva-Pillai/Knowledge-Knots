package com.shivapillai.knowledgeknots;

public class Info_Downloaded_notes {

    String name,path;

    public Info_Downloaded_notes()
    {

    }

    public Info_Downloaded_notes(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
