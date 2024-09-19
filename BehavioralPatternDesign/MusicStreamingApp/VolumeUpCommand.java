// Command to increase the volume
class VolumeUpCommand implements Command {
    private MusicPlayer musicPlayer;

    public VolumeUpCommand(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    @Override
    public void execute() {
        musicPlayer.increaseVolume(); 
    }
}
