package com.sandipawale.admincollegeapp.faculty;

public class TeacherData {
    private String name, email, post, image, key;

    public TeacherData() {
    }

    public TeacherData(String name, String email, String post, String image, String key) {
        this.name = name;
        this.image = email;
        this.post = post;
        this.image = image;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public String getPost()
    {
        return post;
    }
    public void setPost(String post)
    {
        this.post=post;
    }
    public String getImage()
    {
        return image;
    }
    public void setImage(String Image)
    {
        this.image=image;
    }
    public String getKey()
    {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    }



