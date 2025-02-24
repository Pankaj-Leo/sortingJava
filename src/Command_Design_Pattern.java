public class Command_Design_Pattern {

    // Command Interface
    public interface Command {
        void execute();
        void undo();
    }

    // Create the Receiver
    public static class Light {
        public void turnOn() {
            System.out.println("The light is ON");
        }

        public void turnOff() {
            System.out.println("The light is OFF");
        }
    }

    public static class LightOnCommand implements Command {
        private Light light;

        public LightOnCommand(Light light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.turnOn();
        }

        @Override
        public void undo() {
            light.turnOff();
        }
    }

    public static class LightOffCommand implements Command {
        private Light light;

        public LightOffCommand(Light light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.turnOff();
        }

        @Override
        public void undo() {
            light.turnOn();
        }
    }

//Create the Invoker
    public static class RemoteControl {
        private Command command;

        public void setCommand(Command command) {
            this.command = command;
        }

        public void pressButton() {
            command.execute();
        }

        public void pressUndo() {
            command.undo();
        }
    }


    public static void main(String[] args) {
            // Create the receiver
            Light livingRoomLight = new Light();

            // Create commands
            Command lightOn = new LightOnCommand(livingRoomLight);
            Command lightOff = new LightOffCommand(livingRoomLight);

            // Create the invoker
            RemoteControl remote = new RemoteControl();

            // Turn the light ON
            remote.setCommand(lightOn);
            remote.pressButton(); // Output: The light is ON

            // Undo the operation (turn it OFF)
            remote.pressUndo(); // Output: The light is OFF

            // Turn the light OFF
            remote.setCommand(lightOff);
            remote.pressButton(); // Output: The light is OFF

            // Undo the operation (turn it ON)
            remote.pressUndo(); // Output: The light is ON
    }

}
