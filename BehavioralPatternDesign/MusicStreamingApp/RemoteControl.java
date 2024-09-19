// Remote control that will execute the given command
class RemoteControl {
    private Command command; 

    // Sets a new command for the remote control
    public void setCommand(Command command) {
        this.command = command;
    }

    // Simulates pressing a button on the remote
    public void pressButton() {
        command.execute(); 
    }
}
