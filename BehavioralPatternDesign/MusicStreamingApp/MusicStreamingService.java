// Main class to run the music control app
public class MusicStreamingService {
    public static void main(String[] args) {
        // Creating the music player
        MusicPlayer musicPlayer = new MusicPlayer();

        Command playCommand = new PlayCommand(musicPlayer);
        Command pauseCommand = new PauseCommand(musicPlayer);
        Command skipCommand = new SkipCommand(musicPlayer);
        Command volumeUpCommand = new VolumeUpCommand(musicPlayer);
        Command volumeDownCommand = new VolumeDownCommand(musicPlayer);

        // Creating the remote control
        RemoteControl remote = new RemoteControl();

        remote.setCommand(playCommand);
        remote.pressButton();

        remote.setCommand(volumeUpCommand);
        remote.pressButton();

        remote.setCommand(pauseCommand);
        remote.pressButton();

        remote.setCommand(skipCommand);
        remote.pressButton();

        remote.setCommand(volumeDownCommand);
        remote.pressButton();
    }
}
