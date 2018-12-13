package com.example.androidgames.myframework;

public interface Game {
    public Input getInput();

    public FileIO getFileIO();

    public Graphics getGraphics();

    public Audio getAudio();

    public void getScreen(Screen screen);

    public Screen getCurrentScreen();

    public Screen getStartScreen();
}
