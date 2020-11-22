package com.example.findme_firebase;

public class Information {

    private String lobby;
    private String ghost;

    public Information() {

    }

    public Information(String lobby, String ghost) {
        this.lobby=lobby;
        this.ghost=ghost;
    }

    public String getLobby() {
        return lobby;
    }

    public String getGhost() {
        return ghost;
    }

    public void setLobby() {
        this.lobby = lobby;
    }

    public void setGhost() {
        this.ghost = ghost;
    }
}
