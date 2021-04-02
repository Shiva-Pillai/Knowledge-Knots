package com.shivapillai.knowledgeknots;

public class Information_of_upload_docs {

    String file_name,url,sub_name,topics,ch_no;

    public Information_of_upload_docs(){}

    public Information_of_upload_docs(String file_name, String url, String sub_name, String topics, String ch_no) {
        this.file_name = file_name;
        this.url = url;
        this.sub_name = sub_name;
        this.topics = topics;
        this.ch_no = ch_no;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSub_name() {
        return sub_name;
    }

    public void setSub_name(String sub_name) {
        this.sub_name = sub_name;
    }

    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }

    public String getCh_no() {
        return ch_no;
    }

    public void setCh_no(String ch_no) {
        this.ch_no = ch_no;
    }
}
