package fakeplayer.ketongu10.commands.video;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

import py4j.GatewayServer;

public class GatewayToPython {
    public BufferedImage bufferedImage = null;
    public int[] array;
    public byte[] bytes;
    private int size;
    public GatewayToPython(int size) {
        this.size = size;
        this.array = new int[this.size];
    }


    public BufferedImage getBuf() {
        return this.bufferedImage;
    }
    public int getSize() {
        return size;
    }

    public void setArray() {
        DataBuffer buf = bufferedImage.getRaster().getDataBuffer();

        for (int i=0;i<this.size;++i) {
            this.array[i] = buf.getElem(i);
        }

    }

    public void setByteArray() {
        DataBuffer buf = bufferedImage.getRaster().getDataBuffer();
        ByteBuffer intBuffer = ByteBuffer.allocate(4*size); // 4 bytes in an int
        intBuffer.order(ByteOrder.LITTLE_ENDIAN); // Java's default is big-endian

        // Copy ints from intArray into intBuffer as bytes
        for (int i = 0; i < size; i++) {

            intBuffer.putInt(buf.getElem(i));

        }

        // Convert the ByteBuffer to a byte array and return it
        this.bytes = intBuffer.array();

    }

    public int[] getArray() {
        return Arrays.stream(array).toArray();
    }

    public byte[] getByteArray() {
        // Set up a ByteBuffer called intBuffer

        /**DataBuffer buf = bufferedImage.getRaster().getDataBuffer();
        ByteBuffer intBuffer = ByteBuffer.allocate(4*size); // 4 bytes in an int
        intBuffer.order(ByteOrder.LITTLE_ENDIAN); // Java's default is big-endian

        // Copy ints from intArray into intBuffer as bytes
        for (int i = 0; i < size; i++) {

                intBuffer.putInt(buf.getElem(i));

        }

        // Convert the ByteBuffer to a byte array and return it
        byte[] byteArray = intBuffer.array();

        return byteArray;**/
        return this.bytes;
    }

}
