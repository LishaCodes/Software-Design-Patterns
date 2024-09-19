// Command to pause music
class PauseCommand implements Command {
    private MusicPlayer musicPlayer;

    public PauseCommand(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    @Override
    public void execute() {
        musicPlayer.pause(); // Tells the music player to pause
    }
}
