// Interface for Smart TV functions
interface SmartTV {
    void turnOn();
    void turnOff();
    void increaseVolume();
    void decreaseVolume();
    void mute();
    void unmute();
    void switchInput(String inputSource);
    void changeChannel(int channelNumber);
}

// Samsung TV implementation
class SamsungTV implements SmartTV {
    private int volume = 10;
    private boolean muted = false;

    @Override
    public void turnOn() {
        System.out.println("Samsung TV is now ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Samsung TV is now OFF");
    }

    @Override
    public void increaseVolume() {
        if (!muted) {
            volume += 1;
            System.out.println("Samsung TV Volume: " + volume);
        } else {
            System.out.println("Samsung TV is muted. Unmute to adjust volume.");
        }
    }

    @Override
    public void decreaseVolume() {
        if (!muted && volume > 0) {
            volume -= 1;
            System.out.println("Samsung TV Volume: " + volume);
        } else {
            System.out.println("Samsung TV is muted or volume is already at 0.");
        }
    }

    @Override
    public void mute() {
        muted = true;
        System.out.println("Samsung TV is now muted.");
    }

    @Override
    public void unmute() {
        muted = false;
        System.out.println("Samsung TV is now unmuted.");
    }

    @Override
    public void switchInput(String inputSource) {
        System.out.println("Samsung TV switched to input: " + inputSource);
    }

    @Override
    public void changeChannel(int channelNumber) {
        System.out.println("Samsung TV is now on channel: " + channelNumber);
    }
}

// LG TV implementation
class LGTV implements SmartTV {
    private int volume = 20;
    private boolean muted = false;

    @Override
    public void turnOn() {
        System.out.println("LG TV is now ON");
    }

    @Override
    public void turnOff() {
        System.out.println("LG TV is now OFF");
    }

    @Override
    public void increaseVolume() {
        if (!muted) {
            volume += 1;
            System.out.println("LG TV Volume: " + volume);
        } else {
            System.out.println("LG TV is muted. Unmute to adjust volume.");
        }
    }

    @Override
    public void decreaseVolume() {
        if (!muted && volume > 0) {
            volume -= 1;
            System.out.println("LG TV Volume: " + volume);
        } else {
            System.out.println("LG TV is muted or volume is already at 0.");
        }
    }

    @Override
    public void mute() {
        muted = true;
        System.out.println("LG TV is now muted.");
    }

    @Override
    public void unmute() {
        muted = false;
        System.out.println("LG TV is now unmuted.");
    }

    @Override
    public void switchInput(String inputSource) {
        System.out.println("LG TV switched to input: " + inputSource);
    }

    @Override
    public void changeChannel(int channelNumber) {
        System.out.println("LG TV is now on channel: " + channelNumber);
    }
}

// Remote control to manage TV actions
class RemoteControl {
    private SmartTV tv;

    public RemoteControl(SmartTV tv) {
        this.tv = tv;
    }

    // Turn the TV on or off
    public void pressPowerButton(String action) {
        if (action.equals("on")) {
            tv.turnOn();
        } else if (action.equals("off")) {
            tv.turnOff();
        }
    }

    // Adjust TV volume up or down
    public void adjustVolume(String direction) {
        if (direction.equals("up")) {
            tv.increaseVolume();
        } else if (direction.equals("down")) {
            tv.decreaseVolume();
        }
    }

    // Mute or unmute the TV
    public void muteTV() {
        tv.mute();
    }

    public void unmuteTV() {
        tv.unmute();
    }

    // Change input source or channel
    public void changeInputSource(String inputSource) {
        tv.switchInput(inputSource);
    }

    public void changeChannel(int channelNumber) {
        tv.changeChannel(channelNumber);
    }

    // Switch control to a different TV
    public void switchTV(SmartTV newTV) {
        this.tv = newTV;
        System.out.println("Remote now controls a new TV.");
    }
}


public class SmartTVRemoteAdapter {
    public static void main(String[] args) {
        SmartTV samsungTV = new SamsungTV();
        SmartTV lgTV = new LGTV();

        RemoteControl remote = new RemoteControl(samsungTV);

        // Testing Samsung TV 
        remote.pressPowerButton("on");
        remote.adjustVolume("up");
        remote.muteTV();
        remote.adjustVolume("down"); // Volume change ignored as TV is muted
        remote.unmuteTV();
        remote.adjustVolume("down");
        remote.changeInputSource("HDMI");
        remote.changeChannel(5);
        remote.pressPowerButton("off");

        // Switch to LG TV 
        remote.switchTV(lgTV);
        remote.pressPowerButton("on");
        remote.adjustVolume("up");
        remote.changeChannel(10);
        remote.pressPowerButton("off");
    }
}
