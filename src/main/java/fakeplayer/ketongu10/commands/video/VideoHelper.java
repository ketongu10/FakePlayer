package fakeplayer.ketongu10.commands.video;

import net.minecraft.client.Minecraft;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.util.text.TextComponentTranslation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import py4j.GatewayServer;

import javax.annotation.Nullable;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static net.minecraft.util.ScreenShotHelper.createScreenshot;

public class VideoHelper {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");
    public static boolean isActivated = false;
    private static int ticks = 0;
    private static File FakePlayerVideo;
    private static GatewayServer gatewayServer = null;
    private static GatewayToPython pythonGateway = null;
    //public static BufferedImage buffered;
    /*TAK NADO*/
    //private static BufferedImage bufferedimage = null;

    public static void tick() {
        if (isActivated) {
            if (ticks % 20 == 0) {
                Minecraft mc = Minecraft.getMinecraft();
                produceScreenshot(mc.mcDataDir, (String)null , mc.displayWidth, mc.displayHeight, mc.getFramebuffer());

                //Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(ScreenShotHelper.saveScreenshot(mc.mcDataDir, mc.displayWidth, mc.displayHeight, mc.getFramebuffer()));

            }

            ticks++;
        }

    }
    public static void startRecording() {
        try {
            FakePlayerVideo = new File(Minecraft.getMinecraft().mcDataDir, "FakePlayerVideo");
            FakePlayerVideo.mkdir();
            isActivated = true;
            ticks = 0;

            pythonGateway = new GatewayToPython(Minecraft.getMinecraft().getFramebuffer().framebufferWidth*Minecraft.getMinecraft().getFramebuffer().framebufferHeight);
            gatewayServer = new GatewayServer(pythonGateway);
            gatewayServer.start();
            System.out.println("Gateway Server Started");

        } catch (Exception exception) {
            LOGGER.warn("Couldn't create video folder", (Throwable)exception);
            Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new TextComponentTranslation("video_recording.failure", new Object[] {exception.getMessage()}));
        }
    }
    public static void stopRecording() {
        isActivated = false;
        ticks = 0;
        gatewayServer.shutdown();
        pythonGateway = null;
    }

    public static void produceScreenshot(File gameDirectory, @Nullable String screenshotName, int width, int height, Framebuffer buffer) {
        try {
            //BufferedImage bufferedimage = createScreenshot(width, height, buffer);
            pythonGateway.bufferedImage = createScreenshot(width, height, buffer);
            //pythonGateway.setArray();
            pythonGateway.setByteArray();


            File file2;

            if (screenshotName == null)
            {
                file2 = getTimestampedPNGFileForDirectory(FakePlayerVideo);
            }
            else
            {
                file2 = new File(FakePlayerVideo, screenshotName);
            }

            file2 = file2.getCanonicalFile();

            //makefile(file2, bufferedimage);
            //System.out.println(pythonGateway.bufferedImage.getRaster().getDataBuffer().getElem(45676)); //ТАК МОЖНО ОБРАЩАТЬСЯ!!!!!!!

            //ImageIO.write(bufferedimage, "png", file2);


        } catch (Exception exception) {
            LOGGER.warn("Couldn't save screenshot", (Throwable)exception);
            Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new TextComponentTranslation("screenshot.failure", new Object[] {exception.getMessage()}));
        }
    }

    private static File getTimestampedPNGFileForDirectory(File gameDirectory) {
        String s = DATE_FORMAT.format(new Date()).toString();
        int i = 1;

        while (true)
        {
            File file1 = new File(gameDirectory, s + (i == 1 ? "" : "_" + i) + ".txt");

            if (!file1.exists())
            {
                return file1;
            }

            ++i;
        }
    }

    private static void makefile(File f, BufferedImage image) throws IOException {
        try(FileWriter writer = new FileWriter(f)) {
            // запись всей строки
            int size = image.getRaster().getDataBuffer().getSize();
            DataBuffer buf = image.getRaster().getDataBuffer();
            writer.write(size);
            for (int i=0; i<size; i++) {
                writer.append(Integer.toString(buf.getElem(i)) + '\n');
            }



            writer.append('\n');

            writer.flush();
            writer.close();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }






}
