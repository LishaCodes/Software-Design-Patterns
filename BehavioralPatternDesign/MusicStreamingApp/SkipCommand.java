// Command to skip to the next track
class SkipCommand implements Command {
    private MusicPlayer musicPlayer;

    public SkipCommand(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    @Override
    public void execute() {
        musicPlayer.skip(); 
    }
}
