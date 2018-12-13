package com.example.androidgames.myframework;

public interface Music {
    public void play();

    public void stop();

    public void pause();

    public void setVolume(float volume);

    public void setLooping(boolean looping);

    public boolean isPlaying();

    public boolean isStoped();

    public boolean isLooping();

    public void dispose();
}
