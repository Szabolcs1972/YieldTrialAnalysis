package hu.szlavikszabolcs.view.bean;

public class Salt {

    //bytes to hide the salt of the passwords
    private final byte[] bytes = {10,53,24,107,122,126,120,126};

    //byte to shift bytes
    private final byte[] byteShift = {79};

    public Salt() {// a very simple constructor to create an instance
    }
    //this class has just getters for security reasons
    public byte[] getBytes() {
        return bytes;
    }

    public byte[] getByteShift() {
        return byteShift;
    }





    }
