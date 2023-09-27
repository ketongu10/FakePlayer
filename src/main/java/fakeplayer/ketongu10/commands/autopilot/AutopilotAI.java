package fakeplayer.ketongu10.commands.autopilot;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.entity.item.EntityMinecartMobSpawner;
import net.minecraft.util.datafix.fixes.SpawnEggNames;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Mouse;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

@SideOnly(Side.CLIENT)
public class AutopilotAI {
    private static boolean activated = false;
    private static int tick = 0;
    String datafile = "FakePlayer/Autopilot.json";
    public AutopilotAI() {
        //Minecraft.getMinecraft().currentScreen.drawHoveringText("LOOOOOOH", 100, 100);
    }

    public static void setActivated(boolean Activated) {
        activated = Activated;
        tick = 0;
    }

    public static void tick() {
        if (activated) {
            askBrain(Minecraft.getMinecraft().getFramebuffer());
            setKeys();
            tick++;
            if (tick < 40) {
                KeyBinding.setKeyBindState(KEYS.UP, true);
                KeyBinding.setKeyBindState(KEYS.LSHIFT, true);
            } else {
                KeyBinding.setKeyBindState(KEYS.UP, false);
                KeyBinding.setKeyBindState(KEYS.LSHIFT, false);
                KeyBinding.setKeyBindState(KEYS.DROP, true);
            }
            if (tick > 80) {
                KeyBinding.setKeyBindState(KEYS.JUMP, true);
            }
            if (tick > 120) {
                KeyBinding.onTick(KEYS.INVENTORY);
                //KeyBinding.unPressAllKeys();
                setActivated(false);
            }
        }
    }

    private void startAI() {
        if (this.tick < 40)
        KeyBinding.setKeyBindState(17, true);
    }

    private static void askBrain(BufferedImage frame) {

    }

    private static void askBrain(Framebuffer frameBuffer) {

    }

    private static void setKeys() {

    }

    public static final class KEYS {
        /**     setKeyBind   **/
        public static int UP = 17;//W
        public static int DOWN = 31;//S
        public static int RIGHT = 32;//D
        public static int LEFT = 30;//A
        public static int LSHIFT = 42;


        /**      onTick      **/
        public static int INVENTORY = 18;//E
        public static int DROP = 16;//Q
        /**      HeZe     **/
        public static int ESC = 1;
        public static int JUMP = 58;
    }
}
