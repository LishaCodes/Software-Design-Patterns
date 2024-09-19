// Command to play music
class PlayCommand implements Command {
    private MusicPlayer musicPlayer;

    public PlayCommand(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    @Override
    public void execute() {
        musicPlayer.play(); // Tells the music player to start playing
    }
}
