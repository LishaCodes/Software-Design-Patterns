// Command to decrease the volume
class VolumeDownCommand implements Command {
    private MusicPlayer musicPlayer;

    public VolumeDownCommand(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    @Override
    public void execute() {
        musicPlayer.decreaseVolume(); 
    }
}
