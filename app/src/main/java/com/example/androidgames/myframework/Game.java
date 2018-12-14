package com.example.androidgames.myframework;

public interface Game {
    Input getInput();

    FileIO getFileIO();

    Graphics getGraphics();

    Audio getAudio();

    void getScreen(Screen screen);

    Screen getCurrentScreen();

    Screen getStartScreen();
}
