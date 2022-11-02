package com.example.seguimiento13.model;

public class FileOpenerData {
    //Formato del singleton
    private static FileOpenerData instance;

    public User user;

    private FileOpenerData() {
        user = new User("000000", "");
    }

    public static FileOpenerData getInstance(){
        if(instance == null){
            instance = new FileOpenerData();
        }
        return instance;
    }

    public static void setInstance(FileOpenerData instance) {
        FileOpenerData.instance = instance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
